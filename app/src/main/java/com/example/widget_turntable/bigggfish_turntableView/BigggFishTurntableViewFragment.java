package com.example.widget_turntable.bigggfish_turntableView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.widget_turntable.R;
import com.example.widget_turntable.bigggfish_turntableView.widget.LuckyPlateView;
import com.example.widget_turntable.databinding.FragmentBigggfishTurntableviewBinding;

import java.util.ArrayList;
import java.util.List;

public class BigggFishTurntableViewFragment extends Fragment {

    FragmentBigggfishTurntableviewBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.fragment_bigggfish_turntableview,container,false);
        initView();
        return binding.getRoot();
    }

    private void initView(){
        binding.luckPlateView.setOnBtnClickListener(new LuckyPlateView.OnBtnClickListener() {
            @Override
            public void onClick() {
                binding.luckPlateView.startRotating(2);
            }
        });
        binding.luckPlateView.setOnRotatingStopListener(new LuckyPlateView.OnRotatingStopListener() {
            @Override
            public void onStop(int stopPosition) {
                Toast.makeText(getContext(), "恭喜您抽中了" + stopPosition + "号奖品", Toast.LENGTH_SHORT).show();

            }
        });

        binding.luckPlateView.setItemTextStrList(getStrList(6));
        binding.luckPlateView.setItemBitmapList(getBitmapList(6));

        binding.seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress < 2) {
                    progress = 2;
                }
                binding.luckPlateView.setItemTextStrList(getStrList(progress));
                binding.luckPlateView.setItemBitmapList(getBitmapList(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        binding.switchMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    binding.luckPlateView.setRotatingMode(-2);
                } else {
                    binding.luckPlateView.setRotatingMode(-1);
                }
            }
        });
    }

    private List<String> getStrList(int count) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            arrayList.add("POSITION" + i);
        }
        return arrayList;
    }

    private List<Bitmap> getBitmapList(int count) {
        ArrayList<Bitmap> arrayList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (i % 2 == 0) {
                arrayList.add(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher_round));
            } else {
                arrayList.add(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
            }
        }
        return arrayList;
    }
}
