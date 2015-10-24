package in.buzzzz.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import in.buzzzz.R;
import in.buzzzz.model.DetailPagerInfo;

/**
 * Created by Navkrishna on October 24, 2015
 */
public class DetailPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private List<DetailPagerInfo> mDetailPagerInfoList = new ArrayList<>();

    public DetailPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.mContext = context;
    }

    public boolean addItem(DetailPagerInfo detailPagerInfo) {
        return mDetailPagerInfoList.add(detailPagerInfo);
    }

    @Override
    public Fragment getItem(int position) {
        return mDetailPagerInfoList.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return mDetailPagerInfoList.size();
    }

    public View getTabView(int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_detail_tab, null);
        TextView textView = (TextView) view.findViewById(R.id.text_view_title);
        textView.setText(mDetailPagerInfoList.get(position).getTitle());
        return view;
    }
}
