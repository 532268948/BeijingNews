package com.example.beijingnews.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.beijingnews.GuideActivity;

/**
 * Created by 53226 on 2017/4/27.
 */

public class CacheUtils {
    public static void putBoolean(Context context, String key, boolean values) {
        SharedPreferences sp=context.getSharedPreferences("atguigu",Context.MODE_PRIVATE);
        sp.edit().putBoolean(key,values).commit();
    }
    public static boolean getBoolean(Context context,String key){
        SharedPreferences sp=context.getSharedPreferences("atguigu",Context.MODE_PRIVATE);
        return sp.getBoolean(key,false);
    }
}
