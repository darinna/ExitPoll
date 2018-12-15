package com.example.exitpoll.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Election.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "Result";
    public static final String COL_ID = "_id";
    public static final String COL_VOTE = "vote";
    public static final String COL_SCORE = "score";
    public static final String COL_IMAGE = "image";

    private static final String SQL_CREATE_TABLE
            = "CREATE TABLE " + TABLE_NAME + "("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_VOTE + " TEXT,"
            + COL_SCORE + " TEXT,"
            + COL_IMAGE + " TEXT,"
            + ")";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "Election.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE);

        ContentValues cv = new ContentValues();
        cv.put(COL_VOTE, "no");
        cv.put(COL_SCORE, "0");
        cv.put(COL_IMAGE, "vote_no.png");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_VOTE, "1");
        cv.put(COL_SCORE, "0");
        cv.put(COL_IMAGE, "one.png");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_VOTE, "2");
        cv.put(COL_SCORE, "0");
        cv.put(COL_IMAGE, "two.png");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_VOTE, "3");
        cv.put(COL_SCORE, "0");
        cv.put(COL_IMAGE, "three.png");
        db.insert(TABLE_NAME, null, cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
