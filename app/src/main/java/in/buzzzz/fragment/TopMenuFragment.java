package in.buzzzz.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import in.buzzzz.R;

/**
 * Created by ekansh on 23/10/15.
 */
public class TopMenuFragment extends Fragment{

    static boolean topMenuVisible = false;
    private View view;
    private LinearLayout headerTopMenu;
    private ScrollView topMenuItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        super.onCreateView(inflater, viewGroup, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_menu_top,viewGroup,false);
        headerTopMenu = (LinearLayout) view.findViewById(R.id.header_top_menu);
        topMenuItems = (ScrollView) view.findViewById(R.id.list_top_menu);
        listViewHeaderListeners();
        listViewItemsListeners();
        listViewGestureListeners();
        return view;
    }

    private void listViewGestureListeners() {
//        headerTopMenu.setOnClickListener()

    }

    private void listViewItemsListeners(){
        topMenuItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("child view clicked");
            }
        });
    }

    private void listViewHeaderListeners(){
        headerTopMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (topMenuVisible) {
                    topMenuVisible = false;
                    topMenuItems.setVisibility(View.GONE);
                } else {
                    topMenuVisible = true;
                    topMenuItems.setVisibility(View.VISIBLE);


                }
            }
        });
    }


}
