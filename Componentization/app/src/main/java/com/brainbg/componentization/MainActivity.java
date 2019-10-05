package com.brainbg.componentization;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.launcher.ARouter;
import com.brainbg.libcommon.IHome;

public class MainActivity extends AppCompatActivity {

    @Autowired(name = "/home/ConcreteHomeUtils")
    IHome home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ARouter.getInstance().inject(this);

        findViewById(R.id.btn_go).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1. 应用内简单的跳转(通过URL跳转在'进阶用法'中)
//                ARouter.getInstance().build("/home/HomeActivity").navigation();

                // 2. 跳转并携带参数
//                ARouter.getInstance().build("/home/HomeActivity")
//                        .withString("key", "888")
//                        .navigation();
                Toast.makeText(MainActivity.this, home.test("主页操作"), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
