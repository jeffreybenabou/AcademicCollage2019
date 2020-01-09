package com.jeffrey.academiccollage.advancePrograming;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;

import com.jeffrey.academiccollage.BasicActivity;
import com.jeffrey.academiccollage.R;

public class AnimationExample extends BasicActivity {

    private  boolean isPressed=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_example);

    }



    public void setTheButtonsLiseners(View view) {

        ObjectAnimator animation;
        isPressed=!isPressed;
        switch(view.getId()){
            case R.id.animation_all_diraction:
                animation = ObjectAnimator.ofFloat(view,  isPressed?"translationX":"translationY", 0f,100f, 0f);
                animation.setDuration(3000);
                animation.setRepeatCount(ObjectAnimator.INFINITE);

                animation.start();

                break;
            case R.id.animation_left_to_right:
                animation = ObjectAnimator.ofFloat(view,  "translationX", 0f, 100f,0f);
                animation.setDuration(3000);
                animation.setRepeatCount(ObjectAnimator.INFINITE);

                animation.start();
                break;
            case R.id.animation_zoom:
                ObjectAnimator scaleX = ObjectAnimator.ofFloat(view, "scaleX", 1f,2f,1f);
                scaleX.setDuration(2000);
                scaleX.setRepeatCount(ObjectAnimator.INFINITE);
                ObjectAnimator scaleY = ObjectAnimator.ofFloat(view, "scaleY", 1f,2f,1f);
                scaleY.setDuration(2000);
                scaleY.setRepeatCount(ObjectAnimator.INFINITE);
                AnimatorSet animSetScale = new AnimatorSet();
                animSetScale.playTogether(scaleX, scaleY);
                animSetScale.start();

                break;
            case R.id.animation_top_to_bottom:
                animation = ObjectAnimator.ofFloat(view,  "translationY", 0f,100f, 0f);
                animation.setDuration(3000);
                animation.setRepeatCount(ObjectAnimator.INFINITE);

                animation.start();
                break;
            case R.id.animation_fadein:
                animation = ObjectAnimator.ofFloat(view,  "alpha", 1f, 0f,1f);
                animation.setDuration(3000);
                animation.setRepeatCount(ObjectAnimator.INFINITE);

                animation.start();
                break;

            case R.id.animation_rotate:
                animation = ObjectAnimator.ofFloat(view,  "rotation", 0f, 360f,0f);
                animation.setDuration(10000);
                animation.setRepeatCount(ObjectAnimator.INFINITE);

                animation.start();
                break;
            case R.id.animation_error:
                animation = ObjectAnimator.ofFloat(view,  "rotation", 0f, 10f,0f);
                animation.setDuration(100);
                animation.setRepeatCount(1);

                animation.start();
                break;
            case R.id.animation_all_animation:
                ObjectAnimator animX = ObjectAnimator.ofFloat(view, "translationX", 0f,200f,0f);
                animX.setDuration(2000);
                animX.setRepeatCount(ObjectAnimator.INFINITE);
                ObjectAnimator animY = ObjectAnimator.ofFloat(view, "translationY", 0f,200f,0f);
                animY.setDuration(2000);
                animY.setRepeatCount(ObjectAnimator.INFINITE);
                ObjectAnimator rotate = ObjectAnimator.ofFloat(view, "rotation", 0f, 360f,0f);
                rotate.setDuration(10000);
                rotate.setRepeatCount(ObjectAnimator.INFINITE);
                AnimatorSet animSetXY = new AnimatorSet();
                animSetXY.playTogether(animX, animY,rotate);
                animSetXY.start();
                break;
        }


    }
}
