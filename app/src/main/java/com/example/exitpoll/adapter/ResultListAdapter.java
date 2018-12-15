package com.example.exitpoll.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.exitpoll.R;
import com.example.exitpoll.model.Item;

import java.util.List;

public class ResultListAdapter extends ArrayAdapter<Item> {

    private Context mContext;
    private int mResource;
    private List<Item> mItemList;

    public ResultListAdapter(@NonNull Context context,
                             int resource, List<Item> itemList) {
        super(context, resource, itemList);
        this.mContext = context;
        this.mResource = resource;
        this.mItemList = itemList;
    }

    @NonNull
    @Override
    public View getView(int novote, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(mResource, parent, false);

        TextView titleTextView = view.findViewById(R.id.textView);
//        TextView numberTextView = view.findViewById(R.id.number_text_view);


        Item phoneItem = mItemList.get(novote);
        String title = phoneItem.vote;
//        String number = phoneItem.name;


        titleTextView.setText(title);
//        numberTextView.setText(number);

        return view;
    }
}
