package team8.com.pokecard.presentation.presenter;

import android.content.Context;

import java.util.List;

import team8.com.pokecard.data.manager.Navigator;
import team8.com.pokecard.data.manager.PokemonManager;
import team8.com.pokecard.data.manager.UserManager;
import team8.com.pokecard.data.model.Pokemon;
import team8.com.pokecard.presentation.ui.view.CollectionView;

/**
 * Created by iem on 13/12/2017.
 */

public class CollectionPresenter implements BasePresenter{
    private CollectionView collectionView;
    private Context context = null;
    private UserManager userManager = null;

    public CollectionPresenter(Context context, CollectionView view) {
        this.context = context;
        this.userManager = Navigator.getInstance().getUserManager();
        this.collectionView = view;
    }

    public void requestPokemonsOfUser(){
            if(userManager.getCurrentUser().getMyPokemons() != null)
            {
                if(!userManager.getCurrentUser().getMyPokemons().isEmpty())
                    collectionView.DisplayCollectionPokemon(userManager.getCurrentUser().getMyPokemons());
                else
                    collectionView.displayErrorMessage();
            }else
            {
                collectionView.displayErrorMessage();
            }
    }


    @Override
    public void infoMessage(String message) {

    }

    @Override
    public void errorMessage(String message) {

    }


    @Override
    public void getPokemon(Pokemon p) {

    }

    @Override
    public void getListPokemons(List<Pokemon> allPokemon) {

    }
}
