package in.buzzzz.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.buzzzz.R;

/**
 * Created by ekansh on 23/10/15.
 */
public class HomeFragment extends Fragment {

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);

        view = inflater.inflate(R.layout.fragment_home,container,false);
        return view;
    }
}
