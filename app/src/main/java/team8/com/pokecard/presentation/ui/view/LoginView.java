package team8.com.pokecard.presentation.ui.view;

import com.facebook.AccessToken;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

/**
 * Created by Adam on 02/03/2018.
 */

public interface LoginView {

    void launchHome();
    void firebaseAuthWithGoogle(GoogleSignInAccount account);
    void firebaseAuthWithFacebook(AccessToken token);
}
