package team8.com.pokecard.presentation.presenter;

import android.content.Context;
import android.util.Log;

import java.util.List;

import team8.com.pokecard.data.manager.Navigator;
import team8.com.pokecard.data.manager.UserManager;
import team8.com.pokecard.data.model.Pokemon;
import team8.com.pokecard.presentation.ui.view.BoosterView;

/**
 * Created by iem on 15/11/2017.
 */

public class BoosterPresenter implements BasePresenter {


    private Context context;
    private BoosterView boosterView;
    private UserManager userManager;

    public BoosterPresenter(Context context, BoosterView view)
    {
        this.context = context;
        this.boosterView = view;
        this.userManager = Navigator.getInstance().getUserManager();
    }


    public void openBoosterPack()
    {
        userManager.setCurrentUser("Adam Mebarki","nasaru@hotmail.fr");
        userManager.getPokemonsFromBoosterPack(this);

    }


    @Override
    public void getPokemon(Pokemon p) {

    }

    @Override
    public void getListPokemons(List<Pokemon> allPokemon) {
        userManager.getCurrentUser().setMyPokemons(allPokemon);
        if(userManager.getCurrentUser().getMyPokemons() != null)
        {
            for (int i = 0; i < userManager.getCurrentUser().getMyPokemons().size(); i++) {
                Log.d("TAGO",userManager.getCurrentUser().getMyPokemons().get(i).toString());
            }
            boosterView.DisplayBoosterPack(userManager.getCurrentUser().getMyPokemons());
        }// TODO: 10/03/2018 insert in the db in the API DE MERDE

        else
        {
            boosterView.displayErrorMessage();
        }
    }

    @Override
    public void infoMessage(String message) {

    }

    @Override
    public void errorMessage(String message) {
            boosterView.displayErrorMessage();
    }
}
