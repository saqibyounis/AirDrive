package com.air.drive.network.model;

public class DeviceModel {
    String ip;
    String deviceName;

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
    public DeviceModel(String ip, String deviceName, String deviceOsName) {
        this.ip = ip;
        this.deviceName = deviceName;
        this.deviceOsName = deviceOsName;
        this.deviceModel=this;
    }



}
