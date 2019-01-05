/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author leonardo
 */
public class DBConnection {
    static final String jdbc_driver = "com.mysql.jdbc.Driver";
    static final String db_url = "jdbc:mysql://localhost:3306/dss?useSSL=false";
    static final String user = "root";
    static final String pass = "Wonder4Night*11";
    
    public static Connection connect() throws ClassNotFoundException, SQLException {
        Connection con = null;
        
        Class.forName(jdbc_driver);            
        con = DriverManager.getConnection(db_url,user,pass);

        return con; 
    }

    
}
