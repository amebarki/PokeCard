package team8.com.pokecard;

import android.app.Application;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import team8.com.pokecard.Service.PokemonService;

public class PokemonApplication extends Application {

    private static PokemonService pokemonService;
    final public static int PRINT_LIST_ALL = 1;
    final public static int PRINT_LIST_GENERATION = 2;
    final public static int PRINT_LIST_ONE = 3;


    @Override
    public void onCreate() {
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

       pokemonService =  retrofit.create(PokemonService.class);

    }

    public static PokemonService getPokemonService() {
        return pokemonService;
    }
}
