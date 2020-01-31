package com.example.hamrobook_ebookstore.Admin.home;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.hamrobook_ebookstore.Admin.latest.LatestFragment;
import com.example.hamrobook_ebookstore.R;
import com.example.hamrobook_ebookstore.adapter.ViewPageAdapter;
import com.google.android.material.tabs.TabLayout;

public class HomeFragment extends Fragment {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        viewPager=root.findViewById(R.id.viewPager);
        tabLayout=root.findViewById(R.id.tabId);

        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#FFFFFF"));
        ViewPageAdapter viewPageAdapter=new ViewPageAdapter(getChildFragmentManager());
        viewPageAdapter.addFragment(new AllFragment(),"ALL");
        viewPageAdapter.addFragment(new LatestFragment(),"Latest");

        viewPager.setAdapter(viewPageAdapter);
        tabLayout.setupWithViewPager(viewPager);
        return root;
    }


}