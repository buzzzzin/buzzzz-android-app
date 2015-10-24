package in.buzzzz.fragment;

import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import in.buzzzz.R;
import in.buzzzz.adapter.DetailPagerAdapter;
import in.buzzzz.model.DetailPagerInfo;
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
        initTab();
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

    private void initTab() {
        WallFragment wallFragment = new WallFragment();
        WallFragment wallFragment1 = new WallFragment();
        WallFragment wallFragment2 = new WallFragment();
        WallFragment wallFragment3 = new WallFragment();
        DetailPagerInfo wallInfo = new DetailPagerInfo(wallFragment, "Wall");
        DetailPagerInfo chatInfo = new DetailPagerInfo(wallFragment1, "Chat");
        DetailPagerInfo pollInfo = new DetailPagerInfo(wallFragment2, "Poll");
        DetailPagerInfo locationInfo = new DetailPagerInfo(wallFragment3, "Location");

        DetailPagerAdapter detailPagerAdapter = new DetailPagerAdapter(getChildFragmentManager(), getActivity());
        detailPagerAdapter.addItem(wallInfo);
        detailPagerAdapter.addItem(chatInfo);
        detailPagerAdapter.addItem(pollInfo);
        detailPagerAdapter.addItem(locationInfo);

        mViewPager.setAdapter(detailPagerAdapter);
        mViewPager.setOffscreenPageLimit(2);

        mTabLayout.setupWithViewPager(mViewPager);

        for (int index = 0; index < mTabLayout.getTabCount(); index++) {
            TabLayout.Tab tab = mTabLayout.getTabAt(index);
            if (tab != null) {
                tab.setCustomView(detailPagerAdapter.getTabView(index));
            }
        }
    }
}
