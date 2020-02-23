package by.nj.dusty;

import android.graphics.Color;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class PageAdapter extends FragmentPagerAdapter {
    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> FragmentTitle = new ArrayList<>();
    private final List<Integer> FragmentIcon = new ArrayList<>();

    public PageAdapter( FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    public PageAdapter(FragmentManager supportFragmentManager) {
        super(supportFragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return FragmentTitle.size();
    }

    @Override
    public CharSequence getPageTitle(int position){
        return FragmentTitle.get(position);
    }

    public void AddFragment(Fragment fragment, String title, int icon){
        fragmentList.add(fragment);
        FragmentTitle.add(title);
        FragmentIcon.add(icon);
    }
}
