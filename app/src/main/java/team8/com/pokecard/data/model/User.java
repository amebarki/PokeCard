package team8.com.pokecard.data.model;

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
    public User(){

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
