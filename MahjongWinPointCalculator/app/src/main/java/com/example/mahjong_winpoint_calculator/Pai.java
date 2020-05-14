package com.example.mahjong_winpoint_calculator;

import android.content.Context;

import org.opencv.core.Mat;

public class Pai {
    private Context context;
    protected String NAME;
    protected int ID;
    protected double xCoor;
    protected double yCoor;
    protected Mat MAT;

    public Pai(Context current, String name){
        this.context = current;
        this.NAME = name;
    }

    public boolean init(){
        this.ID = context.getResources().getIdentifier(this.NAME, "drawable", context.getPackageName());
        return this.ID != 0;
    }

    public void setXY(double x, double y){
        this.xCoor = x;
        this.yCoor = y;
    }

    public void setMAT(Mat mat){
        this.MAT = mat;
    }
}
