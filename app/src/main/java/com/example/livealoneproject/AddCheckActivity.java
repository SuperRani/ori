package com.example.livealoneproject;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class AddCheckActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText edit_place;
    private EditText edit_day;
    private EditText edit_estate;
    private EditText edit_address;
    private Button btn_insert;
    private Button btn_update;
    private CheckBox house;
    private CheckBox villa;
    private CheckBox apart;
    private int update_index;
    Intent intent;
    boolean isUpdate = false;
//    private boolean isChecked = false;

//    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_check);


//
//        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
//                .setTimestampsInSnapshotsEnabled(true)
//                .build();
//        mstore.setFirestoreSettings(settings);

        edit_place = (EditText)findViewById(R.id.edit_place);
        edit_day = (EditText)findViewById(R.id.edit_day);
        edit_estate = (EditText)findViewById(R.id.edit_estate);
        edit_address = (EditText)findViewById(R.id.edit_address);

        btn_insert = (Button)findViewById(R.id.btn_insert);
        btn_update = (Button)findViewById(R.id.btn_update);

        house = (CheckBox)findViewById(R.id.house);
        villa = (CheckBox)findViewById(R.id.villa);
        apart = (CheckBox)findViewById(R.id.apart);

        btn_insert.setOnClickListener(this);
        btn_update.setOnClickListener(this);
        house.setOnClickListener(this);
        villa.setOnClickListener(this);
        apart.setOnClickListener(this);
        intent = getIntent();
        update_index = intent.getIntExtra("index", 0);
        isUpdate = intent.getBooleanExtra("update", false);
//        update_index = intent.getIntExtra("index", 0);
        if(update_index != 0){
            DBHelper helper = new DBHelper(this);
            SQLiteDatabase db = helper.getWritableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM  checklist", null);
            if(cursor != null){
                cursor.moveToFirst();
                while(cursor.moveToNext()){
                    String key_num = cursor.getString(cursor.getColumnIndex("key_num"));
                    if(update_index == Integer.parseInt(key_num)){
                        String place = cursor.getString(cursor.getColumnIndex("place"));
                        String address = cursor.getString(cursor.getColumnIndex("address"));
                        String estate = cursor.getString(cursor.getColumnIndex("estate"));
                        String day = cursor.getString(cursor.getColumnIndex("day"));
                        String image = cursor.getString(cursor.getColumnIndex("image"));
                        if(image.equals("house")){
                            house.setChecked(true);
                        } else if(image.equals("villa")){
                            villa.setChecked(true);
                        } else {
                            apart.setChecked(true);
                        }

                        edit_place.setText(place);
                        edit_address.setText(address);
                        edit_estate.setText(estate);
                        edit_day.setText(day);
                    }
                }
            }
        }
    }

    @Override
    public void onClick(View v) {
        if(v == house){
            if(villa.isChecked() || apart.isChecked()){
                house.setChecked(false);
                Toast.makeText(this, "중복 선택 불가능", Toast.LENGTH_SHORT).show();
            }
        }
        if(v == villa){
            if(house.isChecked() || apart.isChecked()){
                villa.setChecked(false);
                Toast.makeText(this, "중복 선택 불가능", Toast.LENGTH_SHORT).show();
            }
        }

        if(v == apart){
            if(house.isChecked() || villa.isChecked()){
                apart.setChecked(false);
                Toast.makeText(this, "중복 선택 불가능", Toast.LENGTH_SHORT).show();
            }
        }
        // checkbox를 선택할 때 중복 선택이 불가능하게 만듬 (중복 선택시 잘못된 데이터값이 넘어갈 우려)

        if(v == btn_update){
            if(edit_address.getText().toString().equals("") || edit_day.getText().toString().equals("") || edit_estate.getText().toString().equals("") || edit_place.getText().toString().equals("")){
                Toast.makeText(this, "모두 입력해주세요.", Toast.LENGTH_SHORT).show();
            } else if(!isUpdate){
                Toast.makeText(this, "추가모드일땐 수정이 불가능합니다.", Toast.LENGTH_SHORT).show();
            } else {
                DBHelper helper = new DBHelper(this);
                SQLiteDatabase db = helper.getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put("address", edit_address.getText().toString());
                values.put("day", edit_day.getText().toString());
                values.put("estate", edit_estate.getText().toString());
                values.put("place", edit_place.getText().toString());
                // 3가지의 체크박스 중 선택된 체크박스를 인식해서 house, villa, apart 세가지 String값을 db에 저장
                if(house.isChecked()){
                    values.put("image", "house");
                } else if(villa.isChecked()){
                    values.put("image", "villa");
                } else if(apart.isChecked()){
                    values.put("image", "apart");
                }

                db.update("checklist", values, "key_num = " + update_index, null);
                db.close();

                Toast.makeText(this, "수정되었습니다.", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent();
                intent.putExtra("item", values);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        }

        if(v == btn_insert) {
            if (edit_address.getText().toString().equals("") || edit_day.getText().toString().equals("") || edit_estate.getText().toString().equals("") || edit_place.getText().toString().equals("")) {
                Toast.makeText(this, "모두 입력해주세요.", Toast.LENGTH_SHORT).show();
            } else if(isUpdate){
                Toast.makeText(this, "수정모드에선 추가가 불가능합니다.", Toast.LENGTH_SHORT).show();
            }else {
                DBHelper helper = new DBHelper(this);
                SQLiteDatabase db = helper.getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put("address", edit_address.getText().toString());
                values.put("day", edit_day.getText().toString());
                values.put("estate", edit_estate.getText().toString());
                values.put("place", edit_place.getText().toString());
                values.put("key_num", update_index + 1);
                Log.e("size", update_index + "");
                // 3가지의 체크박스 중 선택된 체크박스를 인식해서 house, villa, apart 세가지 String값을 db에 저장
                if(house.isChecked()){
                    values.put("image", "house");
                } else if(villa.isChecked()){
                    values.put("image", "villa");
                } else if(apart.isChecked()){
                    values.put("image", "apart");
                }

                db.insert("checklist", null, values);
                db.close();

                Toast.makeText(this, "저장되었습니다.", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent();
                intent.putExtra("item", values);
                setResult(Activity.RESULT_OK, intent);
                intent.putExtra("index", update_index);
                finish();
                // 원래는 finish();로 깔려있던 화면으로 돌아가지만 데이터 갱신을 위해 종료하고 새로운 액티비티로 이동
            }


        }

//        id = mstore.collection("ListItem").document().getId();
//        Map<String, Object> post = new HashMap<>();
//        post.put("id", id);
//        post.put("place", edit_place.getText().toString());
//        post.put("day", edit_day.getText().toString());
//        post.put("estate", edit_estate.getText().toString());
//        post.put("address", edit_address.getText().toString());
//        mstore.collection("ListItem").document(id).set(post)
//
//                    .addOnSuccessListener(new OnSuccessListener<Void>() {
//                        @Override
//                        public void onSuccess(Void aVoid) {
//                            Toast.makeText(AddCheckActivity.this, "업로드 성공", Toast.LENGTH_SHORT).show();
//                            finish();
//                        }
//                    })
//                    .addOnFailureListener(new OnFailureListener() {
//                @Override
//                public void onFailure(@NonNull Exception e) {
//                    Toast.makeText(AddCheckActivity.this, "업로드 실패", Toast.LENGTH_SHORT).show();
//                }
//            });







    }
}
