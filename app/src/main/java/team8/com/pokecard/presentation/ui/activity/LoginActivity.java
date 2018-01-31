package team8.com.pokecard.presentation.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.SignInButton;

import org.json.JSONObject;

import team8.com.pokecard.R;
import team8.com.pokecard.data.model.User;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int RC_SIGN_IN = 100;
    GoogleSignIn googleSignIn;
    public CallbackManager callbackManager;
    public Button googleButton;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        googleSignIn = new GoogleSignIn(this);
        addSignInGoogleButtonListener();

        callbackManager = CallbackManager.Factory.create();
        LoginButton loginButton = (LoginButton) findViewById(R.id.sign_in_facebook_button);
        loginButton.setReadPermissions("email");
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        user = new User();
                        user.getFacebookData(object);
                    }
                });
                goToMenu();
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == googleButton.getId()) {
            Context context = getApplicationContext();
            CharSequence text = "Hello toast!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();


        }
    }

    private void addSignInGoogleButtonListener() {
        SignInButton signInGoogle = findViewById(R.id.sign_in_google_button);
        signInGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                googleClick(view);
            }
        });
    }

    public void googleClick(View view) {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(googleSignIn.mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()) {
                user = new User();
                user.setIdGoogle(Integer.getInteger(result.getSignInAccount().getId()));
                goToMenu();
            }
        }
    }

    private void goToMenu() {
//        Intent menuIntent = new Intent(this, MenuActivity.class);
//        startActivity(menuIntent);

        Intent detailIntent = new Intent(this, DetailPokemonActivity.class);
        startActivity(detailIntent);

    }
}