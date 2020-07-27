package com.development.hellowolrd;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class VideoDemo extends AppCompatActivity {
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_demo);
        videoView = findViewById(R.id.video_view);
    }

    public void ask_permission_for_video(){
        if(Build.VERSION.SDK_INT > 22){
            if(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 111);
            else
                record_video();
        }
    }

    public void start_vid(View view){
        ask_permission_for_video();
    }

    public void record_video(){
        Intent video = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if(video.resolveActivity(getPackageManager()) != null)
            startActivityForResult(video, 111);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
       if(requestCode == 111 && resultCode == RESULT_OK){
           Uri uri = data.getData();
           videoView.setVisibility(View.VISIBLE);
           videoView.setVideoURI(uri);
           videoView.start();
       }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 111:
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    record_video();
        }
    }
}