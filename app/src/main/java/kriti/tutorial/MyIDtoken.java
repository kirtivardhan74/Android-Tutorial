package kriti.tutorial;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MyIDtoken extends FirebaseInstanceIdService {
    public MyIDtoken() {
    }

    @Override
    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d("token",refreshedToken);

        super.onTokenRefresh();
    }



    }

