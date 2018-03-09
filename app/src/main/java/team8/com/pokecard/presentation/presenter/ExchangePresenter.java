package team8.com.pokecard.presentation.presenter;

import android.content.Context;

import java.util.List;

import team8.com.pokecard.data.manager.ExchangeManager;
import team8.com.pokecard.data.manager.Navigator;
import team8.com.pokecard.data.manager.UserManager;
import team8.com.pokecard.data.model.Pokemon;
import team8.com.pokecard.presentation.ui.view.ExchangeView;

/**
 * Created by Adam on 07/03/2018.
 */

public class ExchangePresenter implements BasePresenter {


    private Context context;
    private ExchangeView exchangeView;
    private UserManager userManager = null;
    private ExchangeManager exchangeManager = null;
    public ExchangePresenter(Context context, ExchangeView view) {
            this.context = context;
            this.exchangeView = view;
            userManager = Navigator.getInstance().getUserManager();
            exchangeManager = Navigator.getInstance().getExchangeManager();
    }


    public void getExchangeList()
    {

    }

    @Override
    public void getPokemon(Pokemon p) {

    }

    @Override
    public void getListPokemons(List<Pokemon> allPokemon) {

    }

    @Override
    public void errorMessage(String message) {
            exchangeView.DisplayErrorMessage();
    }


    public void getListOfExchange()
    {
            exchangeManager.getListExchangePokemons(this);
    }

    public void insertExchangeOffer(int idPokemonOffer,int idPokemonWanted)
    {
        exchangeManager.insertExchangeOffer(this,idPokemonOffer,idPokemonWanted);
    }

    public void acceptOffer(int exchange_id)
    {

    }


}
