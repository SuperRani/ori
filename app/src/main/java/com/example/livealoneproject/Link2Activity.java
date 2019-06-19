package com.example.livealoneproject;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Link2Activity extends AppCompatActivity {

    Intent i;
    Context context;

    ImageButton shop1,shop2,shop3,shop4,shop5,shop6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link2);

        i=getIntent();
        context=this;

        shop1=(ImageButton) findViewById(R.id.shop1);
        shop2=(ImageButton) findViewById(R.id.shop2);
        shop3=(ImageButton) findViewById(R.id.shop3);
        shop4=(ImageButton) findViewById(R.id.shop4);
        shop5=(ImageButton) findViewById(R.id.shop5);
        shop6=(ImageButton) findViewById(R.id.shop6);

        shop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ssg.com/")));
            }
        });

        shop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.kurly.com/shop/main/index.php?NaPm=ct%3Djx24i5cz%7Cci%3Dcheckout%7Ctr%3Dds%7Ctrx%3D%7Chk%3D0614a1d4b9b6cdcab3062902a238c8aeb546c812")));
            }
        });

        shop3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i=new Intent(Intent.ACTION_VIEW, Uri.parse("https://store.kakao.com/promotion/115?ad=farmer_pf_actionbt")));
            }
        });

        shop4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i=new Intent(Intent.ACTION_VIEW, Uri.parse("http://dshop.dietshin.com/?NaPm=ct%3Djx24kloi%7Cci%3Dcheckout%7Ctr%3Dds%7Ctrx%3D%7Chk%3D1f39cad5f7ed1049f2ca95732a95e4c05826ff18")));
            }
        });

        shop5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.bodydak.com/")));
            }
        });

        shop6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i=new Intent(Intent.ACTION_VIEW, Uri.parse("https://danoshop.net/?NaPm=ct%3Djx24lpmb%7Cci%3Dcheckout%7Ctr%3Dds%7Ctrx%3D%7Chk%3D197a63680ca3ff3dd3f3abeddc0cb19679e83807")));
            }
        });
    }
}
