/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.UUID;
import java.sql.ResultSet;  
import java.util.ArrayList;
import java.util.List;
import model.NetworkDevice;

/**
 *
 * @author cod
 */
public class DeviceController {
    
    public boolean addDevice(NetworkDevice device) {
        device.setDeviceId(UUID.randomUUID().toString());
        try {
            Connection conn = DBConnection.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement("insert into device values(?,?,?,?)");
            ps.setString(1, device.getDeviceId());
            ps.setString(2, device.getDeviceName());
            ps.setString(3, device.getDeviceCategory());
            ps.setString(4, device.getDeviceModel());
            if(ps.executeUpdate()==1){
            conn.commit();
            return true;
                    }
        } catch (Exception e) {
            e.printStackTrace();
                    }
        return false;
    }
    
    
        public List<NetworkDevice> getAllDevices() {
        List<NetworkDevice> devices = new ArrayList<>();
        try {

            Connection conn = DBConnection.getConnection();
            ResultSet rs;
            PreparedStatement ps = conn.prepareStatement("select * from device");
       
            rs = ps.executeQuery();
            while (rs.next()) {
                devices.add(new NetworkDevice(rs.getString("id"), rs.getString("name"), rs.getString("category"),rs.getString("model")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return devices;
    }
        
         public boolean updateDevice(NetworkDevice device) {
             System.out.print(device.toString());
        
        try {
            Connection conn = DBConnection.getConnection();
           
            PreparedStatement ps = conn.prepareStatement("update device set name=? ,category=? ,model=? where id=?");
            ps.setString(4, device.getDeviceId());
            ps.setString(1, device.getDeviceName());
            ps.setString(2, device.getDeviceCategory());
            ps.setString(3, device.getDeviceModel());
            if(ps.executeUpdate()==1){
         System.out.print("end");
            return true;
                    }
        } catch (Exception e) {
            e.printStackTrace();
                    }
        return false;
    }
    
         
         public boolean deleteDevice(String deviceId) {
                    
        try {
            Connection conn = DBConnection.getConnection();
           
            PreparedStatement ps = conn.prepareStatement("delete from device where id=?");
            ps.setString(1, deviceId);
            if(ps.executeUpdate()==1){
         System.out.print("end");
            return true;
                    }
        } catch (Exception e) {
            e.printStackTrace();
                    }
        return false;
    }
}
