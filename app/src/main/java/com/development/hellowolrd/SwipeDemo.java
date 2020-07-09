package com.development.hellowolrd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SwipeDemo extends AppCompatActivity {
    SwipeRefreshLayout swipeRefreshLayout;
    TextView internet_state;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_demo);

        swipeRefreshLayout = findViewById(R.id.swipelayout);
        internet_state = findViewById(R.id.internet_state);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if(is_connected()) {
                    internet_state.setText("Internet Connected!!");
                    internet_state.setTextColor(Color.GREEN);
                    swipeRefreshLayout.setRefreshing(false);
                }else {
                    internet_state.setText("Internet Not Connected!!");
                    internet_state.setTextColor(Color.RED);
                }
            }
        });
    }

    public boolean is_connected(){
        boolean state = false;

        try{
            ConnectivityManager manager = (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = manager.getActiveNetworkInfo();
            state = info != null && info.isAvailable() && info.isConnected();
            return state;
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "Connection Errror!!", Toast.LENGTH_LONG).show();
        }
        return state;
    }
}