//
// Created by Brainbg on 2019/6/19.
//

#include <jni.h>
#include "com_brainbg_ndkfirst_NDKUtils.h"
 JNIEXPORT jstring JNICALL
 Java_com_brainbg_ndkfirst_NDKUtils_getStringFromJNI(JNIEnv* env, jobject obj) {
     return (*env)->NewStringUTF(env,"This is my first jni!");
 }