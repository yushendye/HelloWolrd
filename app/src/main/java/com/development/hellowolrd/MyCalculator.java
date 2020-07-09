package com.development.hellowolrd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MyCalculator extends AppCompatActivity {
    TextView output;
    Button btn_add, btn_sub, btn_mult, btn_div, btn_mod, btn_equal;
    Button btn_dot, btn_clear, btn_neg;
    Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_0;
    ImageButton btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_calculator);


        output = findViewById(R.id.txt_output);

        btn_add = findViewById(R.id.btn_add);
        btn_sub = findViewById(R.id.btn_sub);
        btn_mult = findViewById(R.id.btn_prod);
        btn_div = findViewById(R.id.btn_devide);
        btn_mod = findViewById(R.id.btn_mod);
        btn_equal = findViewById(R.id.btn_equal);

        btn_0 = findViewById(R.id.btn_0);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);
        btn_dot = findViewById(R.id.btn_dot);
        btn_clear = findViewById(R.id.btn_clear);
        btn_back = findViewById(R.id.btn_back);
        btn_neg = findViewById(R.id.change_sign);

    }


    public String calculate(String num1, String op, String num2){
        double n1 = 0, n2 = 0;
        try {
            n1 = Double.parseDouble(num1);
            n2 = Double.parseDouble(num2);
        }catch (Exception e){
            output.setText("Invalid inputs!!");
        }
        String out = "";
        switch (op){
            case "+":
                try{out = (n1 + n2) + "";}catch (Exception e){output.setText("Can't perform addition on invalid data");}
                break;
            case "-":
                try{out = (n1 - n2) + "";}catch (Exception e){output.setText("Can't perform subtraction on invalid data");};
                break;

            case "*":
                try{out = (n1 * n2) + "";}catch (Exception e){output.setText("Can't perform multiplication on invalid data");}
                break;

            case "/":
                try{out = (n1 / n2) + "";}catch (Exception e){output.setText("Can't perform division on invalid data");}
                break;

            case "%":
                try{out = (n1 % n2) + "";}catch (Exception e){output.setText("Can't perform mod on invalid data");}
                break;
        }
        return out;
    }

    public void erase(View view){
        output.setText(back(output.getText().toString()));
    }

    public void negate(View view){
        try {
            double num = Double.parseDouble(output.getText().toString());
            num *= -1;
            output.setText(num + "");
        }catch (Exception e){
            output.setText("Only numbers can be negated");
        }
    }
    public void set(View view){

        Button clicked_btn = findViewById(view.getId());
        String txt = clicked_btn.getText().toString();

        switch (txt){
            case "0":
                output.append("0"); break;
            case "1":
                output.append("1"); break;
            case "2":
                output.append("2"); break;
            case "3":
                output.append("3"); break;
            case "4":
                output.append("4"); break;
            case "5":
                output.append("5"); break;
            case "6":
                output.append("6"); break;
            case "7":
                output.append("7"); break;
            case "8":
                output.append("8"); break;
            case "9":
                output.append("9"); break;
            case ".":
                output.append("."); break;
            case "C":
                output.setText(""); break;
            case "+":
                output.append(" + "); break;
            case "-":
                output.append(" - "); break;
            case "*":
                output.append(" * "); break;
            case "/":
                output.append(" / "); break;
            case "%":
                output.append(" % "); break;
            case "=":
                String[] eq = output.getText().toString().split(" ");
                if(eq.length == 3)
                    output.setText(calculate(eq[0], eq[1], eq[2]));
                else
                    output.setText("Invalid operations");
        }
    }
    public String back(String eq){
        int l = eq.length();
        return eq.substring(0, l - 1);
    }

}