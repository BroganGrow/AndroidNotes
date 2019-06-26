//
// Created by Brainbg on 2019/6/20.
//

#include <jni.h>
#include "com_brainbg_ndkfirst_JNIUtils.h"

JNIEXPORT jstring JNICALL
Java_com_brainbg_ndkfirst_JNIUtils_getDataFromCPP(JNIEnv *env, jclass jclass) {
    return env->NewStringUTF("This is my first jni from C++!");
}