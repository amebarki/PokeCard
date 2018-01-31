package team8.com.pokecard.presentation.presenter;

import android.content.Context;

import java.util.List;

import team8.com.pokecard.data.manager.PokemonManager;
import team8.com.pokecard.data.model.Pokemon;
import team8.com.pokecard.presentation.ui.view.PokedexView;

/**
 * Created by iem on 15/11/2017.
 */

public class PokedexPresenter implements BasePresenter {

    private PokedexView pokedexView;
    private Context context;
    private Pokemon pokemon;
    public PokedexPresenter(Context context, PokedexView pokedexView)
    {
        this.context = context;
        this.pokedexView = pokedexView;
    }


    public void requestPokemon(int id) {
        PokemonManager.getInstance().getPokemon(id,this);
    }

    public void requestGeneration(int generation) {
        PokemonManager.getInstance().getGeneration(generation,this);
    }

    public void requestAllPokemon(){
        PokemonManager.getInstance().getAllPokemon(this);
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
        if(generation != null) {
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

        }
    }
}
