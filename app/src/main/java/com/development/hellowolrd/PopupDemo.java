package com.development.hellowolrd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;

public class PopupDemo extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_demo);

        text = findViewById(R.id.popup_txt);
    }

    public void show_popup(View view){
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.simple_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case  R.id.ligh_dark:
                Intent intent = new Intent(PopupDemo.this, RegistrationPage.class);
                startActivity(intent);
                return true;
            case R.id.calculator:
                Intent intent1 = new Intent(PopupDemo.this, MyCalculator.class);
                startActivity(intent1);
                return true;
            case R.id.gallery:
                Intent intent2 = new Intent(PopupDemo.this, ChangeBack.class);
                startActivity(intent2);
                return true;
            case R.id.quit:
                finish();
                return true;
            default:
                return false;
        }
    }
}