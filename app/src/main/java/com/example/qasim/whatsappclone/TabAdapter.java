package com.example.qasim.whatsappclone;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.qasim.whatsappclone.fragment.CallsFragment;
import com.example.qasim.whatsappclone.fragment.ChatFragment;
import com.example.qasim.whatsappclone.fragment.StatusFragment;

public class TabAdapter extends FragmentPagerAdapter {
    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                return new ChatFragment();
            case 1:
                return new StatusFragment();
            case 2:
                return new CallsFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
