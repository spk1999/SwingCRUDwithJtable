/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import db.DBConnection;
import model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.UUID;
import java.sql.ResultSet;        

/**
 *
 * @author cod
 */
public class UserController {
    
     public boolean addUser(User user) {
        user.setId(UUID.randomUUID().toString());
        try {
            Connection conn = DBConnection.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement("insert into user values(?,?,?,?)");
            ps.setString(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getPassword());
            if(ps.executeUpdate()==1){
            conn.commit();
            return true;
                    }
        } catch (Exception e) {
            e.printStackTrace();
                    }
        return false;
    }
     
     public boolean loginUser(User user) {
        user.setId(UUID.randomUUID().toString());
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("select username from user where username=? and password=?");
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ResultSet rs= ps.executeQuery();
          if(rs.next())
          {
            return true;
          }         
        } catch (Exception e) {
            e.printStackTrace();
                    }
        return false;
    }
    
}
