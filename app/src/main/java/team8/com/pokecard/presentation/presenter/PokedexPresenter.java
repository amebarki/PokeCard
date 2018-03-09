package team8.com.pokecard.presentation.presenter;

import android.content.Context;
import android.util.Log;

import java.util.List;

import team8.com.pokecard.data.manager.Navigator;
import team8.com.pokecard.data.manager.PokemonDatabaseManager;
import team8.com.pokecard.data.manager.PokemonManager;
import team8.com.pokecard.data.model.Pokemon;
import team8.com.pokecard.presentation.ui.view.PokedexView;

/**
 * Created by iem on 15/11/2017.
 */

public class PokedexPresenter implements BasePresenter {

    PokemonManager pokemonManager;

    private PokedexView pokedexView;
    private Context context;
    private Pokemon pokemon;


    public PokedexPresenter(Context context,PokedexView pokedexView)
    {

        this.context = context;
        this.pokedexView = pokedexView;
        this.pokemonManager = Navigator.getInstance().getPokemonManager();

    }

        // call this function when
    public void saveIdOfSelectedPokemon(int id) {
        if(id >0)
            pokemonManager.setIdOfSelectedPokemon(id);
        //pokemonManager.getPokemon(id,this);
        else
            pokedexView.displayErrorMessage();
    }

    public void requestPokemon(int id)
    {
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
            pokedexView.displayErrorMessage();
        }
    }

    public void getGeneration(List<Pokemon> generation) {

        if (generation != null) {
            pokedexView.DisplayGeneration(generation);
        } else {
            pokedexView.displayErrorMessage();
        }
    }

    @Override
    public void getListPokemons(List<Pokemon> allPokemon) {
        if(allPokemon !=null) {
            pokedexView.DisplayAllPokemon(allPokemon);
        } else {
            pokedexView.displayErrorMessage();
        }
    }

    @Override
    public void infoMessage(String message) {

    }

    @Override
    public void errorMessage(String message) {
            pokedexView.displayErrorMessage();
    }
}
