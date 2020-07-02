package com.example.mahjong_winpoint_calculator;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ManuallyActivity extends AppCompatActivity implements View.OnClickListener {
    //TODO store template data, loa default template folder
    private static final String TAG = "ManuallyActivity";
    ImageView theChosenSpot = null;
    HashMap<ImageView, Integer> paiCount;
    ImageView[] spots = {null, null, null,
            null, null, null,
            null, null, null,
            null, null, null,
            null, null};

    ArrayList<String> hands;
    ArrayList<String> chi;
    ArrayList<String> peng;
    ArrayList<String> mingGang;
    ArrayList<String> anGang;
    ArrayList<String> specialFormat;

    ImageView spot00 = null;
    ImageView spot01 = null;
    ImageView spot02 = null;
    ImageView spot10 = null;
    ImageView spot11 = null;
    ImageView spot12 = null;
    ImageView spot20 = null;
    ImageView spot21 = null;
    ImageView spot22 = null;
    ImageView spot30 = null;
    ImageView spot31 = null;
    ImageView spot32 = null;
    ImageView spot40 = null;
    ImageView spot41 = null;

    ImageView yiWanView = null;
    ImageView erWanView = null;
    ImageView sanWanView = null;
    ImageView siWanView = null;
    ImageView wuWanView = null;
    ImageView liuWanView = null;
    ImageView qiWanView = null;
    ImageView baWanView = null;
    ImageView jiuWanView = null;
    ImageView yiBingView = null;
    ImageView erBingView = null;
    ImageView sanBingView = null;
    ImageView siBingView = null;
    ImageView wuBingView = null;
    ImageView liuBingView = null;
    ImageView qiBingView = null;
    ImageView baBingView = null;
    ImageView jiuBingView = null;
    ImageView yiTiaoView = null;
    ImageView erTiaoView = null;
    ImageView sanTiaoView = null;
    ImageView siTiaoView = null;
    ImageView wuTiaoView = null;
    ImageView liuTiaoView = null;
    ImageView qiTiaoView = null;
    ImageView baTiaoView = null;
    ImageView jiuTiaoView = null;
    ImageView dongFengView = null;
    ImageView nanFengView = null;
    ImageView xiFengView = null;
    ImageView beiFengView = null;
    ImageView hongZhongView = null;
    ImageView baiBanView = null;
    ImageView faCaiView = null;

    Button chiBtn0 = null;
    Button chiBtn1 = null;
    Button chiBtn2 = null;
    Button chiBtn3 = null;

    Button pengBtn0 = null;
    Button pengBtn1 = null;
    Button pengBtn2 = null;
    Button pengBtn3 = null;

    Button gangBtn0 = null;
    Button gangBtn1 = null;
    Button gangBtn2 = null;
    Button gangBtn3 = null;

    Button mingBtn0 = null;
    Button mingBtn1 = null;
    Button mingBtn2 = null;
    Button mingBtn3 = null;
    Button mingBtn4 = null;

    Button anBtn0 = null;
    Button anBtn1 = null;
    Button anBtn2 = null;
    Button anBtn3 = null;
    Button anBtn4 = null;

    Button restoreBtn = null;
    Button deleteBtn = null;
    Button calculateBtn = null;

    String EXTRA_LAN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //全屏
        getSupportActionBar().hide(); //隐藏标题
        setContentView(R.layout.activity_manually);

        paiCount = new HashMap<ImageView, Integer>();
        hands = new ArrayList<>();
        chi = new ArrayList<>();
        peng = new ArrayList<>();
        mingGang = new ArrayList<>();
        anGang = new ArrayList<>();
        specialFormat = new ArrayList<>();

        spot00 = (ImageView) findViewById(R.id.spot00);
        spot01 = (ImageView) findViewById(R.id.spot01);
        spot02 = (ImageView) findViewById(R.id.spot02);
        spot10 = (ImageView) findViewById(R.id.spot10);
        spot11 = (ImageView) findViewById(R.id.spot11);
        spot12 = (ImageView) findViewById(R.id.spot12);
        spot20 = (ImageView) findViewById(R.id.spot20);
        spot21 = (ImageView) findViewById(R.id.spot21);
        spot22 = (ImageView) findViewById(R.id.spot22);
        spot30 = (ImageView) findViewById(R.id.spot30);
        spot31 = (ImageView) findViewById(R.id.spot31);
        spot32 = (ImageView) findViewById(R.id.spot32);
        spot40 = (ImageView) findViewById(R.id.spot40);
        spot41 = (ImageView) findViewById(R.id.spot41);
        spot00.setOnClickListener(this);
        spot01.setOnClickListener(this);
        spot02.setOnClickListener(this);
        spot10.setOnClickListener(this);
        spot11.setOnClickListener(this);
        spot12.setOnClickListener(this);
        spot20.setOnClickListener(this);
        spot21.setOnClickListener(this);
        spot22.setOnClickListener(this);
        spot30.setOnClickListener(this);
        spot31.setOnClickListener(this);
        spot32.setOnClickListener(this);
        spot40.setOnClickListener(this);
        spot41.setOnClickListener(this);

        yiWanView = (ImageView) findViewById(R.id.yiwan);
        erWanView = (ImageView) findViewById(R.id.erwan);
        sanWanView = (ImageView) findViewById(R.id.sanwan);
        siWanView = (ImageView) findViewById(R.id.siwan);
        wuWanView = (ImageView) findViewById(R.id.wuwan);
        liuWanView = (ImageView) findViewById(R.id.liuwan);
        qiWanView = (ImageView) findViewById(R.id.qiwan);
        baWanView = (ImageView) findViewById(R.id.bawan);
        jiuWanView = (ImageView) findViewById(R.id.jiuwan);
        yiBingView = (ImageView) findViewById(R.id.yibing);
        erBingView = (ImageView) findViewById(R.id.erbing);
        sanBingView = (ImageView) findViewById(R.id.sanbing);
        siBingView = (ImageView) findViewById(R.id.sibing);
        wuBingView = (ImageView) findViewById(R.id.wubing);
        liuBingView = (ImageView) findViewById(R.id.liubing);
        qiBingView = (ImageView) findViewById(R.id.qibing);
        baBingView = (ImageView) findViewById(R.id.babing);
        jiuBingView = (ImageView) findViewById(R.id.jiubing);
        yiTiaoView = (ImageView) findViewById(R.id.yitiao);
        erTiaoView = (ImageView) findViewById(R.id.ertiao);
        sanTiaoView = (ImageView) findViewById(R.id.santiao);
        siTiaoView = (ImageView) findViewById(R.id.sitiao);
        wuTiaoView = (ImageView) findViewById(R.id.wutiao);
        liuTiaoView = (ImageView) findViewById(R.id.liutiao);
        qiTiaoView = (ImageView) findViewById(R.id.qitiao);
        baTiaoView = (ImageView) findViewById(R.id.batiao);
        jiuTiaoView = (ImageView) findViewById(R.id.jiutiao);
        dongFengView = (ImageView) findViewById(R.id.dongfeng);
        nanFengView = (ImageView) findViewById(R.id.nanfeng);
        xiFengView = (ImageView) findViewById(R.id.xifeng);
        beiFengView = (ImageView) findViewById(R.id.beifeng);
        hongZhongView = (ImageView) findViewById(R.id.hongzhong);
        baiBanView = (ImageView) findViewById(R.id.baiban);
        faCaiView = (ImageView) findViewById(R.id.facai);
        yiWanView.setOnClickListener(this);
        erWanView.setOnClickListener(this);
        sanWanView.setOnClickListener(this);
        siWanView.setOnClickListener(this);
        wuWanView.setOnClickListener(this);
        liuWanView.setOnClickListener(this);
        qiWanView.setOnClickListener(this);
        baWanView.setOnClickListener(this);
        jiuWanView.setOnClickListener(this);
        yiBingView.setOnClickListener(this);
        erBingView.setOnClickListener(this);
        sanBingView.setOnClickListener(this);
        siBingView.setOnClickListener(this);
        wuBingView.setOnClickListener(this);
        liuBingView.setOnClickListener(this);
        qiBingView.setOnClickListener(this);
        baBingView.setOnClickListener(this);
        jiuBingView.setOnClickListener(this);
        yiTiaoView.setOnClickListener(this);
        erTiaoView.setOnClickListener(this);
        sanTiaoView.setOnClickListener(this);
        siTiaoView.setOnClickListener(this);
        wuTiaoView.setOnClickListener(this);
        liuTiaoView.setOnClickListener(this);
        qiTiaoView.setOnClickListener(this);
        baTiaoView.setOnClickListener(this);
        jiuTiaoView.setOnClickListener(this);
        dongFengView.setOnClickListener(this);
        nanFengView.setOnClickListener(this);
        xiFengView.setOnClickListener(this);
        beiFengView.setOnClickListener(this);
        hongZhongView.setOnClickListener(this);
        baiBanView.setOnClickListener(this);
        faCaiView.setOnClickListener(this);

        paiCount.put(yiWanView, 4);
        paiCount.put(erWanView, 4);
        paiCount.put(sanWanView, 4);
        paiCount.put(siWanView, 4);
        paiCount.put(wuWanView, 4);
        paiCount.put(liuWanView, 4);
        paiCount.put(qiWanView, 4);
        paiCount.put(baWanView, 4);
        paiCount.put(jiuWanView, 4);
        paiCount.put(yiBingView, 4);
        paiCount.put(erBingView, 4);
        paiCount.put(sanBingView, 4);
        paiCount.put(siBingView, 4);
        paiCount.put(wuBingView, 4);
        paiCount.put(liuBingView, 4);
        paiCount.put(qiBingView, 4);
        paiCount.put(baBingView, 4);
        paiCount.put(jiuBingView, 4);
        paiCount.put(yiTiaoView, 4);
        paiCount.put(erTiaoView, 4);
        paiCount.put(sanTiaoView, 4);
        paiCount.put(siTiaoView, 4);
        paiCount.put(wuTiaoView, 4);
        paiCount.put(liuTiaoView, 4);
        paiCount.put(qiTiaoView, 4);
        paiCount.put(baTiaoView, 4);
        paiCount.put(jiuTiaoView, 4);
        paiCount.put(dongFengView, 4);
        paiCount.put(xiFengView, 4);
        paiCount.put(nanFengView, 4);
        paiCount.put(beiFengView, 4);
        paiCount.put(hongZhongView, 4);
        paiCount.put(faCaiView, 4);
        paiCount.put(baiBanView, 4);

        chiBtn0 = (Button) findViewById(R.id.chiBtn0);
        chiBtn1 = (Button) findViewById(R.id.chiBtn1);
        chiBtn2 = (Button) findViewById(R.id.chiBtn2);
        chiBtn3 = (Button) findViewById(R.id.chiBtn3);
        chiBtn0.setOnClickListener(this);
        chiBtn1.setOnClickListener(this);
        chiBtn2.setOnClickListener(this);
        chiBtn3.setOnClickListener(this);

        pengBtn0 = (Button) findViewById(R.id.pengBtn0);
        pengBtn1 = (Button) findViewById(R.id.pengBtn1);
        pengBtn2 = (Button) findViewById(R.id.pengBtn2);
        pengBtn3 = (Button) findViewById(R.id.pengBtn3);
        pengBtn0.setOnClickListener(this);
        pengBtn1.setOnClickListener(this);
        pengBtn2.setOnClickListener(this);
        pengBtn3.setOnClickListener(this);

        gangBtn0 = (Button) findViewById(R.id.gangBtn0);
        gangBtn1 = (Button) findViewById(R.id.gangBtn1);
        gangBtn2 = (Button) findViewById(R.id.gangBtn2);
        gangBtn3 = (Button) findViewById(R.id.gangBtn3);
        gangBtn0.setOnClickListener(this);
        gangBtn1.setOnClickListener(this);
        gangBtn2.setOnClickListener(this);
        gangBtn3.setOnClickListener(this);

        mingBtn0 = (Button) findViewById(R.id.mingBtn0);
        mingBtn1 = (Button) findViewById(R.id.mingBtn1);
        mingBtn2 = (Button) findViewById(R.id.mingBtn2);
        mingBtn3 = (Button) findViewById(R.id.mingBtn3);
        mingBtn4 = (Button) findViewById(R.id.mingBtn4);
        mingBtn0.setOnClickListener(this);
        mingBtn1.setOnClickListener(this);
        mingBtn2.setOnClickListener(this);
        mingBtn3.setOnClickListener(this);
        mingBtn4.setOnClickListener(this);
        mingBtn0.setVisibility(View.INVISIBLE);
        mingBtn1.setVisibility(View.INVISIBLE);
        mingBtn2.setVisibility(View.INVISIBLE);
        mingBtn3.setVisibility(View.INVISIBLE);

        anBtn0 = (Button) findViewById(R.id.anBtn0);
        anBtn1 = (Button) findViewById(R.id.anBtn1);
        anBtn2 = (Button) findViewById(R.id.anBtn2);
        anBtn3 = (Button) findViewById(R.id.anBtn3);
        anBtn4 = (Button) findViewById(R.id.anBtn4);
        anBtn0.setOnClickListener(this);
        anBtn1.setOnClickListener(this);
        anBtn2.setOnClickListener(this);
        anBtn3.setOnClickListener(this);
        anBtn4.setOnClickListener(this);
        anBtn0.setVisibility(View.INVISIBLE);
        anBtn1.setVisibility(View.INVISIBLE);
        anBtn2.setVisibility(View.INVISIBLE);
        anBtn3.setVisibility(View.INVISIBLE);

        restoreBtn = (Button) findViewById(R.id.restoreBtn);
        deleteBtn = (Button) findViewById(R.id.deleteBtn);
        calculateBtn = (Button) findViewById(R.id.calculateBtn);
        restoreBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);
        calculateBtn.setOnClickListener(this);

        Button homeBtn = findViewById(R.id.homeBtn);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch_to_main_activity();
            }
        });
        ArrayList<String> cameraResult = getIntent().getStringArrayListExtra("EXTRA_HANDS");
        EXTRA_LAN = getIntent().getStringExtra("EXTRA_LAN");
        setLanguage(EXTRA_LAN);
        if (cameraResult != null){
            Log.e("CR", cameraResult.toString());
            ArrayList<ImageView> imageViews = new ArrayList<ImageView>();
            imageViews.add(spot00);imageViews.add(spot01);imageViews.add(spot02);imageViews.add(spot10);imageViews.add(spot11);imageViews.add(spot12);imageViews.add(spot20);imageViews.add(spot21);imageViews.add(spot22);imageViews.add(spot30);imageViews.add(spot31);imageViews.add(spot32);imageViews.add(spot40);imageViews.add(spot41);
            for (String pai : cameraResult) {
                int imgID = 0;
                switch (pai){
                    case "1-w": imgID = R.id.yiwan; break;
                    case "2-w": imgID = R.id.erwan; break;
                    case "3-w": imgID = R.id.sanwan; break;
                    case "4-w": imgID = R.id.siwan; break;
                    case "5-w": imgID = R.id.wuwan; break;
                    case "6-w": imgID = R.id.liuwan; break;
                    case "7-w": imgID = R.id.qiwan; break;
                    case "8-w": imgID = R.id.bawan; break;
                    case "9-w": imgID = R.id.jiuwan; break;

                    case "1-b": imgID = R.id.yibing; break;
                    case "2-b": imgID = R.id.erbing; break;
                    case "3-b": imgID = R.id.sanbing; break;
                    case "4-b": imgID = R.id.sibing; break;
                    case "5-b": imgID = R.id.wubing; break;
                    case "6-b": imgID = R.id.liubing; break;
                    case "7-b": imgID = R.id.qibing; break;
                    case "8-b": imgID = R.id.babing; break;
                    case "9-b": imgID = R.id.jiubing; break;

                    case "1-t": imgID = R.id.yitiao; break;
                    case "2-t": imgID = R.id.ertiao; break;
                    case "3-t": imgID = R.id.santiao; break;
                    case "4-t": imgID = R.id.sitiao; break;
                    case "5-t": imgID = R.id.wutiao; break;
                    case "6-t": imgID = R.id.liutiao; break;
                    case "7-t": imgID = R.id.qitiao; break;
                    case "8-t": imgID = R.id.batiao; break;
                    case "9-t": imgID = R.id.jiutiao; break;

                    case "d-f": imgID = R.id.dongfeng; break;
                    case "x-f": imgID = R.id.xifeng; break;
                    case "n-f": imgID = R.id.nanfeng; break;
                    case "b-f": imgID = R.id.beifeng; break;
                    case "h-Z": imgID = R.id.hongzhong; break;
                    case "b-B": imgID = R.id.baiban; break;
                    case "f-F": imgID = R.id.facai; break;
                    default: break;
                }

                for (int i =0; i<imageViews.size(); i++){
                    if (imageViews.get(i) != null) {
                        theChosenSpot = imageViews.get(0);
                        imageViews.remove(0);
                        break;
                    }
                }
                if (imgID != 0)
                    onPaiClick(imgID);
            }
        }
    }

    private void setLanguage(String extra_lan) {
        if (extra_lan.equals("EN")){
            restoreBtn.setText(getText(R.string.manually_restore_EN));
            deleteBtn.setText(getText(R.string.manually_delete_EN));
            calculateBtn.setText(getText(R.string.manually_calculate_EN));
        }else {
            restoreBtn.setText(getText(R.string.manually_restore));
            deleteBtn.setText(getText(R.string.manually_delete));
            calculateBtn.setText(getText(R.string.manually_calculate));
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.spot00:
            case R.id.spot01:
            case R.id.spot02:
            case R.id.spot10:
            case R.id.spot11:
            case R.id.spot12:
            case R.id.spot20:
            case R.id.spot21:
            case R.id.spot22:
            case R.id.spot30:
            case R.id.spot31:
            case R.id.spot32:
            case R.id.spot40:
            case R.id.spot41:
                onSpotClick(v.getId());
                break;

            case R.id.yiwan:
            case R.id.erwan:
            case R.id.sanwan:
            case R.id.siwan:
            case R.id.wuwan:
            case R.id.liuwan:
            case R.id.qiwan:
            case R.id.bawan:
            case R.id.jiuwan:
            case R.id.yibing:
            case R.id.erbing:
            case R.id.sanbing:
            case R.id.sibing:
            case R.id.wubing:
            case R.id.liubing:
            case R.id.qibing:
            case R.id.babing:
            case R.id.jiubing:
            case R.id.yitiao:
            case R.id.ertiao:
            case R.id.santiao:
            case R.id.sitiao:
            case R.id.wutiao:
            case R.id.liutiao:
            case R.id.qitiao:
            case R.id.batiao:
            case R.id.jiutiao:
            case R.id.dongfeng:
            case R.id.nanfeng:
            case R.id.xifeng:
            case R.id.beifeng:
            case R.id.hongzhong:
            case R.id.facai:
            case R.id.baiban:
                onPaiClick(v.getId());
                break;

            case R.id.chiBtn0:
            case R.id.chiBtn1:
            case R.id.chiBtn2:
            case R.id.chiBtn3:
            case R.id.pengBtn0:
            case R.id.pengBtn1:
            case R.id.pengBtn2:
            case R.id.pengBtn3:
            case R.id.gangBtn0:
            case R.id.gangBtn1:
            case R.id.gangBtn2:
            case R.id.gangBtn3:
                onChiPengGangBtnClick(v.getId(), v);
                break;

            case R.id.mingBtn0:
            case R.id.mingBtn1:
            case R.id.mingBtn2:
            case R.id.mingBtn3:
            case R.id.mingBtn4:
            case R.id.anBtn0:
            case R.id.anBtn1:
            case R.id.anBtn2:
            case R.id.anBtn3:
            case R.id.anBtn4:
                onMingAnBtnClick(v.getId(), v);
                break;

            case R.id.restoreBtn:
            case R.id.deleteBtn:
            case R.id.calculateBtn:
                onActionBtnClick(v.getId(), v, this);

            default:
                break;
        }
    }

    private void onSpotClick(int id) {
        ImageView theSpot = (ImageView) findViewById(id);

        if (theSpot != null) {

            ColorDrawable cd = (ColorDrawable) theSpot.getBackground();
            if (cd != null) {
                int color = cd.getColor();
                if (color == Color.RED) {
                    Log.i(TAG, "chosen spot red background");
                    theSpot.setBackgroundColor(Color.WHITE);
                    theSpot.setPadding(0, 0, 0, 0);
                    theChosenSpot = null;
                } else if (color == Color.WHITE) {
                    Log.i(TAG, "chosen spot white background");
                    if (theChosenSpot != null) {
                        theChosenSpot.setBackgroundColor(Color.WHITE);
                        theChosenSpot.setPadding(0, 0, 0, 0);
                        theChosenSpot = null;
                    }
                    theSpot.setBackgroundColor(Color.RED);
                    theSpot.setPadding(2, 2, 2, 2);
                    theChosenSpot = theSpot;
                }
            } else {
                Log.i(TAG, "chosen spot no background detected");
                if (theChosenSpot != null) {
                    theChosenSpot.setBackgroundColor(Color.WHITE);
                    theChosenSpot.setPadding(0, 0, 0, 0);
                    theChosenSpot = null;
                }
                theSpot.setBackgroundColor(Color.RED);
                theSpot.setPadding(2, 2, 2, 2);
                theChosenSpot = theSpot;
            }
            Log.i(TAG, "the chosen spot is null: " + (theChosenSpot == null));
        }
    }

    private void onPaiClick(int id) {
        int drawableID = -1;
        switch (id) {
            case R.id.yiwan:
                drawableID = R.drawable.yiwan;
                break;
            case R.id.erwan:
                drawableID = R.drawable.erwan;
                break;
            case R.id.sanwan:
                drawableID = R.drawable.sanwan;
                break;
            case R.id.siwan:
                drawableID = R.drawable.siwan;
                break;
            case R.id.wuwan:
                drawableID = R.drawable.wuwan;
                break;
            case R.id.liuwan:
                drawableID = R.drawable.liuwan;
                break;
            case R.id.qiwan:
                drawableID = R.drawable.qiwan;
                break;
            case R.id.bawan:
                drawableID = R.drawable.bawan;
                break;
            case R.id.jiuwan:
                drawableID = R.drawable.jiuwan;
                break;
            case R.id.yibing:
                drawableID = R.drawable.yibing;
                break;
            case R.id.erbing:
                drawableID = R.drawable.erbing;
                break;
            case R.id.sanbing:
                drawableID = R.drawable.sanbing;
                break;
            case R.id.sibing:
                drawableID = R.drawable.sibing;
                break;
            case R.id.wubing:
                drawableID = R.drawable.wubing;
                break;
            case R.id.liubing:
                drawableID = R.drawable.liubing;
                break;
            case R.id.qibing:
                drawableID = R.drawable.qibing;
                break;
            case R.id.babing:
                drawableID = R.drawable.babing;
                break;
            case R.id.jiubing:
                drawableID = R.drawable.jiubing;
                break;
            case R.id.yitiao:
                drawableID = R.drawable.yitiao;
                break;
            case R.id.ertiao:
                drawableID = R.drawable.ertiao;
                break;
            case R.id.santiao:
                drawableID = R.drawable.santiao;
                break;
            case R.id.sitiao:
                drawableID = R.drawable.sitiao;
                break;
            case R.id.wutiao:
                drawableID = R.drawable.wutiao;
                break;
            case R.id.liutiao:
                drawableID = R.drawable.liutiao;
                break;
            case R.id.qitiao:
                drawableID = R.drawable.qitiao;
                break;
            case R.id.batiao:
                drawableID = R.drawable.batiao;
                break;
            case R.id.jiutiao:
                drawableID = R.drawable.jiutiao;
                break;
            case R.id.dongfeng:
                drawableID = R.drawable.dongfeng;
                break;
            case R.id.nanfeng:
                drawableID = R.drawable.nanfeng;
                break;
            case R.id.xifeng:
                drawableID = R.drawable.xifeng;
                break;
            case R.id.beifeng:
                drawableID = R.drawable.beifeng;
                break;
            case R.id.hongzhong:
                drawableID = R.drawable.hongzhong;
                break;
            case R.id.facai:
                drawableID = R.drawable.facai;
                break;
            case R.id.baiban:
                drawableID = R.drawable.baiban;
                break;
            default:
                drawableID = -1;
                break;
        }

        if (drawableID != -1) {
            if (theChosenSpot == null) {
                for (int i = 0; i < spots.length; i++) {
                    if (spots[i] == null) {
                        switch (i) {
                            case 0:
                                spot00.setImageResource(drawableID);
                                break;
                            case 1:
                                spot01.setImageResource(drawableID);
                                break;
                            case 2:
                                spot02.setImageResource(drawableID);
                                break;
                            case 3:
                                spot10.setImageResource(drawableID);
                                break;
                            case 4:
                                spot11.setImageResource(drawableID);
                                break;
                            case 5:
                                spot12.setImageResource(drawableID);
                                break;
                            case 6:
                                spot20.setImageResource(drawableID);
                                break;
                            case 7:
                                spot21.setImageResource(drawableID);
                                break;
                            case 8:
                                spot22.setImageResource(drawableID);
                                break;
                            case 9:
                                spot30.setImageResource(drawableID);
                                break;
                            case 10:
                                spot31.setImageResource(drawableID);
                                break;
                            case 11:
                                spot32.setImageResource(drawableID);
                                break;
                            case 12:
                                spot40.setImageResource(drawableID);
                                break;
                            case 13:
                                spot41.setImageResource(drawableID);
                                break;
                        }
                        spots[i] = findViewById(id);
                        int num = paiCount.get(spots[i]);
                        if (num <= 1) {
                            findViewById(id).setClickable(false);
                        }
                        paiCount.put(spots[i], num - 1);
                        fillHandArray();
//                        Log.e("hands", hands.toString());
                        break;
                    }
                }
            } else {
                int index = -1;
                if (theChosenSpot == spot00) {
                    if (spots[0] != null) {
                        int num = paiCount.get(spots[0]);
                        spots[0].setClickable(true);
                        paiCount.put(spots[0], num + 1);
                    }
                    spots[0] = findViewById(id);
                    spot00.setImageResource(drawableID);
                    index = 0;
                } else if (theChosenSpot == spot01) {
                    if (spots[1] != null) {
                        int num = paiCount.get(spots[1]);
                        spots[1].setClickable(true);
                        paiCount.put(spots[1], num + 1);
                    }
                    spots[1] = findViewById(id);
                    spot01.setImageResource(drawableID);
                    index = 1;

                } else if (theChosenSpot == spot02) {
                    if (spots[2] != null) {
                        int num = paiCount.get(spots[2]);
                        spots[2].setClickable(true);
                        paiCount.put(spots[2], num + 1);
                    }
                    spots[2] = findViewById(id);
                    spot02.setImageResource(drawableID);
                    index = 2;

                } else if (theChosenSpot == spot10) {
                    if (spots[3] != null) {
                        int num = paiCount.get(spots[3]);
                        spots[3].setClickable(true);
                        paiCount.put(spots[3], num + 1);
                    }
                    spots[3] = findViewById(id);
                    spot10.setImageResource(drawableID);
                    index = 3;

                } else if (theChosenSpot == spot11) {
                    if (spots[4] != null) {
                        int num = paiCount.get(spots[4]);
                        spots[4].setClickable(true);
                        paiCount.put(spots[4], num + 1);
                    }
                    spots[4] = findViewById(id);
                    spot11.setImageResource(drawableID);
                    index = 4;
                } else if (theChosenSpot == spot12) {
                    if (spots[5] != null) {
                        int num = paiCount.get(spots[5]);
                        spots[5].setClickable(true);
                        paiCount.put(spots[5], num + 1);
                    }
                    spots[5] = findViewById(id);
                    spot12.setImageResource(drawableID);
                    index = 5;

                } else if (theChosenSpot == spot20) {
                    if (spots[6] != null) {
                        int num = paiCount.get(spots[6]);
                        spots[6].setClickable(true);
                        paiCount.put(spots[6], num + 1);
                    }
                    spots[6] = findViewById(id);
                    spot20.setImageResource(drawableID);
                    index = 6;

                } else if (theChosenSpot == spot21) {
                    if (spots[7] != null) {
                        int num = paiCount.get(spots[7]);
                        spots[7].setClickable(true);
                        paiCount.put(spots[7], num + 1);
                    }
                    spots[7] = findViewById(id);
                    spot21.setImageResource(drawableID);
                    index = 7;

                } else if (theChosenSpot == spot22) {
                    if (spots[8] != null) {
                        int num = paiCount.get(spots[8]);
                        spots[8].setClickable(true);
                        paiCount.put(spots[8], num + 1);
                    }
                    spots[8] = findViewById(id);
                    spot22.setImageResource(drawableID);
                    index = 8;

                } else if (theChosenSpot == spot30) {
                    if (spots[9] != null) {
                        int num = paiCount.get(spots[9]);
                        spots[9].setClickable(true);
                        paiCount.put(spots[9], num + 1);
                    }
                    spots[9] = findViewById(id);
                    spot30.setImageResource(drawableID);
                    index = 9;

                } else if (theChosenSpot == spot31) {
                    if (spots[10] != null) {
                        int num = paiCount.get(spots[10]);
                        spots[10].setClickable(true);
                        paiCount.put(spots[10], num + 1);
                    }
                    spots[10] = findViewById(id);
                    spot31.setImageResource(drawableID);
                    index = 10;

                } else if (theChosenSpot == spot32) {
                    if (spots[11] != null) {
                        int num = paiCount.get(spots[11]);
                        spots[11].setClickable(true);
                        paiCount.put(spots[11], num + 1);
                    }
                    spots[11] = findViewById(id);
                    spot32.setImageResource(drawableID);
                    index = 11;

                } else if (theChosenSpot == spot40) {
                    if (spots[12] != null) {
                        int num = paiCount.get(spots[12]);
                        spots[12].setClickable(true);
                        paiCount.put(spots[12], num + 1);
                    }
                    spots[12] = findViewById(id);
                    spot40.setImageResource(drawableID);
                    index = 12;

                } else if (theChosenSpot == spot41) {
                    if (spots[13] != null) {
                        int num = paiCount.get(spots[13]);
                        spots[13].setClickable(true);
                        paiCount.put(spots[13], num + 1);
                    }
                    spots[13] = findViewById(id);
                    spot41.setImageResource(drawableID);
                    index = 13;
                }

                int num = paiCount.get(spots[index]);
                if (num <= 1) {
                    findViewById(id).setClickable(false);
                }
                paiCount.put(spots[index], num - 1);
                fillHandArray();
//                Log.e("hands", hands.toString());
                theChosenSpot.setBackgroundColor(Color.WHITE);
                theChosenSpot.setPadding(0, 0, 0, 0);
                if (theChosenSpot == spot00 || theChosenSpot == spot01 || theChosenSpot == spot02) {
                    Button button = findViewById(R.id.chiBtn0);
                    button.setBackgroundResource(R.drawable.round_btn_default);
                    button.setTextColor(Color.rgb(171, 166, 164));

                    button = findViewById(R.id.pengBtn0);
                    button.setBackgroundResource(R.drawable.round_btn_default);
                    button.setTextColor(Color.rgb(171, 166, 164));

                    gangbtnControl(R.id.gangBtn0, false);

                } else if (theChosenSpot == spot10 || theChosenSpot == spot11 || theChosenSpot == spot12) {
                    Button button = findViewById(R.id.chiBtn1);
                    button.setBackgroundResource(R.drawable.round_btn_default);
                    button.setTextColor(Color.rgb(171, 166, 164));

                    button = findViewById(R.id.pengBtn1);
                    button.setBackgroundResource(R.drawable.round_btn_default);
                    button.setTextColor(Color.rgb(171, 166, 164));

                    gangbtnControl(R.id.gangBtn1, false);
                } else if (theChosenSpot == spot20 || theChosenSpot == spot21 || theChosenSpot == spot22) {
                    Button button = findViewById(R.id.chiBtn2);
                    button.setBackgroundResource(R.drawable.round_btn_default);
                    button.setTextColor(Color.rgb(171, 166, 164));

                    button = findViewById(R.id.pengBtn2);
                    button.setBackgroundResource(R.drawable.round_btn_default);
                    button.setTextColor(Color.rgb(171, 166, 164));

                    gangbtnControl(R.id.gangBtn2, false);
                } else if (theChosenSpot == spot30 || theChosenSpot == spot31 || theChosenSpot == spot32) {
                    Button button = findViewById(R.id.chiBtn3);
                    button.setBackgroundResource(R.drawable.round_btn_default);
                    button.setTextColor(Color.rgb(171, 166, 164));

                    button = findViewById(R.id.pengBtn3);
                    button.setBackgroundResource(R.drawable.round_btn_default);
                    button.setTextColor(Color.rgb(171, 166, 164));

                    gangbtnControl(R.id.gangBtn3, false);
                }
                theChosenSpot = null;
            }
        }
    }

    private void onChiPengGangBtnClick(int id, View v) {
        if (id == R.id.chiBtn0 || id == R.id.chiBtn1 || id == R.id.chiBtn2 || id == R.id.chiBtn3) {
            String pai1;
            String pai2;
            String pai3;
            int num1 = 0;
            int num2 = 0;
            int num3 = 0;

            if (hands.isEmpty())
                return;
            Log.e(TAG, hands.toString());
            if (id == R.id.chiBtn0) {
                pai1 = hands.get(0);
                pai2 = hands.get(1);
                pai3 = hands.get(2);
            } else if (id == R.id.chiBtn1) {
                pai1 = hands.get(3);
                pai2 = hands.get(4);
                pai3 = hands.get(5);
            } else if (id == R.id.chiBtn2) {
                pai1 = hands.get(6);
                pai2 = hands.get(7);
                pai3 = hands.get(8);
            } else {
                pai1 = hands.get(9);
                pai2 = hands.get(10);
                pai3 = hands.get(11);
            }

            if (pai1.endsWith("wan") && pai2.endsWith("wan") && pai3.endsWith("wan")) {
                num1 = stringToInt(pai1.split("wan")[0]);
                num2 = stringToInt(pai2.split("wan")[0]);
                num3 = stringToInt(pai3.split("wan")[0]);
            } else if (pai1.endsWith("bing") && pai2.endsWith("bing") && pai3.endsWith("bing")) {
                num1 = stringToInt(pai1.split("bing")[0]);
                num2 = stringToInt(pai2.split("bing")[0]);
                num3 = stringToInt(pai3.split("bing")[0]);
            } else if (pai1.endsWith("tiao") && pai2.endsWith("tiao") && pai3.endsWith("tiao")) {
                num1 = stringToInt(pai1.split("tiao")[0]);
                num2 = stringToInt(pai2.split("tiao")[0]);
                num3 = stringToInt(pai3.split("tiao")[0]);
            } else return;

            if (num1 != 0 && num2 != 0 && num3 != 0) {
                int sorted[] = {num1, num2, num3};
                Arrays.sort(sorted);
                if (!(sorted[0] + 1 == sorted[1] && sorted[1] + 1 == sorted[2])) {
                    return;
                }
            }
            Button button = findViewById(id);
            if (button.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.round_btn_highlight).getConstantState())) { //restore highlight to default
                button.setBackgroundResource(R.drawable.round_btn_default);
                button.setTextColor(Color.rgb(171, 166, 164));
            } else {
                button.setBackgroundResource(R.drawable.round_btn_highlight);
                button.setTextColor(Color.BLACK);
                Button oppositeBtn;
                int gangBtnID;
                if (id == R.id.chiBtn0) {
                    oppositeBtn = findViewById(R.id.pengBtn0);
                    gangBtnID = R.id.gangBtn0;
                } else if (id == R.id.chiBtn1) {
                    oppositeBtn = findViewById(R.id.pengBtn1);
                    gangBtnID = R.id.gangBtn1;
                } else if (id == R.id.chiBtn2) {
                    oppositeBtn = findViewById(R.id.pengBtn2);
                    gangBtnID = R.id.gangBtn2;
                } else {
                    oppositeBtn = findViewById(R.id.pengBtn3);
                    gangBtnID = R.id.gangBtn3;
                }
                oppositeBtn.setBackgroundResource(R.drawable.round_btn_default);
                oppositeBtn.setTextColor(Color.rgb(171, 166, 164));
                gangbtnControl(gangBtnID, false);
            }
        } else if (id == R.id.pengBtn0 || id == R.id.pengBtn1 || id == R.id.pengBtn2 || id == R.id.pengBtn3) {
            ImageView thePai = null;
            if (hands.isEmpty() || Collections.frequency(hands,"null") == hands.size())
                return;
            if (id == R.id.pengBtn0) {
                if (!(hands.get(0).equals(hands.get(1)) && hands.get(1).equals(hands.get(2))) || hands.get(0).equals("null"))
                    return;
                thePai = spots[0];
            } else if (id == R.id.pengBtn1) {
                if (!(hands.get(3).equals(hands.get(4)) && hands.get(4).equals(hands.get(5))) || hands.get(3).equals("null"))
                    return;
                thePai = spots[3];
            } else if (id == R.id.pengBtn2) {
                if (!(hands.get(6).equals(hands.get(7)) && hands.get(7).equals(hands.get(8))) || hands.get(6).equals("null"))
                    return;
                thePai = spots[6];
            } else {
                if (!(hands.get(9).equals(hands.get(10)) && hands.get(10).equals(hands.get(11))) || hands.get(9).equals("null"))
                    return;
                thePai = spots[9];
            }

            Button button = findViewById(id);
            if (button.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.round_btn_highlight).getConstantState())) { //restore highlight to default
                button.setBackgroundResource(R.drawable.round_btn_default);
                button.setTextColor(Color.rgb(171, 166, 164));
            } else {
                button.setBackgroundResource(R.drawable.round_btn_highlight);
                button.setTextColor(Color.BLACK);
                Button oppositeBtn;
                int gangBtnID;
                if (id == R.id.pengBtn0) {
                    oppositeBtn = findViewById(R.id.chiBtn0);
                    gangBtnID = R.id.gangBtn0;
                } else if (id == R.id.pengBtn1) {
                    oppositeBtn = findViewById(R.id.chiBtn1);
                    gangBtnID = R.id.gangBtn1;
                } else if (id == R.id.pengBtn2) {
                    oppositeBtn = findViewById(R.id.chiBtn2);
                    gangBtnID = R.id.gangBtn2;
                } else {
                    oppositeBtn = findViewById(R.id.chiBtn3);
                    gangBtnID = R.id.gangBtn3;
                }
                oppositeBtn.setBackgroundResource(R.drawable.round_btn_default);
                oppositeBtn.setTextColor(Color.rgb(171, 166, 164));
                if (isHighlightBtn(v, findViewById(gangBtnID))){
                    int num = paiCount.get(thePai);
                    if (num < 1)
                        thePai.setClickable(true);
                    paiCount.put(thePai, num + 1);
                    gangbtnControl(gangBtnID, false);
                }

            }
        } else if (id == R.id.gangBtn0 || id == R.id.gangBtn1 || id == R.id.gangBtn2 || id == R.id.gangBtn3) {
            ImageView thePai = null;
            if (hands.isEmpty() || Collections.frequency(hands,"null") == hands.size())
                return;
            Log.e(TAG, hands.toString());
            if (id == R.id.gangBtn0) {
                if (!(hands.get(0).equals(hands.get(1)) && hands.get(1).equals(hands.get(2))) || hands.get(0).equals("null"))
                    return;
                thePai = spots[0];
            } else if (id == R.id.gangBtn1) {
                if (!(hands.get(3).equals(hands.get(4)) && hands.get(4).equals(hands.get(5))) || hands.get(3).equals("null"))
                    return;
                thePai = spots[3];
            } else if (id == R.id.gangBtn2) {
                if (!(hands.get(6).equals(hands.get(7)) && hands.get(7).equals(hands.get(8))) || hands.get(6).equals("null"))
                    return;
                thePai = spots[6];
            } else {
                if (!(hands.get(9).equals(hands.get(10)) && hands.get(10).equals(hands.get(11))) || hands.get(9).equals("null"))
                    return;
                thePai = spots[9];
            }

            Button button = findViewById(id);
            Button chi;
            Button peng;
            if (id == R.id.gangBtn0) {
                chi = findViewById(R.id.chiBtn0);
                peng = findViewById(R.id.pengBtn0);
            } else if (id == R.id.gangBtn1) {
                chi = findViewById(R.id.chiBtn1);
                peng = findViewById(R.id.pengBtn1);
            } else if (id == R.id.gangBtn2) {
                chi = findViewById(R.id.chiBtn2);
                peng = findViewById(R.id.pengBtn2);
            } else {
                chi = findViewById(R.id.chiBtn3);
                peng = findViewById(R.id.pengBtn3);
            }
            if (button.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.round_btn_highlight).getConstantState())) { //restore highlight to default
                gangbtnControl(id, false);
                int num = paiCount.get(thePai);
                if (num < 1)
                    thePai.setClickable(true);
                paiCount.put(thePai, num + 1);
            } else {
                int num = paiCount.get(thePai);
                if (num < 1) {
                    return;
                }else
                    thePai.setClickable(false);
                paiCount.put(thePai, num - 1);
                gangbtnControl(id, true);
                chi.setBackgroundResource(R.drawable.round_btn_default);
                chi.setTextColor(Color.rgb(171, 166, 164));
                peng.setBackgroundResource(R.drawable.round_btn_default);
                peng.setTextColor(Color.rgb(171, 166, 164));
            }
        }
    }

    private void gangbtnControl(int id, boolean highlight) {
        Button button = findViewById(id);
        Button ming;
        Button an;
        if (id == R.id.gangBtn0) {
            ming = findViewById(R.id.mingBtn0);
            an = findViewById(R.id.anBtn0);
        } else if (id == R.id.gangBtn1) {
            ming = findViewById(R.id.mingBtn1);
            an = findViewById(R.id.anBtn1);
        } else if (id == R.id.gangBtn2) {
            ming = findViewById(R.id.mingBtn2);
            an = findViewById(R.id.anBtn2);
        } else {
            ming = findViewById(R.id.mingBtn3);
            an = findViewById(R.id.anBtn3);
        }
        if (highlight) {
            button.setBackgroundResource(R.drawable.round_btn_highlight);
            button.setTextColor(Color.BLACK);

            ming.setVisibility(View.VISIBLE);
            an.setVisibility(View.VISIBLE);

            an.setBackgroundResource(R.drawable.round_btn_highlight);
            an.setTextColor(Color.BLACK);
        } else {
            button.setBackgroundResource(R.drawable.round_btn_default);
            button.setTextColor(Color.rgb(171, 166, 164));
            ming.setBackgroundResource(R.drawable.round_btn_default);
            ming.setTextColor(Color.rgb(171, 166, 164));
            ming.setVisibility(View.INVISIBLE);
            an.setBackgroundResource(R.drawable.round_btn_default);
            an.setTextColor(Color.rgb(171, 166, 164));
            an.setVisibility(View.INVISIBLE);
        }
    }

    private void onMingAnBtnClick(int id, View v) {
        if (id == R.id.mingBtn0 || id == R.id.mingBtn1 || id == R.id.mingBtn2 || id == R.id.mingBtn3 || id == R.id.mingBtn4) {
            Button button = findViewById(id);
            if (button.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.round_btn_highlight).getConstantState())) { //restore highlight to default
                button.setBackgroundResource(R.drawable.round_btn_default);
                button.setTextColor(Color.rgb(171, 166, 164));
            } else {
                button.setBackgroundResource(R.drawable.round_btn_highlight);
                button.setTextColor(Color.BLACK);
                Button oppositeBtn = null;
                if (id == R.id.mingBtn0)
                    oppositeBtn = findViewById(R.id.anBtn0);
                else if (id == R.id.mingBtn1)
                    oppositeBtn = findViewById(R.id.anBtn1);
                else if (id == R.id.mingBtn2)
                    oppositeBtn = findViewById(R.id.anBtn2);
                else if (id == R.id.mingBtn3)
                    oppositeBtn = findViewById(R.id.anBtn3);
                else
                    oppositeBtn = findViewById(R.id.anBtn4);
                oppositeBtn.setBackgroundResource(R.drawable.round_btn_default);
                oppositeBtn.setTextColor(Color.rgb(171, 166, 164));
            }
        } else if (id == R.id.anBtn0 || id == R.id.anBtn1 || id == R.id.anBtn2 || id == R.id.anBtn3 || id == R.id.anBtn4) {
            Button button = findViewById(id);
            if (button.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.round_btn_highlight).getConstantState())) { //restore highlight to default
                button.setBackgroundResource(R.drawable.round_btn_default);
                button.setTextColor(Color.rgb(171, 166, 164));
            } else {
                button.setBackgroundResource(R.drawable.round_btn_highlight);
                button.setTextColor(Color.BLACK);
                Button oppositeBtn = null;
                if (id == R.id.anBtn0)
                    oppositeBtn = findViewById(R.id.mingBtn0);
                else if (id == R.id.anBtn1)
                    oppositeBtn = findViewById(R.id.mingBtn1);
                else if (id == R.id.anBtn2)
                    oppositeBtn = findViewById(R.id.mingBtn2);
                else if (id == R.id.anBtn3)
                    oppositeBtn = findViewById(R.id.mingBtn3);
                else
                    oppositeBtn = findViewById(R.id.mingBtn4);
                oppositeBtn.setBackgroundResource(R.drawable.round_btn_default);
                oppositeBtn.setTextColor(Color.rgb(171, 166, 164));
            }
        }
    }

    private void onActionBtnClick(int id, View v, Activity activity) {
        if (id == R.id.restoreBtn) {
            spots = new ImageView[]{null, null, null,
                    null, null, null,
                    null, null, null,
                    null, null, null,
                    null, null};
            spot00.setImageResource(R.drawable.background);
            spot01.setImageResource(R.drawable.background);
            spot02.setImageResource(R.drawable.background);
//            spot03.setImageResource(R.drawable.background);
            spot10.setImageResource(R.drawable.background);
            spot11.setImageResource(R.drawable.background);
            spot12.setImageResource(R.drawable.background);
//            spot13.setImageResource(R.drawable.background);
            spot20.setImageResource(R.drawable.background);
            spot21.setImageResource(R.drawable.background);
            spot22.setImageResource(R.drawable.background);
//            spot23.setImageResource(R.drawable.background);
            spot30.setImageResource(R.drawable.background);
            spot31.setImageResource(R.drawable.background);
            spot32.setImageResource(R.drawable.background);
            spot40.setImageResource(R.drawable.background);
            spot41.setImageResource(R.drawable.background);

            hands.clear();
            paiCount.clear();
            paiCount.put(yiWanView, 4);
            paiCount.put(erWanView, 4);
            paiCount.put(sanWanView, 4);
            paiCount.put(siWanView, 4);
            paiCount.put(wuWanView, 4);
            paiCount.put(liuWanView, 4);
            paiCount.put(qiWanView, 4);
            paiCount.put(baWanView, 4);
            paiCount.put(jiuWanView, 4);
            paiCount.put(yiBingView, 4);
            paiCount.put(erBingView, 4);
            paiCount.put(sanBingView, 4);
            paiCount.put(siBingView, 4);
            paiCount.put(wuBingView, 4);
            paiCount.put(liuBingView, 4);
            paiCount.put(qiBingView, 4);
            paiCount.put(baBingView, 4);
            paiCount.put(jiuBingView, 4);
            paiCount.put(yiTiaoView, 4);
            paiCount.put(erTiaoView, 4);
            paiCount.put(sanTiaoView, 4);
            paiCount.put(siTiaoView, 4);
            paiCount.put(wuTiaoView, 4);
            paiCount.put(liuTiaoView, 4);
            paiCount.put(qiTiaoView, 4);
            paiCount.put(baTiaoView, 4);
            paiCount.put(jiuTiaoView, 4);
            paiCount.put(dongFengView, 4);
            paiCount.put(xiFengView, 4);
            paiCount.put(nanFengView, 4);
            paiCount.put(beiFengView, 4);
            paiCount.put(hongZhongView, 4);
            paiCount.put(faCaiView, 4);
            paiCount.put(baiBanView, 4);

            for (Map.Entry mapElement : paiCount.entrySet()) {
                ImageView key = (ImageView) mapElement.getKey();
                key.setClickable(true);
            }
            if (theChosenSpot != null) {
                theChosenSpot.setBackgroundColor(Color.WHITE);
                theChosenSpot.setPadding(0, 0, 0, 0);
                theChosenSpot = null;
            }
            Button button = findViewById(R.id.chiBtn0);
            button.setBackgroundResource(R.drawable.round_btn_default);
            button.setTextColor(Color.rgb(171, 166, 164));
            button = findViewById(R.id.chiBtn1);
            button.setBackgroundResource(R.drawable.round_btn_default);
            button.setTextColor(Color.rgb(171, 166, 164));
            button = findViewById(R.id.chiBtn2);
            button.setBackgroundResource(R.drawable.round_btn_default);
            button.setTextColor(Color.rgb(171, 166, 164));
            button = findViewById(R.id.chiBtn3);
            button.setBackgroundResource(R.drawable.round_btn_default);
            button.setTextColor(Color.rgb(171, 166, 164));
            button = findViewById(R.id.pengBtn0);
            button.setBackgroundResource(R.drawable.round_btn_default);
            button.setTextColor(Color.rgb(171, 166, 164));
            button = findViewById(R.id.pengBtn1);
            button.setBackgroundResource(R.drawable.round_btn_default);
            button.setTextColor(Color.rgb(171, 166, 164));
            button = findViewById(R.id.pengBtn2);
            button.setBackgroundResource(R.drawable.round_btn_default);
            button.setTextColor(Color.rgb(171, 166, 164));
            button = findViewById(R.id.pengBtn3);
            button.setBackgroundResource(R.drawable.round_btn_default);
            button.setTextColor(Color.rgb(171, 166, 164));
            gangbtnControl(R.id.gangBtn0, false);
            gangbtnControl(R.id.gangBtn1, false);
            gangbtnControl(R.id.gangBtn2, false);
            gangbtnControl(R.id.gangBtn3, false);
            button = findViewById(R.id.mingBtn4);
            button.setBackgroundResource(R.drawable.round_btn_default);
            button.setTextColor(Color.rgb(171, 166, 164));
            button = findViewById(R.id.anBtn4);
            button.setBackgroundResource(R.drawable.round_btn_highlight);
            button.setTextColor(Color.BLACK);

        } else if (id == R.id.deleteBtn) {
            if (theChosenSpot != null) {
                deletePai(theChosenSpot, v);
//                if (theChosenSpot == spot00) {
//                    if (spots[0] != null) {
//                        int num = paiCount.get(spots[0]);
//                        spots[0].setClickable(true);
//                        paiCount.put(spots[0], num + 1);
//                        spots[0] = null;
//                    }
//                } else if (theChosenSpot == spot01) {
//                    if (spots[1] != null) {
//                        int num = paiCount.get(spots[1]);
//                        spots[1].setClickable(true);
//                        paiCount.put(spots[1], num + 1);
//                        spots[1] = null;
//                    }
//                } else if (theChosenSpot == spot02) {
//                    if (spots[2] != null) {
//                        int num = paiCount.get(spots[2]);
//                        spots[2].setClickable(true);
//                        paiCount.put(spots[2], num + 1);
//                        spots[2] = null;
//                    }
//                } else if (theChosenSpot == spot10) {
//                    if (spots[3] != null) {
//                        int num = paiCount.get(spots[3]);
//                        spots[3].setClickable(true);
//                        paiCount.put(spots[3], num + 1);
//                        spots[3] = null;
//                    }
//                } else if (theChosenSpot == spot11) {
//                    if (spots[4] != null) {
//                        int num = paiCount.get(spots[4]);
//                        spots[4].setClickable(true);
//                        paiCount.put(spots[4], num + 1);
//                        spots[4] = null;
//                    }
//                } else if (theChosenSpot == spot12) {
//                    if (spots[5] != null) {
//                        int num = paiCount.get(spots[5]);
//                        spots[5].setClickable(true);
//                        paiCount.put(spots[5], num + 1);
//                        spots[5] = null;
//                    }
//                } else if (theChosenSpot == spot20) {
//                    if (spots[6] != null) {
//                        int num = paiCount.get(spots[6]);
//                        spots[6].setClickable(true);
//                        paiCount.put(spots[6], num + 1);
//                        spots[6] = null;
//                    }
//                } else if (theChosenSpot == spot21) {
//                    if (spots[7] != null) {
//                        int num = paiCount.get(spots[7]);
//                        spots[7].setClickable(true);
//                        paiCount.put(spots[7], num + 1);
//                        spots[7] = null;
//                    }
//                } else if (theChosenSpot == spot22) {
//                    if (spots[8] != null) {
//                        int num = paiCount.get(spots[8]);
//                        spots[8].setClickable(true);
//                        paiCount.put(spots[8], num + 1);
//                        spots[8] = null;
//                    }
//                } else if (theChosenSpot == spot30) {
//                    if (spots[9] != null) {
//                        int num = paiCount.get(spots[9]);
//                        spots[9].setClickable(true);
//                        paiCount.put(spots[9], num + 1);
//                        spots[9] = null;
//                    }
//                } else if (theChosenSpot == spot31) {
//                    if (spots[10] != null) {
//                        int num = paiCount.get(spots[10]);
//                        spots[10].setClickable(true);
//                        paiCount.put(spots[10], num + 1);
//                        spots[10] = null;
//                    }
//                } else if (theChosenSpot == spot32) {
//                    if (spots[11] != null) {
//                        int num = paiCount.get(spots[11]);
//                        spots[11].setClickable(true);
//                        paiCount.put(spots[11], num + 1);
//                        spots[11] = null;
//                    }
//                } else if (theChosenSpot == spot40) {
//                    if (spots[12] != null) {
//                        int num = paiCount.get(spots[12]);
//                        spots[12].setClickable(true);
//                        paiCount.put(spots[12], num + 1);
//                        spots[12] = null;
//                    }
//                } else if (theChosenSpot == spot41) {
//                    if (spots[13] != null) {
//                        int num = paiCount.get(spots[13]);
//                        spots[13].setClickable(true);
//                        paiCount.put(spots[13], num + 1);
//                        spots[13] = null;
//                    }
//                }
//                theChosenSpot.setBackgroundColor(Color.WHITE);
//                theChosenSpot.setPadding(0, 0, 0, 0);
//                theChosenSpot.setImageResource(R.drawable.background);
//                if (theChosenSpot == spot00 || theChosenSpot == spot01 || theChosenSpot == spot02) {
//                    Button button = findViewById(R.id.chiBtn0);
//                    button.setBackgroundResource(R.drawable.round_btn_default);
//                    button.setTextColor(Color.rgb(171, 166, 164));
//
//                    button = findViewById(R.id.pengBtn0);
//                    button.setBackgroundResource(R.drawable.round_btn_default);
//                    button.setTextColor(Color.rgb(171, 166, 164));
//
//                    gangbtnControl(R.id.gangBtn0, false);
//
//                } else if (theChosenSpot == spot10 || theChosenSpot == spot11 || theChosenSpot == spot12) {
//                    Button button = findViewById(R.id.chiBtn1);
//                    button.setBackgroundResource(R.drawable.round_btn_default);
//                    button.setTextColor(Color.rgb(171, 166, 164));
//
//                    button = findViewById(R.id.pengBtn1);
//                    button.setBackgroundResource(R.drawable.round_btn_default);
//                    button.setTextColor(Color.rgb(171, 166, 164));
//
//                    gangbtnControl(R.id.gangBtn1, false);
//                } else if (theChosenSpot == spot20 || theChosenSpot == spot21 || theChosenSpot == spot22) {
//                    Button button = findViewById(R.id.chiBtn2);
//                    button.setBackgroundResource(R.drawable.round_btn_default);
//                    button.setTextColor(Color.rgb(171, 166, 164));
//
//                    button = findViewById(R.id.pengBtn2);
//                    button.setBackgroundResource(R.drawable.round_btn_default);
//                    button.setTextColor(Color.rgb(171, 166, 164));
//
//                    gangbtnControl(R.id.gangBtn2, false);
//                } else if (theChosenSpot == spot30 || theChosenSpot == spot31 || theChosenSpot == spot32) {
//                    Button button = findViewById(R.id.chiBtn3);
//                    button.setBackgroundResource(R.drawable.round_btn_default);
//                    button.setTextColor(Color.rgb(171, 166, 164));
//
//                    button = findViewById(R.id.pengBtn3);
//                    button.setBackgroundResource(R.drawable.round_btn_default);
//                    button.setTextColor(Color.rgb(171, 166, 164));
//
//                    gangbtnControl(R.id.gangBtn3, false);
//                }


                theChosenSpot = null;
                fillHandArray();

            }else{


                ImageView theLastSpot = null;
                for (int i = spots.length - 1; i>=0; i--){
                    if (spots[i] != null){
                        switch (i) {
                            case 0: theLastSpot = spot00;
                                break;
                            case 1: theLastSpot = spot01;
                                break;
                            case 2: theLastSpot = spot02;
                                break;
                            case 3: theLastSpot = spot10;
                                break;
                            case 4: theLastSpot = spot11;
                                break;
                            case 5: theLastSpot = spot12;
                                break;
                            case 6: theLastSpot = spot20;
                                break;
                            case 7: theLastSpot = spot21;
                                break;
                            case 8: theLastSpot = spot22;
                                break;
                            case 9: theLastSpot = spot30;
                                break;
                            case 10: theLastSpot = spot31;
                                break;
                            case 11: theLastSpot = spot32;
                                break;
                            case 12: theLastSpot = spot40;
                                break;
                            case 13: theLastSpot = spot41;
                                break;
                        }
                        if (theLastSpot != null)
                            break;
                    }
                }
                if (theLastSpot != null){
                    deletePai(theLastSpot, v);
                }
                fillHandArray();
            }
            //Todo delete last pai when no spot been chosen
        } else {
            if (hands.isEmpty()) {
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setTitle("提示/Information")
                        .setMessage("请选择手牌/Please enter the tiles")
                        .setPositiveButton("关闭/close", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                builder.create().show();
                return;
            }

            for (String pai : hands) {
                if (pai.equals("null")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                    builder.setTitle("提示/Information")
                            .setMessage("请补全手牌/Please enter all tiles")
                            .setPositiveButton("关闭/close", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });
                    builder.create().show();
                    return;
                }
            }
            if (theChosenSpot == null) {
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setTitle("提示/Information")
                        .setMessage("请选择胡的牌/Please choose the final tile")
                        .setPositiveButton("关闭/close", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                builder.create().show();
                return;
            }

            // Set up the alert builder
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setTitle("进阶选项/Advanced Choice");

            // Add a checkbox list
            String[] special = {"门风刻", "圈风刻", "胡绝张", "抢杠胡", "杠上开花","海底捞月"};
            specialFormat.clear();
            boolean[] checkedItems = {false, false, false, false, false, false};
            builder.setMultiChoiceItems(special, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                    // The user checked or unchecked a box
                    switch (which){
                        case 0: if(isChecked)
                            specialFormat.add("menFengKe");
                        else
                            specialFormat.remove("menFengKe"); break;
                        case 1: if(isChecked)
                            specialFormat.add("quanFengKe");
                        else
                            specialFormat.remove("quanFengKe"); break;
                        case 2: if(isChecked)
                            specialFormat.add("huJueZhang");
                        else
                            specialFormat.remove("huJueZhang"); break;
                        case 3: if(isChecked)
                            specialFormat.add("qiangGangHu");
                        else
                            specialFormat.remove("qiangGangHu"); break;
                        case 4: if(isChecked)
                            specialFormat.add("gangShangKaiHua");
                        else
                            specialFormat.remove("gangShangKaiHua"); break;
                        case 5: if(isChecked)
                            specialFormat.add("haiDiLaoYue");
                        else
                            specialFormat.remove("haiDiLaoYue"); break;
                    }
                }
            });


            // Add OK and Cancel buttons
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // The user clicked OK
                    countPointCreater(v, activity, specialFormat);
                }
            });
            builder.setNegativeButton("Cancel", null);

            // Create and show the alert dialog
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }

    private void deletePai(ImageView theSpot, View v){
        if (theSpot == spot00) {
            if (spots[0] != null) {
                int num = paiCount.get(spots[0]);
                spots[0].setClickable(true);
                if (isHighlightBtn(v,findViewById(R.id.gangBtn0)))
                    paiCount.put(spots[0], num + 2);
                else
                    paiCount.put(spots[0], num + 1);
                spots[0] = null;
            }
        } else if (theSpot == spot01) {
            if (spots[1] != null) {
                int num = paiCount.get(spots[1]);
                spots[1].setClickable(true);
                if (isHighlightBtn(v,findViewById(R.id.gangBtn0)))
                    paiCount.put(spots[1], num + 2);
                else
                    paiCount.put(spots[1], num + 1);
                spots[1] = null;
            }
        } else if (theSpot == spot02) {
            if (spots[2] != null) {
                int num = paiCount.get(spots[2]);
                spots[2].setClickable(true);
                if (isHighlightBtn(v,findViewById(R.id.gangBtn0)))
                    paiCount.put(spots[2], num + 2);
                else
                    paiCount.put(spots[2], num + 1);
                spots[2] = null;
            }
        } else if (theSpot == spot10) {
            if (spots[3] != null) {
                int num = paiCount.get(spots[3]);
                spots[3].setClickable(true);
                if (isHighlightBtn(v,findViewById(R.id.gangBtn1)))
                    paiCount.put(spots[3], num + 2);
                else
                    paiCount.put(spots[3], num + 1);
                spots[3] = null;
            }
        } else if (theSpot == spot11) {
            if (spots[4] != null) {
                int num = paiCount.get(spots[4]);
                spots[4].setClickable(true);
                if (isHighlightBtn(v,findViewById(R.id.gangBtn1)))
                    paiCount.put(spots[4], num + 2);
                else
                    paiCount.put(spots[4], num + 1);
                spots[4] = null;
            }
        } else if (theSpot == spot12) {
            if (spots[5] != null) {
                int num = paiCount.get(spots[5]);
                spots[5].setClickable(true);
                if (isHighlightBtn(v,findViewById(R.id.gangBtn1)))
                    paiCount.put(spots[5], num + 2);
                else
                    paiCount.put(spots[5], num + 1);
                spots[5] = null;
            }
        } else if (theSpot == spot20) {
            if (spots[6] != null) {
                int num = paiCount.get(spots[6]);
                spots[6].setClickable(true);
                if (isHighlightBtn(v,findViewById(R.id.gangBtn2)))
                    paiCount.put(spots[6], num + 2);
                else
                    paiCount.put(spots[6], num + 1);
                spots[6] = null;
            }
        } else if (theSpot == spot21) {
            if (spots[7] != null) {
                int num = paiCount.get(spots[7]);
                spots[7].setClickable(true);
                if (isHighlightBtn(v,findViewById(R.id.gangBtn2)))
                    paiCount.put(spots[7], num + 2);
                else
                    paiCount.put(spots[7], num + 1);
                spots[7] = null;
            }
        } else if (theSpot == spot22) {
            if (spots[8] != null) {
                int num = paiCount.get(spots[8]);
                spots[8].setClickable(true);
                if (isHighlightBtn(v,findViewById(R.id.gangBtn2)))
                    paiCount.put(spots[8], num + 2);
                else
                    paiCount.put(spots[8], num + 1);
                spots[8] = null;
            }
        } else if (theSpot == spot30) {
            if (spots[9] != null) {
                int num = paiCount.get(spots[9]);
                spots[9].setClickable(true);
                if (isHighlightBtn(v,findViewById(R.id.gangBtn3)))
                    paiCount.put(spots[9], num + 2);
                else
                    paiCount.put(spots[9], num + 1);
                spots[9] = null;
            }
        } else if (theSpot == spot31) {
            if (spots[10] != null) {
                int num = paiCount.get(spots[10]);
                spots[10].setClickable(true);
                if (isHighlightBtn(v,findViewById(R.id.gangBtn3)))
                    paiCount.put(spots[10], num + 2);
                else
                    paiCount.put(spots[10], num + 1);
                spots[10] = null;
            }
        } else if (theSpot == spot32) {
            if (spots[11] != null) {
                int num = paiCount.get(spots[11]);
                spots[11].setClickable(true);
                if (isHighlightBtn(v,findViewById(R.id.gangBtn3)))
                    paiCount.put(spots[11], num + 2);
                else
                    paiCount.put(spots[11], num + 1);
                spots[11] = null;
            }
        } else if (theSpot == spot40) {
            if (spots[12] != null) {
                int num = paiCount.get(spots[12]);
                spots[12].setClickable(true);
                paiCount.put(spots[12], num + 1);
                spots[12] = null;
            }
        } else if (theSpot == spot41) {
            if (spots[13] != null) {
                int num = paiCount.get(spots[13]);
                spots[13].setClickable(true);
                paiCount.put(spots[13], num + 1);
                spots[13] = null;
            }
        }
        theSpot.setBackgroundColor(Color.WHITE);
        theSpot.setPadding(0, 0, 0, 0);
        theSpot.setImageResource(R.drawable.background);
        if (theSpot == spot00 || theSpot == spot01 || theSpot == spot02) {
            Button button = findViewById(R.id.chiBtn0);
            button.setBackgroundResource(R.drawable.round_btn_default);
            button.setTextColor(Color.rgb(171, 166, 164));

            button = findViewById(R.id.pengBtn0);
            button.setBackgroundResource(R.drawable.round_btn_default);
            button.setTextColor(Color.rgb(171, 166, 164));

            gangbtnControl(R.id.gangBtn0, false);

        } else if (theSpot == spot10 || theSpot == spot11 || theSpot == spot12) {
            Button button = findViewById(R.id.chiBtn1);
            button.setBackgroundResource(R.drawable.round_btn_default);
            button.setTextColor(Color.rgb(171, 166, 164));

            button = findViewById(R.id.pengBtn1);
            button.setBackgroundResource(R.drawable.round_btn_default);
            button.setTextColor(Color.rgb(171, 166, 164));

            gangbtnControl(R.id.gangBtn1, false);
        } else if (theSpot == spot20 || theSpot == spot21 || theSpot == spot22) {
            Button button = findViewById(R.id.chiBtn2);
            button.setBackgroundResource(R.drawable.round_btn_default);
            button.setTextColor(Color.rgb(171, 166, 164));

            button = findViewById(R.id.pengBtn2);
            button.setBackgroundResource(R.drawable.round_btn_default);
            button.setTextColor(Color.rgb(171, 166, 164));

            gangbtnControl(R.id.gangBtn2, false);
        } else if (theSpot == spot30 || theSpot == spot31 || theSpot == spot32) {
            Button button = findViewById(R.id.chiBtn3);
            button.setBackgroundResource(R.drawable.round_btn_default);
            button.setTextColor(Color.rgb(171, 166, 164));

            button = findViewById(R.id.pengBtn3);
            button.setBackgroundResource(R.drawable.round_btn_default);
            button.setTextColor(Color.rgb(171, 166, 164));

            gangbtnControl(R.id.gangBtn3, false);
        }

    }

    public void fillHandArray() {
        hands.clear();
        for (ImageView imageView : spots) {
            if (imageView == null)
                hands.add("null");
            else {
                hands.add(getResources().getResourceEntryName(imageView.getId()));
            }

        }
    }

    private int stringToInt(String num) {
        switch (num) {
            case "yi":
                return 1;
            case "er":
                return 2;
            case "san":
                return 3;
            case "si":
                return 4;
            case "wu":
                return 5;
            case "liu":
                return 6;
            case "qi":
                return 7;
            case "ba":
                return 8;
            case "jiu":
                return 9;
            default:
                return 0;
        }
    }

    private void switch_to_main_activity() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("EXTRA_LAN", EXTRA_LAN);
        startActivity(intent);
    }

    private boolean isHighlightBtn(View v, Button button){
        if (button.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.round_btn_highlight).getConstantState()))
            return true;
        return false;
    }

    private boolean isQuanDaiYao(ArrayList<String> shouPai){
        boolean valid = false;
        for (int i = 0; i <= 2; i++){
            String num = shouPai.get(i).split("-")[0];
            String type = shouPai.get(i).split("-")[1];
            if (num.equals("1") || num.equals("9") || type.equals("f") || type.equals("Z") || type.equals("F") || type.equals("B")) {
                valid = true;
                break;
            }
        }
        if (!valid)
            return false;
        valid = false;
        for (int i = 3; i <= 5; i++){
            String num = shouPai.get(i).split("-")[0];
            String type = shouPai.get(i).split("-")[1];
            if (num.equals("1") || num.equals("9") || type.equals("f") || type.equals("Z") || type.equals("F") || type.equals("B")) {
                valid = true;
                break;
            }
        }
        if (!valid)
            return false;
        valid = false;
        for (int i = 6; i <= 8; i++){
            String num = shouPai.get(i).split("-")[0];
            String type = shouPai.get(i).split("-")[1];
            if (num.equals("1") || num.equals("9") || type.equals("f") || type.equals("Z") || type.equals("F") || type.equals("B")) {
                valid = true;
                break;
            }
        }
        if (!valid)
            return false;
        valid = false;
        for (int i = 9; i <= 11; i++){
            String num = shouPai.get(i).split("-")[0];
            String type = shouPai.get(i).split("-")[1];
            if (num.equals("1") || num.equals("9") || type.equals("f") || type.equals("Z") || type.equals("F") || type.equals("B")) {
                valid = true;
                break;
            }
        }
        if (!valid)
            return false;
        valid = false;
        for (int i = 12; i <= 13; i++){
            String num = shouPai.get(i).split("-")[0];
            String type = shouPai.get(i).split("-")[1];
            if (num.equals("1") || num.equals("9") || type.equals("f") || type.equals("Z") || type.equals("F") || type.equals("B")) {
                valid = true;
                break;
            }
        }
        return valid;
    }

    private void countPointCreater(View v, Activity activity, ArrayList<String> specialFormat) {
        String huPai = null;
        ArrayList<String> chi = new ArrayList<>();
        ArrayList<String> peng = new ArrayList<>();
        ArrayList<String> mingGang = new ArrayList<>();
        ArrayList<String> anGang = new ArrayList<>();
        ArrayList<String> anKe = new ArrayList<>();
        ArrayList<String> shouPai = new ArrayList<>();
        boolean ziMo = false;
        boolean danDiaoJiang = false;
        boolean menQianQing = false;
        boolean quanDaiWu = true;
        boolean quanDaiYao = false;
        boolean special = false;
        boolean kanZhang = false;
        boolean bianZhang = false;
        boolean menFengKe = false;
        boolean quanFengKe = false;
        boolean huJueZhang = false;
        boolean qiangGangHu = false;
        boolean GangShangKaiHua = false;
        boolean haiDiLaoYue = false;

        for (String pai : hands) {
            if (pai.endsWith("wan")) {
                String suffix = "wan";
                shouPai.add(stringToInt(pai.split(suffix)[0]) + "-w");
            } else if (pai.endsWith("bing")) {
                String suffix = "bing";
                shouPai.add(stringToInt(pai.split(suffix)[0]) + "-b");
            } else if (pai.endsWith("tiao")) {
                String suffix = "tiao";
                shouPai.add(stringToInt(pai.split(suffix)[0]) + "-t");
            } else if (pai.endsWith("feng")) {
                shouPai.add(pai.charAt(0) + "-f");
            } else if (pai.equals("hongzhong")) {
                shouPai.add("h-Z");
            } else if (pai.equals("baiban")) {
                shouPai.add("b-B");
            } else {
                shouPai.add("f-F");
            }
        }

        if (theChosenSpot == spot00){
            huPai = shouPai.get(0);
        }else if(theChosenSpot == spot01){
            huPai = shouPai.get(1);
        }else if(theChosenSpot == spot02){
            huPai = shouPai.get(2);
        }else if(theChosenSpot == spot10){
            huPai = shouPai.get(3);
        }else if(theChosenSpot == spot11){
            huPai = shouPai.get(4);
        }else if(theChosenSpot == spot12){
            huPai = shouPai.get(5);
        }else if(theChosenSpot == spot20){
            huPai = shouPai.get(6);
        }else if(theChosenSpot == spot21){
            huPai = shouPai.get(7);
        }else if(theChosenSpot == spot22){
            huPai = shouPai.get(8);
        }else if(theChosenSpot == spot30){
            huPai = shouPai.get(9);
        }else if(theChosenSpot == spot31){
            huPai = shouPai.get(10);
        }else if(theChosenSpot == spot32){
            huPai = shouPai.get(11);
        }else if(theChosenSpot == spot40){
            huPai = shouPai.get(12);
        }else if(theChosenSpot == spot41){
            huPai = shouPai.get(13);
        }
        Log.i("hup", huPai);


        Button button = findViewById(R.id.chiBtn0);
        if (isHighlightBtn(v,button)) {
            chi.add(shouPai.get(0));
            chi.add(shouPai.get(1));
            chi.add(shouPai.get(2));
        }
        button = findViewById(R.id.chiBtn1);
        if (isHighlightBtn(v,button)) {
            chi.add(shouPai.get(3));
            chi.add(shouPai.get(4));
            chi.add(shouPai.get(5));
        }
        button = findViewById(R.id.chiBtn2);
        if (isHighlightBtn(v,button)) {
            chi.add(shouPai.get(6));
            chi.add(shouPai.get(7));
            chi.add(shouPai.get(8));
        }
        button = findViewById(R.id.chiBtn3);
        if (isHighlightBtn(v,button)) {
            chi.add(shouPai.get(9));
            chi.add(shouPai.get(10));
            chi.add(shouPai.get(11));
        }
        button = findViewById(R.id.pengBtn0);
        if (isHighlightBtn(v,button)) {
            peng.add(shouPai.get(0));
        }
        button = findViewById(R.id.pengBtn1);
        if (isHighlightBtn(v,button)) {
            peng.add(shouPai.get(3));
        }
        button = findViewById(R.id.pengBtn2);
        if (isHighlightBtn(v,button)) {
            peng.add(shouPai.get(6));
        }
        button = findViewById(R.id.pengBtn3);
        if (isHighlightBtn(v,button)) {
            peng.add(shouPai.get(9));
        }
        button = findViewById(R.id.gangBtn0);
        if (isHighlightBtn(v,button)) {
            button = findViewById(R.id.mingBtn0);
            if (isHighlightBtn(v, button)) {
                mingGang.add(shouPai.get(0));
            } else
                anGang.add(shouPai.get(0));
        }
        button = findViewById(R.id.gangBtn1);
        if (isHighlightBtn(v,button)) {
            button = findViewById(R.id.mingBtn1);
            if (isHighlightBtn(v,button)) {
                mingGang.add(shouPai.get(3));
            } else
                anGang.add(shouPai.get(3));
        }
        button = findViewById(R.id.gangBtn2);
        if (isHighlightBtn(v,button)) {
            button = findViewById(R.id.mingBtn2);
            if (isHighlightBtn(v,button)) {
                mingGang.add(shouPai.get(6));
            } else
                anGang.add(shouPai.get(6));
        }
        button = findViewById(R.id.gangBtn3);
        if (isHighlightBtn(v,button)) {
            button = findViewById(R.id.mingBtn3);
            if (isHighlightBtn(v,button)) {
                mingGang.add(shouPai.get(9));
            } else
                anGang.add(shouPai.get(9));
        }

        anKe.addAll(0, anGang);
        if (!isHighlightBtn(v,findViewById(R.id.chiBtn0)) && !isHighlightBtn(v,findViewById(R.id.pengBtn0)) && !isHighlightBtn(v,findViewById(R.id.gangBtn0))){
            if (shouPai.get(0).equals(shouPai.get(1)) && shouPai.get(1).equals(shouPai.get(2)))
                anKe.add(shouPai.get(0));
        }
        if (!isHighlightBtn(v,findViewById(R.id.chiBtn1)) && !isHighlightBtn(v,findViewById(R.id.pengBtn1)) && !isHighlightBtn(v,findViewById(R.id.gangBtn1))){
            if (shouPai.get(3).equals(shouPai.get(4)) && shouPai.get(4).equals(shouPai.get(5)))
                anKe.add(shouPai.get(3));
        }
        if (!isHighlightBtn(v,findViewById(R.id.chiBtn2)) && !isHighlightBtn(v,findViewById(R.id.pengBtn2)) && !isHighlightBtn(v,findViewById(R.id.gangBtn2))){
            if (shouPai.get(6).equals(shouPai.get(7)) && shouPai.get(7).equals(shouPai.get(8)))
                anKe.add(shouPai.get(6));
        }
        if (!isHighlightBtn(v,findViewById(R.id.chiBtn3)) && !isHighlightBtn(v,findViewById(R.id.pengBtn3)) && !isHighlightBtn(v,findViewById(R.id.gangBtn3))){
            if (shouPai.get(9).equals(shouPai.get(10)) && shouPai.get(10).equals(shouPai.get(11)))
                anKe.add(shouPai.get(9));
        }

        if (theChosenSpot == spot00 || theChosenSpot == spot01 || theChosenSpot == spot02){
            if (!isHighlightBtn(v,findViewById(R.id.chiBtn0)) && !isHighlightBtn(v,findViewById(R.id.pengBtn0)) && !isHighlightBtn(v,findViewById(R.id.gangBtn0)))
                ziMo = true;
            else
                ziMo = false;
        }else if (theChosenSpot == spot10 || theChosenSpot == spot11 || theChosenSpot == spot12){
            if (!isHighlightBtn(v,findViewById(R.id.chiBtn1)) && !isHighlightBtn(v,findViewById(R.id.pengBtn1)) && !isHighlightBtn(v,findViewById(R.id.gangBtn1)))
                ziMo = true;
            else
                ziMo = false;
        } else if (theChosenSpot == spot20 || theChosenSpot == spot21 || theChosenSpot == spot22){
            if (!isHighlightBtn(v,findViewById(R.id.chiBtn2)) && !isHighlightBtn(v,findViewById(R.id.pengBtn2)) && !isHighlightBtn(v,findViewById(R.id.gangBtn2)))
                ziMo = true;
            else
                ziMo = false;
        }else if (theChosenSpot == spot30 || theChosenSpot == spot31 || theChosenSpot == spot32){
            if (!isHighlightBtn(v,findViewById(R.id.chiBtn3)) && !isHighlightBtn(v,findViewById(R.id.pengBtn3)) && !isHighlightBtn(v,findViewById(R.id.gangBtn3)))
                ziMo = true;
            else
                ziMo = false;
        }else if (theChosenSpot == spot40 || theChosenSpot == spot41){
            if (isHighlightBtn(v,findViewById(R.id.anBtn4)))
                ziMo = true;
            else
                ziMo = false;
        }
        if (theChosenSpot == spot40 || theChosenSpot == spot41) {
           danDiaoJiang = true;
        }else
            danDiaoJiang = false;
        if (theChosenSpot == spot00 || theChosenSpot == spot01 || theChosenSpot == spot02){
            if (!isHighlightBtn(v,findViewById(R.id.chiBtn1)) && !isHighlightBtn(v,findViewById(R.id.pengBtn1)) && !isHighlightBtn(v,findViewById(R.id.gangBtn1))
                    && !isHighlightBtn(v,findViewById(R.id.chiBtn2)) && !isHighlightBtn(v,findViewById(R.id.pengBtn2)) && !isHighlightBtn(v,findViewById(R.id.gangBtn2))
                    && !isHighlightBtn(v,findViewById(R.id.chiBtn3)) && !isHighlightBtn(v,findViewById(R.id.pengBtn3)) && !isHighlightBtn(v,findViewById(R.id.gangBtn3))
                    && isHighlightBtn(v, findViewById(R.id.anBtn4)))
                menQianQing = true;
            else
                menQianQing = false;
        }else if (theChosenSpot == spot10 || theChosenSpot == spot11 || theChosenSpot == spot12){
            if (!isHighlightBtn(v,findViewById(R.id.chiBtn0)) && !isHighlightBtn(v,findViewById(R.id.pengBtn0)) && !isHighlightBtn(v,findViewById(R.id.gangBtn0))
                    && !isHighlightBtn(v,findViewById(R.id.chiBtn2)) && !isHighlightBtn(v,findViewById(R.id.pengBtn2)) && !isHighlightBtn(v,findViewById(R.id.gangBtn2))
                    && !isHighlightBtn(v,findViewById(R.id.chiBtn3)) && !isHighlightBtn(v,findViewById(R.id.pengBtn3)) && !isHighlightBtn(v,findViewById(R.id.gangBtn3))
                    && isHighlightBtn(v, findViewById(R.id.anBtn4)))
                menQianQing = true;
            else
                menQianQing = false;
        } else if (theChosenSpot == spot20 || theChosenSpot == spot21 || theChosenSpot == spot22){
            if (!isHighlightBtn(v,findViewById(R.id.chiBtn1)) && !isHighlightBtn(v,findViewById(R.id.pengBtn1)) && !isHighlightBtn(v,findViewById(R.id.gangBtn1))
                    && !isHighlightBtn(v,findViewById(R.id.chiBtn0)) && !isHighlightBtn(v,findViewById(R.id.pengBtn0)) && !isHighlightBtn(v,findViewById(R.id.gangBtn0))
                    && !isHighlightBtn(v,findViewById(R.id.chiBtn3)) && !isHighlightBtn(v,findViewById(R.id.pengBtn3)) && !isHighlightBtn(v,findViewById(R.id.gangBtn3))
                    && isHighlightBtn(v, findViewById(R.id.anBtn4)))
                menQianQing = true;
            else
                menQianQing = false;
        }else if (theChosenSpot == spot30 || theChosenSpot == spot31 || theChosenSpot == spot32){
            if (!isHighlightBtn(v,findViewById(R.id.chiBtn1)) && !isHighlightBtn(v,findViewById(R.id.pengBtn1)) && !isHighlightBtn(v,findViewById(R.id.gangBtn1))
                    && !isHighlightBtn(v,findViewById(R.id.chiBtn2)) && !isHighlightBtn(v,findViewById(R.id.pengBtn2)) && !isHighlightBtn(v,findViewById(R.id.gangBtn2))
                    && !isHighlightBtn(v,findViewById(R.id.chiBtn0)) && !isHighlightBtn(v,findViewById(R.id.pengBtn0)) && !isHighlightBtn(v,findViewById(R.id.gangBtn0))
                    && isHighlightBtn(v, findViewById(R.id.anBtn4)))
                menQianQing = true;
            else
                menQianQing = false;
        }else if (theChosenSpot == spot40 || theChosenSpot == spot41){
            if (!isHighlightBtn(v,findViewById(R.id.chiBtn1)) && !isHighlightBtn(v,findViewById(R.id.pengBtn1)) && !isHighlightBtn(v,findViewById(R.id.gangBtn1))
                    && !isHighlightBtn(v,findViewById(R.id.chiBtn2)) && !isHighlightBtn(v,findViewById(R.id.pengBtn2)) && !isHighlightBtn(v,findViewById(R.id.gangBtn2))
                    && !isHighlightBtn(v,findViewById(R.id.chiBtn3)) && !isHighlightBtn(v,findViewById(R.id.pengBtn3)) && !isHighlightBtn(v,findViewById(R.id.gangBtn3))
                    && !isHighlightBtn(v,findViewById(R.id.chiBtn0)) && !isHighlightBtn(v,findViewById(R.id.pengBtn0)) && !isHighlightBtn(v,findViewById(R.id.gangBtn0)))
                menQianQing = true;
            else
                menQianQing = false;
        }

        quanDaiWu = ((shouPai.get(0).contains("5") || shouPai.get(1).contains("5") || shouPai.get(2).contains("5")) &&
                (shouPai.get(3).contains("5") || shouPai.get(4).contains("5") || shouPai.get(5).contains("5")) &&
                (shouPai.get(6).contains("5") || shouPai.get(7).contains("5") || shouPai.get(8).contains("5")) &&
                (shouPai.get(9).contains("5") || shouPai.get(10).contains("5") || shouPai.get(11).contains("5")) &&
                (shouPai.get(12).contains("5") && shouPai.get(13).contains("5")));

        quanDaiYao = isQuanDaiYao(shouPai);

        String pai1 = null;
        String pai2 = null;
        String pai3 = null;
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        if (theChosenSpot == spot00 || theChosenSpot == spot01 || theChosenSpot == spot02){
            pai1 = shouPai.get(0);
            pai2 = shouPai.get(1);
            pai3 = shouPai.get(2);
        }else if (theChosenSpot == spot10 || theChosenSpot == spot11 || theChosenSpot == spot12){
            pai1 = shouPai.get(3);
            pai2 = shouPai.get(4);
            pai3 = shouPai.get(5);
        } else if (theChosenSpot == spot20 || theChosenSpot == spot21 || theChosenSpot == spot22){
            pai1 = shouPai.get(6);
            pai2 = shouPai.get(7);
            pai3 = shouPai.get(8);
        }else if (theChosenSpot == spot30 || theChosenSpot == spot31 || theChosenSpot == spot32) {
            pai1 = shouPai.get(9);
            pai2 = shouPai.get(10);
            pai3 = shouPai.get(11);
        }
        if (pai1 != null && pai2 != null && pai3 != null) {
            if (pai1.endsWith("w") && pai2.endsWith("w") && pai3.endsWith("w")) {
                num1 = Integer.parseInt(pai1.split("-")[0]);
                num2 = Integer.parseInt(pai2.split("-")[0]);
                num3 = Integer.parseInt(pai3.split("-")[0]);
            } else if (pai1.endsWith("b") && pai2.endsWith("b") && pai3.endsWith("b")) {
                num1 = Integer.parseInt(pai1.split("-")[0]);
                num2 = Integer.parseInt(pai2.split("-")[0]);
                num3 = Integer.parseInt(pai3.split("-")[0]);
            } else if (pai1.endsWith("t") && pai2.endsWith("t") && pai3.endsWith("t")) {
                num1 = Integer.parseInt(pai1.split("-")[0]);
                num2 = Integer.parseInt(pai2.split("-")[0]);
                num3 = Integer.parseInt(pai3.split("-")[0]);
            }
            if (num1 != 0 && num2 != 0 && num3 != 0) {
                int sorted[] = {num1, num2, num3};
                Arrays.sort(sorted);
                if (sorted[0] + 1 == sorted[1] && sorted[1] + 1 == sorted[2]) {
                    int huPaiNum = Integer.parseInt(huPai.split("-")[0]);
                    if ((huPaiNum == sorted[0] || huPaiNum == sorted[2]) && (huPaiNum == 3 || huPaiNum == 7))
                        bianZhang = true;
                    if (huPaiNum == sorted[1])
                        kanZhang = true;
                }
            }
        }

        menFengKe = specialFormat.contains("menFengKe");
        quanFengKe = specialFormat.contains("quanFengKe");
        huJueZhang = specialFormat.contains("huJueZhang");
        qiangGangHu = specialFormat.contains("qiangGangHu");
        GangShangKaiHua = specialFormat.contains("GangShangKaiHua");
        haiDiLaoYue = specialFormat.contains("haiDiLaoYue");

        Log.e("shouPai", shouPai.toString());
        Log.e("chi", chi.toString());
        Log.e("peng", peng.toString());
        Log.e("mGang", mingGang.toString());
        Log.e("aGang", anGang.toString());
        Log.e("anKe", anKe.toString());
        Log.e("ziMo", ziMo + "");
        Log.e("danDiaoJiang", danDiaoJiang + "");
        Log.e("menQianQing", menQianQing + "");
        Log.e("quanDaiWu", quanDaiWu + "");
        Log.e("quanDaiYao", quanDaiYao + "");
        Log.e("kanZhang", kanZhang + "");
        Log.e("bianZhang", bianZhang + "");


        Log.e("menFengKe", menFengKe + "");
        Log.e("quanFengKe", quanFengKe + "");
        Log.e("huJueZhang", huJueZhang + "");
        Log.e("qiangGangHu", qiangGangHu + "");
        Log.e("GangShangKaiHua", GangShangKaiHua + "");
        Log.e("haiDiLaoYue", haiDiLaoYue + "");


        CountPoint cp = new CountPoint(10,shouPai,huPai,ziMo,chi,peng,mingGang,anGang,anKe,menQianQing,danDiaoJiang,quanDaiWu,quanDaiYao,kanZhang,bianZhang,menFengKe,quanFengKe,huJueZhang,qiangGangHu,GangShangKaiHua,haiDiLaoYue);

        //check special
        int[] specialHand = new int[34];
        Arrays.fill(specialHand, 0);
        cp.listToArray(shouPai, specialHand);
        if (cp.isQiXingBuKao(specialHand)){
            special = true;
            Log.i("special", "qixingbukao");
        }else if (cp.isQuanBuKao(specialHand)){
            special = true;
            Log.i("special", "quanbukao");
        }else if (cp.isQiDui(specialHand)){
            special = true;
            Log.i("special", "qidui");
        }else if (cp.isShiSanYao(specialHand)){
            special = true;
            Log.i("special", "shisanyao");
        }

        if (cp.checkHu() || special) {
            Log.i(TAG, "Hu Le!");
            //Log.i(TAG, cp.calculate_final_point().toString());
            //System.out.println(cp.calculate_final_point().toString());
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setTitle("胡！/HU!")
                    .setMessage("番型: " + cp.calculate_final_point().toString() + "\n番数: " + cp.getScoreRecorder().toString() + "\n总共 " + cp.getFinalPoint() + " 番")
                    .setPositiveButton("恭喜！/Congratulation!", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            AlertDialog dialog = builder.create();
//            dialog.getWindow().setGravity(Gravity.BOTTOM);

            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            WindowManager.LayoutParams wmlp = dialog.getWindow().getAttributes();

            wmlp.gravity = Gravity.TOP | Gravity.LEFT;

            wmlp.y = 1430;   //y position
            wmlp.x = 30;


            dialog.show();
        }
        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setTitle("诈胡！/No HU!")
                    .setMessage("-")
                    .setPositiveButton("gg", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            AlertDialog dialog = builder.create();
//            dialog.getWindow().setGravity(Gravity.BOTTOM);

            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            WindowManager.LayoutParams wmlp = dialog.getWindow().getAttributes();

            wmlp.gravity = Gravity.TOP | Gravity.LEFT;

            wmlp.y = 1430;   //y position
            wmlp.x = 30;


            dialog.show();
        }

    }
}