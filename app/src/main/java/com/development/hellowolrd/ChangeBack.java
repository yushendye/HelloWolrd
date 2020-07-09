package com.development.hellowolrd;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class ChangeBack extends AppCompatActivity {
    RelativeLayout activity_back;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_back);
        activity_back = findViewById(R.id.activity_back);
        imageView = findViewById(R.id.back);
    }

    public void camera(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 101);
    }

    public void gallery(View view){
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, 102);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 101){

            Bitmap pic = (Bitmap)data.getExtras().get("data");
            Drawable drawable = new BitmapDrawable(getResources(), pic);
            activity_back.setBackground(drawable);
            Toast.makeText(getApplicationContext(), "done!!", Toast.LENGTH_LONG).show();
        }

        if(requestCode == 102 && resultCode == RESULT_OK && null != data){
            Toast.makeText(getApplicationContext(), "done!!", Toast.LENGTH_LONG).show();
            Uri uri = data.getData();
            Bitmap mybitmap;
            try{
                mybitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                activity_back.setBackground(new BitmapDrawable(getResources(), mybitmap));
            }catch (Exception e){}
        }
    }
}