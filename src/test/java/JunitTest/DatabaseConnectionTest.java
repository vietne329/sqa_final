package JunitTest;

import DB.DBConnection;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static org.junit.Assert.*;



public class DatabaseConnectionTest {

    public static Connection CreateConnectionTrue(){
        Connection conn = null;
        String url ="jdbc:mysql://localhost:3306/sqa_db?useUnicode=true&characterEncoding=UTF-8";
        String username = "root";
        String password = "123456";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,username,password);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }


    public static Connection CreateConnectionFaild(){
        Connection conn = null;
        String url ="jdbc:mysql://localhost:3306/sqa_db?useUnicode=true&characterEncoding=UTF-8";
        String username = "rootasd";
        String password = "123456asd";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,username,password);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }


    @Test
    @DisplayName("Test connect chuẩn với username và password của mysql")
    public void testDBConnect1(){
        Connection conn = CreateConnectionTrue();
        assertNotNull(conn);
    }

    @Test
    @DisplayName("Test connect với username và password sai của mysql")
    public void testDBConnect2(){
        Connection conn = CreateConnectionFaild();
        assertNull(conn);
    }

}
