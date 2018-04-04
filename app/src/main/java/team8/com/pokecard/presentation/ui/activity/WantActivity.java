package team8.com.pokecard.presentation.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import team8.com.pokecard.R;
import team8.com.pokecard.presentation.ui.fragment.PokedexFragment;

public class WantActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_want);

        if (findViewById(R.id.want_trade_frame) != null) {

            PokedexFragment pokedexFragment = PokedexFragment.newInstanceAll();

            pokedexFragment.setArguments(getIntent().getExtras());

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.want_trade_frame, pokedexFragment).commit();
        }

    }
}
