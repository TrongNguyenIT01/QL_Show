package com.example.ql_show;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_Name = "show.db";
    private static final int DB_ver = 1;

    public <context> DatabaseHelper(Context context) {
        super(context, DB_Name, null, DB_ver);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE Show(" +
                "Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "TenShow TEXT," +
                "DiaDiem TEXT ," +
                "ThoiGian TEXT ," +
                "BauShow TEXT ," +
                "GhiChu TEXT)";
        db.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insertShow(AddShow show) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("TenShow", show.getTenShow());
        values.put("DiaDiem", show.getDiaDiem());
        values.put("ThoiGian", show.getThoiGian());
        values.put("BauShow", show.getBauShow());
        values.put("GhiChu", show.getGhiChu());

        long result = db.insert("Show", null, values);

        return result != -1;
    }

    public ArrayList<AddShow> getAllShows() {
        ArrayList<AddShow> list = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM Show", null);

        if (cursor.moveToFirst()) {
            do {
                String tenshow = cursor.getString(1);
                String diadiem = cursor.getString(2);
                String thoigian = cursor.getString(3);
                String baushow = cursor.getString(4);
                String ghichu = cursor.getString(5);


                AddShow show = new AddShow(tenshow, diadiem, thoigian, baushow, ghichu);
                list.add(show);
            } while (cursor.moveToNext());
        }

        cursor.close();
        return list;
    }

    }

