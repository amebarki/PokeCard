package team8.com.pokecard.presentation.presenter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.telecom.Call;
import android.util.Log;

import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import java.util.List;

import team8.com.pokecard.R;
import team8.com.pokecard.data.manager.Navigator;
import team8.com.pokecard.data.manager.PokemonManager;
import team8.com.pokecard.data.manager.UserManager;
import team8.com.pokecard.data.model.Pokemon;
import team8.com.pokecard.presentation.ui.view.LoginView;

/**
 * Created by Adam on 02/03/2018.
 */

public class LoginPresenter {


    private Context context;
    private LoginView loginView;
    private static String TAG = "FIREBASE";
    private static final int RC_SIGN_IN = 100;
    private UserManager userManager = null;
    public LoginPresenter(Context context, LoginView view) {
        this.context = context;
        this.loginView = view;
        userManager = Navigator.getInstance().getUserManager();
    }


    public GoogleSignInClient initGoogleSignIn() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(context.getString(R.string.client_google_token))
                .requestEmail()
                .build();
        return GoogleSignIn.getClient(context, gso);
    }


    public CallbackManager initFacebookSignIn() {
        FacebookSdk.sdkInitialize(context);
        AppEventsLogger.activateApp(context);
        return CallbackManager.Factory.create();
    }

    public void startConnection(int requestCode, int resultCode, Intent data, CallbackManager callbackManager) {
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount account = task.getResult(ApiException.class);
                loginView.firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                Log.w(TAG, "Google sign in failed", e);
            }
        } else {
            callbackManager.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void recupAccessToken(LoginResult loginResult) {
        loginView.firebaseAuthWithFacebook(loginResult.getAccessToken());
    }

    public void fireBaseSignInWithCredential(@NonNull Task<AuthResult> task,FirebaseAuth mAuth,String socialNetworkName) {
        if (task.isSuccessful()) {
            Log.d(TAG, "signInWithCredential:success");
            FirebaseUser user = mAuth.getCurrentUser();
            userManager.createUser(user,this);
            userManager.userExist(this);
            // verify if user is new  or not
        } else {
            Log.w(TAG, "signInWithCredential:failure", task.getException());
            //display error
        }
    }

    public void launchBoosterPackActivity(){

            loginView.launchBoosterPack();
    }

    public void launchHomeActivity()
    {
            loginView.launchHome();
    }


    public void errorMessage(String message)
    {

    }

}
