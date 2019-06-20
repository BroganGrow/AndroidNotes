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
public class JNIUtils {
    public static final String TAG = JNIUtils.class.getSimpleName();

    static {
        try {
            System.loadLibrary("first-jni");  //加载so库
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            Log.e(TAG, "loadLibrary fail !");
        }
    }

    /**
     * 通过JNI从C中获取数据
     *
     * @return String
     */
    public static native String getDataFromC();

    /**
     * 通过JNI从C++中获取数据
     *
     * @return String
     */
    public static native String getDataFromCPP();
}
