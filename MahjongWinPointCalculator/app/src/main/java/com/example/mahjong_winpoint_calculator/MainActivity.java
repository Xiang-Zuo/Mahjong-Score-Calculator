package com.example.mahjong_winpoint_calculator;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;


public class MainActivity extends AppCompatActivity {
    private static final int PERMISSIONS_REQUEST_CODE = 200;
    private static final String TAG = "MainActivity";
    Button main_to_camera_btn;
    Button main_to_manual_btn;
    Button main_to_gallery_btn;
    String[] PERMISSIONS = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
    ArrayList<String> UNGRANTED_PERMISSIONS = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!checkPermission(this, PERMISSIONS)) {
            ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSIONS_REQUEST_CODE);
        }

        main_to_camera_btn = (Button) findViewById(R.id.main_to_cameraAct_button);
        main_to_camera_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                    switch_to_camera_activity();
                }
        });

        main_to_manual_btn = (Button) findViewById(R.id.main_to_manuallyAct_button);
        main_to_manual_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                switch_to_manual_activity();
            }
        });

        main_to_gallery_btn = (Button) findViewById(R.id.main_to_galleryAct_button);
        main_to_gallery_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                switch_to_gallery_activity();
            }
        });
    }

    private boolean checkPermission(Context context, String... permissions) {
//        UNGRANTED_PERMISSIONS.clear();
//        for (String permission : PERMISSIONS){
//            if ((ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED)){
//                UNGRANTED_PERMISSIONS.add(permission);
//            }
//        }
//        return UNGRANTED_PERMISSIONS.isEmpty();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context!= null && permissions != null){
            for (String permission : PERMISSIONS){
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

//    private void requestPermissions() {
//        ActivityCompat.requestPermissions(this, UNGRANTED_PERMISSIONS.toArray(new String[UNGRANTED_PERMISSIONS.size()]), PERMISSIONS_REQUEST_CODE);
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        switch (requestCode) {
//            case PERMISSIONS_REQUEST_CODE:
//                if ((grantResults.length > 0) && grantResults[0] + grantResults[1] == PackageManager.PERMISSION_GRANTED) {
//                    Toast.makeText(getApplicationContext(), "Permission Granted", Toast.LENGTH_SHORT).show();
//                    main_to_camera_btn = (Button) findViewById(R.id.main_to_cameraAct_button);
//                    main_to_camera_btn.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            switch_to_camera_activity();
//                        }
//                    });
//                }else{
//                    Toast.makeText(getApplicationContext(), "Some Permissions Denied", Toast.LENGTH_SHORT).show();
//                    showMessageOKCancel("You need to allow access permissions", new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialog, int which) {
//                                    if (!checkPermission())
//                                        requestPermissions();
//                                }
//                            });
//
//                }
////                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
////                        UNGRANTED_PERMISSIONS.remove(Manifest.permission.CAMERA);
////                        if (grantResults[1] == PackageManager.PERMISSION_GRANTED) {
////                            UNGRANTED_PERMISSIONS.remove(Manifest.permission.WRITE_EXTERNAL_STORAGE);
////                            Toast.makeText(getApplicationContext(), "Permission Granted", Toast.LENGTH_SHORT).show();
////                            main_to_camera_btn = (Button) findViewById(R.id.main_to_cameraAct_button);
////                            main_to_camera_btn.setOnClickListener(new View.OnClickListener() {
////                                @Override
////                                public void onClick(View v){
////                                    switch_to_camera_activity();
////                                }
////                            });
//                break;
//
//        }
//
//    }


//                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    Toast.makeText(getApplicationContext(), "Permission Granted", Toast.LENGTH_SHORT).show();
//
//                    main_to_camera_btn = (Button) findViewById(R.id.main_to_cameraAct_button);
//                    main_to_camera_btn.setOnClickListener(new View.OnClickListener() {
//
//                        @Override
//                        public void onClick(View v){
//                            switch_to_camera_activity();
//                        }
//                    });
//                } else {
//                    Toast.makeText(getApplicationContext(), "Permission Denied", Toast.LENGTH_SHORT).show();
//                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
//                            showMessageOKCancel("You need to allow access permissions", new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialog, int which) {
//                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                                        requestPermissions();
//                                    }
//                                }
//                            });
//                        }
//                    }
//                }
//                break;
//            }
//
//            // other 'case' lines to check for other
//            // permissions this app might request.
//    }

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

    private void switch_to_manual_activity() {
        Intent intent = new Intent(this, ManuallyActivity.class);
        startActivity(intent);
    }

    private void switch_to_gallery_activity(){
        Intent intent = new Intent(this, GalleryActivity.class);
        startActivity(intent);
    }

}

