package com.cmsegroup8.searchba.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.cmsegroup8.searchba.Model.Trees;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteAssetHelper {

    private static final String DB_NAME = "trees.db";
    private static final int DB_VERSION = 1;


    public Database(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public List<Trees> getTrees(){

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {"id", "name"};
        String tableName = "trees";

        qb.setTables(tableName);
        Cursor c = qb.query(db,sqlSelect,null, null, null, null, null);
        List<Trees> result = new ArrayList<>();
        if(c.moveToFirst()){
            do{
                Trees trees = new Trees();
                trees.setId(c.getInt(c.getColumnIndex("id")));
                trees.setName(c.getString(c.getColumnIndex("name")));

                result.add(trees);
            }while(c.moveToNext());
        }
        return result;
    }

    public List<String> getNames() {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {"name"};
        String tableName = "trees";

        qb.setTables(tableName);
        Cursor c = qb.query(db, sqlSelect, null, null, null, null, null);
        List<String> result = new ArrayList<>();
        if (c.moveToFirst()) {
            do {
                result.add(c.getString(c.getColumnIndex("name")));
            } while (c.moveToNext());
        }
        return result;
    }

    public List<Trees> getTreesByName(String name){
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {"id", "name"};
        String tableName = "trees";

        qb.setTables(tableName);
        Cursor c = qb.query(db,sqlSelect,"name LIKE ?", new String[]{"%"+name+"%"}, null, null, null);
        List<Trees> result = new ArrayList<>();
        if(c.moveToFirst()){
            do{
                Trees trees = new Trees();
                trees.setId(c.getInt(c.getColumnIndex("id")));
                trees.setName(c.getString(c.getColumnIndex("name")));

                result.add(trees);
            }while(c.moveToNext());
        }
        return result;
    }
}


