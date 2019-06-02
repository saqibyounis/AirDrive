package com.air.drive.network;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.text.format.Formatter;

import static android.content.Context.WIFI_SERVICE;

public class IPAddressClass {
public static String getCurrentIP(Context context){

    WifiManager wm = (WifiManager) context.getSystemService(WIFI_SERVICE);
    String ip = Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());
    return ip;

}


}
