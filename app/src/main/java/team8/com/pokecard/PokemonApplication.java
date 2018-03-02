package team8.com.pokecard;

import android.app.Application;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import team8.com.pokecard.data.manager.Navigator;
import team8.com.pokecard.webservice.PokemonApiService;

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
    final public static String API_BASE_URL = "http://192.168.43.19/pokecard/index.php/";
    final public static String API_BASE_URL_ADAM = "http://172.31.246.100/pokecard/index.php/";
    @Override
    public void onCreate() {
        super.onCreate();
        application = this;

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(API_BASE_URL_ADAM)
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
