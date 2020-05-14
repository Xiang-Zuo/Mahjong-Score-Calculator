package com.example.mahjong_winpoint_calculator;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    private static final String TAG = "ResultActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ArrayList<String> hands = getIntent().getStringArrayListExtra("EXTRA_HANDS");

        Log.e(TAG, hands.toString());

        CountPoint cp = new CountPoint(10, hands);
        if (cp.checkHu()){
            Log.e(TAG, "HU LE!");
        }else{
            Log.e(TAG, "ZHA HU!");
        }
    }
}
