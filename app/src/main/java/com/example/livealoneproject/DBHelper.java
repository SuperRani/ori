package com.example.livealoneproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DBFILE = "dbfile" ;

    public DBHelper(Context context){
        super(context, DBFILE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE checklist " +
                "(_id integer PRIMARY KEY AUTOINCREMENT, " +
                "key_num TEXT, " +
                "image TEXT, " +
                "place TEXT, " +
                "day TEXT," +
                "estate TEXT," +
                "address TEXT);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table checklist");
        onCreate(db);

    }
}
