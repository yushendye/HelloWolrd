package com.development.hellowolrd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MenuDemo extends AppCompatActivity {
    ListView listView;
    ArrayAdapter<String> adapter;
    List<String> list;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_demo);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listView  = findViewById(R.id.mylist);
        init_list_view();
        registerForContextMenu(listView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.simple_menu, menu);
        return true;
    }

    public void init_list_view(){
        init_list();
        adapter = new ArrayAdapter<String>(this, R.layout.my_list_item, R.id.custom_text, list);

        listView.setAdapter(adapter);
    }
    public void init_list(){
        list = new ArrayList<>();
        list.add("9975086979");
        list.add("9004447001");
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case  R.id.ligh_dark:
                Intent intent = new Intent(MenuDemo.this, RegistrationPage.class);
                startActivity(intent);
                break;
            case R.id.calculator:
                Intent intent1 = new Intent(MenuDemo.this, MyCalculator.class);
                startActivity(intent1);
                break;
            case R.id.gallery:
                Intent intent2 = new Intent(MenuDemo.this, ChangeBack.class);
                startActivity(intent2);
                break;
            case R.id.quit:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Context Menu");
        menu.add(0, v.getId(), 0, "Call");
        menu.add(1, v.getId(), 1, "Message");
    }


}