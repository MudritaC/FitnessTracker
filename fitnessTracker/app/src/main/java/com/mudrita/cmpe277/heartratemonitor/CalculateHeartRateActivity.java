package com.mudrita.cmpe277.heartratemonitor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static android.graphics.Color.WHITE;

public class CalculateHeartRateActivity extends AppCompatActivity {

    TextView ageText,genderText;
    private RelativeLayout rl ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_heart_rate);
        rl =(RelativeLayout)findViewById(R.id.calHR);
    }

    public void calculateHR (View view){
        Intent i = new Intent(this,HeartRateMonitor.class);
        this.startActivity(i);
//        TextView tx = new TextView(this);
//        tx.setText("Enter Age :");
//        tx.setTextColor(WHITE);
//        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
//        lp.addRule(RelativeLayout.BELOW, R.id.measurementButton);
//        lp.addRule(RelativeLayout.CENTER_HORIZONTAL);
//        tx.setLayoutParams(lp);
//        rl.addView(tx);


    }
}
