package com.example.widget_turntable.wangchengmeng_lotteryturntable;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.widget_turntable.R;
import com.example.widget_turntable.databinding.FragmentLotteryturntableBinding;
import com.example.widget_turntable.wangchengmeng_lotteryturntable.view.LuckSpan;

public class WangchengmengLotteryTurntableFragment extends Fragment implements View.OnClickListener {

    FragmentLotteryturntableBinding binding;
    /**
     * 默认为false避免还没点击开始转动就会提示
     */
    private boolean isClickStart;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.fragment_lotteryturntable, container, false);
        initView();
        return binding.getRoot();
    }

    private void initView() {
        binding.ivStart.setOnClickListener(this);
        binding.lsLucky.setOnSpanRollListener(new LuckSpan.SpanRollListener() {
            @Override
            public void onSpanRollListener(double speed) {
                if (0 == speed) {
                    //已经停止下来了 提示中奖名并释放按钮
                    binding.ivStart.setEnabled(true);
                    if (isClickStart) {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getContext(), "恭喜你中奖了", Toast.LENGTH_SHORT).show();
                                isClickStart = false;
                            }
                        });
                    }
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_start:
                binding.ivStart.setEnabled(false);
                isClickStart = true;
                //传入的参数由后台返回指定中哪个奖项
                binding.lsLucky.luckyStart(0);
                //模拟请求网络
                new Thread(() -> {
                    //  网络请求6秒
                    SystemClock.sleep(5000);
                    //  逐渐停止转盘
                    binding.lsLucky.luckStop();
                }).start();
                break;
            default:
                break;
        }
    }
}
