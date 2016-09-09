package com.dongz.dropdownwarning;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by DongZ on 2016/9/8.
 */
public class DropDownWarning extends LinearLayout {
    private String TAG = "DropDownWarning";
    private TextView textView;
    private String warningMessage;
    private int backgroundColor, foregroundColor;
    private ObjectAnimator fadeIn, fadeOut;
    private ViewGroup parent;
    private int height;
    private Interpolator interpolatorIn, interpolatorOut;
    private int animationLength;
    private int standingTime;
    boolean isVisible = false;


    public static class Builder {
        private Interpolator interpolatorIn, interpolatorOut;
        private int animationLength;
        private int standingTime;
        private int height;
        private String warningMessage;
        private Context context;
        private ViewGroup parent;
        private int backgroundColor, foregroundColor;


        public Builder(Context context, ViewGroup parent) {
            this.context = context;
            this.parent = parent;
            warningMessage = "My Message";
            height = 80;
            animationLength = 500;
            standingTime = 1000;
            interpolatorIn = new AccelerateInterpolator();
            interpolatorOut = new AccelerateInterpolator();
            backgroundColor = 0xfffe1b1b;
            foregroundColor = 0xff000000;
        }


        public Builder interpolatorIn(Interpolator interpolator) {
            this.interpolatorIn = interpolator;
            return this;
        }

        public Builder interpolatorOut(Interpolator interpolator) {
            this.interpolatorOut = interpolator;
            return this;
        }

        public Builder standingTime(int time) {
            this.standingTime = time;
            return this;
        }
        public Builder animationLength(int length) {
            this.animationLength = length;
            return this;
        }

        public Builder textHeight(int height) {
            this.height = height;
            return this;
        }

        public Builder message(String message) {
            this.warningMessage = message;
            return this;
        }

        public Builder foregroundColor(int color) {
            this.foregroundColor = color;
            return this;
        }

        public Builder backgroundColor(int color) {
            this.backgroundColor = color;
            return this;
        }

        public DropDownWarning build() {
            return new DropDownWarning(this);
        }

    }

    public DropDownWarning(Builder builder) {
        super(builder.context);

        warningMessage = builder.warningMessage;
        backgroundColor = builder.backgroundColor;
        foregroundColor = builder.foregroundColor;
        height = builder.height;
        interpolatorIn = builder.interpolatorIn;
        interpolatorOut = builder.interpolatorOut;
        animationLength = builder.animationLength;
        standingTime = builder.standingTime;
        parent = builder.parent;


        addWarningView();
        setUpLayoutParams();
        initializeAnimation();
    }


    private void addWarningView() {
        textView = new TextView(getContext());
        textView.setText(warningMessage);
        textView.setBackgroundColor(backgroundColor);
        textView.setGravity(Gravity.CENTER);
        textView.setPadding(0, 12, 0, 12);
        textView.setVisibility(INVISIBLE);
        textView.setTextColor(foregroundColor);
        LayoutParams l = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height);
        textView.setLayoutParams(l);
        addView(textView);
    }

    private void setUpLayoutParams() {
        LayoutParams l = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        setLayoutParams(l);
        parent.addView(this);
    }

    private void initializeAnimation() {

        fadeIn = ObjectAnimator.ofFloat(textView, "y", -height, 0);
        fadeIn.setDuration(animationLength);
        fadeOut = ObjectAnimator.ofFloat(textView, "y", 0, -height);
        fadeOut.setDuration(animationLength);


        fadeIn.addListener(onFadeInListener);
        fadeOut.addListener(onFadeOutListener);
        if (interpolatorIn != null) {
            fadeIn.setInterpolator(interpolatorIn);
        }

        if (interpolatorOut != null) {
            fadeOut.setInterpolator(interpolatorOut);
        }
    }

     /**
     * Starts fade in animation and shows text view
     */

    public void show() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(fadeIn,fadeOut);
        animatorSet.play(fadeOut).after(standingTime);
        animatorSet.play(fadeIn);
        animatorSet.start();
    }

    Animator.AnimatorListener onFadeInListener = new Animator.AnimatorListener() {
        @Override
        public void onAnimationStart(Animator animation) {
            textView.setVisibility(VISIBLE);
        }

        @Override
        public void onAnimationEnd(Animator animation) {

        }

        @Override
        public void onAnimationCancel(Animator animation) {

        }

        @Override
        public void onAnimationRepeat(Animator animation) {

        }
    };


    private Animator.AnimatorListener onFadeOutListener = new Animator.AnimatorListener() {
        @Override
        public void onAnimationStart(Animator animation) {
        }

        @Override
        public void onAnimationEnd(Animator animation) {
            textView.setVisibility(GONE);
        }

        @Override
        public void onAnimationCancel(Animator animation) {

        }

        @Override
        public void onAnimationRepeat(Animator animation) {

        }
    };
}

