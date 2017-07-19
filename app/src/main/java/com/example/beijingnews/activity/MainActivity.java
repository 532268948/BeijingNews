package com.example.beijingnews.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.beijingnews.R;
import com.example.beijingnews.fragment.ContentFragment;
import com.example.beijingnews.fragment.LeftmenuFragment;
import com.example.beijingnews.utils.DensityUtil;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity {

    public static final String LEFTMENU_TAG="leftmenu_tag";
    public static final String MAIN_TAG="main_tag";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initSlidingMenu();
        initFragment();
    }

    private void initFragment() {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.fl_leftmenu,new LeftmenuFragment(), LEFTMENU_TAG);
        ft.replace(R.id.fl_contentmenu,new ContentFragment(), MAIN_TAG);
        ft.commit();

    }

    public void initSlidingMenu(){
        setContentView(R.layout.activity_main);
        setBehindContentView(R.layout.leftmenu);
        SlidingMenu slidingMenu=getSlidingMenu();
        slidingMenu.setSecondaryMenu(R.layout.rightmenu);
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        slidingMenu.setMode(SlidingMenu.LEFT);
        slidingMenu.setBehindOffset(DensityUtil.dip2px(this,200));
    }


}
