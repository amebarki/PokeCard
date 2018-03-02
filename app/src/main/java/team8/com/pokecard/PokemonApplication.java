package team8.com.pokecard;

import android.app.Application;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import team8.com.pokecard.Service.PokemonApiService;
import team8.com.pokecard.data.manager.Navigator;
import team8.com.pokecard.data.manager.PokemonDatabaseManager;
import team8.com.pokecard.data.manager.PokemonManager;
import team8.com.pokecard.data.manager.UserManager;

/**
 * Created by iem on 15/11/2017.
 */

@SuppressWarnings("AssignmentToStaticFieldFromInstanceMethod")
public class PokemonApplication extends Application {

    private static PokemonApplication application;
    private static PokemonApiService pokemonApiService;
    final public static int PRINT_LIST_ALL = 1;
    final public static int PRINT_LIST_GENERATION = 2;
    final public static int PRINT_LIST_ONE = 3;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        String API_BASE_URL = "http://172.31.246.100/pokecard/index.php/";
//172.31.246.100
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
        Navigator.getInstance().init();
    }

    public static PokemonApplication getApplication() {
        return application;
    }

    public static PokemonApiService getPokemonApiService() {
        return pokemonApiService;
    }


}
