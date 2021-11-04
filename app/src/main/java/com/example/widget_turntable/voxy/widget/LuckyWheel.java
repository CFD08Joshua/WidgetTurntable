package com.example.widget_turntable.voxy.widget;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import com.example.widget_turntable.R;
import com.example.widget_turntable.databinding.LayoutLuckyWheelBinding;

public class LuckyWheel extends FrameLayout {

    Button btnStart;
    ImageView ivLuckyWheel;
    ImageView ivWheelBackground;
    private OnResultListener onResultListener;

    private LayoutLuckyWheelBinding binding;

    public LuckyWheel(@NonNull Context context) {
        this(context, null);
    }

    public LuckyWheel(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
//        btnStart = new Button(context);
//        LayoutParams btnStartLp = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        btnStartLp.gravity = Gravity.CENTER;
//        btnStart.setLayoutParams(btnStartLp);
//        btnStart.setBackground(ContextCompat.getDrawable(context, R.mipmap.ic_lucky_wheel_point));
//        btnStart.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int temp = (int) (Math.random() * 360);
//                if (temp % 45 == 0) {
//                    //自訂義偏移量
//                    temp += 5;
//                }
//
//                Log.d("TAG", "目標旋轉角度 :" + temp + "度");
//                //showToast("目標旋轉角度 :" + temp + "度");
//                final int targetNumber = temp;
//
//                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(ivLuckyWheel, "rotation", 0, targetNumber + 3600);
//                objectAnimator.setInterpolator(new DecelerateInterpolator());
//                objectAnimator.setDuration(8000);
//                objectAnimator.addListener(new AnimatorListenerAdapter() {
//                    @Override
//                    public void onAnimationEnd(Animator animation) {
//                        super.onAnimationEnd(animation);
////                        getResult(targetNumber);
//                        //stopMusic();
//                        Toast.makeText(context, "dddddddd", Toast.LENGTH_LONG).show();
//                    }
//                });
//
//                objectAnimator.start();
//            }
//        });
//        ivLuckyWheel = new ImageView(context);
//        LayoutParams luckyWheelLp = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        luckyWheelLp.gravity = Gravity.CENTER;
//        ivLuckyWheel.setLayoutParams(luckyWheelLp);
//        ivLuckyWheel.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_turntable));
//
//        ivWheelBackground = new ImageView(context);
//        LayoutParams lpWheelBackground = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        lpWheelBackground.gravity = Gravity.CENTER;
//        ivWheelBackground.setLayoutParams(lpWheelBackground);
//        ivWheelBackground.setImageDrawable(ContextCompat.getDrawable(context, R.mipmap.ic_lucky_wheel_bg));
//
//        addView(btnStart);
//        addView(ivLuckyWheel);
//        addView(ivWheelBackground);


        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.layout_lucky_wheel, this, false);
        binding.icLuckyWheelNode.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = (int) (Math.random() * 360);
                if (temp % 45 == 0) {
                    //自訂義偏移量
                    temp += 5;
                }

                Log.d("TAG", "目標旋轉角度 :" + temp + "度");
                //showToast("目標旋轉角度 :" + temp + "度");
                final int targetNumber = temp;

                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(binding.icLuckyWheel, "rotation", 0, targetNumber + 3600);
                objectAnimator.setInterpolator(new DecelerateInterpolator());
                objectAnimator.setDuration(8000);
                objectAnimator.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
//                        getResult(targetNumber);
                        //stopMusic();
                        Toast.makeText(context, "dddddddd", Toast.LENGTH_LONG).show();
                    }
                });

                objectAnimator.start();
            }
        });
        binding.icLuckyWheel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "dddddddd", Toast.LENGTH_LONG).show();
            }
        });
        addView(binding.getRoot());
    }

    public interface OnResultListener {

        void onResult();
    }
}
