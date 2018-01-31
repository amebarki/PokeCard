package team8.com.pokecard;

import android.app.Application;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import team8.com.pokecard.Service.PokemonApiService;

/**
 * Created by iem on 15/11/2017.
 */

@SuppressWarnings("AssignmentToStaticFieldFromInstanceMethod")
public class PokemonApplication extends Application {

    private static PokemonApiService pokemonApiService;
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
                                ScalarsConverterFactory.create())
                        .addConverterFactory(
                                GsonConverterFactory.create()
                        );
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(logging);
        Retrofit retrofit =
                builder
                        .client(
                                httpClient.build()
                        )
                        .build();

        pokemonApiService = retrofit.create(PokemonApiService.class);
    }

    public static PokemonApiService getPokemonApiService() {
        return pokemonApiService;
    }



}
