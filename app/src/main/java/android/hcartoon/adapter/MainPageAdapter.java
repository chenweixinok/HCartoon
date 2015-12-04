package android.hcartoon.adapter;

import android.hcartoon.fragment.RankingIndexFragment;
import android.hcartoon.fragment.RecommendFragment;
import android.hcartoon.fragment.ShelfFragment;
import android.hcartoon.fragment.SortFragment;
import android.hcartoon.fragment.TopicFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Lenovo on 2015/11/17.
 */
public class MainPageAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> frags;

    public MainPageAdapter(FragmentManager fm) {
        super(fm);
        frags = new ArrayList<Fragment>();
        frags.add(new RecommendFragment());
        frags.add(new SortFragment());
        frags.add(new TopicFragment());
        frags.add(new RankingIndexFragment());
        frags.add(new ShelfFragment());

    }

    @Override
    public Fragment getItem(int position) {
        return frags.get(position);
    }

    @Override
    public int getCount() {
        return frags.size();
    }

}
