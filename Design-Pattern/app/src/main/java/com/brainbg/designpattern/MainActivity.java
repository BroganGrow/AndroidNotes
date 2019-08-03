package com.brainbg.designpattern;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.brainbg.designpattern.simpleFactory.SimpleFactoryActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        findViewById(R.id.btn_simple_factory).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_simple_factory:
                startActivity(new Intent(mContext, SimpleFactoryActivity.class));
                break;
        }
    }
}
