package com.brainbg.ndkfirst;

import android.util.Log;

/**
 * <pre>
 *     author : Brainbg
 *     e-mail : brainbg@foxmail
 *     time   : 2019/06/19
 *     desc   :
 * </pre>
 */
public class NDKUtils {
    public static final String TAG = NDKUtils.class.getSimpleName();

    static {
        try {
            System.loadLibrary("first-jni");  //加载so库
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            Log.e(TAG,"loadLibrary fail !");
        }
    }

    public static native String getStringFromJNI();
}
