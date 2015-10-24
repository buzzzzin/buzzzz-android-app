package in.buzzzz.fragment.buzzzz;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.buzzzz.R;

/**
 * Created by Navkrishna on October 24, 2015
 */
public class WallFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_wall, container, false);
        return view;
    }
}
