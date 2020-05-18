package com.example.mahjong_winpoint_calculator;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity implements OnItemSelectedListener{
    private static final String TAG = "ResultActivity";
    private ArrayList<Spinner> spinners;
    Button calculate_point_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); //隐藏标题
        setContentView(R.layout.activity_result);
        ArrayList<String> hands = getIntent().getStringArrayListExtra("EXTRA_HANDS");

        //display hands in Spinners
        spinnersInit(hands);

        calculate_point_btn = (Button) findViewById(R.id.result_calculate_button);
        calculate_point_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                ArrayList<String> modifiedHands = new ArrayList<String>();
                for (Spinner spinner: spinners){
                    modifiedHands.add(switchPaiName(spinner.getSelectedItem().toString()));
                }
                Log.i("Modified Hands:", modifiedHands.toString());
                CountPoint cp = new CountPoint(10, modifiedHands);
                if (cp.checkHu()){
                    Log.e(TAG, "HU LE!");
                    Toast.makeText(getApplicationContext(), "胡!", Toast.LENGTH_LONG).show();
                    
                }else{
                    Log.e(TAG, "ZHA HU!");
                    Toast.makeText(getApplicationContext(), "诈胡！", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void spinnersInit(ArrayList<String> hands){
        spinners = new ArrayList<Spinner>();
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
        Spinner spinner4 = (Spinner) findViewById(R.id.spinner4);
        Spinner spinner5 = (Spinner) findViewById(R.id.spinner5);
        Spinner spinner6 = (Spinner) findViewById(R.id.spinner6);
        Spinner spinner7 = (Spinner) findViewById(R.id.spinner7);
        Spinner spinner8 = (Spinner) findViewById(R.id.spinner8);
        Spinner spinner9 = (Spinner) findViewById(R.id.spinner9);
        Spinner spinner10 = (Spinner) findViewById(R.id.spinner10);
        Spinner spinner11 = (Spinner) findViewById(R.id.spinner11);
        Spinner spinner12 = (Spinner) findViewById(R.id.spinner12);
        Spinner spinner13 = (Spinner) findViewById(R.id.spinner13);
        Spinner spinner14 = (Spinner) findViewById(R.id.spinner14);

        spinners.add(spinner1);
        spinners.add(spinner2);
        spinners.add(spinner3);
        spinners.add(spinner4);
        spinners.add(spinner5);
        spinners.add(spinner6);
        spinners.add(spinner7);
        spinners.add(spinner8);
        spinners.add(spinner9);
        spinners.add(spinner10);
        spinners.add(spinner11);
        spinners.add(spinner12);
        spinners.add(spinner13);
        spinners.add(spinner14);

        List<String> categories = new ArrayList<String>();
        categories.add("一万");
        categories.add("二万");
        categories.add("三万");
        categories.add("四万");
        categories.add("五万");
        categories.add("六万");
        categories.add("七万");
        categories.add("八万");
        categories.add("九万");
        categories.add("一条");
        categories.add("二条");
        categories.add("三条");
        categories.add("四条");
        categories.add("五条");
        categories.add("六条");
        categories.add("七条");
        categories.add("八条");
        categories.add("九条");
        categories.add("一筒");
        categories.add("二筒");
        categories.add("三筒");
        categories.add("四筒");
        categories.add("五筒");
        categories.add("六筒");
        categories.add("七筒");
        categories.add("八筒");
        categories.add("九筒");
        categories.add("东风");
        categories.add("西风");
        categories.add("南风");
        categories.add("北风");
        categories.add("红中");
        categories.add("发财");
        categories.add("白板");
        categories.add("未检测");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        for (Spinner spinner : spinners){
            spinner.setOnItemSelectedListener(this);
            spinner.setAdapter(dataAdapter);
            spinner.setSelection(dataAdapter.getPosition("未检测"));
        }

        for (int i=0; i< hands.size(); i++){
            spinners.get(i).setSelection(dataAdapter.getPosition(switchPaiName(hands.get(i))));
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
        if (parent.getItemAtPosition(position) == "未检测")
            ((TextView) parent.getChildAt(0)).setTextColor(Color.RED);

        // Showing selected spinner item
        //Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_SHORT).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }


    private String switchPaiName(String paiName){
        String name;
        switch (paiName){
            case "1-w": name = "一万"; break;
            case "2-w": name = "二万"; break;
            case "3-w": name = "三万"; break;
            case "4-w": name = "四万"; break;
            case "5-w": name = "五万"; break;
            case "6-w": name = "六万"; break;
            case "7-w": name = "七万"; break;
            case "8-w": name = "八万"; break;
            case "9-w": name = "九万"; break;
            case "1-t": name = "一条"; break;
            case "2-t": name = "二条"; break;
            case "3-t": name = "三条"; break;
            case "4-t": name = "四条"; break;
            case "5-t": name = "五条"; break;
            case "6-t": name = "六条"; break;
            case "7-t": name = "七条"; break;
            case "8-t": name = "八条"; break;
            case "9-t": name = "九条"; break;
            case "1-b": name = "一筒"; break;
            case "2-b": name = "二筒"; break;
            case "3-b": name = "三筒"; break;
            case "4-b": name = "四筒"; break;
            case "5-b": name = "五筒"; break;
            case "6-b": name = "六筒"; break;
            case "7-b": name = "七筒"; break;
            case "8-b": name = "八筒"; break;
            case "9-b": name = "九筒"; break;
            case "d-f": name = "东风"; break;
            case "n-f": name = "南风"; break;
            case "x-f": name = "西风"; break;
            case "b-f": name = "北风"; break;
            case "h-Z": name = "红中"; break;
            case "b-B": name = "白板"; break;
            case "f-F": name = "发财"; break;

            case "一万": name = "1-w"; break;
            case "二万": name = "2-w"; break;
            case "三万": name = "3-w"; break;
            case "四万": name = "4-w"; break;
            case "五万": name = "5-w"; break;
            case "六万": name = "6-w"; break;
            case "七万": name = "7-w"; break;
            case "八万": name = "8-w"; break;
            case "九万": name = "9-w"; break;
            case "一条": name = "1-t"; break;
            case "二条": name = "2-t"; break;
            case "三条": name = "3-t"; break;
            case "四条": name = "4-t"; break;
            case "五条": name = "5-t"; break;
            case "六条": name = "6-t"; break;
            case "七条": name = "7-t"; break;
            case "八条": name = "8-t"; break;
            case "九条": name = "9-t"; break;
            case "一筒": name = "1-b"; break;
            case "二筒": name = "2-b"; break;
            case "三筒": name = "4-b"; break;
            case "四筒": name = "4-b"; break;
            case "五筒": name = "5-b"; break;
            case "六筒": name = "6-b"; break;
            case "七筒": name = "7-b"; break;
            case "八筒": name = "8-b"; break;
            case "九筒": name = "9-b"; break;
            case "东风": name = "d-f"; break;
            case "南风": name = "n-f"; break;
            case "西风": name = "x-f"; break;
            case "北风": name = "b-f"; break;
            case "红中": name = "h-Z"; break;
            case "白板": name = "b-B"; break;
            case "发财": name = "f-F"; break;
            default:
                name = "undefine"; break;
        }
        return name;
    }
}
