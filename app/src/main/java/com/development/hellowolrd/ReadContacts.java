package com.development.hellowolrd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ReadContacts extends AppCompatActivity {
    List<String> contactlist;
    ListView view;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_contacts);
        view = findViewById(R.id.contact_list);
        ask_permission();
        contactlist = get_contacts();
        adapter = new ArrayAdapter<>(getApplication(), R.layout.my_list_item, R.id.custom_text, contactlist);
        view.setAdapter(adapter);
    }

    public void ask_permission(){
        if(Build.VERSION.SDK_INT > 22){
            if(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED)
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 101);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case  101:
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    contactlist = get_contacts();
                    adapter = new ArrayAdapter<>(getApplication(), R.layout.my_list_item, R.id.custom_text, contactlist);
                    view.setAdapter(adapter);
                }
        }
    }

    public List<String> get_contacts(){
        List<String> contacts = new ArrayList<>();
        Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null,null, null);
        while (phones.moveToNext())
        {
            String name=phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            contacts.add(name + " : " + phoneNumber);
        }
        phones.close();
        return contacts;
    }
}