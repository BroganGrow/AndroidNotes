package com.brainbg.learngraphics.act;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.brainbg.learngraphics.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_paint).setOnClickListener(this);
        findViewById(R.id.btn_canvas).setOnClickListener(this);
        findViewById(R.id.btn_path).setOnClickListener(this);
        findViewById(R.id.btn_text).setOnClickListener(this);
        findViewById(R.id.btn_rect).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_paint:
                startActivity(new Intent(MainActivity.this, PaintActivity.class));
                break;
            case R.id.btn_canvas:
                startActivity(new Intent(MainActivity.this, CanvasActivity.class));
                break;
            case R.id.btn_path:
                startActivity(new Intent(MainActivity.this, PathActivity.class));
                break;
            case R.id.btn_text:

                startActivity(new Intent(MainActivity.this, TextActivity.class));
                break;
            case R.id.btn_rect:
                break;
        }

    }
}
