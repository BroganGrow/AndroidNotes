package com.brainbg.ndkfirst;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tvC = findViewById(R.id.tv_c);
        TextView tvCPP = findViewById(R.id.tv_cpp);
        tvC.setText(JNIUtils.getDataFromC());
        tvCPP.setText(JNIUtils.getDataFromCPP());
    }
}