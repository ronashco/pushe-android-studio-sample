package co.ronash.pushesample.as;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


import co.ronash.pushe.Pushe;
import co.ronash.pushe.k.c;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Pushe.initialize(this, true);
        if(Pushe.isPusheInitialized(this)){
            Pushe.sendSimpleNotifToUser(this, Pushe.getPusheId(this), "Hi", "It is a notificatin from app to itself");
            try {
                Pushe.sendCustomJsonToUser(this, Pushe.getPusheId(this), "{\"key\": \"It is a json from app to itself\"}");
            } catch (co.ronash.pushe.k.c c) {
                Log.e("Pushe-AS-Sample", c.getMessage());
            }
        }
    }
}
