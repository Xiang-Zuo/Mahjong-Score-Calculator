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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private static final int PERMISSIONS_REQUEST_CODE = 200;
    private static final String TAG = "MainActivity";
    TextView title;
    Button main_to_camera_btn;
    Button main_to_manual_btn;
    Button main_to_gallery_btn;
    Spinner languages;
    String EXTRA_LAN = "CN";
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

        languages = (Spinner) findViewById(R.id.languages_spinner);
        List<String> languageList = new ArrayList<String>();
        languageList.add("中文");
        languageList.add("EN");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, languageList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languages.setAdapter(dataAdapter);
        languages.setOnItemSelectedListener(this);

        EXTRA_LAN = getIntent().getStringExtra("EXTRA_LAN");
        if (EXTRA_LAN != null) {
            if (EXTRA_LAN.equals("EN")) {
                languages.setSelection(1);
            } else {
                languages.setSelection(0);
            }
        }
    }

    private void setLanguage(String extra_lan) {
        if (extra_lan == null)
            return;
        title = (TextView) findViewById(R.id.main_title);
        if (extra_lan.equals("EN")){
            title.setText(getString(R.string.main_title_EN));
            main_to_manual_btn.setText(getText(R.string.main_to_manual__btn_EN));
            main_to_camera_btn.setText(getText(R.string.main_to_camera_btn_EN));
            main_to_gallery_btn.setText(getText(R.string.main_to_gallery_btn_EN));
        }else {
            title.setText(getString(R.string.main_title));
            main_to_manual_btn.setText(getText(R.string.main_to_manual_btn));
            main_to_camera_btn.setText(getText(R.string.main_to_camera_btn));
            main_to_gallery_btn.setText(getText(R.string.main_to_gallery_btn));
        }
    }

    private boolean checkPermission(Context context, String... permissions) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context!= null && permissions != null){
            for (String permission : PERMISSIONS){
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
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
        intent.putExtra("EXTRA_LAN", EXTRA_LAN);
        startActivity(intent);
    }

    private void switch_to_manual_activity() {
        Intent intent = new Intent(this, ManuallyActivity.class);
        intent.putExtra("EXTRA_LAN", EXTRA_LAN);
        startActivity(intent);
    }

    private void switch_to_gallery_activity(){
        Intent intent = new Intent(this, GalleryActivity.class);
        intent.putExtra("EXTRA_LAN", EXTRA_LAN);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selectedLan = parent.getItemAtPosition(position).toString();
        title = (TextView) findViewById(R.id.main_title);
        if (selectedLan.equals("EN")){
            EXTRA_LAN = "EN";
            title.setText(getString(R.string.main_title_EN));
            main_to_manual_btn.setText(getText(R.string.main_to_manual__btn_EN));
            main_to_camera_btn.setText(getText(R.string.main_to_camera_btn_EN));
            main_to_gallery_btn.setText(getText(R.string.main_to_gallery_btn_EN));
        }else{
            EXTRA_LAN = "CN";
            title.setText(getString(R.string.main_title));
            main_to_manual_btn.setText(getText(R.string.main_to_manual_btn));
            main_to_camera_btn.setText(getText(R.string.main_to_camera_btn));
            main_to_gallery_btn.setText(getText(R.string.main_to_gallery_btn));
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}

