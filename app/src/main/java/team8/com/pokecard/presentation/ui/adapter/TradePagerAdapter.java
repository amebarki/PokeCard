package team8.com.pokecard.presentation.ui.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import team8.com.pokecard.R;
import team8.com.pokecard.presentation.ui.fragment.CollectionFragment;
import team8.com.pokecard.presentation.ui.fragment.SelectFragment;

public class TradePagerAdapter extends FragmentPagerAdapter {
    private final int PAGE_COUNT = 2;
    private Context mContext;

    public TradePagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return SelectFragment.newInstance();
            case 1:
                return CollectionFragment.newInstance();
            default:
                return new Fragment();
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.trade_select);
            case 1:
                return mContext.getString(R.string.trade_send);
            default:
                return null;
        }
    }
}
