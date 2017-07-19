package com.example.beijingnews.fragment;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.beijingnews.base.BaseFragment;
import com.example.beijingnews.utils.LogUtil;

/**
 * Created by 53226 on 2017/7/19.
 */

public class LeftmenuFragment extends BaseFragment{
    private TextView textView;

    @Override
    public View initview() {
        LogUtil.e("左侧菜单页面初始化.....");
        textView=new TextView(mContext);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(25);
        textView.setTextColor(Color.RED);
        return textView;
    }

    @Override
    public void initDate() {
        super.initDate();
        LogUtil.e("左侧菜单数据初始化.....");
        textView.setText("我是左侧菜单游戏");
    }
}
