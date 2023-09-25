package com.example.myapplication3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button1, button2, button3, button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolbar();
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button1) {
            getDialog();
        } else if (view.getId() == R.id.button2) {
            ExitDialog();
        } else if (view.getId() == R.id.button3) {
            makeBG();
        } else if (view.getId() == R.id.button4) {
            chooseOS();
        }
    }

    private void setToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Lab2 App");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setSubtitle("By M1229014");
        toolbar.setSubtitleTextColor(Color.WHITE);
        toolbar.setContentInsetStartWithNavigation(0);
    }

    private void getDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("關於");
        builder.setMessage("課程:嵌入式軟體設計\n開課單位:資訊工程學系");
        builder.setPositiveButton("確認", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    private void ExitDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("再次確認是否關閉");
        builder.setMessage("確定要結束本程式呢");
        builder.setPositiveButton("確認", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.setNegativeButton("取消", null).show();
    }

    private void makeBG() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        String[] options = {"紅色", "白色", "黑色"};
        builder.setTitle("改變背景顏色");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                ConstraintLayout layoutMain = (ConstraintLayout) findViewById(R.id.activity_main);
                switch(which){
                    case 0: layoutMain.setBackgroundColor(Color.RED);
                        break;
                    case 1: layoutMain.setBackgroundColor(Color.WHITE);
                        break;
                    case 2: layoutMain.setBackgroundColor(Color.BLACK);
                        break;
                }
            }
        });
        builder.setNegativeButton("取消", null);
        builder.create().show();
    }

    private void chooseOS() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        String[] items = {"Android", "IOS", "Windows Phone", "Firefox OS"};
        boolean[] itemsChecked = new boolean[items.length];
        builder.setTitle("選擇用過的手機作業系統");
        builder.setMultiChoiceItems(items,itemsChecked, new DialogInterface.OnMultiChoiceClickListener() {
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                Toast.makeText(MainActivity.this, items[which] + (isChecked ? " 勾選": "沒有勾選"), Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton("確認", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String msg = "";
                for (int index = 0; index < items.length; index++) {
                    if (itemsChecked[index]) {
                        msg += items[index] + "\n";
                    }
                }
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消", null);
        builder.create().show();
    }

}