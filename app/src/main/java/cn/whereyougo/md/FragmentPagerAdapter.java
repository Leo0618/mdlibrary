package cn.whereyougo.md;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import cn.whereyougo.md.fragment.ButtonFragment;
import cn.whereyougo.md.fragment.DialogsFragment;
import cn.whereyougo.md.fragment.FabFragment;
import cn.whereyougo.md.fragment.ProgressFragment;
import cn.whereyougo.md.fragment.SliderFragment;
import cn.whereyougo.md.fragment.SnackbarFragment;
import cn.whereyougo.md.fragment.SpinnersFragment;
import cn.whereyougo.md.fragment.SwitchesFragment;
import cn.whereyougo.md.fragment.TextfieldFragment;

public class FragmentPagerAdapter extends FragmentStatePagerAdapter {

    Fragment[] mFragments;
    static String[] titleList = new String[]{
            "Progresses", "Buttons", "FABs", "Switches", "Sliders", "Spinners", "TextFields", "SnackBars", "Dialogs"
    };

    public FragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        mFragments = new Fragment[titleList.length];
    }

    @Override
    public Fragment getItem(int position) {
        if (mFragments[position] == null) {
            switch (position) {
                case 0:
                    mFragments[position] = ProgressFragment.newInstance();
                    break;
                case 1:
                    mFragments[position] = ButtonFragment.newInstance();
                    break;
                case 2:
                    mFragments[position] = FabFragment.newInstance();
                    break;
                case 3:
                    mFragments[position] = SwitchesFragment.newInstance();
                    break;
                case 4:
                    mFragments[position] = SliderFragment.newInstance();
                    break;
                case 5:
                    mFragments[position] = SpinnersFragment.newInstance();
                    break;
                case 6:
                    mFragments[position] = TextfieldFragment.newInstance();
                    break;
                case 7:
                    mFragments[position] = SnackbarFragment.newInstance();
                    break;
                case 8:
                    mFragments[position] = DialogsFragment.newInstance();
                    break;
            }
        }
        return mFragments[position];
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList[position];
    }

    @Override
    public int getCount() {
        return titleList.length;
    }
}
