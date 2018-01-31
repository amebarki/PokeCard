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
    private static CollectionPresenter instance = null;

    private Pokemon currentPokemon;

    public static CollectionPresenter getInstance() {
        if (instance == null) {
            instance = new CollectionPresenter();
        }

        return instance;
    }


    public CollectionPresenter() {

    }

    public Pokemon getCurrentPokemon() {
        return currentPokemon;
    }

    public void setCurrentPokemon(Pokemon currentPokemon) {
        this.currentPokemon = currentPokemon;
    }

    public void requestAllPokemon(CollectionView collectionView){
        this.collectionView = collectionView;
        PokemonManager.getInstance().getAllPokemon(this);
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
}
