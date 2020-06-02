package com.example.mahjong_winpoint_calculator;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashMap;

import androidx.appcompat.app.AppCompatActivity;

public class ManuallyActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "ManuallyActivity";
    ImageView theChosenSpot = null;
    HashMap<ImageView, Integer> paiCount;
    ImageView[] spots = {null, null, null,
                                                                        null, null, null,
                                                                        null, null, null,
                                                                        null, null, null,
                                                                        null, null};

    ArrayList<String> hands;

    ImageView spot00 = null;
    ImageView spot01 = null;
    ImageView spot02 = null;
    ImageView spot03 = null;
    ImageView spot10 = null;
    ImageView spot11 = null;
    ImageView spot12 = null;
    ImageView spot13 = null;
    ImageView spot20 = null;
    ImageView spot21 = null;
    ImageView spot22 = null;
    ImageView spot23 = null;
    ImageView spot30 = null;
    ImageView spot31 = null;
    ImageView spot32 = null;
    ImageView spot33 = null;
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

    Button anBtn0 = null;
    Button anBtn1 = null;
    Button anBtn2 = null;
    Button anBtn3 = null;

    Button restoreBtn = null;
    Button deleteBtn = null;
    Button calculateBtn = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //全屏
        getSupportActionBar().hide(); //隐藏标题
        setContentView(R.layout.activity_manually);

        paiCount = new HashMap<ImageView, Integer>();
        hands = new ArrayList<>();

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

        yiWanView     = (ImageView) findViewById(R.id.yiwan);
        erWanView     = (ImageView) findViewById(R.id.erwan);
        sanWanView    = (ImageView) findViewById(R.id.sanwan);
        siWanView     = (ImageView) findViewById(R.id.siwan);
        wuWanView     = (ImageView) findViewById(R.id.wuwan);
        liuWanView    = (ImageView) findViewById(R.id.liuwan);
        qiWanView     = (ImageView) findViewById(R.id.qiwan);
        baWanView     = (ImageView) findViewById(R.id.bawan);
        jiuWanView    = (ImageView) findViewById(R.id.jiuwan);
        yiBingView    = (ImageView) findViewById(R.id.yibing);
        erBingView    = (ImageView) findViewById(R.id.erbing);
        sanBingView   = (ImageView) findViewById(R.id.sanbing);
        siBingView    = (ImageView) findViewById(R.id.sibing);
        wuBingView    = (ImageView) findViewById(R.id.wubing);
        liuBingView   = (ImageView) findViewById(R.id.liubing);
        qiBingView    = (ImageView) findViewById(R.id.qibing);
        baBingView    = (ImageView) findViewById(R.id.babing);
        jiuBingView   = (ImageView) findViewById(R.id.jiubing);
        yiTiaoView    = (ImageView) findViewById(R.id.yitiao);
        erTiaoView    = (ImageView) findViewById(R.id.ertiao);
        sanTiaoView   = (ImageView) findViewById(R.id.santiao);
        siTiaoView    = (ImageView) findViewById(R.id.sitiao);
        wuTiaoView    = (ImageView) findViewById(R.id.wutiao);
        liuTiaoView   = (ImageView) findViewById(R.id.liutiao);
        qiTiaoView    = (ImageView) findViewById(R.id.qitiao);
        baTiaoView    = (ImageView) findViewById(R.id.batiao);
        jiuTiaoView   = (ImageView) findViewById(R.id.jiutiao);
        dongFengView  = (ImageView) findViewById(R.id.dongfeng);
        nanFengView   = (ImageView) findViewById(R.id.nanfeng);
        xiFengView    = (ImageView) findViewById(R.id.xifeng);
        beiFengView   = (ImageView) findViewById(R.id.beifeng);
        hongZhongView = (ImageView) findViewById(R.id.hongzhong);
        baiBanView    = (ImageView) findViewById(R.id.baiban);
        faCaiView     = (ImageView) findViewById(R.id.facai);
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
        mingBtn0.setOnClickListener(this);
        mingBtn1.setOnClickListener(this);
        mingBtn2.setOnClickListener(this);
        mingBtn3.setOnClickListener(this);

        anBtn0 = (Button) findViewById(R.id.anBtn0);
        anBtn1 = (Button) findViewById(R.id.anBtn1);
        anBtn2 = (Button) findViewById(R.id.anBtn2);
        anBtn3 = (Button) findViewById(R.id.anBtn3);
        anBtn0.setOnClickListener(this);
        anBtn1.setOnClickListener(this);
        anBtn2.setOnClickListener(this);
        anBtn3.setOnClickListener(this);

        restoreBtn = (Button) findViewById(R.id.restoreBtn);
        deleteBtn = (Button) findViewById(R.id.deleteBtn);
        calculateBtn = (Button) findViewById(R.id.calculateBtn);
        restoreBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);
        calculateBtn.setOnClickListener(this);


    }


    public void onClick(View v){
        switch (v.getId()){
            case R.id.spot00: case R.id.spot01: case R.id.spot02: case R.id.spot10: case R.id.spot11: case R.id.spot12: case R.id.spot20: case R.id.spot21: case R.id.spot22:
            case R.id.spot30: case R.id.spot31: case R.id.spot32: case R.id.spot40: case R.id.spot41:
                onSpotClick(v.getId());
                break;

            case R.id.yiwan: case R.id.erwan: case R.id.sanwan: case R.id.siwan: case R.id.wuwan: case R.id.liuwan: case R.id.qiwan: case R.id.bawan: case R.id.jiuwan:
            case R.id.yibing: case R.id.erbing: case R.id.sanbing: case R.id.sibing: case R.id.wubing: case R.id.liubing: case R.id.qibing: case R.id.babing: case R.id.jiubing:
            case R.id.yitiao: case R.id.ertiao: case R.id.santiao: case R.id.sitiao: case R.id.wutiao: case R.id.liutiao: case R.id.qitiao: case R.id.batiao: case R.id.jiutiao:
            case R.id.dongfeng: case R.id.nanfeng: case R.id.xifeng: case R.id.beifeng: case R.id.hongzhong: case R.id.facai: case R.id.baiban:
                onPaiClick(v.getId(),v );
                break;

            case R.id.chiBtn0: case R.id.chiBtn1: case R.id.chiBtn2: case R.id.chiBtn3: case R.id.pengBtn0: case R.id.pengBtn1: case R.id.pengBtn2: case R.id.pengBtn3:
            case R.id.gangBtn0: case R.id.gangBtn1: case R.id.gangBtn2: case R.id.gangBtn3:
                onChiPengGangBtnClick(v.getId());
                break;

            case R.id.mingBtn0: case R.id.mingBtn1: case R.id.mingBtn2: case R.id.mingBtn3: case R.id.anBtn0: case R.id.anBtn1: case R.id.anBtn2: case R.id.anBtn3:
                onMingAnBtnClick(v.getId());
                break;

            case R.id.restoreBtn: case R.id.deleteBtn: case R.id.calculateBtn:
                onActionBtnClick(v.getId());

                default:
                    break;
        }
    }

    private void onSpotClick(int id){
        ImageView theSpot = (ImageView) findViewById(id);

        if (theSpot != null){

            ColorDrawable cd = (ColorDrawable) theSpot.getBackground();
            if (cd != null) {
                int color = cd.getColor();
                if (color == Color.RED){
                    Log.i(TAG, "chosen spot red background");
                    theSpot.setBackgroundColor(Color.WHITE);
                    theSpot.setPadding(0,0,0,0);
                    theChosenSpot = null;
                }else if(color == Color.WHITE){
                    Log.i(TAG, "chosen spot white background");
                    if (theChosenSpot != null){
                        theChosenSpot.setBackgroundColor(Color.WHITE);
                        theChosenSpot.setPadding(0,0,0,0);
                        theChosenSpot = null;
                    }
                    theSpot.setBackgroundColor(Color.RED);
                    theSpot.setPadding(2, 2, 2, 2);
                    theChosenSpot = theSpot;
                }
            }
            else {
                Log.i(TAG, "chosen spot no background detected");
                if (theChosenSpot != null){
                    theChosenSpot.setBackgroundColor(Color.WHITE);
                    theChosenSpot.setPadding(0,0,0,0);
                    theChosenSpot = null;
                }
                theSpot.setBackgroundColor(Color.RED);
                theSpot.setPadding(2, 2, 2, 2);
                theChosenSpot = theSpot;
            }
            Log.i(TAG, "the chosen spot is null: " + (theChosenSpot == null));
        }
    }

    private void onPaiClick(int id, View v) {
        int drawableID = -1;
        switch (id){
            case R.id.yiwan: drawableID = R.drawable.yiwan; break;
            case R.id.erwan: drawableID = R.drawable.erwan; break;
            case R.id.sanwan: drawableID = R.drawable.sanwan; break;
            case R.id.siwan: drawableID = R.drawable.siwan; break;
            case R.id.wuwan: drawableID = R.drawable.wuwan; break;
            case R.id.liuwan: drawableID = R.drawable.liuwan; break;
            case R.id.qiwan: drawableID = R.drawable.qiwan; break;
            case R.id.bawan: drawableID = R.drawable.bawan; break;
            case R.id.jiuwan: drawableID = R.drawable.jiuwan; break;
            case R.id.yibing: drawableID = R.drawable.yibing; break;
            case R.id.erbing: drawableID = R.drawable.erbing; break;
            case R.id.sanbing: drawableID = R.drawable.sanbing; break;
            case R.id.sibing: drawableID = R.drawable.sibing; break;
            case R.id.wubing: drawableID = R.drawable.wubing; break;
            case R.id.liubing: drawableID = R.drawable.liubing; break;
            case R.id.qibing: drawableID = R.drawable.qibing; break;
            case R.id.babing: drawableID = R.drawable.babing; break;
            case R.id.jiubing: drawableID = R.drawable.jiubing; break;
            case R.id.yitiao: drawableID = R.drawable.yitiao; break;
            case R.id.ertiao: drawableID = R.drawable.ertiao; break;
            case R.id.santiao: drawableID = R.drawable.santiao; break;
            case R.id.sitiao: drawableID = R.drawable.sitiao; break;
            case R.id.wutiao: drawableID = R.drawable.wutiao; break;
            case R.id.liutiao: drawableID = R.drawable.liutiao; break;
            case R.id.qitiao: drawableID = R.drawable.qitiao; break;
            case R.id.batiao: drawableID = R.drawable.batiao; break;
            case R.id.jiutiao: drawableID = R.drawable.jiutiao; break;
            case R.id.dongfeng: drawableID = R.drawable.dongfeng; break;
            case R.id.nanfeng: drawableID = R.drawable.nanfeng; break;
            case R.id.xifeng: drawableID = R.drawable.xifeng; break;
            case R.id.beifeng: drawableID = R.drawable.beifeng; break;
            case R.id.hongzhong: drawableID = R.drawable.hongzhong; break;
            case R.id.facai: drawableID = R.drawable.facai; break;
            case R.id.baiban: drawableID = R.drawable.baiban; break;
            default:
                drawableID = -1; break;
        }

        if (drawableID != -1){
            if (theChosenSpot == null){
                for (int i = 0; i<spots.length; i++){
                    if (spots[i] == null){
                        switch (i){
                            case 0:  spot00.setImageResource(drawableID); break;
                            case 1:  spot01.setImageResource(drawableID); break;
                            case 2:  spot02.setImageResource(drawableID); break;
                            case 3:  spot10.setImageResource(drawableID); break;
                            case 4:  spot11.setImageResource(drawableID); break;
                            case 5:  spot12.setImageResource(drawableID); break;
                            case 6:  spot20.setImageResource(drawableID); break;
                            case 7:  spot21.setImageResource(drawableID); break;
                            case 8:  spot22.setImageResource(drawableID); break;
                            case 9:  spot30.setImageResource(drawableID); break;
                            case 10:  spot31.setImageResource(drawableID); break;
                            case 11:  spot32.setImageResource(drawableID); break;
                            case 12:  spot40.setImageResource(drawableID); break;
                            case 13:  spot41.setImageResource(drawableID); break;
                        }
                        spots[i] = findViewById(id);
                        int num = paiCount.get(spots[i]);
                        if (num <= 1){
                            findViewById(id).setClickable(false);
                        }
                        paiCount.put(spots[i], num - 1);
                        fillHandArray(v);
                        Log.e("hands", hands.toString());
                        break;
                    }
                }
            }else{
                theChosenSpot.setImageResource(drawableID);
                int index = -1;
                if (theChosenSpot == spot00)
                    spots[0] = findViewById(id);
                else if (theChosenSpot == spot01)
                    spots[1] = findViewById(id);
                else if (theChosenSpot == spot02)
                    spots[2] = findViewById(id);
                else if (theChosenSpot == spot10)
                    spots[3] = findViewById(id);
                else if (theChosenSpot == spot11)
                    spots[4] = findViewById(id);
                else if (theChosenSpot == spot12)
                    spots[5] = findViewById(id);
                else if (theChosenSpot == spot20)
                    spots[6] = findViewById(id);
                else if (theChosenSpot == spot21)
                    spots[7] = findViewById(id);
                else if (theChosenSpot == spot22)
                    spots[8] = findViewById(id);
                else if (theChosenSpot == spot30)
                    spots[9] = findViewById(id);
                else if (theChosenSpot == spot31)
                    spots[10] = findViewById(id);
                else if (theChosenSpot == spot32)
                    spots[11] = findViewById(id);
                else if (theChosenSpot == spot40)
                    spots[12] = findViewById(id);
                else if (theChosenSpot == spot41)
                    spots[13] = findViewById(id);

                int num = paiCount.get(theChosenSpot);
                if (num <= 1){
                    findViewById(id).setClickable(false);
                }
                paiCount.put(theChosenSpot, num - 1);

                }
            }
        }

    private void onChiPengGangBtnClick(int id){
        if (id == R.id.chiBtn0 || id == R.id.chiBtn1 || id == R.id.chiBtn2 || id == R.id.chiBtn3){
            Button button = findViewById(id);
            button.setBackgroundResource(R.drawable.round_btn_highlight);
            button.setTextColor(Color.BLACK);




        }else if (id == R.id.pengBtn0 || id == R.id.pengBtn1 || id == R.id.pengBtn2 || id == R.id.pengBtn3){



        }else if (id == R.id.gangBtn0 || id == R.id.gangBtn1 || id == R.id.gangBtn2 || id == R.id.gangBtn3){




        }

    }

    private void onMingAnBtnClick(int id){

    }

    private void onActionBtnClick(int id){

    }

    public void fillHandArray(View v){
        hands.clear();
        for (ImageView imageView : spots){
            if (imageView == null)
                hands.add("null");
            else {
                String a = v.getResources().getResourceEntryName(imageView.getId());
                hands.add(a);
            }

        }
    }

}
