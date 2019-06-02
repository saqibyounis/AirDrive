package com.air.drive.network.udpserver;

import com.air.drive.device.model.DeviceModel;
import com.air.drive.network.interfaces.IncommingConnectionListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class UDPServer {
    int port=2939;
    DatagramSocket datagramSocket;
    public boolean RUNNER_FLAG=true;

    List<DeviceModel> deviceModels=new ArrayList<>();
     List<IncommingConnectionListener> incommingConnectionListeners=new ArrayList<>();
    public void startUdpServer(String ip) throws IOException, JSONException {
    datagramSocket= new DatagramSocket(null);
    InetSocketAddress address = new InetSocketAddress(ip, port);
    datagramSocket.bind(address);
    byte[] receiveData = new byte[1024];
    byte[] sendData = new byte[1024];

    while(RUNNER_FLAG)
    {
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        datagramSocket.receive(receivePacket);
        //String sentence = new String( receivePacket.getData());
        JSONObject jsonObject=new JSONObject(new String(receivePacket.getData()));
        DeviceModel deviceModel=new DeviceModel(jsonObject.getString("ip"),jsonObject.getString("deviceName"),jsonObject.getString("deviceOsName"),jsonObject.getString("deviceType"));
        deviceModels.add(deviceModel);
        InetAddress IPAddress = receivePacket.getAddress();
        int port = receivePacket.getPort();
        String responseToClient= DeviceModel.deviceModel.getJson();
        sendData = responseToClient.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
        datagramSocket.send(sendPacket);
        for (IncommingConnectionListener incommingConnectionListener: incommingConnectionListeners) {
            incommingConnectionListener.getAConnectoin(deviceModel);
        }

    }


}
public void addIncommingConnectionListener(IncommingConnectionListener listener){
        incommingConnectionListeners.add(listener);

}
public void stopServer(){
    this.RUNNER_FLAG=false;
     datagramSocket.close();
}


}
