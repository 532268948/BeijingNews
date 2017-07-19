package com.example.beijingnews;

import android.app.Application;

import org.xutils.x;

/**
 * Created by 53226 on 2017/7/19.
 */

public class BeijingNewsApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(true);
    }
}
