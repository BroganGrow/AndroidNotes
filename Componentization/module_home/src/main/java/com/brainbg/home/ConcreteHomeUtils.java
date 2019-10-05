package com.brainbg.home;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.brainbg.libcommon.IHome;

/**
 * <pre>
 *     author : Brainbg
 *     e-mail : brainbg@foxmail.com
 *     time   : 2019/10/05
 *     desc   :
 * </pre>
 */
@Route(path = "/home/ConcreteHomeUtils")
public class ConcreteHomeUtils implements IHome {
    @Override
    public String test(String s) {
        return "home模块：测试" + s;
    }

    @Override
    public void init(Context context) {

    }
}
