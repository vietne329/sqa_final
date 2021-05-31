package DAO;

import Bean.StudyClass;
import Bean.TeachPlan;
import DB.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CreatePlanDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/sqa_db?useUnicode=yes&characterEncoding=UTF-8";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    private static final String INSERT_PLAN_SQL = "INSERT INTO kehoachdayhoc" + "  (tenbaihoc,kip,loai, ghichu, lophoc_id) VALUES " +
            " (?, ?,  ?, ?, ?)";

    public CreatePlanDAO(){

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

    public boolean insertTeachPlan(Connection conn,TeachPlan tp) throws SQLException {
        System.out.println(INSERT_PLAN_SQL);

             PreparedStatement preparedStatement = conn.prepareStatement(INSERT_PLAN_SQL);
            preparedStatement.setString(1, tp.getTenbaihoc());
            preparedStatement.setInt(2, tp.getKip());
            preparedStatement.setString(3, tp.getLoai());
            preparedStatement.setString(4, tp.getGhichu());
            preparedStatement.setInt(5, tp.getLophoc_id());

            System.out.println(preparedStatement);
            int check = preparedStatement.executeUpdate();
            if(check != 0){
                return true;
            }

        return false;
    }

    public List<TeachPlan> getTeachPlan(int id){
        Connection conn = DBConnection.CreateConnection();
        List<TeachPlan> list = new ArrayList<TeachPlan>();
        PreparedStatement ptmt;
        String sql = "SELECT kip,tenlop,tenmonhoc,tenbaihoc,loai,ghichu from lophoc,kehoachdayhoc where lophoc.id = kehoachdayhoc.lophoc_id and lophoc.id = ?";

        try {
            ptmt = conn.prepareStatement(sql);
            ptmt.setInt(1,id);
            ResultSet rs = ptmt.executeQuery();

            while (rs.next()){
                TeachPlan tp = new TeachPlan();
                String tenlop = rs.getString("tenlop");
                int kip = rs.getInt("kip");
                String tenmonhoc =rs.getString("tenmonhoc");
                String tenbaihoc = rs.getString("tenbaihoc");
                String loai = rs.getString("loai");
                String ghichu = rs.getString("ghichu");

                tp.setKip(kip);
                tp.setTenlop(tenlop);
                tp.setTenmonhoc(tenmonhoc);
                tp.setTenbaihoc(tenbaihoc);
                tp.setLoai(loai);
                tp.setGhichu(ghichu);

                list.add(tp);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return list;
    }
}
