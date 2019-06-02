package com.air.drive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.air.drive.device.DeviceDetails;
import com.air.drive.device.model.DeviceModel;
import com.air.drive.network.RemoveIpAddressEnd;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       tv=findViewById(R.id.tv);
        DeviceDetails.initializeDeviceDetail(this,this);
        tv.setText(""+ RemoveIpAddressEnd.getIp(DeviceModel.deviceModel.getIp()));

    }
}
