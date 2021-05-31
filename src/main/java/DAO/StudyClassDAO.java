package DAO;

import Bean.StudyClass;
import DB.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudyClassDAO {

    private String jdbcURL = "jdbc:mysql://localhost:3306/sqa_db?useUnicode=yes&characterEncoding=UTF-8";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    private static final String INSERT_CLASS_SQL = "INSERT INTO lophoc" + "  (tenlop, tenmonhoc, sotinchi,sokip,sotietlythuyet,sotietthuchanh) VALUES " +
            " (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_CLASS_BY_ID = "select id,tenlop, tenmonhoc, sotinchi,sokip,sotietlythuyet,sotietthuchanh,thoigian from lophoc where id =?";
    private static final String SELECT_ALL_CLASS = "select * from lophoc";
    private static final String DELETE_CLASS_SQL = "delete from lophocdangky where lophoc_id = ?";
    private static final String UPDATE_LOPHOC_SQL = "update lophoc set tenlop = ?,tenmonhoc= ?, sotinchi =?,sokip =? ,sotietlythuyet = ?, sotietthuchanh = ? where id = ?";

    public StudyClassDAO(){

    }
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }


    public StudyClass selectClassById(int id) {
        StudyClass sc = null;

        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CLASS_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id_lop = rs.getInt("id");
                String tenlop = rs.getString("tenlop");
                String tenmonhoc = rs.getString("tenmonhoc");
                int sotin = rs.getInt("sotinchi");
                int sokip = rs.getInt("sokip");
                int sotietlythuyet = rs.getInt("sotietlythuyet");
                int sotietthuchanh = rs.getInt("sotietthuchanh");
                String thoigian = rs.getString("thoigian");
                sc = new StudyClass(id,tenlop,tenmonhoc,sotin,sokip,sotietlythuyet,sotietthuchanh,thoigian);

            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return sc;
    }

    public List< StudyClass > selectAllClass() {

        List < StudyClass > list = new ArrayList<>();

        try (
                Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CLASS);) {
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String tenlop = rs.getString("tenlop");
                String tenmonhoc = rs.getString("tenmonhoc");
                int sotinchi = rs.getInt("sotinchi");
                int sotkip = rs.getInt("sokip");
                int sotietlythuyet = rs.getInt("sotietlythuyet");
                int sotietthuchanh = rs.getInt("sotietthuchanh");
                String thoigian = rs.getString("thoigian");

                list.add(new StudyClass(id, tenlop, tenmonhoc, sotinchi,sotkip,sotietlythuyet,sotietthuchanh,thoigian));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return list;
    }

    public boolean deleteClass(Connection conn,int id) throws SQLException {
        boolean rowDeleted;
        try (

                PreparedStatement statement = conn.prepareStatement(DELETE_CLASS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateClass(StudyClass sc) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_LOPHOC_SQL);) {
            statement.setString(1, sc.getTenlop());
            statement.setString(2, sc.getTenmonhoc());
            statement.setInt(3, sc.getSotin());
            statement.setInt(4, sc.getSokip());
            statement.setInt(5, sc.getSokiplythuyet());
            statement.setInt(6, sc.getSokipthuchanh());
            statement.setInt(7, sc.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }


    public List<StudyClass> searchClassByName(String txtSearch) {
        List<StudyClass> list = new ArrayList<>();
        Connection conn = DBConnection.CreateConnection();
        PreparedStatement ptmt =null;
        ResultSet rs;
        String sql = "select * from lophoc where tenmonhoc like ?";
        try {
            ptmt = conn.prepareStatement(sql);
            ptmt.setString(1, "%" + txtSearch + "%");
            rs = ptmt.executeQuery();

            while (rs.next()) {
                list.add(new StudyClass(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
                        rs.getInt(6),rs.getInt(7),rs.getString(8)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;

    }
}


