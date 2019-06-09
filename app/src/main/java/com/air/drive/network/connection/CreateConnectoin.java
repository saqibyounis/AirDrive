package com.air.drive.network.connection;

import com.air.drive.device.model.DeviceModel;
import com.air.drive.network.RemoveIpAddressEnd;
import com.air.drive.network.httpclient.HttpClient;
import com.air.drive.network.httpserver.HttpServer;
import com.air.drive.network.interfaces.IncommingConnectionListener;
import com.air.drive.network.interfaces.OutgoingConnectionListener;
import com.air.drive.network.udpclient.UDPClient;
import com.air.drive.network.udpserver.UDPServer;

import org.json.JSONException;

import java.io.IOException;

public class CreateConnectoin {
    UDPServer udpServer;
    UDPClient udpClient;
    HttpClient httpClient;
    HttpServer httpServer;


    public CreateConnectoin(){

        udpClient=new UDPClient();
        udpServer=new UDPServer();

    }

    public  void createReceivingConnectoin(IncommingConnectionListener listener) throws IOException, JSONException {
        udpServer.addIncommingConnectionListener(listener);

        udpServer.startUdpServer(DeviceModel.deviceModel.getIp());

    }

    public  void createSendingConnection( OutgoingConnectionListener listener,String lastIP) throws IOException, JSONException {
        udpClient.addOutgoingConnectionListener(listener);

        udpClient.startUdpClient(RemoveIpAddressEnd.getIp(DeviceModel.deviceModel.getIp()),lastIP);


    }

    public void closeSending(){
        udpClient.stopClient();

    }

    public void closeReceiving(){
        udpServer.stopServer();

    }



}
