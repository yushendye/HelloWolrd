package com.development.hellowolrd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class ProgressBarDemo extends AppCompatActivity{
    ProgressBar progressBar;
    TextView load_percent;
    Handler handler = new Handler();
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar_demo);

        progressBar = findViewById(R.id.progressbar);
        load_percent = findViewById(R.id.txt_percent);

        count = progressBar.getProgress();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100){
                    count++;

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(count);
                            load_percent.setText(count + "% completed!!");
                        }
                    });

                    try {
                        Thread.sleep(100);
                    }catch (InterruptedException e){}
                }
            }
        }).start();
    }
}