package com.example.mahjong_winpoint_calculator;

import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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
import org.opencv.imgproc.Imgproc;

import java.io.IOException;

import androidx.appcompat.app.AppCompatActivity;

public class CameraActivity extends AppCompatActivity implements CvCameraViewListener2{
    //状态
    private String TAG;
    //OpenCV的相机接口
    private CameraBridgeViewBase mCVCamera;
    //缓存相机每帧输入的数据
    private Mat mRgba;
    //拍照btn
    private Button button;

    /**通过OpenCV管理Android服务，初始化OpenCV**/
    BaseLoaderCallback mLoaderCallback = new BaseLoaderCallback(this) {
        @Override
        public void onManagerConnected(int status) {
            switch (status) {
                case LoaderCallbackInterface.SUCCESS:
                    Log.i(TAG, "OpenCV loaded successfully");
                    mCVCamera.enableView();
                    break;
                default:break;
            }
        }
    };
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            if(msg.what == 1){
                button.performClick();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //全屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); //横屏
        getSupportActionBar().hide(); //隐藏标题
        setContentView(R.layout.activity_camera);

        //初始化并设置预览部件
        mCVCamera = (CameraBridgeViewBase) findViewById(R.id.camera_view);
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
                        Mat template = readImageFromResources(R.drawable.yiwan);
//                        Imgproc.resize(template,template,new Size(template.cols() / 5, template.rows() ), 0, 0, Imgproc.INTER_AREA);
                        Mat result = matchTemplate(src,template);
//                        template = readImageFromResources(R.drawable.erwan);
//                        result = matchTemplate(result,template);
                        Log.e("Match-------result:", Boolean.toString(result.empty()));
                        showImg(result);


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
    protected void onResume() {
        /***强制横屏***/
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
        Log.e("Mat","...............4...............");
        mRgba = new Mat(height, width, CvType.CV_8UC4);
    }

    /**图像处理都写在这里！！！**/
    @Override
    public Mat onCameraFrame(CameraBridgeViewBase.CvCameraViewFrame inputFrame) {
        mRgba = inputFrame.rgba();  //一定要有！！！不然数据保存不进MAT中！！！
        //直接返回输入视频预览图的RGB数据并存放在Mat数据中
        Log.e("Mat","...............5...............");
        return mRgba;
    }

    //结束时释放
    @Override
    public void onCameraViewStopped() {
        Log.e("Mat","...............6...............");
        mRgba.release();
    }

    //src image, template, method, return img with rect
    public static Mat matchTemplate(Mat img, Mat temp) {
//        Imgproc.cvtColor(img, img, Imgproc.COLOR_rgba2bgra);
//        Imgproc.cvtColor(temp, temp, Imgproc.COLOR_RGB2BGRA);
        Log.e("Matching:","before" );
        int match_method = Imgproc.TM_CCOEFF_NORMED;


        int result_cols = img.cols() - temp.cols() + 1;
        int result_rows = img.rows() - temp.rows() + 1;
        Mat result = new Mat(result_rows, result_cols, CvType.CV_32FC1);
        Imgproc.matchTemplate(img, temp, result, match_method);

        Log.e("Match", Boolean.toString(result.empty()));


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

        //return result;
        return  img;
    }

    private Mat readImageFromResources(int resource_ID) {
        Mat img = null;
        try {
            img = Utils.loadResource(this, resource_ID);
            //Imgproc.cvtColor(img, img, Imgproc.COLOR_RGB2BGRA);
            Imgproc.cvtColor(img, img, Imgproc.COLOR_RGB2RGBA);

        } catch (IOException e) {
            Log.e(TAG, Log.getStackTraceString(e));
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

}

