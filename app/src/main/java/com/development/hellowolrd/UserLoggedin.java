package com.development.hellowolrd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UserLoggedin extends AppCompatActivity {
    TextView txt_username;
    TextView txt_contact;
    EditText edt_sms;

    private final int SMS_PERMISSION_CODE = 101;
    private final int CALL_PERMISSION_CODE = 102;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_loggedin);

        txt_username = findViewById(R.id.username);
        txt_contact = findViewById(R.id.contact);
        edt_sms = findViewById(R.id.message);

        Intent old = getIntent();
        String str_username = old.getStringExtra("username");
        txt_username.append(str_username);

        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.custom_toast, (ViewGroup)findViewById(R.id.custom_toast));
        TextView name = view.findViewById(R.id.toast_edt_name);
        name.setText("User " + str_username + " Logged in !!");
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(view);
        toast.show();
    }

    public void make_call(View view){
        ask_Call_Permissions();
    }

    public void sendWhatsapp(View view){
        Intent whatsAppIntent = new Intent();
        whatsAppIntent.setType("text/plain");
        whatsAppIntent.setPackage("com.whatsapp");
        whatsAppIntent.putExtra(Intent.EXTRA_TEXT, edt_sms.getText().toString().trim());
        startActivity(Intent.createChooser(whatsAppIntent, "Share using"));
    }

    public void ask_Call_Permissions(){
        if (Build.VERSION.SDK_INT > 22) {
                if(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, CALL_PERMISSION_CODE);
                }
        }
    }

    public void ask_SMS_permissions(){
        if(Build.VERSION.SDK_INT > 22){
            if(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, SMS_PERMISSION_CODE);
            }
        }
    }
    public void sendSMS(View view){
        ask_SMS_permissions();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case SMS_PERMISSION_CODE:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    SmsManager manager =SmsManager.getDefault();
                    manager.sendTextMessage("9975086979", null, edt_sms.getText().toString().trim(), null, null);
                }
                else {
                    Toast.makeText(this, "Permission to send SMS is not granted!!!", Toast.LENGTH_SHORT).show();
                }
                break;
            case CALL_PERMISSION_CODE:
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    String str = txt_contact.getText().toString();
                    String number = str.split(" ")[1];

                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number));
                    startActivity(intent);
                }
        }
    }
}