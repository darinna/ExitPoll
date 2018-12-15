package com.example.exitpoll;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.exitpoll.db.DatabaseHelper;
import com.example.exitpoll.model.Item;

import java.util.ArrayList;
import java.util.List;

import static com.example.exitpoll.db.DatabaseHelper.COL_ID;
import static com.example.exitpoll.db.DatabaseHelper.COL_IMAGE;
//import static com.example.exitpoll.db.DatabaseHelper.COL_NAME;
//import static com.example.exitpoll.db.DatabaseHelper.COL_NAME;
//import static com.example.exitpoll.db.DatabaseHelper.COL_NAME;
import static com.example.exitpoll.db.DatabaseHelper.COL_VOTE;
import static com.example.exitpoll.db.DatabaseHelper.COL_SCORE;
import static com.example.exitpoll.db.DatabaseHelper.COL_VOTE;
import static com.example.exitpoll.db.DatabaseHelper.TABLE_NAME;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper mHelper;
    private SQLiteDatabase mDb;
    private List<Item> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHelper = new DatabaseHelper(MainActivity.this);
        mDb = mHelper.getWritableDatabase();

        Button vote_one = findViewById(R.id.button);
        Button vote_two = findViewById(R.id.button2);
        Button vote_three = findViewById(R.id.button3);
        Button vote_no = findViewById(R.id.button4);
        Button score_view = findViewById(R.id.button5);

        loadPhoneData();

        vote_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadPhoneData();
                Item item = itemList.get(0);
                String textscore = item.score.toString();
                int score =Integer.valueOf(textscore)+1;
                String newscore = Integer.toString(score);
                ContentValues cv = new ContentValues();
                cv.put(COL_VOTE, "no");
                cv.put(COL_SCORE,newscore);
                cv.put(COL_IMAGE,"vote_no.png");


                mDb.update(
                        TABLE_NAME,
                        cv,
                        COL_ID + " = ?",
                        new String[]{String.valueOf(1)}
                );
                loadPhoneData();

    }



        });

        vote_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadPhoneData();
                Item item = itemList.get(1);
                String textscore = item.score.toString();
                int score =Integer.valueOf(textscore)+1;
                String newscore = Integer.toString(score);
                ContentValues cv = new ContentValues();
                cv.put(COL_VOTE, "1");
                cv.put(COL_SCORE,newscore);
                cv.put(COL_IMAGE,"one.png");


                mDb.update(
                        TABLE_NAME,
                        cv,
                        COL_ID + " = ?",
                        new String[]{String.valueOf(2)}
                );
                loadPhoneData();

            }
        });

        vote_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadPhoneData();
                Item item = itemList.get(2);
                String textscore = item.score.toString();
                int score =Integer.valueOf(textscore)+1;
                String newscore = Integer.toString(score);
                ContentValues cv = new ContentValues();
                cv.put(COL_VOTE, "2");
                cv.put(COL_SCORE,newscore);
                cv.put(COL_IMAGE,"two.png");


                mDb.update(
                        TABLE_NAME,
                        cv,
                        COL_ID + " = ?",
                        new String[]{String.valueOf(3)}
                );
                loadPhoneData();

            }
        });

        vote_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadPhoneData();
                Item item = itemList.get(3);
                String textscore = item.score.toString();
                int score =Integer.valueOf(textscore)+1;
                String newscore = Integer.toString(score);
                ContentValues cv = new ContentValues();
                cv.put(COL_VOTE, "3");
                cv.put(COL_SCORE,newscore);
                cv.put(COL_IMAGE,"three.png");


                mDb.update(
                        TABLE_NAME,
                        cv,
                        COL_ID + " = ?",
                        new String[]{String.valueOf(4)}
                );
                loadPhoneData();

            }
        });

        score_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, View.class);
                startActivity(intent);
            }
        });
    }


    private void loadPhoneData() {
        Cursor c = mDb.query(TABLE_NAME, null, null, null, null, null, null);

        itemList = new ArrayList<>();
        while (c.moveToNext()) {
            long id = c.getLong(c.getColumnIndex(COL_ID));
            String name = c.getString(c.getColumnIndex(COL_VOTE));
            String score = c.getString(c.getColumnIndex(COL_SCORE));
            String image = c.getString(c.getColumnIndex(COL_IMAGE));

            Item item = new Item(id, name, score,image);
            itemList.add(item);
        }
        c.close();
    }
}
