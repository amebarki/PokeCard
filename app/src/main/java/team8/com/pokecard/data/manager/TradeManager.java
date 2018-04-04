package team8.com.pokecard.data.manager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import team8.com.pokecard.PokemonApplication;
import team8.com.pokecard.data.model.Trade;
import team8.com.pokecard.data.model.User;
import team8.com.pokecard.presentation.presenter.BasePresenter;

/**
 * Created by Adam on 09/03/2018.
 */

public class TradeManager {

    private ArrayList<Trade> listTradePokemon;

    public TradeManager()
    {
        listTradePokemon = new ArrayList<>();
    }

    public void insertExchangeOffer(final BasePresenter presenter, int idPokemonOffer, int idPokemonWanted)
    {
        User currentUser = Navigator.getInstance().getUserManager().getCurrentUser();
        Call<Integer> call = PokemonApplication.getPokemonApiService().offerPokemon(currentUser.getEmail(),idPokemonOffer,idPokemonWanted,0);
        call.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                //info message
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                presenter.errorMessage("");
            }
        });

    }


    public void getListExchangePokemons(final BasePresenter presenter)
    {
        User currentUser = Navigator.getInstance().getUserManager().getCurrentUser();
        Call<List<Trade>> call = PokemonApplication.getPokemonApiService().listExchangeOfPokemons();
        call.enqueue(new Callback<List<Trade>>() {
            @Override
            public void onResponse(Call<List<Trade>> call, Response<List<Trade>> response) {
                //info message
                listTradePokemon.addAll(response.body());
            }

            @Override
            public void onFailure(Call<List<Trade>> call, Throwable t) {
                presenter.errorMessage("");
            }
        });

    }

    public void acceptExchange(final BasePresenter presenter)
    {
      /*  User currentUser = Navigator.getInstance().getUserManager().getCurrentUser();
        Call<List<Trade>> call = PokemonApplication.getPokemonApiService().listExchangeOfPokemons();
        call.enqueue(new Callback<List<Trade>>() {
            @Override
            public void onResponse(Call<List<Trade>> call, Response<List<Trade>> response) {
                //info message
                listTradePokemon.addAll(response.body());
            }

            @Override
            public void onFailure(Call<List<Trade>> call, Throwable t) {
                presenter.errorMessage("");
            }
        });*/

    }
}
