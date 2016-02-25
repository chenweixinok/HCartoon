package android.hcartoon.fragment;


import android.hcartoon.activity.R;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

/**
 * Created by Lenovo on 2015/11/20.
 */
public class RankingIndexFragment extends Fragment implements RadioGroup.OnCheckedChangeListener {

    private FragmentManager manager;
    private FragmentTransaction transaction;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_ranking_index,null);
        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.rank_radiogroup);
        radioGroup.setOnCheckedChangeListener(this);
        manager = getFragmentManager();
        transaction = manager.beginTransaction();
        RankingWeekFragment fragment = new RankingWeekFragment();
        transaction.replace(R.id.rank_index,fragment);
        transaction.commit();
        return view;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        transaction = manager.beginTransaction();
        switch (checkedId){
            case R.id.rank_index_pop:
                transaction.replace(R.id.rank_index, new RankingPopFragment());
                break;

            case R.id.rank_index_week:
                transaction.replace(R.id.rank_index, new RankingWeekFragment());
                break;

            default:
                break;
        }

        transaction.commit();

    }
}
