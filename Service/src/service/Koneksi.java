/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Koneksi {

    private static final Logger LOGGER = Logger.getLogger(Koneksi.class.getName());

    public static Connection openConnect() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/service";
            String username = "root";
            String password = "";
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Driver MySQL tidak ditemukan!", e);
            throw new SQLException("Driver MySQL tidak ditemukan!");
        } catch (SQLException se) {
            LOGGER.log(Level.SEVERE, "Kesalahan saat menghubungkan ke database!", se);
            throw se;
        }
    }
}
