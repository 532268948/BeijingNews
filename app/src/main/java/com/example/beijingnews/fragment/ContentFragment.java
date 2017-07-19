package com.example.beijingnews.fragment;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioGroup;

import com.example.beijingnews.R;
import com.example.beijingnews.base.BaseFragment;
import com.example.beijingnews.utils.LogUtil;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by 53226 on 2017/7/19.
 */

public class ContentFragment extends BaseFragment {

    @ViewInject(R.id.viewpager)
    private ViewPager viewPager;
    @ViewInject(R.id.rg_main)
    private RadioGroup radioGroup;
    @Override
    public View initview() {
        LogUtil.e("主页面初始化.....");
        View view =View.inflate(mContext, R.layout.content_fragment,null);
        x.view().inject(this,view);
        return view;
    }

    @Override
    public void initDate() {
        super.initDate();
        LogUtil.e("主菜单数据初始化.....");
        radioGroup.check(R.id.rb_home);
    }
}
