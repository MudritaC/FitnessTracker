package com.mudrita.cmpe277.heartratemonitor;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.BLUE;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;
import static android.graphics.Color.YELLOW;

public class HomeActivity extends AppCompatActivity {

    EditText height,weight;
    Spinner heightUnit,weightUnit;
    TextView bmiText,bmiCategory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        height = (EditText)findViewById(R.id.heightEditText);
        weight =(EditText)findViewById(R.id.weightEditText);
        heightUnit =(Spinner)findViewById(R.id.heightSpinner);
        weightUnit =(Spinner)findViewById(R.id.weightSpinner);
        bmiText = (TextView) findViewById(R.id.bmiText);
        bmiCategory = (TextView) findViewById(R.id.bmiCategory);
    }

    public  void calculateBMI(View view){
        double h = Double.parseDouble(height.getText().toString());
        double w = Double.parseDouble(weight.getText().toString());
        String hu=heightUnit.getSelectedItem().toString();
        String wu = weightUnit.getSelectedItem().toString();
        if(hu.equals("inches")){
            h=h*0.0254;
        }
        if(wu.equals("lb")) {
            w = w * 0.453592;
        }
        double bmi =w/(h*h);
        DecimalFormat f = new DecimalFormat("##.00");
        float bmirounded=Float.parseFloat(f.format(bmi));

        getBMICategory(bmirounded);


    }

    public void calculateHeartRate(View view){
        Intent i = new Intent(this,CalculateHeartRateActivity.class);
        this.startActivity(i);
    }

    public void calculatesteps(View view){
        Intent i = new Intent(this,PedometerActivity.class);
        this.startActivity(i);
    }

    private void getBMICategory(float bmirounded){
        String category="";
        int color =Color.BLACK;
        if(bmirounded <15){
            category="Very severely underweight";
            color=BLUE;

        }
        else if(bmirounded >=15 && bmirounded <16){
            category="Severely underweight";
            color=BLUE;

        }
        else if(bmirounded >=16 && bmirounded <18.5){
            category="Underweight";
            color=BLUE;

        }
        else if(bmirounded >=18.5 && bmirounded <25){
            category="Normal (healthy weight)";
            color=GREEN;

        }
        else if(bmirounded >=25 && bmirounded <30){
            category="Overweight";
            color=YELLOW;

        }
        else if(bmirounded >=30 && bmirounded <35){
            category="Moderately obese";
            color=YELLOW;

        }
        else if(bmirounded >=35 && bmirounded <40){
            category="Severely obese !";
            color=R.color.myred;

        }
        else if(bmirounded >=40){
            category="Very severely obese !!";
            color=R.color.myred;

        }
        bmiText.setTextColor(color);
        bmiCategory.setTextColor(color);
        bmiText.setText("Your BMI is: "+bmirounded);
        bmiCategory.setText(category);

    }



}
