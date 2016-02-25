package android.hcartoon.fragment;


import android.content.Context;
import android.content.Intent;
import android.hcartoon.activity.DownloadActivity;
import android.hcartoon.activity.FeedbackActivity;
import android.hcartoon.activity.LoginActivity;
import android.hcartoon.activity.R;
import android.hcartoon.activity.SettingActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by Lenovo on 2015/11/17.
 */
public class NavigationFragment extends Fragment implements View.OnClickListener {

    private View view;
    final Context context = getActivity();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.navigation_menu,null);

        view.findViewById(R.id.menu_login).setOnClickListener(this);
        view.findViewById(R.id.menu_set).setOnClickListener(this);
        view.findViewById(R.id.menu_download).setOnClickListener(this);
        view.findViewById(R.id.menu_feedback).setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        Intent intent = null;

        switch (v.getId()){
            case R.id.menu_login:
                intent = new Intent(getActivity(), LoginActivity.class);
                break;

            case R.id.menu_set:
                intent = new Intent(getActivity(), SettingActivity.class);
                break;

            case R.id.menu_download:
                intent = new Intent(getActivity(), DownloadActivity.class);
                break;

            case R.id.menu_feedback:
                intent = new Intent(getActivity(), FeedbackActivity.class);
                break;
        }
        getActivity().startActivity(intent);
    }
}
