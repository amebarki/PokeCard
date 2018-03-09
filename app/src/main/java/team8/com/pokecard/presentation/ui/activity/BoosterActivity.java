package team8.com.pokecard.presentation.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import team8.com.pokecard.R;
import team8.com.pokecard.data.model.Pokemon;
import team8.com.pokecard.presentation.ui.view.BoosterView;

public class BoosterActivity extends AppCompatActivity implements BoosterView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booster);
    }

    @Override
    public void DisplayErrorMessage() {

    }

    @Override
    public void DisplayInformationMessage() {

    }

    @Override
    public void DisplayBoosterPack(List<Pokemon> boosterPackPokemons) {

    }
}
