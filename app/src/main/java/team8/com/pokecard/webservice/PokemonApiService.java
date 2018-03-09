package team8.com.pokecard.webservice;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import team8.com.pokecard.data.manager.PokemonManager;
import team8.com.pokecard.data.model.Exchange;
import team8.com.pokecard.data.model.Pokemon;
import team8.com.pokecard.data.model.User;

/**
 * Created by iem on 15/11/2017.
 */

public interface PokemonApiService {


    /**
     * POKEMON FROM API
     */

    @GET("pokemon/get/{id}")
    Call<Pokemon> getPokemon(@Path("id") int id);

    @GET("pokemon/generation/get/{id}")
    Call<List<Pokemon>> getGeneration(@Path("id") int id);

    @GET("pokemon/all")
    Call<List<Pokemon>> getAllPokemon();


    /**
     * POKEMON OF USER
     */

    // Send email and recup pokemon need to modify PHP WEB SERVICE
    @GET("local/users/get/{email}/pokemon/list")
    Call<List<Pokemon>> getUserListPokemon(@Path("email") String email);

    @GET("local/users/get/{email}")
    Call<User> getUser(@Path("email") String email);

    @GET("local/users/get/{email}/pokemon/booster")
    Call<List<Pokemon>> getBoosterPack(@Path("email") String email);


    @FormUrlEncoded
    @POST("local/users/new")
    Call<String> createUser(@Field("name") String name,
                             @Field("email") String email);



    @POST("local/pokemon/new")
    Call<Integer> insertUserPokemon(@Field("id") int id,
                                    @Field("name") String name,
                                    @Field("sprite") String sprite,
                                    @Field("description") String description,
                                    @Field("type1") String type1,
                                    @Field("type2") String type2);
    /**
     * CALL FOR EXCHANGE POKEMON BETWEEN USERS
     */

    @GET("local/users/list/offer")
    Call<List<Exchange>> listExchangeOfPokemons();

    @FormUrlEncoded
    @POST("local/users/offer")
    Call<Integer> offerPokemon(@Field("email") String user_email,
                      @Field("pokemon_offer_id") int pokemon_offer_id,
                      @Field("pokemon_wanted_id") int pokemon_wanted_id,
                      @Field("offer_accepted") int offer_accepted);


    @FormUrlEncoded
    @POST("local/users/accept")
    Call acceptExchange(@Field("user2_email") String user2_email,
                        @Field("exchange_id") int exchange_id,
                        @Field("offer_accepted") int offer_accepted);


    /*
    @FormUrlEncoded
    @POST("users/new")
    Call<PokemonDatabaseManager.CodeReturn> insertNewUser(@Field("id") int id,
                                                          @Field("name") String name);
    @FormUrlEncoded
    @POST("users/list/")
    Call<List<Pokemon>> getListPokemon(@Field("id") int id, @Field("name") String name);*/
}
