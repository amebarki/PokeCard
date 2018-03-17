package team8.com.pokecard.presentation.ui.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import java.util.List;

import team8.com.pokecard.R;
import team8.com.pokecard.data.manager.Navigator;
import team8.com.pokecard.data.model.Pokemon;
import team8.com.pokecard.presentation.presenter.BoosterPresenter;
import team8.com.pokecard.presentation.presenter.CollectionPresenter;
import team8.com.pokecard.presentation.ui.adapter.CollectionRecyclerAdapter;
import team8.com.pokecard.presentation.ui.view.BoosterView;
import team8.com.pokecard.tools.CustomItemClickListener;

public class BoosterActivity extends AppCompatActivity implements View.OnClickListener, BoosterView {

    RecyclerView recyclerView;
    ArrayList<Pokemon> pokemonArrayList;
    BoosterPresenter boosterPresenter;
    Context context;

    Button openButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booster);
        boosterPresenter = Navigator.getInstance().getBoosterPresenter(this,this);
        openButton = findViewById(R.id.booster_button_open);
        openButton.setOnClickListener(this);
        // TODO: 10/03/2018 keep this function here to charge the booster pack before click the button  
        // TODO: 10/03/2018 I met the problem of time out with it. If it reach 60 seconds = error maybe a retry will be necessary
        boosterPresenter.openBoosterPack();
    }

    @Override
    public void onClick(View v) {
        if (v == findViewById(R.id.booster_button_open)) {
            setRecyclerView();

            //TODO Get 5 Pokemon random (Request Call Presenter)
        }
    }

    private void setRecyclerView() {
        recyclerView = findViewById(R.id.collection_recycler);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        final CollectionRecyclerAdapter recyclerAdapter = new CollectionRecyclerAdapter(pokemonArrayList, context, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

            }
        });

        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }


    @Override
    public void displayErrorMessage() {

    }

    @Override
    public void displayInformationMessage() {

    }

    @Override
    public void DisplayBoosterPack(List<Pokemon> boosterPackPokemons) {

    }
}
