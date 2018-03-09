package team8.com.pokecard.presentation.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import team8.com.pokecard.R;
import team8.com.pokecard.data.model.Pokemon;
import team8.com.pokecard.presentation.ui.view.BoosterView;
import team8.com.pokecard.presentation.ui.view.ExchangeView;

public class ExchangeActivity extends AppCompatActivity implements ExchangeView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange);
    }

    @Override
    public void DisplayErrorMessage() {

    }

    @Override
    public void DisplayInformationMessage() {

    }


}
