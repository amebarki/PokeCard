package team8.com.pokecard.data.manager;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import team8.com.pokecard.PokemonApplication;
import team8.com.pokecard.data.model.Pokemon;

/**
 * Created by Adam on 13/12/2017.
 */

public class PokemonDatabaseManager {

    private static PokemonDatabaseManager ourInstance;

    public static PokemonDatabaseManager getInstance() {
        if(ourInstance == null) {
            ourInstance = new PokemonDatabaseManager();
        }
        return ourInstance;
    }


    private PokemonDatabaseManager() {

    }


    public void sendPokemon(){
        Pokemon poke = new Pokemon(151,"Mewtwo","sprite");
        Call<PokemonDatabaseManager.CodeReturn> call = PokemonApplication.getPokemonApiService().insertNewPokemon(poke.getId(),poke.getName());
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
            public void onFailure(Call<PokemonDatabaseManager.CodeReturn> call, Throwable t) {
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
