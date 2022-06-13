package com.guelzinhocurso.condesdiary.activities.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.guelzinhocurso.condesdiary.activities.RecyclerView.ValuesList;

import java.util.ArrayList;
import java.util.List;

public class Dao implements iDao{

    private SQLiteDatabase write, read;

    public Dao (Context context) {
    DbHelper db = new DbHelper(context);
    write = db.getWritableDatabase();
    read = db.getReadableDatabase();
    }


    @Override
    public boolean save(ValuesList valuesList) {
        ContentValues cv = new ContentValues();
        cv.put("title", valuesList.getTitle());
        cv.put("text", valuesList.getText());

        try{
            write.insert(DbHelper.TABLE_NAMES, null, cv);
        }

        catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean update(ValuesList valuesList) {
        ContentValues cv = new ContentValues();
        cv.put("title", valuesList.getTitle());
        cv.put("text", valuesList.getText());
        try{
            String [] whereArgs = {valuesList.getId().toString()};
            write.update(DbHelper.TABLE_NAMES, cv, "id = ?",whereArgs);
        }

        catch (Exception e){

            return false;

        }
        return true;
    }

    @Override
    public boolean delete(ValuesList valuesList) {
        try {
            String [] args = {valuesList.getId().toString()};
            write.delete(DbHelper.TABLE_NAMES,"id = ?", args);
        }

        catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public List<ValuesList> list() {
        List<ValuesList> taskList = new ArrayList<>();

        String sql = "SELECT * FROM " + DbHelper.TABLE_NAMES + " ;";
        Cursor cursor = read.rawQuery(sql, null);

        while (cursor.moveToNext()){
            ValuesList task = new ValuesList();

            Long id = cursor.getLong(cursor.getColumnIndex("id"));
            String titleTask = cursor.getString(cursor.getColumnIndex("title"));
            String textTask = cursor.getString(cursor.getColumnIndex("text"));

            task.setId(id);
            task.setText(textTask);
            task.setTitle(titleTask); //Colocando as informações

            taskList.add(task);
        }

        return taskList;
    }


}
