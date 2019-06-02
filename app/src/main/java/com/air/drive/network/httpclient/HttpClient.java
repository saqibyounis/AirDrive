package com.air.drive.network.httpclient;

import com.air.drive.network.interfaces.ConnectionProgressListener;
import com.air.drive.network.interfaces.HttpMessageListener;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class HttpClient {

    private   boolean RECEIVER_FLAG = true;
    Socket clientSocket=null;
    int port=4939;
    DataOutputStream dataOutputStream;
    DataInputStream dataInputStream;
    public static int status=-1;
    List<HttpMessageListener> messageListeners=new ArrayList<>();
    List<ConnectionProgressListener> connectionProgressListeners=new ArrayList<>();

    public HttpClient(String ipAddress) throws IOException {
          status=0;
            clientSocket=new Socket(InetAddress.getByName(ipAddress),port);
            dataInputStream=new DataInputStream(clientSocket.getInputStream());
            dataOutputStream=new DataOutputStream(clientSocket.getOutputStream());
            status=01;




    }

    public void addConnectionProgressListener(ConnectionProgressListener listener){
        connectionProgressListeners.add(listener);

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
