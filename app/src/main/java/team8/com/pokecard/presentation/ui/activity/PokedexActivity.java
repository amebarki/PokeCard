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


public class PokedexActivity extends AppCompatActivity implements PokedexView {

    private static final String TAG = "MainActivity";
    private static ListView list_pokemon_listview;
    private static ArrayList<Pokemon> array;
    private static PokedexAdapter adapter;
    private static TextView textView_pokemon;

    private PokedexPresenter pokedexPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokedex);
        array = new ArrayList<>();
        list_pokemon_listview = (ListView) findViewById(R.id.list_pokemon_list_view);
        adapter = new PokedexAdapter(this,array);
        list_pokemon_listview.setAdapter(adapter);
      //  RecupApi recup = new RecupApi();
     //   recup.execute(array,adapter);
        // envoyer instance d'une liste et la mettre a jour dans l'async task
        pokedexPresenter = new PokedexPresenter(this,this);

       // pokedexPresenter.requestGeneration();
       // pokedexPresenter.requestPokemon();
        pokedexPresenter.requestAllPokemon();
    }

    @Override
    public void DisplayPokemon(Pokemon pokemon) {
        Log.d("pokemon",pokemon.getName());
        textView_pokemon.setText(pokemon.toString());
    }

    @Override
    public void DisplayGeneration(List<Pokemon> generation) {
            Log.d("POKEMON", generation.toString());
    }

    @Override
    public void DisplayAllPokemon(List<Pokemon> allPokemon) {
        Log.d("POKEMON",allPokemon.toString());
        array.addAll(allPokemon);
        adapter.notifyDataSetChanged();
    }


}