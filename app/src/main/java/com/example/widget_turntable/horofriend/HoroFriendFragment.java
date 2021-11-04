package com.example.widget_turntable.horofriend;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.widget_turntable.R;
import com.example.widget_turntable.databinding.FragmentHorofriendBinding;

public class HoroFriendFragment extends Fragment {

    FragmentHorofriendBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.fragment_horofriend, container, false);
        initView();
        return binding.getRoot();
    }

    private void initView() {
        binding.ivStart.setOnClickListener(new View.OnClickListener() {
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

                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(binding.ivInnerTurntable, "rotation", 0, targetNumber + 3600);
                objectAnimator.setInterpolator(new DecelerateInterpolator());
                objectAnimator.setDuration(8000);
                objectAnimator.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        getResult(targetNumber);
                        //stopMusic();
                    }
                });

                objectAnimator.start();
            }
        });
    }
    private void getResult(int targetNumber) {
        Log.d("TAG", "中獎結果" + targetNumber);
        if (targetNumber < 45) {
            Toast.makeText(getContext(), "恭喜獲得! 四等獎", Toast.LENGTH_LONG).show();
        } else if (targetNumber < 90) {
            Toast.makeText(getContext(), "恭喜獲得! 六等獎", Toast.LENGTH_LONG).show();
        } else if (targetNumber < 135) {
            Toast.makeText(getContext(), "恭喜獲得! 一等獎", Toast.LENGTH_LONG).show();
        } else if (targetNumber < 180) {
            Toast.makeText(getContext(), "恭喜獲得! 二等獎", Toast.LENGTH_LONG).show();
        } else if (targetNumber < 225) {
            Toast.makeText(getContext(), "感謝參與! 繼續加油!", Toast.LENGTH_LONG).show();
        } else if (targetNumber < 270) {
            Toast.makeText(getContext(), "恭喜獲得! 五等獎", Toast.LENGTH_LONG).show();
        } else if (targetNumber < 315) {
            Toast.makeText(getContext(), "恭喜獲得! 三等獎", Toast.LENGTH_LONG).show();
        } else if (targetNumber < 360) {
            Toast.makeText(getContext(), "恭喜獲得! 特等獎", Toast.LENGTH_LONG).show();
        }
    }
}
