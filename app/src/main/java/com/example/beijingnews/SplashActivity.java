package com.example.beijingnews;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.beijingnews.activity.MainActivity;
import com.example.beijingnews.utils.CacheUtils;

public class SplashActivity extends Activity {
    private RelativeLayout rl_splash_root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        rl_splash_root=(RelativeLayout)findViewById(R.id.rl_splash_root);
        RotateAnimation ra=new RotateAnimation(0,360,RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);

        AlphaAnimation aa=new AlphaAnimation(0,1);

        ScaleAnimation sa=new ScaleAnimation(0,1,0,1,ScaleAnimation.RELATIVE_TO_SELF,0.5f,ScaleAnimation.RELATIVE_TO_SELF,0.5f);

        AnimationSet set=new AnimationSet(false);
        set.addAnimation(ra);
        set.addAnimation(aa);
        set.addAnimation(sa);
        set.setDuration(2000);
        set.setFillAfter(true);

        rl_splash_root.startAnimation(set);

        set.setAnimationListener(new MyAnimationListener());

    }
    class MyAnimationListener implements Animation.AnimationListener {

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            boolean isStartMain= CacheUtils.getBoolean(SplashActivity.this,GuideActivity.START_MAIN);
            if(isStartMain){
                Intent intent=new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
            }else{
                Intent intent=new Intent(SplashActivity.this,GuideActivity.class);
                startActivity(intent);
            }
            finish();
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}
