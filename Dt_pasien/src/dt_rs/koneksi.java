/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dt_rs;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ruikenichi
 */
public class koneksi {
    public Connection openConnect() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/db_pasien";
            String username = "root";
            String password = "";
            connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (ClassNotFoundException e) {
            System.out.println("Driver Tidak Terhubung!!!");
            return null;
        } catch (SQLException se) {
            System.out.println("Perintah SQL Salah!!!");
            throw se;
        }
    }
}    
