package com.brainbg.designpattern.builder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.brainbg.designpattern.R;

/**
 * <pre>
 *     author : Brainbg
 *     e-mail : brainbg@foxmail
 *     time   : 2019/08/03
 *     desc   : 建造者模式使用
 * </pre>
 */
public class BuilderActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_produceContent;
    private StringBuffer sb;
    private EditText etCpu, etMainboard, etGraphicsCard, etHardDisk;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_builder);
        setTitle("建造者模式");
        initView();

        sb = new StringBuffer();


    }

    private void initView() {
        etCpu = findViewById(R.id.et_cpu);
        etMainboard = findViewById(R.id.et_mainboard);
        etGraphicsCard = findViewById(R.id.et_graphics_card);
        etHardDisk = findViewById(R.id.et_hard_disk);

        findViewById(R.id.btn_produce_apple).setOnClickListener(this);
        findViewById(R.id.btn_clear).setOnClickListener(this);
        tv_produceContent = findViewById(R.id.tv_produce_content);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_produce_apple://组装电脑
                new PCBuilder.Builder()
                        .addCPU(etCpu.getText().toString())
                        .addMainboard(etMainboard.getText().toString())
                        .addGraphicsCard(etGraphicsCard.getText().toString())
                        .addHardDisk(etHardDisk.getText().toString())
                        .build()
                        .execute(new StringCallback() {
                            @Override
                            public void onSuccess(String result) {
                                tv_produceContent.setText(sb.append(result));
                            }

                            @Override
                            public void onError(String error) {
                                tv_produceContent.setText(sb.append(error));
                            }
                        });
                break;

            case R.id.btn_clear:
                sb.setLength(0);
                tv_produceContent.setText(sb);
                break;
        }

    }
}
