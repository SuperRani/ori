package com.example.livealoneproject;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public Button beforeBtn;
    public Button afterBtn;
    public Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        beforeBtn = (Button)findViewById(R.id.beforeBtn);
        afterBtn = (Button)findViewById(R.id.afterBtn);

        beforeBtn.setOnClickListener(this);
        afterBtn.setOnClickListener(this);
        context = this;
    }

    @Override
    public void onClick(View v) {
        if(v == beforeBtn){
            PopupMenu p = new PopupMenu(getApplicationContext(), v);
            getMenuInflater().inflate(R.menu.popupmenu, p.getMenu());
            p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    switch (item.getItemId()){

                        // 체크리스트
                        case R.id.popupCheck:
                            Intent i = new Intent(context, CheckActivity.class);
                            startActivity(i);
                            break;
                        case R.id.popupEstate:
                            startActivity(new Intent(context, EstateMap.class));
                            break;

                    }
                    return false;

                }
            });
            p.show();

        }else if(v == afterBtn){
            PopupMenu p = new PopupMenu(getApplicationContext(), v);
            getMenuInflater().inflate(R.menu.popupmenuafter, p.getMenu());
            p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    switch (item.getItemId()){

                        case R.id.popup:

                            PackageManager pm =getPackageManager();
                            Intent intent = pm.getLaunchIntentForPackage("com.example.leejinseong.nomadhackathone");
                            intent.setAction(Intent.ACTION_MAIN);
                            startActivity(intent);
                            break;

                        case R.id.popup2:

                            startActivity(intent=new Intent(context,After2MainActivity.class));
                            break;

                    }
                    return false;

                }
            });
            p.show();

        }


    }
}
