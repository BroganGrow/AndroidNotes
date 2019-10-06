package com.brainbg.home;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;

/**
 * <pre>
 *     author : Brainbg
 *     e-mail : brainbg@foxmail.com
 *     time   : 2019/10/05
 *     desc   :
 * </pre>
 */
@Route(path = "/home/HomeActivity")
public class HomeActivity extends AppCompatActivity  {

    @Autowired
    public String key;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity_home);

//        ARouter.getInstance().inject(this);
//
//        TextView tv_content = findViewById(R.id.tv_content);
//        tv_content.setText(key);
    }
}
