package com.example.broadcaseDemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by dingli on 2015-8-18.
 */
public class CastActivityTwo extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cast_activity);
        TextView textView=(TextView)findViewById(R.id.tv2);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BroadcastActivity.SMS);
                CastActivityTwo.this.sendBroadcast(intent);
            }
        });
    }
}