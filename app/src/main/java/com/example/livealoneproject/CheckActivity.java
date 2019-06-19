package com.example.livealoneproject;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

public class CheckActivity extends AppCompatActivity implements View.OnClickListener {


    private RecyclerView main_recyclerView;
    private AdapterListView mainAdapter;

    private final int ADD_ITEM = 0;

//    FirebaseFirestore mStore = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        main_recyclerView = (RecyclerView)findViewById(R.id.main_recyclerView);

        findViewById(R.id.main_write_button).setOnClickListener(this);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        main_recyclerView.setLayoutManager(mLayoutManager);

        mainAdapter = new AdapterListView();
        main_recyclerView.setAdapter(mainAdapter);

        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from checklist", null);

//        mStore.collection("ListItem").get()
//                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        if (task.isSuccessful()) {
//                            for (QueryDocumentSnapshot document : task.getResult()) {
//                                String id = (String) document.getData().get("id");
//                                String place =(String)document.getData().get("place");
//                                String day =(String)document.getData().get("day");
//                                String estate =(String)document.getData().get("estate");
//                                String address =(String)document.getData().get("address");
//
//                                ListItem data = new ListItem(id, place, day, estate, address);
////                                items.add(data);
//
//
//                            }
//                        }
//                    }
//                });
        if(cursor != null){
            cursor.moveToFirst();
            while(cursor.moveToNext()){
                String place = cursor.getString(cursor.getColumnIndex("place"));
                String address = cursor.getString(cursor.getColumnIndex("address"));
                String estate = cursor.getString(cursor.getColumnIndex("estate"));
                String day = cursor.getString(cursor.getColumnIndex("day"));
                String image = cursor.getString(cursor.getColumnIndex("image"));
                String index = cursor.getString(cursor.getColumnIndex("key_num"));
                Drawable getImage;
                if(image.equals("house")){
                    getImage = getResources().getDrawable(R.drawable.house);
                } else if(image.equals("villa")){
                    getImage = getResources().getDrawable(R.drawable.house1);
                } else {
                    getImage = getResources().getDrawable(R.drawable.ic_launcher_background);
                }
                // checkbox에 저장된 String값을 불러와서 3가지의 이미지 중 한가지로 선택
                // image = db에 저장된 String값 getImage = db에 저장된 String값으로 Drawable을 저장
                mainAdapter.addItem(new ListItem(getImage, place, day, estate, address, Integer.parseInt(index)));
            }
        }

//
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_write_button:
                Intent i = new Intent(getApplicationContext(), AddCheckActivity.class);
                int size = mainAdapter.getItemCount();
                i.putExtra("index", size);
                Log.e("size", size + "");
                startActivityForResult(i, ADD_ITEM);

                // 액티비티가 화면아래 깔려있어서 db 갱신이 안되는관계로 종료 (다음 화면에서 새로열리면서 데이터 초기화)
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==ADD_ITEM && resultCode == Activity.RESULT_OK) {
            ContentValues item = data.getParcelableExtra("item");
            String image = item.getAsString("image");
            String place = item.getAsString("place");
            String day = item.getAsString("day");
            String estate = item.getAsString("estate");
            String address = item.getAsString("address");
            String index = item.getAsString("key_num");
            Drawable getImage;
            if(image.equals("house")){
                getImage = getResources().getDrawable(R.drawable.house);
            } else if(image.equals("villa")){
                getImage = getResources().getDrawable(R.drawable.house1);
            } else {
                getImage = getResources().getDrawable(R.drawable.ic_launcher_background);
            }
            mainAdapter.addItem(new ListItem(getImage, place, day, estate, address, Integer.parseInt(index)));
            mainAdapter.notifyDataSetChanged();
        }
        if(requestCode== 1 && resultCode == Activity.RESULT_OK){
            Intent intent = new Intent(this, CheckActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
