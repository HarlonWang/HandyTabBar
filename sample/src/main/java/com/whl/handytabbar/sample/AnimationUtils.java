package com.whl.handytabbar.sample;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;

import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;

/**
 * Created by Administrator on 2015/2/5.
 */
public class AnimationUtils {

    public static Animation getScaleAnimation(){
        Animation scaleAnimation = new ScaleAnimation(0.1f, 1.0f,0.1f,1.0f);
        scaleAnimation.setDuration(500);
        return scaleAnimation;
    }

    public static Animation getRotateAnimation(View view){
        int height =view.getHeight()/2;
        int width=view.getWidth()/2;
        Animation rotateAnimation = new RotateAnimation(360f, 0,width,height);
        rotateAnimation.setDuration(1000);
        view.startAnimation(rotateAnimation);
        return rotateAnimation;
    }

    public static void getBounceAnimation(View view){
        AnimatorSet animatorSet=new AnimatorSet();
        animatorSet.playTogether(
                ObjectAnimator.ofFloat(view, "scaleX", 1.0f ,1.4f, 0.9f, 1.15f, 0.95f, 1.02f, 1.0f),
                ObjectAnimator.ofFloat(view,"scaleY",1.0f ,1.4f, 0.9f, 1.15f, 0.95f, 1.02f, 1.0f));
        animatorSet.setTarget(view);
        animatorSet.setDuration(1000);
        animatorSet.start();
    }
    
}
