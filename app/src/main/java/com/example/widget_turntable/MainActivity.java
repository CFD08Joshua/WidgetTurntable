package com.example.widget_turntable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.widget_turntable.bigggfish_turntableView.BigggFishTurntableViewFragment;
import com.example.widget_turntable.databinding.ActivityMainBinding;
import com.example.widget_turntable.horofriend.HoroFriendFragment;
import com.example.widget_turntable.lwang057_luckyturntable.lwang057LuckyTurnTable;
import com.example.widget_turntable.mmoamenn_luckywheel.MmoamennLuckyWheelFragment;
import com.example.widget_turntable.thanhniencung_luckyWheel.ThanhniencungLuckyWheelFragment;
import com.example.widget_turntable.voxy.VoxyFragment;
import com.example.widget_turntable.wangchengmeng_lotteryturntable.WangchengmengLotteryTurntableFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        setSupportActionBar(binding.toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setupViewPager(binding.viewpager);

        binding.tabs.setupWithViewPager(binding.viewpager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new VoxyFragment(),"Voxy");
        adapter.addFragment(new WangchengmengLotteryTurntableFragment(), "wangchengmeng LotteryTurntable");
//        adapter.addFragment(new HnsycsxhzcshTurntableViewFragment(), "hnsycsxhzcsh TurntableView");
        adapter.addFragment(new BigggFishTurntableViewFragment(), "BigggFish TurntableView");
        adapter.addFragment(new ThanhniencungLuckyWheelFragment(), "Thanhniencung LuckyWheel");
        adapter.addFragment(new MmoamennLuckyWheelFragment(), "mmoamenn LuckyWheel_Android");
        adapter.addFragment(new lwang057LuckyTurnTable(), "lwang057 LuckyTurnTable");
        adapter.addFragment(new HoroFriendFragment(), "HoroFriend");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}