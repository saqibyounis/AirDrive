package com.air.drive;

import android.app.Dialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.air.drive.device.model.DeviceModel;
import com.air.drive.network.RemoveIpAddressEnd;
import com.air.drive.network.connection.CreateConnectoin;
import com.air.drive.network.interfaces.IncommingConnectionListener;
import com.air.drive.network.interfaces.OutgoingConnectionListener;

import org.json.JSONException;
import org.w3c.dom.Text;

import java.io.IOException;

public class SendAndReceiveAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_and_receive);
    }

    public void send(View view) throws IOException, JSONException {


     /*   new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("SENDING STAERT");
                CreateConnectoin createConnectoin=new CreateConnectoin();
                try {
                    createConnectoin.createSendingConnection(new OutgoingConnectionListener() {
                        @Override
                        public void foundAClient(DeviceModel deviceModel) {
                            System.out.println("OUTGOING");
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }).start();*/




    }

    public void receive(View view) throws IOException, JSONException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("RCEIVEING STAERT");
                final CreateConnectoin createConnectoin=new CreateConnectoin();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //System.out.println(RemoveIpAddressEnd.getLastIp(DeviceModel.deviceModel.getIp()));
                        final Dialog dialog=new Dialog(SendAndReceiveAct.this);
                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        dialog.setContentView(R.layout.lastipname);
                        TextView lastip=dialog.findViewById(R.id.lastip);

                        lastip.setText(RemoveIpAddressEnd.getLastIp(DeviceModel.deviceModel.getIp()));
                        Button button=dialog.findViewById(R.id.cb);
                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                        createConnectoin.closeReceiving();
                                dialog.dismiss();

                            }
                        });
                        dialog.setCancelable(false);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.show();
                    }
                });
                try {
                    createConnectoin.createReceivingConnectoin(new IncommingConnectionListener() {
                        @Override
                        public void getAConnectoin(DeviceModel deviceModel) {
                            System.out.println("INCOMMING");
                        }
                    });


                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }


}
