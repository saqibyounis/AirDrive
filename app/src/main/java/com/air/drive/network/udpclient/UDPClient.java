package com.air.drive.network.udpclient;

import com.air.drive.device.model.DeviceModel;
import com.air.drive.network.interfaces.OutgoingConnectionListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class UDPClient {
    DatagramSocket clientSocket = null;
    int port=2939;
    public boolean RUNNER_FLAG=true;
    public int range=255;
    List<DeviceModel> deviceModels=new ArrayList<>();
    List<OutgoingConnectionListener> outgoingConnectionListeners=new ArrayList<>();
    public void startUdpClient(String ip,String last) throws IOException, JSONException {
        clientSocket=new DatagramSocket();
             clientSocket.setSoTimeout(2000);
        ///for (int i=0;i<=255;i++){

try {

             InetAddress IPAddress = InetAddress.getByName(ip+""+last);
            System.out.println("IP ADDRESS"+IPAddress);
             byte[] sendData = new byte[1024];
             byte[] receiveData = new byte[1024];
             String json= DeviceModel.deviceModel.getJson();
             sendData = json.getBytes();
             DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
             clientSocket.send(sendPacket);
             DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
             clientSocket.receive(receivePacket);
             //String modifiedSentence = new String(receivePacket.getData());
            JSONObject jsonObject=new JSONObject(new String(receivePacket.getData()));
            DeviceModel deviceModel=new DeviceModel(jsonObject.getString("ip"),jsonObject.getString("deviceName"),jsonObject.getString("deviceOsName"),jsonObject.getString("deviceType"));
            deviceModels.add(deviceModel);
    System.out.println("FOUND");
            for (OutgoingConnectionListener outgoing:outgoingConnectionListeners) {
                System.out.println("in ni");
                outgoing.foundAClient(deviceModel);
            }
}catch (Exception ex){
    System.out.println("NO FOUND");
//continue;

}


         //}
        clientSocket.close();

    }


public void addOutgoingConnectionListener(OutgoingConnectionListener listener){
        outgoingConnectionListeners.add(listener);

}
public void stopClient(){
        RUNNER_FLAG=false;
        clientSocket.close();
}
}
