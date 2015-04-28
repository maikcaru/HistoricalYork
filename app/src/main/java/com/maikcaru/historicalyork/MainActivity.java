package com.maikcaru.historicalyork;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;


public class MainActivity extends FragmentActivity {

    myViewPager viewPager;
    int selectedIndex;

    PagerAdapter pagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (myViewPager) findViewById(R.id.viewPager);
        pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(0);
    }

    public ViewPager getViewPager(){
        return viewPager;
    }

    public void setSelectedIndex(int i){

        selectedIndex = i;
    }

    public int getSelectedIndex(){
        return selectedIndex;
    }

    private class PagerAdapter extends FragmentPagerAdapter {
        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if(position == 0){
                return new MapFragment();
            }
            else{
                return new SiteFragment();
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    }


}
