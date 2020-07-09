package com.development.hellowolrd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        print_toast("onCreate method called!!");
    }

    @Override
    protected void onStart() {
        super.onStart();
        print_toast("onStart called!!");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        print_toast("onRestart called!!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        print_toast("onPause called!!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        print_toast("onResume called!!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        print_toast("onStop called!!");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        print_toast("onDestroy called!!");
    }

    public void print_toast(String string){
        Toast.makeText(getApplicationContext(), string, Toast.LENGTH_LONG).show();
    }
}