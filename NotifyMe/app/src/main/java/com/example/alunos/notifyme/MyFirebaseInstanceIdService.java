package com.example.alunos.notifyme;

import android.util.Log;

/**
 * Created by alunos on 19/10/17.
 */

public class MyFirebaseInstanceIdService {
    private static final String TAG = "MFIdService";

    @Override
    public void onTokenRefresh(){
        String refreshedToken = FirebaseIntancedId.getInstance().getToken();
        Log.d(TAG, "Token atualizado: " + refreshedToken);
        sendRegistrationToServer(refreshedToken);
    }

    private void sendRegistrationToServer(String refreshedToken){

    }
}
