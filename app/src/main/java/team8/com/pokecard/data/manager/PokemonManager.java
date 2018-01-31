package team8.com.pokecard.data.manager;

import android.util.Log;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import team8.com.pokecard.PokemonApplication;
import team8.com.pokecard.data.model.Pokemon;
import team8.com.pokecard.presentation.presenter.BasePresenter;

/**
 * Created by iem on 15/11/2017.
 */

public class PokemonManager {

    private static PokemonManager ourInstance;
    private static PokemonManager instance;

    public static PokemonManager getInstance() {
        if(instance == null) {
            instance = new PokemonManager();
        }
        return instance;
    }

    private PokemonManager() {

    }

    public void getPokemon(int id, final BasePresenter basePresenter) {
        Log.d("POKEMON","" + id);

        Call<Pokemon> call = PokemonApplication.getPokemonApiService().getPokemon(id);
        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                // listener.onSuccess(response.body());
                basePresenter.getPokemon(response.body());
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {

            }
        });
    }

    public void getGeneration(int id, final BasePresenter basePresenter)
    {
        Call<List<Pokemon>> call = PokemonApplication.getPokemonApiService().getGeneration(id);
        call.enqueue(new Callback<List<Pokemon>>() {
            @Override
            public void onResponse(Call<List<Pokemon>> call, Response<List<Pokemon>> response) {
                basePresenter.getGeneration(response.body());
            }

            @Override
            public void onFailure(Call<List<Pokemon>> call, Throwable t) {

            }
        });
    }

    public void getAllPokemon(final BasePresenter basePresenter)
    {
        Call<List<Pokemon>> call = PokemonApplication.getPokemonApiService().getAllPokemon();
        call.enqueue(new Callback<List<Pokemon>>() {
            @Override
            public void onResponse(Call<List<Pokemon>> call, Response<List<Pokemon>> response) {
                basePresenter.getAllPokemon(response.body());
            }

            @Override
            public void onFailure(Call<List<Pokemon>> call, Throwable t) {

            }
        });
    }

    public Pokemon getPokemonSync(int id) {


        try {
            Call<Pokemon> call = PokemonApplication.getPokemonApiService().getPokemon(id);
            Response<Pokemon> response = call.execute();
            if(response.isSuccessful()) {
                Pokemon p = response.body();
                return p;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public interface IPokemon {
        void onSuccess(Pokemon p);
    }

}
