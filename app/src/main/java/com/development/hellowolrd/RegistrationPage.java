package com.development.hellowolrd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RegistrationPage extends AppCompatActivity {
    RelativeLayout relativeLayout;
    EditText edt_fname, edt_lname, edt_dob, edt_password, edt_cnf_password;
    RadioGroup rg_gender, rg_style;
    RadioButton rb_gender, rb_style, male, female, light, dark;
    CheckBox java, ml, python, ai;
    TextView prompt_gender, prompt_style, prompt_courses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);

        relativeLayout = findViewById(R.id.relative);

        edt_fname = findViewById(R.id.edt_f_name);
        edt_lname = findViewById(R.id.edt_l_name);
        edt_dob = findViewById(R.id.edt_dob);
        edt_password = findViewById(R.id.edt_password);
        edt_cnf_password = findViewById(R.id.edt_cnf_password);

        rg_gender = findViewById(R.id.rg_gender);
        rg_style = findViewById(R.id.rg_theme);

        java = findViewById(R.id.chk_java);
        python = findViewById(R.id.chk_python);
        ml = findViewById(R.id.chk_ml);
        ai = findViewById(R.id.chk_ai);

        male = findViewById(R.id.rb_male);
        female = findViewById(R.id.rb_female);

        dark = findViewById(R.id.rb_gray);
        light = findViewById(R.id.rb_light);

        prompt_courses = findViewById(R.id.prompt_courses);
        prompt_gender = findViewById(R.id.prompt_gender);
        prompt_style = findViewById(R.id.prompt_style);


        rg_gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb_gender = findViewById(checkedId);
            }
        });

        rg_style.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb_style = findViewById(checkedId);
                switch (checkedId){
                    case R.id.rb_light:
                        relativeLayout.setBackgroundResource(R.drawable.light_back);
                        invert(Color.BLACK);
                        break;
                    case R.id.rb_gray:
                        relativeLayout.setBackgroundResource(R.drawable.gray_back);
                        invert(Color.WHITE);
                }
            }
        });
    }

    public void open_site(View view){
        /*
        Intent intent= new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("https://www.google.com/"));
        Intent chooser= Intent.createChooser(intent,"Open website using...");
        if(intent.resolveActivity(getPackageManager())!=null);
        startActivity(chooser);
         */
        Uri webpage = Uri.parse("https://www.google.com");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(webIntent);
    }


    public void register(View view){
        List<String> courses = new ArrayList<>();
        String name = "Name " + edt_fname.getText().toString() + " " + edt_lname.getText().toString();
        String dob = "\nDate of Birth : " + edt_dob.getText().toString();
        String gen = "\nGender : " + rb_gender.getText().toString();


        if(java.isChecked())
            courses.add("Java");
        if(python.isChecked())
            courses.add("Python");
        if(ai.isChecked())
            courses.add("Artificial Intelligence");
        if(ml.isChecked())
            courses.add("Machine Learning");

        String op = name + dob + gen;
        Toast.makeText(getApplicationContext(), op, Toast.LENGTH_LONG).show();

        Toast.makeText(getApplicationContext(), "\nSubjects selected are : ", Toast.LENGTH_LONG).show();
        for (int i = 0; i < courses.size(); i++)
            Toast.makeText(this, (i + 1) + " : " + courses.get(i), Toast.LENGTH_LONG).show();
    }

    void invert(int color){
        prompt_style.setTextColor(color);
        prompt_gender.setTextColor(color);
        prompt_courses.setTextColor(color);

        male.setTextColor(color);
        female.setTextColor(color);
        dark.setTextColor(color);
        light.setTextColor(color);

        java.setTextColor(color);
        python.setTextColor(color);
        ai.setTextColor(color);
        ml.setTextColor(color);

        edt_fname.setHintTextColor(color);
        edt_fname.setTextColor(color);

        edt_lname.setHintTextColor(color);
        edt_lname.setTextColor(color);

        edt_dob.setHintTextColor(color);
        edt_dob.setTextColor(color);

        edt_password.setHintTextColor(color);
        edt_password.setTextColor(color);

        edt_cnf_password.setHintTextColor(color);
        edt_cnf_password.setTextColor(color);
    }
}