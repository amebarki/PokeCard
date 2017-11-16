package team8.com.pokecard.manager;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import team8.com.pokecard.PokemonApplication;
import team8.com.pokecard.Service.PokemonService;
import team8.com.pokecard.model.Pokemon;

/**
 * Created by iem on 15/11/2017.
 */

public class PokemonManager {

    private static PokemonManager ourInstance;

    public static PokemonManager getInstance() {
        if(ourInstance == null) {
            ourInstance = new PokemonManager();
        }
        return ourInstance;
    }



    private PokemonManager() {

    }

    public void getPokemon(int id, final IPokemon listener) {

        Call<Pokemon> call = PokemonApplication.getPokemonService().getPokemon(id);

        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                 listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {

            }
        });


    }

    public Pokemon getPokemonSync(int id) {


        try {
            Call<Pokemon> call = PokemonApplication.getPokemonService().getPokemon(id);
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
