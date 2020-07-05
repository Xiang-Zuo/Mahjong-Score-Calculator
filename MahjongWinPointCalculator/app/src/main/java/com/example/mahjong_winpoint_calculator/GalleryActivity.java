package com.example.mahjong_winpoint_calculator;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class GalleryActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "GalleryActivity";

    Button homeBtn;
    Button loadDefaultBtn;
    Button hintBtn;

    String EXTRA_LAN;

    ImageView spot00 = null;
    ImageView spot01 = null;
    ImageView spot02 = null;
    ImageView spot03 = null;
    ImageView spot04 = null;
    ImageView spot10 = null;
    ImageView spot11 = null;
    ImageView spot12 = null;
    ImageView spot13 = null;

    ImageView spot20 = null;
    ImageView spot21 = null;
    ImageView spot22 = null;
    ImageView spot23 = null;
    ImageView spot24 = null;
    ImageView spot30 = null;
    ImageView spot31 = null;
    ImageView spot32 = null;
    ImageView spot33 = null;

    ImageView spot40 = null;
    ImageView spot41 = null;
    ImageView spot42 = null;
    ImageView spot43 = null;
    ImageView spot44 = null;
    ImageView spot50 = null;
    ImageView spot51 = null;
    ImageView spot52 = null;
    ImageView spot53 = null;

    ImageView spot60 = null;
    ImageView spot61 = null;
    ImageView spot62 = null;
    ImageView spot63 = null;
    ImageView spot64 = null;
    ImageView spot70 = null;
    ImageView spot71 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //全屏
        getSupportActionBar().hide(); //隐藏标题

        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);

        setContentView(R.layout.activity_gallery);

        spot00 = (ImageView) findViewById(R.id.spot00);
        spot01 = (ImageView) findViewById(R.id.spot01);
        spot02 = (ImageView) findViewById(R.id.spot02);
        spot03 = (ImageView) findViewById(R.id.spot03);
        spot04 = (ImageView) findViewById(R.id.spot04);
        spot10 = (ImageView) findViewById(R.id.spot10);
        spot11 = (ImageView) findViewById(R.id.spot11);
        spot12 = (ImageView) findViewById(R.id.spot12);
        spot13 = (ImageView) findViewById(R.id.spot13);

        spot20 = (ImageView) findViewById(R.id.spot20);
        spot21 = (ImageView) findViewById(R.id.spot21);
        spot22 = (ImageView) findViewById(R.id.spot22);
        spot23 = (ImageView) findViewById(R.id.spot23);
        spot24 = (ImageView) findViewById(R.id.spot24);
        spot30 = (ImageView) findViewById(R.id.spot30);
        spot31 = (ImageView) findViewById(R.id.spot31);
        spot32 = (ImageView) findViewById(R.id.spot32);
        spot33 = (ImageView) findViewById(R.id.spot33);

        spot40 = (ImageView) findViewById(R.id.spot40);
        spot41 = (ImageView) findViewById(R.id.spot41);
        spot42 = (ImageView) findViewById(R.id.spot42);
        spot43 = (ImageView) findViewById(R.id.spot43);
        spot44 = (ImageView) findViewById(R.id.spot44);
        spot50 = (ImageView) findViewById(R.id.spot50);
        spot51 = (ImageView) findViewById(R.id.spot51);
        spot52 = (ImageView) findViewById(R.id.spot52);
        spot53 = (ImageView) findViewById(R.id.spot53);

        spot60 = (ImageView) findViewById(R.id.spot60);
        spot61 = (ImageView) findViewById(R.id.spot61);
        spot62 = (ImageView) findViewById(R.id.spot62);
        spot63 = (ImageView) findViewById(R.id.spot63);
        spot64 = (ImageView) findViewById(R.id.spot64);
        spot70 = (ImageView) findViewById(R.id.spot70);
        spot71 = (ImageView) findViewById(R.id.spot71);

        spot00.setOnClickListener(this);
        spot01.setOnClickListener(this);
        spot02.setOnClickListener(this);
        spot03.setOnClickListener(this);
        spot04.setOnClickListener(this);
        spot10.setOnClickListener(this);
        spot11.setOnClickListener(this);
        spot12.setOnClickListener(this);
        spot13.setOnClickListener(this);

        spot20.setOnClickListener(this);
        spot21.setOnClickListener(this);
        spot22.setOnClickListener(this);
        spot23.setOnClickListener(this);
        spot24.setOnClickListener(this);
        spot30.setOnClickListener(this);
        spot31.setOnClickListener(this);
        spot32.setOnClickListener(this);
        spot33.setOnClickListener(this);

        spot40.setOnClickListener(this);
        spot41.setOnClickListener(this);
        spot42.setOnClickListener(this);
        spot43.setOnClickListener(this);
        spot44.setOnClickListener(this);
        spot50.setOnClickListener(this);
        spot51.setOnClickListener(this);
        spot52.setOnClickListener(this);
        spot53.setOnClickListener(this);

        spot60.setOnClickListener(this);
        spot61.setOnClickListener(this);
        spot62.setOnClickListener(this);
        spot63.setOnClickListener(this);
        spot64.setOnClickListener(this);
        spot70.setOnClickListener(this);
        spot71.setOnClickListener(this);


        init(this);

        homeBtn = findViewById(R.id.homeBtn);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch_to_main_activity();
            }
        });

        loadDefaultBtn = findViewById(R.id.defaultTemplateButton);
        loadDefaultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDefaultTemplate();
            }
        });
        hintBtn = findViewById(R.id.button_hint);
        hintBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHint();
            }
        });


        EXTRA_LAN = getIntent().getStringExtra("EXTRA_LAN");
        setLanguage(EXTRA_LAN);


    }

    private void showHint(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if (EXTRA_LAN.equals("EN")) {
            builder.setTitle("Hint")
                    .setMessage("The default template may not support all type of mahjong, make your own mahjong template!\n "+"Take photos of Mahjong tiles and crop them, replace the picture in the template page.\n" +
                        "*** Make sure to back up the template file, the template file directory is \n" +
                        "Files->Internal Storage->Android->Data->com.example.mahjong_winpoint_calculator->files->templates\n" +
                        "Please back up the entire templates file***")
                    .setPositiveButton("close", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
        }else{
            builder.setTitle("提示")
                    .setMessage("默认模板不一定支持所有的麻将，制作你自己的麻将模板吧\n"+"制作方法为拍摄麻将牌并裁剪成图片，根据名称替换默认模板中的图片\n" +
                            "***制作完成后请一定备份模板文件，更新过程很有可能造成文件丢失，模板文件目录为：\n" +
                            "文件管理->内部储存->Android->data->com.example.mahjong_winpoint_calculator->files->templates\n" +
                            "请保存整个templates文件***")
                    .setPositiveButton("close", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
        }
        builder.create().show();
    }

    private void setLanguage(String extra_lan) {
        TextView title = findViewById(R.id.gallery_title);
        if (extra_lan.equals("EN")){
            title.setText(getText(R.string.gallery_title_EN));
            loadDefaultBtn.setText(getText(R.string.gallery_default_EN));
            hintBtn.setText(R.string.gallery_hint_EN);
        }else {
            title.setText(getText(R.string.gallery_title));
            loadDefaultBtn.setText(getText(R.string.gallery_default));
            hintBtn.setText(R.string.gallery_hint);
        }
    }

    private void loadDefaultTemplate() {
        String[] templateList;
        try {
            templateList = getAssets().list("");
            if (templateList.length > 0){
                for (String fileName : templateList){
                    Bitmap bitmap  = getBitmapFromAssets(fileName);
                    saveImage(bitmap, -1, this, fileName);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


//        Bitmap bitmap3_w  = getBitmapFromAssets("3-w.jpg");
//        saveImage(bitmap3_w, 2, this);
//
//        Bitmap bitmap3_t  = getBitmapFromAssets("3-t.jpg");
//        saveImage(bitmap3_t, 42, this);
//
//        Bitmap bitmap3_b  = getBitmapFromAssets("3-b.jpg");
//        saveImage(bitmap3_b, 22, this);

        init(this);
    }

    public Bitmap getBitmapFromAssets(String fileName) {
        AssetManager assetManager = getAssets();
        InputStream istr = null;
        Bitmap bitmap = null;
        try {
            istr = assetManager.open(fileName);
            bitmap = BitmapFactory.decodeStream(istr);
            istr.close();
        } catch (IOException e) {
            Log.e(TAG, e.toString());
            e.printStackTrace();
        }
        return bitmap;
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.spot00:
            case R.id.spot01:
            case R.id.spot02:
            case R.id.spot03:
            case R.id.spot04:
            case R.id.spot10:
            case R.id.spot11:
            case R.id.spot12:
            case R.id.spot13:
            case R.id.spot20:
            case R.id.spot21:
            case R.id.spot22:
            case R.id.spot23:
            case R.id.spot24:
            case R.id.spot30:
            case R.id.spot31:
            case R.id.spot32:
            case R.id.spot33:
            case R.id.spot40:
            case R.id.spot41:
            case R.id.spot42:
            case R.id.spot43:
            case R.id.spot44:
            case R.id.spot50:
            case R.id.spot51:
            case R.id.spot52:
            case R.id.spot53:
            case R.id.spot60:
            case R.id.spot61:
            case R.id.spot62:
            case R.id.spot63:
            case R.id.spot64:
            case R.id.spot70:
            case R.id.spot71:
                String name = v.getResources().getResourceEntryName(v.getId());
                int id = Integer.valueOf(name.split("spot")[1]);
                onSpotClick(id);
                break;
            default:
                break;
        }

    }

    private void init(Context context) {
        File filepath = context.getExternalFilesDir(null);
        File dir = new File(filepath + File.separator + "templates");
        if (dir.exists()){
            ImageView spot;
            File[] files = dir.listFiles();
            for (File file : files){
                spot = getSpot(file.getName());
                if (spot != null){
                    Bitmap myBitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
                    spot.setImageBitmap(myBitmap);
                }
            }
        }else {
            Log.i(TAG, "template dir not exist");
        }
    }

    private ImageView getSpot(String fileName){
        ImageView imageView = null;
        switch (fileName){
            case "1-w.jpg": imageView = findViewById(R.id.spot00); break;
            case "2-w.jpg": imageView = findViewById(R.id.spot01); break;
            case "3-w.jpg": imageView = findViewById(R.id.spot02); break;
            case "4-w.jpg": imageView = findViewById(R.id.spot03); break;
            case "5-w.jpg": imageView = findViewById(R.id.spot04); break;
            case "6-w.jpg": imageView = findViewById(R.id.spot10); break;
            case "7-w.jpg": imageView = findViewById(R.id.spot11); break;
            case "8-w.jpg": imageView = findViewById(R.id.spot12); break;
            case "9-w.jpg": imageView = findViewById(R.id.spot13); break;

            case "1-b.jpg": imageView = findViewById(R.id.spot20); break;
            case "2-b.jpg": imageView = findViewById(R.id.spot21); break;
            case "3-b.jpg": imageView = findViewById(R.id.spot22); break;
            case "4-b.jpg": imageView = findViewById(R.id.spot23); break;
            case "5-b.jpg": imageView = findViewById(R.id.spot24); break;
            case "6-b.jpg": imageView = findViewById(R.id.spot30); break;
            case "7-b.jpg": imageView = findViewById(R.id.spot31); break;
            case "8-b.jpg": imageView = findViewById(R.id.spot32); break;
            case "9-b.jpg": imageView = findViewById(R.id.spot33); break;

            case "1-t.jpg": imageView = findViewById(R.id.spot40); break;
            case "2-t.jpg": imageView = findViewById(R.id.spot41); break;
            case "3-t.jpg": imageView = findViewById(R.id.spot42); break;
            case "4-t.jpg": imageView = findViewById(R.id.spot43); break;
            case "5-t.jpg": imageView = findViewById(R.id.spot44); break;
            case "6-t.jpg": imageView = findViewById(R.id.spot50); break;
            case "7-t.jpg": imageView = findViewById(R.id.spot51); break;
            case "8-t.jpg": imageView = findViewById(R.id.spot52); break;
            case "9-t.jpg": imageView = findViewById(R.id.spot53); break;

            case "d-f.jpg": imageView = findViewById(R.id.spot60); break;
            case "x-f.jpg": imageView = findViewById(R.id.spot61); break;
            case "n-f.jpg": imageView = findViewById(R.id.spot62); break;
            case "b-f.jpg": imageView = findViewById(R.id.spot63); break;
            case "h-Z.jpg": imageView = findViewById(R.id.spot64); break;
            case "b-B.jpg": imageView = findViewById(R.id.spot70); break;
            case "f-F.jpg": imageView = findViewById(R.id.spot71); break;
            default: break;
        }
        return imageView;
    }

    private void onSpotClick(int id) {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, id);
    }

    @Override
    protected void onActivityResult(int reqCode, int resultCode, Intent data) {

        super.onActivityResult(reqCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            try {
                final Uri imageUri = data.getData();
                final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                int imageViewID = 0;
                switch (reqCode){
                    case 0: case 1: case 2: case 3: case 4:
                        imageViewID = this.getResources().getIdentifier("spot0"+reqCode, "id", this.getPackageName());
                        break;
                    default:
                        imageViewID = this.getResources().getIdentifier("spot"+reqCode, "id", this.getPackageName());
                        break;
                }
                ImageView imageView = findViewById(imageViewID);
                imageView.setImageBitmap(selectedImage);
                saveImage(selectedImage, reqCode, this, "null");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_LONG).show();
            }

        }else {
            Toast.makeText(getApplicationContext(), "You haven't picked Image",Toast.LENGTH_LONG).show();
        }
    }

    private void saveImage(Bitmap bitmap, int id, Context context, String fileName) {
        //FileOutputStream out = null;
        if (!fileName.equals("") && !fileName.endsWith(".jpg"))
            return;
        if (fileName.equals("null")) {
            switch (id) {
                case 0:
                    fileName = "1-w.jpg";
                    break;
                case 1:
                    fileName = "2-w.jpg";
                    break;
                case 2:
                    fileName = "3-w.jpg";
                    break;
                case 3:
                    fileName = "4-w.jpg";
                    break;
                case 4:
                    fileName = "5-w.jpg";
                    break;
                case 10:
                    fileName = "6-w.jpg";
                    break;
                case 11:
                    fileName = "7-w.jpg";
                    break;
                case 12:
                    fileName = "8-w.jpg";
                    break;
                case 13:
                    fileName = "9-w.jpg";
                    break;
                case 20:
                    fileName = "1-b.jpg";
                    break;
                case 21:
                    fileName = "2-b.jpg";
                    break;
                case 22:
                    fileName = "3-b.jpg";
                    break;
                case 23:
                    fileName = "4-b.jpg";
                    break;
                case 24:
                    fileName = "5-b.jpg";
                    break;
                case 30:
                    fileName = "6-b.jpg";
                    break;
                case 31:
                    fileName = "7-b.jpg";
                    break;
                case 32:
                    fileName = "8-b.jpg";
                    break;
                case 33:
                    fileName = "9-b.jpg";
                    break;
                case 40:
                    fileName = "1-t.jpg";
                    break;
                case 41:
                    fileName = "2-t.jpg";
                    break;
                case 42:
                    fileName = "3-t.jpg";
                    break;
                case 43:
                    fileName = "4-t.jpg";
                    break;
                case 44:
                    fileName = "5-t.jpg";
                    break;
                case 50:
                    fileName = "6-t.jpg";
                    break;
                case 51:
                    fileName = "7-t.jpg";
                    break;
                case 52:
                    fileName = "8-t.jpg";
                    break;
                case 53:
                    fileName = "9-t.jpg";
                    break;
                case 60:
                    fileName = "d-f.jpg";
                    break;
                case 61:
                    fileName = "x-f.jpg";
                    break;
                case 62:
                    fileName = "n-f.jpg";
                    break;
                case 63:
                    fileName = "b-f.jpg";
                    break;
                case 64:
                    fileName = "h-Z.jpg";
                    break;
                case 70:
                    fileName = "b-B.jpg";
                    break;
                case 71:
                    fileName = "f-F.jpg";
                    break;
                default:
                    fileName = "";
                    break;
            }
        }
//        File filepath = Environment.getExternalStorageDirectory();
        File filepath = context.getExternalFilesDir(null);
        File dir = new File(filepath + File.separator + "templates");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File imageFile = new File(dir, fileName);
//        if (imageFile.exists())
//            imageFile.delete();
        try {
            FileOutputStream out = new FileOutputStream(imageFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100 , out);
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (id != -1) {
            Toast.makeText(getApplicationContext(), "Template saved!", Toast.LENGTH_SHORT).show();
        }
        MediaScannerConnection.scanFile(this, new String[]{imageFile.toString()}, new String[]{imageFile.getName()}, null);
    }

    private void switch_to_main_activity() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("EXTRA_LAN", EXTRA_LAN);
        startActivity(intent);
    }

}
