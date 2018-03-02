package team8.com.pokecard.presentation.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.SignInButton;

import team8.com.pokecard.R;
import team8.com.pokecard.data.model.User;
import team8.com.pokecard.service.GoogleSignIn;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int RC_SIGN_IN = 100;
    GoogleSignIn googleSignIn;
    public CallbackManager callbackManager;
    private SignInButton googleButton;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        googleButton = findViewById(R.id.sign_in_google_button);
        googleSignIn = new GoogleSignIn(this);
        addSignInGoogleButtonListener();

        callbackManager = CallbackManager.Factory.create();
        LoginButton loginButton = findViewById(R.id.sign_in_facebook_button);
        loginButton.setReadPermissions("email");
        loginButton.registerCallback(callbackManager, new MyFacebookCallback());

    }


    private void addSignInGoogleButtonListener() {
        SignInButton signInGoogle = findViewById(R.id.sign_in_google_button);
        signInGoogle.setOnClickListener(this);
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

            @Override
            public void onClick (View view){
                if (view.getId() == googleButton.getId()) {
                    googleClick(view);
                }
            }

        private void goToMenu () {
            Intent menuIntent = new Intent(this, HomeActivity.class);
            startActivity(menuIntent);

        }

        private class MyFacebookCallback implements FacebookCallback<LoginResult> {
            @Override
            public void onSuccess(LoginResult loginResult) {
                goToMenu();
            }

            @Override
            public void onCancel() {
                Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.connection_error), Toast.LENGTH_SHORT);
                toast.show();
            }

            @Override
            public void onError(FacebookException error) {

            }
        }
    }