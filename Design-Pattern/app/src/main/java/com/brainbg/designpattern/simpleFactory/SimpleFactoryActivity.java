package com.brainbg.designpattern.simpleFactory;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.brainbg.designpattern.R;

/**
 * <pre>
 *     author : Brainbg
 *     e-mail : brainbg@foxmail
 *     time   : 2019/08/03
 *     desc   : 简单工厂模式使用
 * </pre>
 */
public class SimpleFactoryActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_produceContent;
    private StringBuffer sb;
    private DataLine appleProduct, androidProduct;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_factory);
        setTitle("简单工厂模式");
        initView();

        appleProduct = DataLineFactory.product(DataLineFactory.APPLE);
        androidProduct = DataLineFactory.product(DataLineFactory.ANDROID);
        sb = new StringBuffer();
    }

    private void initView() {
        findViewById(R.id.btn_produce_apple).setOnClickListener(this);
        findViewById(R.id.btn_produce_android).setOnClickListener(this);

        tv_produceContent = findViewById(R.id.tv_produce_content);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_produce_apple://生产苹果数据线
                tv_produceContent.setText(sb.append(appleProduct.produce()));
                break;
            case R.id.btn_produce_android://生产安卓数据线
                tv_produceContent.setText(sb.append(androidProduct.produce()));
                break;
        }

    }
}
