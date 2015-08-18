package com.example.broadcaseDemo;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class BroadcastActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        TextView tv=(TextView)findViewById(R.id.tv);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent().setClass(BroadcastActivity.this, CastActivityTwo.class);
                BroadcastActivity.this.startActivity(intent);

            }
        });
        IntentFilter intentFilter=new IntentFilter(SMS);
        registerReceiver(Myreceive, intentFilter);

    }
    public static String SMS="com.ding.sms";
    BroadcastReceiver Myreceive=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals(SMS)){
                Log.i("AAAD","onReceive");
                Toast.makeText(getApplicationContext(),"ding ding",Toast.LENGTH_LONG).show();
            }

        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("AAAD","onPause");
//        unregisterReceiver(Myreceive);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("AAAD", "onStop");
//        unregisterReceiver(Myreceive);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("AAAD", "onDestroy");
        unregisterReceiver(Myreceive);
    }
}
