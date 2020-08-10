package com.royale.java_svetofor;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private Boolean startingStoping = false;
    private LinearLayout lin1;
    private LinearLayout lin2;
    private LinearLayout lin3;
    private Button startak;
    private Button stopak;
    private int counter;
    private Toolbar tb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lin1 = findViewById(R.id.lin1);
        lin2 = findViewById(R.id.lin2);
        lin3 = findViewById(R.id.lin3);
        startak = findViewById(R.id.button_start);
        stopak = findViewById(R.id.button_stop);
        startak.setBackgroundColor(getResources().getColor(R.color.color_green));
        stopak.setBackgroundColor(getResources().getColor(R.color.color_red));
        counter = 0;
        tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        getSupportActionBar().setTitle("Получилось");
    }


    public void startStop(View view) {
        final int id_view = view.getId();
        switch (id_view){
            case R.id.button_start:
                Log.d("startStop","Start!");
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        startingStoping = true;
                        while (startingStoping){
                            counter++;
                            switch (counter){
                                case 1:
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            getSupportActionBar().setTitle("КО");
                                            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFF09")));
                                        }
                                    });
                                    lin1.setBackgroundColor(getResources().getColor(R.color.color_red));
                                    lin2.setBackgroundColor(getResources().getColor(R.color.color_default));
                                    lin3.setBackgroundColor(getResources().getColor(R.color.color_default));
                                break;
                                case 2:

                                    runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        getSupportActionBar().setTitle("СТ");
                                        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#64F603")));
                                    }
                                });

                                    lin1.setBackgroundColor(getResources().getColor(R.color.color_default));
                                    lin2.setBackgroundColor(getResources().getColor(R.color.color_yellow));
                                    lin3.setBackgroundColor(getResources().getColor(R.color.color_default));
                                break;
                                case 3:

                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            getSupportActionBar().setTitle("ЯЯЯЯЯ");
                                            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#DD1001")));
                                        }
                                    });
                                    lin1.setBackgroundColor(getResources().getColor(R.color.color_default));
                                    lin2.setBackgroundColor(getResources().getColor(R.color.color_default));
                                    lin3.setBackgroundColor(getResources().getColor(R.color.color_green));
                                break;
                            }
                            if(counter == 3) counter = 0;
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }).start();
                break;
                case R.id.button_stop:
                    lin1.setBackgroundColor(getResources().getColor(R.color.color_default));
                    lin2.setBackgroundColor(getResources().getColor(R.color.color_default));
                    lin3.setBackgroundColor(getResources().getColor(R.color.color_default));
                    Log.d("startStop","Stop!");
                startingStoping = false;
                break;
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        startingStoping = false;
    }
}
