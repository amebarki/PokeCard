package team8.com.pokecard.data.model;

import android.util.Log;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;

import org.json.JSONObject;

/**
 * Created by iem on 15/11/2017.
 */

public class User {

    private String name;
    private String emailFacebook;
    private String emailGoogle;
    private int idFacebook;
    private int idGoogle;
    private static String TAG="GOOOGLE";
    public User(){

    }

    public User(GoogleSignInAccount result)
    {
        Log.d(TAG,""+ result.getEmail());
        Log.d(TAG,""+ result.getId());
        Log.d(TAG,""+ result.getDisplayName());
        Log.d(TAG,""+ result.getFamilyName());
        Log.d(TAG,""+ result.getGivenName());
    }
    public User(String emailFacebook,String emailGoogle) {
        this.emailFacebook = emailFacebook;
        this.emailGoogle = emailGoogle;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailFacebook() {
        return emailFacebook;
    }

    public void setEmailFacebook(String emailFacebook) {
        this.emailFacebook = emailFacebook;
    }

    public String getEmailGoogle() {
        return emailGoogle;
    }

    public void setEmailGoogle(String emailGoogle) {
        this.emailGoogle = emailGoogle;
    }

    public void getFacebookData(JSONObject object)
    {

    }


    public void setIdGoogle(int idGoogle)
    {
        this.idGoogle = idGoogle;
    }

}
