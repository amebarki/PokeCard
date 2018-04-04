package team8.com.pokecard.presentation.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import java.util.List;

import team8.com.pokecard.R;
import team8.com.pokecard.data.model.Pokemon;
import team8.com.pokecard.data.model.Trade;
import team8.com.pokecard.presentation.ui.adapter.TradePagerAdapter;
import team8.com.pokecard.presentation.ui.view.TradeView;

public class TradeActivity extends AppCompatActivity {
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trade);

        initializeViewPager();
    }

    private void initializeViewPager() {

        this.toolbar = findViewById(R.id.trade_toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        tabLayout = findViewById(R.id.trade_tabLayout);
        if (tabLayout != null) {
            tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
            tabLayout.setTabMode(TabLayout.MODE_FIXED);

            viewPager = findViewById(R.id.trade_viewPager);
            viewPager.setAdapter(new TradePagerAdapter(getSupportFragmentManager(),this));
            viewPager.setClipToPadding(false);
            viewPager.setPageMargin(12);

            tabLayout.setupWithViewPager(viewPager);
        }
    }
}
