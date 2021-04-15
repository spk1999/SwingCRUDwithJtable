/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

/**
 *
 * @author cod
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    
      public static Connection getConnection()
        {
                Connection connection=null;
                try {
                        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sujan?useSSL=false", "root", "root");
                } catch (Exception e) {
                        e.printStackTrace();
                }

                return connection;
        }
    
}
