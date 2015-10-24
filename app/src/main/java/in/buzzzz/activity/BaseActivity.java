package in.buzzzz.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import in.buzzzz.R;
import in.buzzzz.fragment.BottomMenuFragment;
import in.buzzzz.fragment.TopMenuFragment;

/**
 * Created by ekansh on 23/10/15.
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fragment_top_menu, new TopMenuFragment());
        transaction.add(R.id.fragment_menu_bottom, new BottomMenuFragment());
        transaction.commit();
    }
}
