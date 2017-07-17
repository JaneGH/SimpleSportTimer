package net.httpletters_archive.simplesporttimer.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import net.httpletters_archive.simplesporttimer.fragments.AllTimerFragment;
import net.httpletters_archive.simplesporttimer.fragments.CurrentTimerFragment;

/**
 * Created by MyComp on 12.04.2017.
 */

public class TabAdapter extends FragmentStatePagerAdapter {

    public static final int CURRENT_TASK_TIMER_POSITION = 0;
    public static final int ALL_TASK_TIMER_POSITION = 1;

    private int numberOfTabs;
    private CurrentTimerFragment currentTimerFragment;
    private AllTimerFragment allTimerFragment;

    public TabAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.numberOfTabs = numberOfTabs;
        currentTimerFragment = new CurrentTimerFragment();
        allTimerFragment = new AllTimerFragment();
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
           case 0: return currentTimerFragment;
           case 1: return allTimerFragment;
           default: return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
