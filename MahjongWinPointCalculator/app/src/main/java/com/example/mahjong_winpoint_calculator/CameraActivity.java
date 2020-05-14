package com.example.mahjong_winpoint_calculator;

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
import org.opencv.imgproc.Imgproc;

import java.io.IOException;
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

//    private int[] TEMPLATEID = new int[]{R.drawable.erwan, R.drawable.sanwan, R.drawable.siwan, R.drawable.wuwan, R.drawable.liuwan, R.drawable.qiwan};
    private String[] TEMPLATEID = new String[]{"yiwan","erwan", "sanwan", "siwan", "wuwan", "liuwan", "qiwan"};


    /**通过OpenCV管理Android服务，初始化OpenCV**/
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
//    Handler handler = new Handler(){
//        @Override
//        public void handleMessage(Message msg){
//            super.handleMessage(msg);
//            if(msg.what == 1){
//                button.performClick();
//            }
//        }
//    };

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
                        double resizedCol = 0.0;
                        double resizedRow = 0.0;
                        Mat result = null;
                        int count = 1;
                        //correct...
//                        Mat template = readImageFromResources("yiwan").MAT;
//                        double resizedCol = template.cols() / 2.5;
//                        double resizedRow = template.rows() / 2.5;
//                        int count = 2;
//                        Mat result;
//                        Imgproc.cvtColor(template,template,Imgproc.COLOR_RGBA2GRAY);
//                        Imgproc.resize(template,template,new Size(resizedCol, resizedRow ), 0, 0, Imgproc.INTER_AREA);
//                        result = matchTemplate(src,template, "1-w");
//                        for (int templateID : TEMPLATEID){
//                            template = readImageFromResources(templateID);
//                            Imgproc.cvtColor(template,template,Imgproc.COLOR_RGBA2GRAY);
//                            Imgproc.resize(template,template,new Size(resizedCol, resizedRow ), 0, 0, Imgproc.INTER_AREA);
//                            result = matchTemplate(result,template, count+"-w");
//                            count += 1;
//                        }
//                        showImg(result);
//                        Log.e("Match-------result:", hands.toString());


                        for (String paiName : TEMPLATEID){
                            Mat template = readImageFromResources(paiName).MAT;
                            if (resizedCol == 0.0 && resizedRow == 0.0){
                                resizedCol = template.cols() / 2.5;
                                resizedRow = template.rows() / 2.5;
                            }
                            Imgproc.cvtColor(template,template,Imgproc.COLOR_RGBA2GRAY);
                            Imgproc.resize(template,template,new Size(resizedCol, resizedRow ), 0, 0, Imgproc.INTER_AREA);
                            if (result == null)
                                result = matchTemplate(src,template, count +"-w");
                            else
                                result = matchTemplate(result,template, count +"-w");
                            count += 1;
                        }
                        showImg(result);
                        Log.e("Match-------result:", hands.toString());


                        //switch_to_result_activity();

                        //...correct


                        //Mat inter = new Mat(mRgba.width(), mRgba.height(), CvType.CV_8UC4);
                        //Log.e("Mat","...............1...............");
                        //将四通道的RGBA转为三通道的BGR，重要！！
//                        Imgproc.cvtColor(mRgba, inter, Imgproc.COLOR_RGBA2BGR);
//                        Log.e("Mat","...............2...............");
//                        File sdDir = null;
//                        //判断是否存在机身内存
//                        boolean sdCardExist = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
//                        if(sdCardExist) {
//                            //获得机身储存根目录
//                            sdDir = Environment.getExternalStorageDirectory();
//                            Log.e("Mat","...............3...............");
//                        }
//                        //将拍摄准确时间作为文件名
//                        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
//                        String filename = sdf.format(new Date());
//                        String savepath=sdDir + "/Pictures/OpenCV/";
//                        File f=new File(savepath);
//                        if(!f.exists()){
//                            f.mkdirs();
//                        }
//                        String filePath = sdDir + "/Pictures/OpenCV/" + filename + ".png";
//                        Log.e("Mat","..............."+filePath+"...............");
//                        //将转化后的BGR矩阵内容写入到文件中
//                        Imgcodecs.imwrite(filePath, inter);
//                        Toast.makeText(CameraActivity.this, "图片保存到: "+ filePath, Toast.LENGTH_SHORT).show();
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
        Log.e("Mat","...............6...............");
        mRgba.release();
    }

    //src image, template, method, return img with rect
    public Mat matchTemplate(Mat img, Mat temp, String card_Name) {
//        Imgproc.cvtColor(img, img, Imgproc.COLOR_rgba2bgra);
//        Imgproc.cvtColor(temp, temp, Imgproc.COLOR_RGB2BGRA);

        int match_method = Imgproc.TM_CCOEFF_NORMED;
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
            if(mmr.maxVal >=0.8)
            {
                Log.i("x-y", matchLoc.x +"-"+matchLoc.y);
                uniqueObjXYCoor(matchLoc.x, matchLoc.y,uniqueObjPositions,card_Name);
//                unique_xy_coor.add(Math.ceil(matchLoc.x / 10) + "-" + Math.ceil(matchLoc.y / 10));

//                hands.add(card_Name);
                Imgproc.rectangle(img, matchLoc,
                        new Point(matchLoc.x + temp.cols(),matchLoc.y + temp.rows()),
                        new Scalar(0,255,0));
                Imgproc.rectangle(result, matchLoc,
                        new Point(matchLoc.x + temp.cols(),matchLoc.y + temp.rows()),
                        new    Scalar(0,255,0),-1);
                //break;
            }
            else
            {
                break; //No more results within tolerance, break search
            }
        }

        for (String xy : uniqueObjPositions){
            Log.i("x-y-coor", xy);
            hands.add(xy.split("-")[2] + "-" + xy.split("-")[3]);

            //write label
            Imgproc.putText (
                    img,                          // Matrix obj of the image
                    card_Name,          // Text to be added
                    new Point(Double.parseDouble(xy.split("-")[0]), Double.parseDouble(xy.split("-")[1])),               // point
                    Core.FONT_HERSHEY_SIMPLEX ,      // front face
                    1,                               // front scale
                    new Scalar(0, 0, 0),             // Scalar object for color
                    1                                // Thickness
            );

        }

        //return result;
        return  img;
    }

    private Pai readImageFromResources(String paiName) {
        Pai pai = new Pai(this, paiName);
        try {
            if (pai.init()){
                Mat img = Utils.loadResource(this, pai.ID);
                //Imgproc.cvtColor(img, img, Imgproc.COLOR_RGB2BGRA);
                Imgproc.cvtColor(img, img, Imgproc.COLOR_RGB2RGBA);
                pai.setMAT(img);
            }else{
                Log.e(TAG, "fail to get pai drawable");
            }
        } catch (IOException e) {
            Log.e(TAG, Log.getStackTraceString(e));
        }
        return pai;
    }

    private void showImg(Mat img) {
        //Imgproc.cvtColor(img, img, Imgproc.COLOR_RGBA2BGRA);
        Bitmap bm = Bitmap.createBitmap(img.cols(), img.rows(),Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(img, bm);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageBitmap(bm);
    }

    private ArrayList<String> uniqueObjXYCoor(Double x, Double y, ArrayList<String> xYCoor, String cardName){
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

        return xYCoor;
    }

    private void switch_to_result_activity() {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("EXTRA_HANDS", (ArrayList<String>) hands);
        startActivity(intent);
    }


}

