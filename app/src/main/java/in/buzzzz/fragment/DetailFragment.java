package in.buzzzz.fragment;

import android.app.Fragment;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import in.buzzzz.R;
import in.buzzzz.utility.UiUtility;

/**
 * Created by Navkrishna on October 24, 2015
 */
public class DetailFragment extends Fragment {

    CoordinatorLayout mCoordinatorLayout;
    ViewPager mViewPager;
    AppBarLayout mAppBarLayout;
    CollapsingToolbarLayout mCollapsingToolbarLayout;
    RelativeLayout mRelativeLayoutContainer;
    ImageView mImageViewBuzz;
    TabLayout mTabLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_detail, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mCoordinatorLayout = (CoordinatorLayout) view.findViewById(R.id.coordinator_layout);
        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        mAppBarLayout = (AppBarLayout) view.findViewById(R.id.app_bar_layout);
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar);
        mRelativeLayoutContainer = (RelativeLayout) view.findViewById(R.id.relative_layout_container);
        mImageViewBuzz = (ImageView) view.findViewById(R.id.image_view_buzz);
        mTabLayout = (TabLayout) view.findViewById(R.id.tab_layout);

        Point point = UiUtility.getDisplayPoints(getActivity());
        int width = point.x;
        int height = (width * 9) / 16;

        UiUtility.setLayoutParam(mRelativeLayoutContainer, height, width);
        UiUtility.setLayoutParam(mImageViewBuzz, height, width);
    }
}
