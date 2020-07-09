package com.development.hellowolrd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SpinnerDemo extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner mySpinner;
    ArrayAdapter<String> adapter;
    List<String> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_demo);

        items = new ArrayList<>();
        items.add("Badminton");
        items.add("Football");
        items.add("Cricket");
        items.add("Table Tenis");
        mySpinner = findViewById(R.id.my_spinner);
        adapter = new ArrayAdapter<>(SpinnerDemo.this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setOnItemSelectedListener(this);
        mySpinner.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),  "Selected " + items.get(position), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(getApplicationContext(),  "Nothing Selected!!", Toast.LENGTH_LONG).show();
    }
}