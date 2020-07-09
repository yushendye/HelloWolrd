package com.development.hellowolrd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListViewDemo extends AppCompatActivity {
    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    List<String> items;
    int count = 1;

    public void initItems(){
        items = new ArrayList<>();
        items.add("Avengers");
        items.add("Avengers: Age of Ultron");
        items.add("Avengers: Infinity War");
        items.add("Avengers: End Game");
        items.add("Star Wars: Episode 4, New Hope");
        items.add("Star Wars: Episode 5, Empire Strikes Back");
        items.add("Star Wars: Episode 6, Return of the Jedi");
        items.add("Star Wars: Episode 1, Phantom Menance");
        items.add("Star Wars: Episode 2, Attack of the Clones");
        items.add("Star Wars: Episode 3, Revenge of the Sith");
    }

    public void init_list_view(){
        initItems();
        arrayAdapter = new ArrayAdapter(this, R.layout.my_list_item, R.id.custom_text, items);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_demo);

        listView = findViewById(R.id.lsv_my_list_view);
        init_list_view();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected = arrayAdapter.getItem(position);
                Toast.makeText(getApplicationContext(), "You have selected : " + selected, Toast.LENGTH_LONG).show();
                count = 0;
            }
        });
    }

    @Override
    public void onBackPressed() {
        count++;
        if(count <= 2)
            Toast.makeText(this, "Press back one more time to exit", Toast.LENGTH_SHORT).show();

        if(count > 2) {
            super.onBackPressed();
            finish();
        }
    }

    /*
    if (backPressedtime+ 2000>System.currentTimeMillis()){
        super.onBackPressed();
        finish();
    }else
        Toast.makeText(this,"Press Back again to Exit",Toast.LENGTH_LONG).show();
        backPressedtime=System.currentTimeMillis();
    }
     */
}