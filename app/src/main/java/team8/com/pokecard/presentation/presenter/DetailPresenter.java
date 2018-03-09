package team8.com.pokecard.presentation.presenter;

import android.content.Context;

import java.util.List;

import team8.com.pokecard.data.manager.Navigator;
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

    public DetailPresenter(Context context, DetailView view) {
        this.context = context;
        this.pokemonManager = Navigator.getInstance().getPokemonManager();
        this.detailView = view;
    }


    // TODO: 09/03/2018   Call this function in the activity
    public void requestPokemonSelected() {
        int id = pokemonManager.getIdOfSelectedPokemon();
        pokemonManager.getPokemon(id, this);
    }

    @Override
    public void getPokemon(Pokemon p) {
        if (p != null) {
            detailView.DisplayPokemon(p);
        } else {
            detailView.displayErrorMessage();
        }
    }

    @Override
    public void getListPokemons(List<Pokemon> allPokemon) {

    }


    @Override
    public void infoMessage(String message) {

    }

    @Override
    public void errorMessage(String message) {
        detailView.displayErrorMessage();
    }
}
