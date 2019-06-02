package com.air.drive.network.httpserver;

import com.air.drive.device.DeviceDetails;
import com.air.drive.device.model.DeviceModel;
import com.air.drive.network.interfaces.HttpMessageListener;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class HttpServer {
    private   boolean RECEIVER_FLAG = true;
    ServerSocket serverSocket=null;
    private int port=4939;
    private int connNumber=100;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    private Socket clientSocket;
    public static HttpServer httpServer;
    public static int status=-1;
    List<HttpMessageListener> messageListeners=new ArrayList<>();

    HttpServer() throws IOException {
        serverSocket=new ServerSocket(port,connNumber,InetAddress.getByName(DeviceModel.deviceModel.getIp()));
        status=0;
        clientSocket=serverSocket.accept();
        status=1;
        dataInputStream=new DataInputStream(clientSocket.getInputStream());
        dataOutputStream=new DataOutputStream(clientSocket.getOutputStream());

        this.httpServer=this;
        status=01;
    }

    public void write(String message) throws Exception {
        if(status==01){
            dataOutputStream.writeChars(message);


        }else {
            throw new Exception("server not ready");

        }

    }
public void addMessageListener(HttpMessageListener listener){
        messageListeners.add(listener);

}
    private void read() throws Exception {

        if(status==01){
        while(RECEIVER_FLAG) {
            String msg=dataInputStream.readUTF();
            for (HttpMessageListener message : messageListeners) {
                message.newMessage(msg);
                   }
        }
        }else {
            throw new Exception("server not ready");

        }

    }

}
