package jp.techacademy.hanai.hideo.calcapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DispAnsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disp_ans);

        Intent intent = getIntent();
        String value1 = intent.getStringExtra("Ans");
//        int value2 = intent.getIntExtra("VALUE2", 0);

        TextView textView = (TextView) findViewById(R.id.textView);
//        textView.setText(String.valueOf(value1 + value2));
        textView.setText(value1);
    }
}