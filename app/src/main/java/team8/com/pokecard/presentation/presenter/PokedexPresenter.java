package team8.com.pokecard.presentation.presenter;

import android.content.Context;
import android.util.Log;

import java.util.List;

import team8.com.pokecard.data.manager.PokemonDatabaseManager;
import team8.com.pokecard.data.manager.PokemonManager;
import team8.com.pokecard.data.model.Pokemon;
import team8.com.pokecard.presentation.ui.view.PokedexView;

/**
 * Created by iem on 15/11/2017.
 */

public class PokedexPresenter implements BasePresenter {

    Pokemon pok;
    PokemonManager pokemonManager;
    Pokemon poke;

    private PokedexView pokedexView;
    private Context context;
    private Pokemon pokemon;


    public PokedexPresenter(Context context, PokemonManager manager,PokedexView pokedexView)
    {

        this.context = context;
        this.pokedexView = pokedexView;
        this.pokemonManager = manager;
    }

    /*  public void test() {

        pokemonManager.getPokemon(1, new PokemonManager.IPokemon() {
            @Override
            public void onSuccess(Pokemon p) {
                pok = p;
            }
        });

    }*/

    public void requestPokemon(int id) {
        pokemonManager.getPokemon(id,this);
    }

    public void requestGeneration(int generation) {
        pokemonManager.getGeneration(generation,this);
    }

    public void requestAllPokemon(){
        pokemonManager.getAllPokemon(this);

    }

    @Override
    public void getPokemon(Pokemon p) {
        this.pokemon = p;
        if(pokemon !=null) {
            pokedexView.DisplayPokemon(pokemon);
        } else {
            // displayError
        }
    }

    @Override
    public void getGeneration(List<Pokemon> generation) {
        Log.d("POKEMON", "getGeneration");

        if (generation != null) {
            Log.d("POKEMON", "not null");
            pokedexView.DisplayGeneration(generation);
        } else {
            // display Error
        }
    }

    @Override
    public void getAllPokemon(List<Pokemon> allPokemon) {
        if(allPokemon !=null) {
            pokedexView.DisplayAllPokemon(allPokemon);
        } else {
            Log.d("NULLL", 1 + "");
        }
    }

    @Override
    public void getIdByFacebook(int id){

    }


    @Override
    public void getIdByGoogle(int id) {

    }


    public void sendPokemon()
    {
        // send pokemon to create in the db
    }
}
