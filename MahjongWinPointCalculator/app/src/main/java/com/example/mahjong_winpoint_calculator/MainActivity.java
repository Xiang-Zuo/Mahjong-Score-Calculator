package com.example.mahjong_winpoint_calculator;

import android.os.Bundle;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.CameraBridgeViewBase.CvCameraViewListener2;
import org.opencv.core.Mat;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.CvType;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import android.content.pm.ActivityInfo;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;
import java.util.Date;


public class MainActivity extends AppCompatActivity implements CvCameraViewListener2{
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
        setContentView(R.layout.activity_main);

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
                        Mat inter = new Mat(mRgba.width(), mRgba.height(), CvType.CV_8UC4);
                        Log.e("Mat","...............1...............");
                        //将四通道的RGBA转为三通道的BGR，重要！！
                        Imgproc.cvtColor(mRgba, inter, Imgproc.COLOR_RGBA2BGR);
                        Log.e("Mat","...............2...............");
                        File sdDir = null;
                        //判断是否存在机身内存
                        boolean sdCardExist = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
                        if(sdCardExist) {
                            //获得机身储存根目录
                            sdDir = Environment.getExternalStorageDirectory();
                            Log.e("Mat","...............3...............");
                        }
                        //将拍摄准确时间作为文件名
                        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
                        String filename = sdf.format(new Date());
                        String savepath=sdDir + "/Pictures/OpenCV/";
                        File f=new File(savepath);
                        if(!f.exists()){
                            f.mkdirs();
                        }
                        String filePath = sdDir + "/Pictures/OpenCV/" + filename + ".png";
                        Log.e("Mat","..............."+filePath+"...............");
                        //将转化后的BGR矩阵内容写入到文件中
                        Imgcodecs.imwrite(filePath, inter);
                        Toast.makeText(MainActivity.this, "图片保存到: "+ filePath, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        // check camera permission



//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }


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
}

