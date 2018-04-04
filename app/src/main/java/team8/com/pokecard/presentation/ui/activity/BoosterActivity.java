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
import team8.com.pokecard.presentation.ui.adapter.BoosterRecyclerAdapter;
import team8.com.pokecard.presentation.ui.adapter.CollectionRecyclerAdapter;
import team8.com.pokecard.presentation.ui.view.BoosterView;
import team8.com.pokecard.tools.CustomItemClickListener;

public class BoosterActivity extends AppCompatActivity implements View.OnClickListener, BoosterView {

    RecyclerView recyclerView;
    ArrayList<Pokemon> pokemonArrayList = new ArrayList<>();
    BoosterPresenter boosterPresenter;

    Button openButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booster);
        boosterPresenter = Navigator.getInstance().getBoosterPresenter(this,this);
        openButton = findViewById(R.id.booster_button_open);
        openButton.setOnClickListener(this);
        setRecyclerView();
    }

    @Override
    public void onClick(View v) {
        if (v == findViewById(R.id.booster_button_open)) {
            boosterPresenter.openBoosterPack();
        }
    }

    private void setRecyclerView() {
        recyclerView = findViewById(R.id.booster_recycler);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        final BoosterRecyclerAdapter boosterRecyclerAdapter = new BoosterRecyclerAdapter(pokemonArrayList, this, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

            }
        });

        recyclerView.setAdapter(boosterRecyclerAdapter);
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
        pokemonArrayList.addAll(boosterPackPokemons);
        recyclerView.getAdapter().notifyDataSetChanged();

    }
}
