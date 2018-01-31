package team8.com.pokecard.presentation.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import team8.com.pokecard.presentation.adapter.PokedexAdapter;
import team8.com.pokecard.data.model.Pokemon;
import team8.com.pokecard.R;
import team8.com.pokecard.presentation.presenter.PokedexPresenter;
import team8.com.pokecard.presentation.ui.view.PokedexView;


@SuppressWarnings("AssignmentToStaticFieldFromInstanceMethod")
public class PokedexActivity extends AppCompatActivity implements PokedexView {

    private static final String TAG = "MainActivity";
    private static ListView list_pokemon_listview;
    private static ArrayList<Pokemon> array;
    private static PokedexAdapter adapter;

    private PokedexPresenter pokedexPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokedex);
        array = new ArrayList<>();
        list_pokemon_listview = (ListView) findViewById(R.id.list_pokemon_list_view);
        adapter = new PokedexAdapter(this,array);
        list_pokemon_listview.setAdapter(adapter);
        pokedexPresenter = new PokedexPresenter(this,this);
        //pokedexPresenter.requestGeneration();
        pokedexPresenter.sendPokemon();
    }

    @Override
    public void DisplayPokemon(Pokemon pokemon) {

    }

    @Override
    public void DisplayGeneration(List<Pokemon> generation) {
        array.addAll(generation);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void DisplayAllPokemon(List<Pokemon> allPokemon) {
        array.addAll(allPokemon);
        adapter.notifyDataSetChanged();
    }

}