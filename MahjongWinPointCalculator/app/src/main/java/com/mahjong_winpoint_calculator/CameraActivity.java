package com.mahjong_winpoint_calculator;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.CameraBridgeViewBase.CvCameraViewListener2;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import androidx.appcompat.app.AppCompatActivity;

public class CameraActivity extends AppCompatActivity implements CvCameraViewListener2{
    private static final String TAG = "CameraActivity";

    private CameraBridgeViewBase mCVCamera;
    private Mat mRgba;
    Button button;
    Button backToMainBtn;
    String EXTRA_LAN;

    private static ArrayList<String> hands = new ArrayList<>();

    public static final String EXTRA_HANDS = "com.mahjong_winpoint_calculator.EXTRA_HANDS";

    private String[] TEMPLATEID_WAN  = new String[]{"1-w.jpg","2-w.jpg", "3-w.jpg", "4-w.jpg", "5-w.jpg", "6-w.jpg", "7-w.jpg", "8-w.jpg", "9-w.jpg"};
    private String[] TEMPLATEID_TIAO = new String[]{"1-t.jpg","2-t.jpg", "3-t.jpg", "4-t.jpg", "5-t.jpg", "6-t.jpg", "7-t.jpg", "8-t.jpg", "9-t.jpg"};
    private String[] TEMPLATEID_BING = new String[]{"1-b.jpg","2-b.jpg", "3-b.jpg", "4-b.jpg", "5-b.jpg", "6-b.jpg", "7-b.jpg", "8-b.jpg", "9-b.jpg"};
    private String[] TEMPLATEID_ZI   = new String[]{"d-f.jpg","n-f.jpg", "x-f.jpg", "b-f.jpg", "h-Z.jpg", "b-B.jpg", "f-F.jpg"};
    
    private BaseLoaderCallback mLoaderCallback = new BaseLoaderCallback(this) {
        @Override
        public void onManagerConnected(int status) {
            switch (status) {
                case LoaderCallbackInterface.SUCCESS:
                    Log.i(TAG, "OpenCV loaded successfully");
                    mCVCamera.enableView();
                    break;
                default:{
                    super.onManagerConnected(status);
                }break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "called onCreate");
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //全屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); //横屏
        getSupportActionBar().hide(); //隐藏标题
        setContentView(R.layout.activity_camera);

        //初始化并设置预览部件
        mCVCamera = (CameraBridgeViewBase) findViewById(R.id.show_camera_activity_java_surface_view);
        mCVCamera.setCvCameraViewListener(this);

        button = (Button) findViewById(R.id.deal_btn);
        backToMainBtn = (Button) findViewById(R.id.back_btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mRgba != null) {
                    if(!mRgba.empty()) {
                        //mRgba 为opencv的4通道
                        Mat src = mRgba;
                        hands.clear();
                        double resizedCol = 99;
                        double resizedRow = 133.33;
                        Mat result = null;

                        for (String paiName : TEMPLATEID_WAN){
                            Mat template = readImageFromFile(paiName,CameraActivity.this);
                            if (template == null){
                                Log.i(TAG, paiName + " file not exist");
                                continue;
                            }
                            Imgproc.resize(template,template,new Size(resizedCol, resizedRow ), 0, 0, Imgproc.INTER_AREA);
                            if (result == null)
                                result = matchTemplate(src,template, paiName.replace(".jpg",""));
                            else
                                result = matchTemplate(result,template,paiName.replace(".jpg",""));

                        }

                        for (String paiName : TEMPLATEID_TIAO){
                            Mat template = readImageFromFile(paiName,CameraActivity.this);
                            if (template == null){
                                Log.i(TAG, paiName + " file not exist");
                                continue;
                            }
                            Imgproc.resize(template,template,new Size(resizedCol, resizedRow ), 0, 0, Imgproc.INTER_AREA);
                            if (result == null)
                                result = matchTemplate(src, template, paiName.replace(".jpg",""));
                            else
                                result = matchTemplate(result, template, paiName.replace(".jpg",""));
                        }


                        for (String paiName : TEMPLATEID_BING){
                            Mat template = readImageFromFile(paiName,CameraActivity.this);
                            if (template == null){
                                Log.i(TAG, paiName + " file not exist");
                                continue;
                            }
                            Imgproc.resize(template,template,new Size(resizedCol, resizedRow ), 0, 0, Imgproc.INTER_AREA);
                            if (result == null)
                                result = matchTemplate(src, template, paiName.replace(".jpg",""));
                            else
                                result = matchTemplate(result, template, paiName.replace(".jpg",""));
                        }
                        for (String paiName : TEMPLATEID_ZI){
                            Mat template = readImageFromFile(paiName,CameraActivity.this);
                            if (template == null){
                                Log.i(TAG, paiName + " file not exist");
                                continue;
                            }
                            Imgproc.resize(template,template,new Size(resizedCol, resizedRow ), 0, 0, Imgproc.INTER_AREA);
                            if (result == null)
                                result = matchTemplate(src, template, paiName.replace(".jpg",""));
                            else
                                result = matchTemplate(result, template, paiName.replace(".jpg",""));
                        }
                        ArrayList<String> sortedHand = sortPosition(hands);
                        hands.clear();
                        hands.addAll(0,sortedHand);
                        switch_to_result_activity();
                    }
                }
            }
        });
        backToMainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch_to_main_activity();
            }
        });
        EXTRA_LAN = getIntent().getStringExtra("EXTRA_LAN");
        setLanguage(EXTRA_LAN);
    }

    private void setLanguage(String extra_lan) {
        Button dealBtn = findViewById(R.id.deal_btn);
        Button backBtn = findViewById(R.id.back_btn);
        if (extra_lan.equals("EN")){
            dealBtn.setText(getText(R.string.camera_take_photo_EN));
            backBtn.setText(getText(R.string.camera_back_to_main_EN));
        }else {
            dealBtn.setText(getText(R.string.camera_take_photo));
            backBtn.setText(getText(R.string.camera_back_to_main));
        }
    }

    @Override
    public void onPause()
    {
        super.onPause();
        if (mCVCamera != null)
            mCVCamera.disableView();
    }

    @Override
    protected void onResume() {
        // landscape
        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        } else {
            if(!OpenCVLoader.initDebug()) {
                Log.d(TAG, "OpenCV library not found!");
            } else {
                Log.d(TAG, "OpenCV library found inside package. Using it!");
                mLoaderCallback.onManagerConnected(LoaderCallbackInterface.SUCCESS);
            }
        }
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        if(mCVCamera != null) {
            mCVCamera.disableView();
        }
        super.onDestroy();
    }

    public void onCameraViewStarted(int width, int height) {
        mRgba = new Mat(height, width, CvType.CV_8UC4);
    }

    @Override
    public Mat onCameraFrame(CameraBridgeViewBase.CvCameraViewFrame inputFrame) {
        mRgba = inputFrame.rgba();
        Imgproc.cvtColor(mRgba,mRgba,Imgproc.COLOR_RGBA2GRAY);
        return mRgba;
    }

    //结束时释放
    @Override
    public void onCameraViewStopped() {
        mRgba.release();
    }

    //src image, template, method, return img with rect
    public Mat matchTemplate(Mat img, Mat temp, String card_Name) {
        int match_method = Imgproc.TM_CCOEFF_NORMED;
        ArrayList<String> uniqueObjPositions = new ArrayList<>();

        int result_cols = img.cols() - temp.cols() + 1;
        int result_rows = img.rows() - temp.rows() + 1;
        Mat result = new Mat(result_rows, result_cols, CvType.CV_32FC1);
        Imgproc.matchTemplate(img, temp, result, match_method);

        while(true)
        {
            Core.MinMaxLocResult mmr = Core.minMaxLoc(result);
            Point matchLoc = mmr.maxLoc;
            if(mmr.maxVal >=0.8)
            {
                uniqueObjXYCoor(matchLoc.x, matchLoc.y,uniqueObjPositions,card_Name);
                Imgproc.rectangle(img, matchLoc,
                        new Point(matchLoc.x + temp.cols(),matchLoc.y + temp.rows()),
                        new Scalar(0,255,0));
                Imgproc.rectangle(result, matchLoc,
                        new Point(matchLoc.x + temp.cols(),matchLoc.y + temp.rows()),
                        new    Scalar(0,255,0),-1);
            }
            else
            {
                break; //No more results within tolerance, break search
            }
        }

        for (String xy : uniqueObjPositions){
            hands.add(xy);

        }
        return  img;
    }

    private ArrayList<String> sortPosition(ArrayList<String> src){
        if (src.isEmpty()){
            return new ArrayList<>();
        }
        ArrayList<String> row0 = new ArrayList<>();
        ArrayList<String> row1 = new ArrayList<>();
        ArrayList<String> row2 = new ArrayList<>();
        ArrayList<String> row3 = new ArrayList<>();
        ArrayList<String> row4 = new ArrayList<>();
        ArrayList<String> outlier = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();

        double y0 = 0.0;
        double y1 = 0.0;
        double y2 = 0.0;
        double y3 = 0.0;
        double y4 = 0.0;

        for (String pai : src){
            double y =Double.parseDouble(pai.split("-")[1]);
            if (y0 == 0.0 || Math.abs(y0 - y) < 30){
                row0.add(pai);
                y0 = y;
            }else if (y1 == 0.0 || Math.abs(y1 - y) < 30){
                row1.add(pai);
                y1 = y;
            }else if (y2 == 0.0 || Math.abs(y2 - y) < 30){
                row2.add(pai);
                y2 = y;
            }else if (y3 == 0.0 || Math.abs(y3 - y) < 30){
                row3.add(pai);
                y3 = y;
            }else if (y4 == 0.0 || Math.abs(y4 - y) < 30){
                row4.add(pai);
                y4 = y;
            }else {
                outlier.add(pai);
            }
        }

        ArrayList<Double> sortedY = new ArrayList<Double>();
        sortedY.add(y0);
        sortedY.add(y1);
        sortedY.add(y2);
        sortedY.add(y3);
        sortedY.add(y4);

        Log.i("row 0" , row0.toString());
        Log.i("row 1" , row1.toString());
        Log.i("row 2" , row2.toString());
        Log.i("row 3" , row3.toString());
        Log.i("row 4" , row4.toString());
        Log.i("outlier" , outlier.toString());

        Collections.sort(sortedY);
        Log.i("sorted", sortedY.toString());

        for (Double y : sortedY){
            if (Double.parseDouble(row0.get(row0.size() - 1).split("-")[1]) == y){
                result.addAll(result.size(),row0);
                int emptySpot = 3-row0.size();
                while (emptySpot > 0){
                    result.add("null");
                    emptySpot--;
                }
            }else if(Double.parseDouble(row1.get(row1.size() - 1).split("-")[1]) == y){
                result.addAll(result.size(),row1);
                int emptySpot = 3-row1.size();
                while (emptySpot > 0){
                    result.add("null");
                    emptySpot--;
                }
            }else if(Double.parseDouble(row2.get(row2.size() - 1).split("-")[1]) == y){
                result.addAll(result.size(),row2);
                int emptySpot = 3-row2.size();
                while (emptySpot > 0){
                    result.add("null");
                    emptySpot--;
                }
            }else if(Double.parseDouble(row3.get(row3.size() - 1).split("-")[1]) == y){
                result.addAll(result.size(),row3);
                int emptySpot = 3-row3.size();
                while (emptySpot > 0){
                    result.add("null");
                    emptySpot--;
                }
            }else if(Double.parseDouble(row4.get(row4.size() - 1).split("-")[1]) == y){
                result.addAll(result.size(),row4);
                int emptySpot = 2-row4.size();
                while (emptySpot > 0){
                    result.add("null");
                    emptySpot--;
                }
            }
        }
        for (int i = 0;i<result.size(); i++){
            String pai = "null";
            if (!result.get(i).equals("null"))
                pai = result.get(i).split("-")[2] + "-" + result.get(i).split("-")[3];
            result.set(i,pai);
        }
        return result;
    }

    private Mat readImageFromFile(String paiName, Context context) {
        Mat img = null;
        File filepath = context.getExternalFilesDir(null);
        File dir = new File(filepath + File.separator + "templates");
        if (dir.exists()){
            ImageView spot;
            File[] files = dir.listFiles();
            for (File file : files){
                if (file.getName().equals(paiName))
                    img = Imgcodecs.imread(file.getAbsolutePath(), Imgcodecs.IMREAD_GRAYSCALE);
            }
        }else {
            Log.e(TAG, "template dir not exist");
        }
        return img;
    }

    private void uniqueObjXYCoor(Double x, Double y, ArrayList<String> xYCoor, String cardName){
        Boolean unique = true;
        if (xYCoor.isEmpty()){
            xYCoor.add(x+"-"+y + "-" + cardName);
        }else{
            for (String xY : xYCoor){
                Double xTemp = Double.parseDouble(xY.split("-")[0]);
                Double yTemp = Double.parseDouble(xY.split("-")[1]);
                if (Math.abs(x-xTemp) < 20 && Math.abs(y-yTemp) < 20){
                    unique = false;
                }
            }
            if (unique)
                xYCoor.add(x+"-"+y+"-"+cardName);
        }
    }

    private void switch_to_result_activity() {
        Log.e("Camera", hands.toString());
        Intent intent = new Intent(this, ManuallyActivity.class);
        intent.putExtra("EXTRA_HANDS", (ArrayList<String>) hands);
        intent.putExtra("EXTRA_LAN", EXTRA_LAN);
        startActivity(intent);
        finish();
    }

    private void switch_to_main_activity() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("EXTRA_LAN", EXTRA_LAN);
        startActivity(intent);
        finish();
    }
}

