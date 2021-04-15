/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author cod
 */
public class NetworkDevice {
    
   String deviceId;
   String deviceName;
   String deviceCategory;
   String deviceModel;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceCategory() {
        return deviceCategory;
    }

    public void setDeviceCategory(String deviceCategory) {
        this.deviceCategory = deviceCategory;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public NetworkDevice(String deviceId, String deviceName, String deviceCategory, String deviceModel) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.deviceCategory = deviceCategory;
        this.deviceModel = deviceModel;
    }

    @Override
    public String toString() {
        return "NetworkDevice{" + "deviceId=" + deviceId + ", deviceName=" + deviceName + ", deviceCategory=" + deviceCategory + ", deviceModel=" + deviceModel + '}';
    }
   
    
   
   
    
}
