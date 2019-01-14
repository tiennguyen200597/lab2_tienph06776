package tien.demo.lab2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class checkBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String code= intent.getStringExtra("code");
       /* try {

        }*/


        //Toast.makeText(context, "dd"+dd, Toast.LENGTH_SHORT).show();
    }
}
