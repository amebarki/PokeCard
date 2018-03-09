package team8.com.pokecard.presentation.presenter;

import android.content.Context;

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
        userManager.getPokemonsFromBoosterPack(this);
        if(userManager.getCurrentUser().getMyPokemons() != null)
            boosterView.DisplayBoosterPack(userManager.getCurrentUser().getMyPokemons());
        else
        {
            boosterView.DisplayErrorMessage();
        }
    }


    @Override
    public void getPokemon(Pokemon p) {

    }

    @Override
    public void getListPokemons(List<Pokemon> allPokemon) {

    }

    @Override
    public void errorMessage(String message) {
            boosterView.DisplayErrorMessage();
    }
}
