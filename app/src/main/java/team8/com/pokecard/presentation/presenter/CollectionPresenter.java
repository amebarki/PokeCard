package team8.com.pokecard.presentation.presenter;

import android.content.Context;

import java.util.List;

import team8.com.pokecard.data.manager.PokemonManager;
import team8.com.pokecard.data.model.Pokemon;
import team8.com.pokecard.presentation.ui.view.CollectionView;

/**
 * Created by iem on 13/12/2017.
 */

public class CollectionPresenter implements BasePresenter {
    private CollectionView collectionView;
    private Pokemon currentPokemon;
    private Context context = null;
    private PokemonManager pokemonManager;

    public CollectionPresenter(Context context, PokemonManager manager, CollectionView view) {
        this.context = context;
        this.pokemonManager = manager;
        this.collectionView = view;
    }

    public Pokemon getCurrentPokemon() {
        return currentPokemon;
    }

    public void setCurrentPokemon(Pokemon currentPokemon) {
        this.currentPokemon = currentPokemon;
    }

    public void requestAllPokemon(CollectionView collectionView){
        this.collectionView = collectionView;
        pokemonManager.getAllPokemon(this);
    }

    @Override
    public void getPokemon(Pokemon p) {

    }

    @Override
    public void getListPokemons(List<Pokemon> allPokemon) {
        if(allPokemon !=null) {
            collectionView.DisplayCollectionPokemon(allPokemon);
        } else {
            collectionView.DisplayErrorMessage();
        }
    }

    @Override
    public void errorMessage(String message) {

    }

}
