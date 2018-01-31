package team8.com.pokecard.data.manager;

/**
 * Created by Adam on 31/01/2018.
 */

public class UserManager {

    private static UserManager ourInstance;
    public static UserManager getInstance() {
        if(ourInstance == null) {
            ourInstance = new UserManager();
        }
        return ourInstance;
    }


}
