package lanou.amg.main.welcomepage;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by dllo on 16/9/19.
 */
public class Adapter_ViewPager_WelComePage extends FragmentPagerAdapter{

    public void setArrayList(ArrayList<Fragment> arrayList) {
        this.arrayList = arrayList;
    }

    private ArrayList<Fragment> arrayList;

    public Adapter_ViewPager_WelComePage(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public int getCount() {
        return arrayList == null ? 0 : arrayList.size();
    }
}
