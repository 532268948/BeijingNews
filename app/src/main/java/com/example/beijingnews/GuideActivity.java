package com.example.beijingnews;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.constraint.solver.ArrayLinkedVariables;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.beijingnews.activity.MainActivity;
import com.example.beijingnews.utils.CacheUtils;
import com.example.beijingnews.utils.DensityUtil;

import java.util.ArrayList;

public class GuideActivity extends Activity implements View.OnClickListener{
    public static final String START_MAIN="start_main";
    private ViewPager viewPager;
    private Button btnStartMain;
    private LinearLayout llPointGroup;
    private ImageView ivRedPoint;
    private int marginLeft;
    private ArrayList<ImageView> imageViews;
    private int widthDpi;

    private void findViews(){
        viewPager=(ViewPager)findViewById(R.id.viewpager);
        btnStartMain=(Button)findViewById(R.id.btn_start_main);
        llPointGroup=(LinearLayout)findViewById(R.id.ll_point_group);
        ivRedPoint=(ImageView)findViewById(R.id.iv_red_point);
        btnStartMain.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==btnStartMain){
            CacheUtils.putBoolean(this,START_MAIN,true);
            Intent intent=new Intent(GuideActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        findViews();
        initDate();
        ivRedPoint.getViewTreeObserver().addOnGlobalLayoutListener(new MyOnGlobalayoutListener());
        viewPager.addOnPageChangeListener(new MyOnPageChangeListener());
    }
    class MyOnPageChangeListener implements ViewPager.OnPageChangeListener{

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            float leftMargin=(position+positionOffset)*marginLeft;
            RelativeLayout.LayoutParams params=(RelativeLayout.LayoutParams)ivRedPoint.getLayoutParams();
            params.leftMargin=(int)leftMargin;
            ivRedPoint.setLayoutParams(params);
        }

        @Override
        public void onPageSelected(int position) {
            if(position==imageViews.size()-1){
                btnStartMain.setVisibility(View.VISIBLE);
            }else{
                btnStartMain.setVisibility(View.GONE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
    class MyOnGlobalayoutListener implements ViewTreeObserver.OnGlobalLayoutListener{
        @Override
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                ivRedPoint.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
            marginLeft=llPointGroup.getChildAt(1).getLeft()-llPointGroup.getChildAt(0).getLeft();
        }
    }
    private void initDate(){
        widthDpi = DensityUtil.dip2px(this,10);
        int [] ids=new int[]{R.drawable.guide_1,R.drawable.guide_2,R.drawable.guide_3};
        imageViews=new ArrayList<>();
        for(int i=0;i<ids.length;i++){
            ImageView imageview =new ImageView(this);
            imageview.setBackgroundResource(ids[i]);
            imageViews.add(imageview);
            ImageView point=new ImageView(this);
            point.setBackgroundResource(R.drawable.point_normal);
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(widthDpi,widthDpi);
            if(i!=0){
                params.leftMargin=widthDpi;
            }
            point.setLayoutParams(params);
            llPointGroup.addView(point);
        }
        viewPager.setAdapter(new MyPagerAdapter());
    }
    class MyPagerAdapter extends PagerAdapter{
        @Override
        public int getCount() {
            return imageViews.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView=imageViews.get(position);
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }
    }
}
