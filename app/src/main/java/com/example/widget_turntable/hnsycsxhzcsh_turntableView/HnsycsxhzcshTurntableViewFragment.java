package com.example.widget_turntable.hnsycsxhzcsh_turntableView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.widget_turntable.R;
import com.example.widget_turntable.databinding.FragmentHnsycsxhzcshTurntableviewBinding;
import com.example.widget_turntable.hnsycsxhzcsh_turntableView.view.TurntableView;

import java.util.ArrayList;

public class HnsycsxhzcshTurntableViewFragment extends Fragment {

    FragmentHnsycsxhzcshTurntableviewBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.fragment_hnsycsxhzcsh_turntableview, container, false);
        initView();
        return binding.getRoot();
    }

    private void initView() {
        binding.btPointTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.turntable.startRotate(7, new TurntableView.ITurntableListener() {
                    @Override
                    public void onStart() {
                        Toast.makeText(getContext(), "开始抽奖", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onEnd(int position, String name) {
                        binding.tvResult.setText("抽奖结束抽中第" + (position + 1) + "位置的奖品:" + name);

                    }
                });
            }
        });

        binding.btChangecolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeColors();
            }
        });

        binding.btChangedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //修改转盘数据
                changeDatas();
            }
        });

        binding.ivNode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.turntable.startRotate(new TurntableView.ITurntableListener() {
                    @Override
                    public void onStart() {
                        Toast.makeText(getContext(), "开始抽奖", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onEnd(int position, String name) {
                        binding.tvResult.setText("抽奖结束抽中第" + (position + 1) + "位置的奖品:" + name);
                    }
                });
            }
        });
    }

    private void changeColors() {
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.parseColor("#ff8584"));
        colors.add(getResources().getColor(R.color.colorAccent));
        colors.add(Color.parseColor("#000000"));
        binding.turntable.setBackColor(colors);
    }

    private void changeDatas() {
        int num = 6;
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Bitmap> bitmaps = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            names.add("第" + (i + 1));
            bitmaps.add(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        }
        binding.turntable.setDatas(num, names, bitmaps);
    }
}
