package team8.com.pokecard.presentation.presenter;

import android.content.Context;

import java.util.List;

import team8.com.pokecard.data.manager.PokemonManager;
import team8.com.pokecard.data.model.Pokemon;
import team8.com.pokecard.presentation.ui.view.CollectionView;
import team8.com.pokecard.presentation.ui.view.PokedexView;

/**
 * Created by iem on 13/12/2017.
 */

public class CollectionPresenter implements BasePresenter {
    private CollectionView collectionView;
    private Context context = null;
    private PokemonManager pokemonManager;

    public CollectionPresenter(Context context, PokemonManager manager, CollectionView view) {
        this.context = context;
        this.pokemonManager = manager;
        this.collectionView = view;
    }

    public void requestAllPokemon(){

        pokemonManager.getAllPokemon(this);
    }

    @Override
    public void getPokemon(Pokemon p) {

    }

    @Override
    public void getGeneration(List<Pokemon> generation) {

    }

    @Override
    public void getAllPokemon(List<Pokemon> allPokemon) {
        if(allPokemon !=null) {
            collectionView.DisplayCollectionPokemon(allPokemon);
        } else {
        }
    }

    @Override
    public void getIdByFacebook(int id) {

    }

    @Override
    public void getIdByGoogle(int id) {

    }
}
