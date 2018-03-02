package team8.com.pokecard.data.manager;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

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


    public PokemonManager()
    {

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

    public void sendPokemon(){
        Pokemon poke = new Pokemon(151,"Mewtwo","sprite");
        Call<CodeReturn> call = PokemonApplication.getPokemonApiService().insertNewPokemon(poke.getId(),poke.getName());
        call.enqueue(new Callback<CodeReturn>() {
            @Override
            public void onResponse(Call<CodeReturn> call, Response<CodeReturn> response) {

                if(response.isSuccessful())
                {
                    CodeReturn cr = response.body();
                    Log.d("POKEMON",cr.message);
                    Log.d("POKEMON","SUCCESS");
                }
            }

            @Override
            public void onFailure(Call<CodeReturn> call, Throwable t) {
                Log.d("POKEMON" ,"Erreur" + t.getMessage());
            }
        });

    }


    public class CodeReturn {
        @SerializedName("code")
        public int code;
        @SerializedName("name")
        public String message;
    }


}

