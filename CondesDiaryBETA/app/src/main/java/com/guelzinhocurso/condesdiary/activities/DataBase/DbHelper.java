package com.guelzinhocurso.condesdiary.activities.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public static int VERSION = 1;
    public static String NAME_DB = "DB_NAMES";
    public static String TABLE_NAMES = "TABLE_NAMES";

    public DbHelper(@Nullable Context context) {
        super(context, NAME_DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS TABLE_NAMES" + "(id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT NOT NULL, text TEXT NOT NULL);";

        try {
            db.execSQL(sql);

        }

        catch (Exception e){

        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
