package com.air.drive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.air.drive.device.DeviceDetails;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DeviceDetails.initializeDeviceDetail(this,this);


    }
}
