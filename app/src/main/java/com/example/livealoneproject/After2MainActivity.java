package com.example.livealoneproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class After2MainActivity extends AppCompatActivity {

    Button link1,link2;

    Intent i;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after2_main);

        context=this;

        link1=(Button) findViewById(R.id.link1);
        link2=(Button) findViewById(R.id.link2);

        link1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i=new Intent(context,Link1Activity.class));
            }
        });

        link2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i=new Intent(context,Link2Activity.class));
            }
        });
    }
}
