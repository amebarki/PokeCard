package team8.com.pokecard.Service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import team8.com.pokecard.data.model.Pokemon;

/**
 * Created by iem on 15/11/2017.
 */

public interface PokemonService {

    @GET("pokemon/get/{id}")
    Call<Pokemon> getPokemon(@Path("id") int id);

    @GET("pokemon/generation/get/{id}")
    Call<List<Pokemon>> getGeneration(@Path("id") int id);

    @GET("pokemon/all")
    Call<List<Pokemon>> getAllPokemon();

}
