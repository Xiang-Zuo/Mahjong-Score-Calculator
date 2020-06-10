package com.example.mahjong_winpoint_calculator;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;

import androidx.appcompat.app.AppCompatActivity;

public class GalleryActivity extends AppCompatActivity implements View.OnClickListener {

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
                    default:
                        imageViewID = this.getResources().getIdentifier("spot"+reqCode, "id", this.getPackageName());
                }
                ImageView imageView = findViewById(imageViewID);
                imageView.setImageBitmap(selectedImage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_LONG).show();
            }

        }else {
            Toast.makeText(getApplicationContext(), "You haven't picked Image",Toast.LENGTH_LONG).show();
        }
    }

}
