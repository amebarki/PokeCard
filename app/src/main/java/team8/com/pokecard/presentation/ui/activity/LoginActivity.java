package team8.com.pokecard.presentation.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import team8.com.pokecard.R;
import team8.com.pokecard.data.manager.Navigator;
import team8.com.pokecard.data.model.User;
import team8.com.pokecard.presentation.presenter.LoginPresenter;
import team8.com.pokecard.presentation.ui.view.LoginView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, LoginView {

    private static final int RC_SIGN_IN = 100;
    private User user;
    private static String TAG = "FIREBASE";
    private SignInButton signInButton;
    private FirebaseAuth mAuth;
    private GoogleSignInClient mGoogleSignInClient;
    public CallbackManager callbackManager;

    private LoginPresenter loginPresenter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginPresenter = Navigator.getInstance().getLoginPresenter(this, this);
        mGoogleSignInClient = loginPresenter.initGoogleSignIn();
        callbackManager = loginPresenter.initFacebookSignIn();
        this.initializeComponents();
        mAuth = FirebaseAuth.getInstance();

    }


    private void initializeComponents() {
        //Google
        signInButton = findViewById(R.id.sign_in_google_button);
        signInButton.setSize(SignInButton.SIZE_STANDARD);
        signInButton.setOnClickListener(this);
        //Facebook

        LoginButton loginButton = findViewById(R.id.sign_in_facebook_button);
        loginButton.setReadPermissions("email");
        loginButton.registerCallback(callbackManager, new MyFacebookCallback());
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == signInButton.getId()) {
            signIn();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        loginPresenter.startConnection(requestCode, resultCode, data,callbackManager);
    }

    @Override
    public void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());
        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        loginPresenter.fireBaseSignInWithCredential(task, mAuth,getString(R.string.google_name));
                    }
                });
    }

    @Override
    public void firebaseAuthWithFacebook(AccessToken token) {
        Log.d(TAG, "handleFacebookAccessToken:" + token);

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        loginPresenter.fireBaseSignInWithCredential(task,mAuth,getString(R.string.facebook_name));
                    }
                });
    }

    private void goToMenu() {
        Intent menuIntent = new Intent(this, HomeActivity.class);
        startActivity(menuIntent);
    }

    @Override
    public void launchHome() {
       //goToMenu();
    }

    @Override
    public void launchBoosterPack() {
            // open BoosterPack
    }

    @Override
    public void DisplayErrorMessage() {

    }

    @Override
    public void DisplayInformationMessage() {

    }

    private class MyFacebookCallback implements FacebookCallback<LoginResult> {
        @Override
        public void onSuccess(LoginResult loginResult) {
            loginPresenter.recupAccessToken(loginResult);
//            goToMenu();
        }

        @Override
        public void onCancel() {
            Log.d(TAG, "facebook:onCancel");
            Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.connection_error), Toast.LENGTH_SHORT);
            toast.show();
        }

        @Override
        public void onError(FacebookException error) {
            Log.d(TAG, "facebook:onError", error);

        }
    }

}