package team8.com.pokecard.Service;

import java.util.List;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import team8.com.pokecard.data.manager.PokemonDatabaseManager;
import team8.com.pokecard.data.manager.PokemonManager;
import team8.com.pokecard.data.model.Pokemon;

/**
 * Created by iem on 15/11/2017.
 */

public interface PokemonApiService {


    // GET API

    @GET("pokemon/get/{id}")
    Call<Pokemon> getPokemon(@Path("id") int id);

    @GET("pokemon/generation/get/{id}")
    Call<List<Pokemon>> getGeneration(@Path("id") int id);

    @GET("pokemon/all")
    Call<List<Pokemon>> getAllPokemon();



    @GET("local/users/get/{id]}/pokemon/list")
    Call<List<Pokemon>> getUserListPokemon(@Path("id") int id);

    @GET("/local/users/facebook/get/{id}")
    Call<Integer> getUserIdByFacebook(@Path("id")int id);

    @GET("/local/users/google/get/{id}")
    Call<Integer> getUserIdByGoogle(@Path("id")int id);

    //Post Database

    // Post for exchange pokemon

    @FormUrlEncoded
    @POST("local/users/offer")
    Call offerPokemon(@Field("user_id") int user_id,
                      @Field("pokemon_offer_id") int pokemon_offer_id,
                      @Field("pokemon_wanted_id") int pokemon_wanted_id);


    @FormUrlEncoded
    @POST("local/users/accept")
    Call acceptExchange(@Field("user2_id")int user2_id,
                        @Field("exchange_id") int exchange_id,
                        @Field("offer_accepted") int offer_accepted);


    @FormUrlEncoded
    @POST("pokemon/receive")
    Call<PokemonDatabaseManager.CodeReturn> insertNewPokemon(@Field("id") int id,
                                                             @Field("name") String name);


    /*
    @FormUrlEncoded
    @POST("users/new")
    Call<PokemonDatabaseManager.CodeReturn> insertNewUser(@Field("id") int id,
                                                          @Field("name") String name);
    @FormUrlEncoded
    @POST("users/list/")
    Call<List<Pokemon>> getListPokemon(@Field("id") int id, @Field("name") String name);*/
}