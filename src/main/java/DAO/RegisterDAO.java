package DAO;

import Bean.StudyClass;
import DB.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegisterDAO {

    public static List<StudyClass> listClass(Connection conn){
        List<StudyClass>list =new ArrayList<StudyClass>();

        PreparedStatement ptmt = null;
        String sql ="SELECT * FROM lophoc";

        try {
            ptmt= conn.prepareStatement(sql);
            ResultSet rs = ptmt.executeQuery();

            while (rs.next()){
                StudyClass sc = new StudyClass();
                int id = rs.getInt("id");
                String tenlop = rs.getString("tenlop");
                String tenmonhoc =rs.getString("tenmonhoc");
                int sotin = rs.getInt("sotinchi");
                int sokip = rs.getInt("sokip");
                int lythuyet = rs.getInt("sotietlythuyet");
                int thuchanh = rs.getInt("sotietthuchanh");
                String thoigian = rs.getString("thoigian");

                sc.setId(id);
                sc.setTenlop(tenlop);
                sc.setTenmonhoc(tenmonhoc);
                sc.setSotin(sotin);
                sc.setSokip(sokip);
                sc.setSokiplythuyet(lythuyet);
                sc.setSokipthuchanh(thuchanh);
                sc.setThoigian(thoigian);
                list.add(sc);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return list;
    }


}
