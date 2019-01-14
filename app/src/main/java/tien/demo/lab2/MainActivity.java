package tien.demo.lab2;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editEt;
    private Button button;
    private EditText editcheckma;
    private Button btncheck;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //bai1----------------------------------------------------
        MyBr myBr=new MyBr();
        final IntentFilter filter = new IntentFilter("android.intent.action.NEW_OUTGOING_CALL");
        registerReceiver(myBr, filter);
        NetworkChangeReceiver receiver = new NetworkChangeReceiver();
        final IntentFilter filter1 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(receiver, filter1);
        //bai2----------------------------------------------------------
        editEt = (EditText) findViewById(R.id.editEt);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("name",editEt.getText().toString());
                intent.setAction("fpoly.android.CUSTOM_INTENT");
                sendBroadcast(intent);
            }
        });
        TestBr testBr=new TestBr();
        final IntentFilter filter3 = new IntentFilter("fpoly.android.CUSTOM_INTENT");
        registerReceiver(testBr, filter3);
        //bai2---------------------------------------------------
        editcheckma = (EditText) findViewById(R.id.editcheckma);
        btncheck = (Button) findViewById(R.id.btncheck);
        btncheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent();
                intent1.putExtra("code",editcheckma.getText().toString());
                intent1.setAction("tien.android.CHECK_CODE");
                sendBroadcast(intent1);
            }
        });
    }
}
