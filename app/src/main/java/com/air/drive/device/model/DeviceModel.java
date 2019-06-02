package com.air.drive.device.model;

public class DeviceModel {
    String ip;
    String deviceName;

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    String deviceType;

    public DeviceModel getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(DeviceModel deviceModel) {
        this.deviceModel = deviceModel;
    }

    public static DeviceModel deviceModel;
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceOsName() {
        return deviceOsName;
    }

    public void setDeviceOsName(String deviceOsName) {
        this.deviceOsName = deviceOsName;
    }

    String deviceOsName;
    public DeviceModel(String ip, String deviceName, String deviceOsName,String deviceType) {
        this.ip = ip;
        this.deviceName = deviceName;
        this.deviceOsName = deviceOsName;
        this.deviceType=deviceType;
        this.deviceModel=this;
    }



}
