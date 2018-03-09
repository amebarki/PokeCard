package team8.com.pokecard.data.manager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import team8.com.pokecard.PokemonApplication;
import team8.com.pokecard.data.model.Exchange;
import team8.com.pokecard.data.model.User;
import team8.com.pokecard.presentation.presenter.BasePresenter;

/**
 * Created by Adam on 09/03/2018.
 */

public class ExchangeManager {

    private ArrayList<Exchange> listExchangePokemon;

    public ExchangeManager()
    {
        listExchangePokemon = new ArrayList<>();
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
        Call<List<Exchange>> call = PokemonApplication.getPokemonApiService().listExchangeOfPokemons();
        call.enqueue(new Callback<List<Exchange>>() {
            @Override
            public void onResponse(Call<List<Exchange>> call, Response<List<Exchange>> response) {
                //info message
                listExchangePokemon.addAll(response.body());
            }

            @Override
            public void onFailure(Call<List<Exchange>> call, Throwable t) {
                presenter.errorMessage("");
            }
        });

    }

    public void acceptExchange(final BasePresenter presenter)
    {
      /*  User currentUser = Navigator.getInstance().getUserManager().getCurrentUser();
        Call<List<Exchange>> call = PokemonApplication.getPokemonApiService().listExchangeOfPokemons();
        call.enqueue(new Callback<List<Exchange>>() {
            @Override
            public void onResponse(Call<List<Exchange>> call, Response<List<Exchange>> response) {
                //info message
                listExchangePokemon.addAll(response.body());
            }

            @Override
            public void onFailure(Call<List<Exchange>> call, Throwable t) {
                presenter.errorMessage("");
            }
        });*/

    }
}
