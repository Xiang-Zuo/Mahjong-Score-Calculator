package com.example.mahjong_winpoint_calculator;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


public class MainActivity extends AppCompatActivity {
    private static  final int PERMISSIONS_REQUEST_CODE = 200;
    Button main_to_camera_btn;
    String[] PERMISSIONS = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
    ArrayList<String> UNGRANTED_PERMISSIONS = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (checkPermission()) {
            main_to_camera_btn = (Button) findViewById(R.id.main_to_cameraAct_button);
            main_to_camera_btn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v){
                    switch_to_camera_activity();
                }
            });
        }
        else {
            requestPermissions();
        }
    }

    private boolean checkPermission() {
        for (String permission : PERMISSIONS){
            if ((ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED)){
                UNGRANTED_PERMISSIONS.add(permission);
            }
        }
        return UNGRANTED_PERMISSIONS.isEmpty();
    }

    private void requestPermissions() {

        ActivityCompat.requestPermissions(this, UNGRANTED_PERMISSIONS.toArray(new String[UNGRANTED_PERMISSIONS.size()]), PERMISSIONS_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case PERMISSIONS_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getApplicationContext(), "Permission Granted", Toast.LENGTH_SHORT).show();

                    main_to_camera_btn = (Button) findViewById(R.id.main_to_cameraAct_button);
                    main_to_camera_btn.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v){
                            switch_to_camera_activity();
                        }
                    });
                } else {
                    Toast.makeText(getApplicationContext(), "Permission Denied", Toast.LENGTH_SHORT).show();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                            showMessageOKCancel("You need to allow access permissions", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                        requestPermissions();
                                    }
                                }
                            });
                        }
                    }
                }
                break;
            }

            // other 'case' lines to check for other
            // permissions this app might request.
    }

    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(MainActivity.this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }


    private void switch_to_camera_activity() {
        Intent intent = new Intent(this, CameraActivity.class);
        startActivity(intent);

    }
}

