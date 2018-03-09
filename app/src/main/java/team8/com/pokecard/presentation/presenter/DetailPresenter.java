package team8.com.pokecard.presentation.presenter;

import android.content.Context;

import java.util.List;

import team8.com.pokecard.data.manager.PokemonManager;
import team8.com.pokecard.data.model.Pokemon;
import team8.com.pokecard.presentation.ui.view.DetailView;

/**
 * Created by iem on 15/11/2017.
 */

public class DetailPresenter implements BasePresenter {

    private Context context = null;
    private PokemonManager pokemonManager = null;
    private DetailView detailView = null;

    public DetailPresenter(Context context, PokemonManager manager, DetailView view)
    {
        this.context = context;
        this.pokemonManager = manager;
        this.detailView = view;
    }

    public void requestCurrentPokemon(int id) {
        pokemonManager.getPokemon(id,this);
    }

    @Override
    public void getPokemon(Pokemon p) {
        if(p !=null) {
            detailView.DisplayPokemon(p);
        } else {
            // displayError
        }
    }

    @Override
    public void getGeneration(List<Pokemon> generation) {

    }

    @Override
    public void getAllPokemon(List<Pokemon> allPokemon) {

    }

    @Override
    public void getIdByFacebook(int id) {

    }

    @Override
    public void getIdByGoogle(int id) {

    }
}
