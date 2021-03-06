package com.example.widget_turntable.voxy;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.widget_turntable.R;
import com.example.widget_turntable.databinding.FragmentVoxyBinding;

import java.util.Random;

public class VoxyFragment extends Fragment {
    private Animation mStartAnimation;
    private Animation mEndAnimation;
    private boolean isRunning;
    private int mPrizeGrade = 6; //奖品级别，0代表没有
    private int mItemCount = 3;
    private int[] mPrizePosition = {0, 4, 2, 1, 5, 3}; //奖品在转盘中的位置(到达一等奖的距离)

    FragmentVoxyBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.fragment_voxy, container, false);
//        initViewLwang057LuckyTurnTable();
        return binding.getRoot();
    }



//    private void initViewLwang057LuckyTurnTable() {
//        binding.idStartBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (!isRunning) {
//
//                    isRunning = true;
//                    mStartAnimation.reset();
//                    binding.idLuckyTurntable.startAnimation(mStartAnimation);
//
//                    if (mEndAnimation != null) {
//                        mEndAnimation.cancel();
//                    }
//
//                    new Handler().postDelayed(new Runnable() {
//
//                        @Override
//                        public void run() {
//                            endAnimation();
//                        }
//                    }, 2000);
//                }
//            }
//        });
//        mStartAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.rotate_anim);
//        mStartAnimation.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//            }
//        });
//    }
//
//    // 结束动画，慢慢停止转动，抽中的奖品定格在指针指向的位置
//    private void endAnimation() {
//
//        int position = mPrizePosition[mPrizeGrade - 1];
//        float toDegreeMin = 360 / mItemCount * (position - 0.5f) + 1;
//        Random random = new Random();
//        int randomInt = random.nextInt(360 / mItemCount - 1);
//        float toDegree = toDegreeMin + randomInt + 360 * 5; //5周 + 偏移量
//
//        // 按中心点旋转 toDegree度
//        // 参数：旋转的开始角度、旋转的结束角度、X轴的伸缩模式、X坐标的伸缩值、Y轴的伸缩模式、Y坐标的伸缩值
//        mEndAnimation = new RotateAnimation(0, toDegreeMin, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//        mEndAnimation.setDuration(3000); // 设置旋转时间
//        mEndAnimation.setRepeatCount(0); // 设置重复次数
//        mEndAnimation.setFillAfter(true);// 动画执行完后是否停留在执行完的状态
//        mEndAnimation.setInterpolator(new DecelerateInterpolator()); // 动画播放的速度
//        mEndAnimation.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                isRunning = false;
//                Toast.makeText(getContext(), "富光350ml水杯", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//
//            }
//        });
//        binding.idLuckyTurntable.startAnimation(mEndAnimation);
//        mStartAnimation.cancel();
//    }
//
//
//    //停止动画（异常情况，没有奖品）
//    private void stopAnimation() {
//
//        //转盘停止回到初始状态
//        if (isRunning) {
//
//            mStartAnimation.cancel();
//            binding.idLuckyTurntable.clearAnimation();
//            isRunning = false;
//        }
//    }
}
