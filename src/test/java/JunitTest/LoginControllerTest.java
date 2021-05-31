package JunitTest;

import Bean.Account;
import DAO.LoginDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;

public class LoginControllerTest {
    Account account = new Account();
    LoginDAO loginDAO = new LoginDAO();

    @BeforeEach
    void initData(){
        account.setUsername("viet123");
        account.setPassword("123456");
    }

    @Test
    @DisplayName("Test tài khoản đăng nhập chuẩn")
    void checkAccount() throws SQLException, ClassNotFoundException {
        //test tai khoan da co trong database
        account =loginDAO.checkLogin("viet123","123456");
        assertNotNull(account);
        assertEquals("viet123",account.getUsername());
        assertEquals("123456",account.getPassword());
    }

    @Test
    @DisplayName("Test tài khoản đăng nhập username sai, password đúng")
    void checkAccount1() throws SQLException, ClassNotFoundException {
        //test tai khoan da co trong database
        account =loginDAO.checkLogin("viet123111","123456");
        assertNull(account);
    }

    @Test
    @DisplayName("Test tài khoản đăng nhập username đúng, password sai")
    void checkAccount2() throws SQLException, ClassNotFoundException {
        //test tai khoan da co trong database
        account =loginDAO.checkLogin("viet123","1111111111");
        assertNull(account);
    }

    @Test
    @DisplayName("Test tài khoản đăng nhập cả username và password sai")
    void checkAccount3() throws SQLException, ClassNotFoundException {
        //test tai khoan da co trong database
        account =loginDAO.checkLogin("viet123111","0000000");
        assertNull(account);
    }

    @Test
    @DisplayName("Test tài khoản đăng nhập username null")
    void checkAccount4() throws SQLException, ClassNotFoundException {
        //test tai khoan da co trong database
        account =loginDAO.checkLogin("","123456");
        assertNull(account);
    }

    @Test
    @DisplayName("Test tài khoản đăng nhập password null")
    void checkAccount5() throws SQLException, ClassNotFoundException {
        //test tai khoan da co trong database
        account =loginDAO.checkLogin("viet123","");
        assertNull(account);
    }

    @Test
    @DisplayName("Test tài khoản đăng nhập username chưa khoảng trắng")
    void checkAccount6() throws SQLException, ClassNotFoundException {
        //test tai khoan da co trong database
        account =loginDAO.checkLogin("   viet123   ","123456");
        assertNull(account);
    }

    @Test
    @DisplayName("Test tài khoản đăng nhập password chưa khoảng trắng")
    void checkAccount7() throws SQLException, ClassNotFoundException {
        //test tai khoan da co trong database
        account =loginDAO.checkLogin("viet123","  123456  ");
        assertNull(account);
    }



}
