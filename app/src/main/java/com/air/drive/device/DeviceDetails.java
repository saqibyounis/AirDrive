package com.air.drive.device;

import android.app.Activity;
import android.content.Context;

import com.air.drive.device.model.DeviceModel;
import com.air.drive.network.IPAddressClass;

import github.nisrulz.easydeviceinfo.base.DeviceType;
import github.nisrulz.easydeviceinfo.base.EasyConfigMod;
import github.nisrulz.easydeviceinfo.base.EasyDeviceMod;

public class DeviceDetails {
public static void initializeDeviceDetail(Context context, Activity activity){
    EasyDeviceMod easyDeviceMod = new EasyDeviceMod(context);
    String deviceTypeString="default";
    int deviceType = easyDeviceMod.getDeviceType(activity);
    switch (deviceType) {
        case DeviceType.WATCH:
            System.out.println("watch");
            deviceTypeString="watch";
            break;
        case DeviceType.PHONE:
            System.out.println("phone");

            deviceTypeString="phone";
            break;
        case DeviceType.PHABLET:
            System.out.println("phablet");

            deviceTypeString="phablet";
            break;
        case DeviceType.TABLET:
            System.out.println("tablet");

            deviceTypeString="tablet";
            break;
        case DeviceType.TV:
            System.out.println("tv");

            deviceTypeString="tv";
            break;
    }
    DeviceModel deviceModel=new DeviceModel(IPAddressClass.getCurrentIP(context),easyDeviceMod.getDevice(),easyDeviceMod.getOSCodename(),deviceTypeString);


}

}
