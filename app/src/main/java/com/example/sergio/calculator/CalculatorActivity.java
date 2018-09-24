package com.example.sergio.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    private TextView numview;
    private String num = "";
    private String operator = "";
    private String prev_num = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
    }

    private void updateScreen(){
        numview.setText(num);
    }

    public void OnClickDigit(View view){
        if(prev_num != ""){
            updateScreen();
        }
        Button b = (Button) view;
        num += b.getText();
        updateScreen();
    }

    public void OnClickOperator(View view){
        Button b = (Button) view;
        operator = b.getText().toString();
        prev_num = num;
        num = "";
        numview.setText(num);
    }

    public void OnClickEqual(View view){
        String result = "";
        double result_num = 0;
        double num1 = Double.parseDouble(prev_num);
        double num2 = Double.parseDouble(num);
        if(operator.equals("+")){
            result_num = num1+num2;
        }
        else if(operator.equals("-")){
            result_num = num1-num2;
        }
        else if(operator.equals("*")){
            result_num = num1*num2;
        }
        else if(operator.equals("/")){
            result_num = num1/num2;
        }
        result = String.valueOf(result_num);
        prev_num = result;
        num = "";
        numview.setText(result);
    }

    public void OnClickDot(View view){
        if  (num.indexOf('.') == -1)
        {
            Button b = (Button)view;
            num += '.';
            numview.setText(num);
        }
    }

    public void onClickClear(View view)
    {
        num = "0";
        prev_num = 0;
        numview.setText("0");
    }

}
