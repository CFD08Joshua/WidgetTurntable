package com.example.widget_turntable.mmoamenn_luckywheel;

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
import com.example.widget_turntable.databinding.FragmentMmoamennLuckywheelBinding;
import com.example.widget_turntable.mmoamenn_luckywheel.model.WheelItem;
import com.example.widget_turntable.mmoamenn_luckywheel.widget.LuckyWheel;
import com.example.widget_turntable.mmoamenn_luckywheel.widget.WheelView;

import java.util.ArrayList;
import java.util.List;

public class MmoamennLuckyWheelFragment extends Fragment {

    FragmentMmoamennLuckywheelBinding binding;
    List<WheelItem> wheelItems;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.fragment_mmoamenn_luckywheel, container, false);
        generateWheelItems();
        initView();
        return binding.getRoot();
    }

    private void initView() {
        binding.luckyWheel.addWheelItems(wheelItems);
        binding.luckyWheel.setTarget(1);
        binding.luckyWheel.setLuckyWheelReachTheTarget(new WheelView.OnLuckyWheelReachTheTarget() {
            @Override
            public void onReachTarget() {
                Toast.makeText(getContext(), "Target Reached", Toast.LENGTH_LONG).show();

            }
        });
        binding.start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.luckyWheel.rotateWheelTo(1);
            }
        });
    }

    private void generateWheelItems() {
        wheelItems = new ArrayList<>();
        wheelItems.add(new WheelItem(Color.parseColor("#fc6c6c"), BitmapFactory.decodeResource(getResources(),
                R.drawable.chat), "100 $"));
        wheelItems.add(new WheelItem(Color.parseColor("#00E6FF"), BitmapFactory.decodeResource(getResources(),
                R.drawable.coupon), "0 $"));
        wheelItems.add(new WheelItem(Color.parseColor("#F00E6F"), BitmapFactory.decodeResource(getResources(),
                R.drawable.ice_cream), "30 $"));
        wheelItems.add(new WheelItem(Color.parseColor("#00E6FF"), BitmapFactory.decodeResource(getResources(),
                R.drawable.lemonade), "6000 $"));
        wheelItems.add(new WheelItem(Color.parseColor("#fc6c6c"), BitmapFactory.decodeResource(getResources(),
                R.drawable.orange), "9 $"));
        wheelItems.add(new WheelItem(Color.parseColor("#00E6FF"), BitmapFactory.decodeResource(getResources(),
                R.drawable.shop), "20 $"));
    }
}
