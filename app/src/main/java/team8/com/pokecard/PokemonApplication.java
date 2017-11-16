package team8.com.pokecard;

import android.app.Application;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import team8.com.pokecard.Service.PokemonService;

/**
 * Created by iem on 15/11/2017.
 */

public class PokemonApplication extends Application {

    private static PokemonService pokemonService;


    @Override
    public void onCreate()
    {
        super.onCreate();
        String API_BASE_URL = "http://pokecard.local/index.php/";

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(API_BASE_URL)
                        .addConverterFactory(
                                GsonConverterFactory.create()
                        );

        Retrofit retrofit =
                builder
                        .client(
                                httpClient.build()
                        )
                        .build();

        PokemonService client =  retrofit.create(PokemonService.class);

    }

    public static PokemonService getPokemonService() {
        return pokemonService;
    }
}
