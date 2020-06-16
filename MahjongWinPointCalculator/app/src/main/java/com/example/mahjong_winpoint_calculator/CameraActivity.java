package com.example.mahjong_winpoint_calculator;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
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
import org.opencv.android.Utils;
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

import androidx.appcompat.app.AppCompatActivity;

public class CameraActivity extends AppCompatActivity implements CvCameraViewListener2{
    private static final String TAG = "CameraActivity";
    //OpenCV的相机接口
    private CameraBridgeViewBase mCVCamera;
    //缓存相机每帧输入的数据
    private Mat mRgba;
    //拍照btn
    Button button;
    //
    private static ArrayList<String> hands = new ArrayList<>();

    public static final String EXTRA_HANDS = "com.example.mahjong_winpoint_calculator.EXTRA_HANDS";

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

        //拍照按键
        button = (Button) findViewById(R.id.deal_btn);

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
//                            if (resizedCol == 0.0 && resizedRow == 0.0){
//                                resizedCol = template.cols() / 6;
//                                resizedRow = template.rows() / 6;
//                            }
//                            Log.e("col", resizedCol +"");
//                            Log.e("row", resizedRow +"");

//                            Imgproc.cvtColor(template,template,Imgproc.COLOR_RGBA2GRAY);
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
//                            if (resizedCol == 0.0 && resizedRow == 0.0){
//                                resizedCol = template.cols() / 4;
//                                resizedRow = template.rows() / 4;
//                            }
//                            Imgproc.cvtColor(template,template,Imgproc.COLOR_RGBA2GRAY);
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
//                            if (resizedCol == 0.0 && resizedRow == 0.0){
//                                resizedCol = template.cols() / 4;
//                                resizedRow = template.rows() / 4;
//                            }
//                            Imgproc.cvtColor(template,template,Imgproc.COLOR_RGBA2GRAY);
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
//                            if (resizedCol == 0.0 && resizedRow == 0.0){
//                                resizedCol = template.cols() / 4;
//                                resizedRow = template.rows() / 4;
//                            }
//                            Imgproc.cvtColor(template,template,Imgproc.COLOR_RGBA2GRAY);
                            Imgproc.resize(template,template,new Size(resizedCol, resizedRow ), 0, 0, Imgproc.INTER_AREA);
                            if (result == null)
                                result = matchTemplate(src, template, paiName.replace(".jpg",""));
                            else
                                result = matchTemplate(result, template, paiName.replace(".jpg",""));
                        }
                        switch_to_result_activity();
                    }
                }
            }
        });
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
            //横屏后才加载部件，否则会FC
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

    //对象实例化及基本属性的设置，包括长度、宽度和图像类型标志
    public void onCameraViewStarted(int width, int height) {
        mRgba = new Mat(height, width, CvType.CV_8UC4);
    }

    /**图像处理都写在这里！！！**/
    @Override
    public Mat onCameraFrame(CameraBridgeViewBase.CvCameraViewFrame inputFrame) {
        mRgba = inputFrame.rgba();
//        //only for emulator in display native image
//        Imgproc.cvtColor(mRgba,mRgba,Imgproc.COLOR_RGBA2BGR);
        // for compare
        Imgproc.cvtColor(mRgba,mRgba,Imgproc.COLOR_RGBA2GRAY);

        return mRgba;
    }

    //结束时释放
    @Override
    public void onCameraViewStopped() {
        //Log.e("Mat","...............6...............");
        mRgba.release();
    }

    //src image, template, method, return img with rect
    public Mat matchTemplate(Mat img, Mat temp, String card_Name) {
//        Imgproc.cvtColor(img, img, Imgproc.COLOR_rgba2bgra);
//        Imgproc.cvtColor(temp, temp, Imgproc.COLOR_RGB2BGRA);

        int match_method = Imgproc.TM_CCOEFF_NORMED;
        //int match_method = Imgproc.TM_CCORR;

        ArrayList<String> uniqueObjPositions = new ArrayList<>();

        int result_cols = img.cols() - temp.cols() + 1;
        int result_rows = img.rows() - temp.rows() + 1;
        Mat result = new Mat(result_rows, result_cols, CvType.CV_32FC1);
        Imgproc.matchTemplate(img, temp, result, match_method);


//        Core.MinMaxLocResult mmr = Core.minMaxLoc(result);
//        Point matchLoc;
//        if (match_method == Imgproc.TM_SQDIFF || match_method == Imgproc.TM_SQDIFF_NORMED) {
//            matchLoc = mmr.minLoc;
//        } else {
//            matchLoc = mmr.maxLoc;
//        }
//        Imgproc.rectangle(img, matchLoc, new Point(matchLoc.x + temp.cols(),matchLoc.y + temp.rows()), new Scalar(0, 255, 0));
//        Log.e("Writing:","result" );


        while(true)
        {
            Core.MinMaxLocResult mmr = Core.minMaxLoc(result);
            Point matchLoc = mmr.maxLoc;
            if(mmr.maxVal >=0.75)
            {
                Log.i("x-y", matchLoc.x +"-"+matchLoc.y);
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
            Log.i("x-y-coor", xy);
            hands.add(xy.split("-")[2] + "-" + xy.split("-")[3]);
        }
        return  img;
    }

    private Mat readImageFromFile(String paiName, Context context) {
//        Pai pai = new Pai(this, paiName);
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

    private void showImg(Mat img) {
        //Imgproc.cvtColor(img, img, Imgproc.COLOR_RGBA2BGRA);
        Bitmap bm = Bitmap.createBitmap(img.cols(), img.rows(),Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(img, bm);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageBitmap(bm);
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
        startActivity(intent);
    }
}

