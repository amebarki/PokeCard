package team8.com.pokecard.presentation.presenter;

import android.content.Context;

import java.util.List;

import team8.com.pokecard.data.manager.PokemonManager;
import team8.com.pokecard.data.manager.TradeManager;
import team8.com.pokecard.data.manager.Navigator;
import team8.com.pokecard.data.manager.UserManager;
import team8.com.pokecard.data.model.Pokemon;
import team8.com.pokecard.presentation.ui.view.TradeView;

/**
 * Created by Adam on 07/03/2018.
 */

public class TradePresenter implements BasePresenter {


    private Context context;
    private TradeView tradeView;
    private UserManager userManager = null;
    private TradeManager tradeManager = null;
    private PokemonManager pokemonManager = null;


    public TradePresenter(Context context, TradeView view) {
            this.context = context;
            this.tradeView = view;
            userManager = Navigator.getInstance().getUserManager();
            tradeManager = Navigator.getInstance().getTradeManager();
            pokemonManager = Navigator.getInstance().getPokemonManager();
    }


    public void requestExchangeList()
    {

    }

    public void requestAllPokemon() {
        pokemonManager.getAllPokemon(this);
    }

    @Override
    public void getPokemon(Pokemon p) {

    }

    @Override
    public void getListPokemons(List<Pokemon> allPokemon) {
        tradeView.DisplayAllPokemon(allPokemon);
    }

    @Override
    public void infoMessage(String message) {

    }

    @Override
    public void errorMessage(String message) {
            tradeView.displayErrorMessage();
    }


    public void getListOfExchange()
    {
            tradeManager.getListExchangePokemons(this);
    }

    public void insertExchangeOffer(int idPokemonOffer,int idPokemonWanted)
    {
        tradeManager.insertExchangeOffer(this,idPokemonOffer,idPokemonWanted);
    }

    public void acceptOffer(int exchange_id)
    {

    }


}
