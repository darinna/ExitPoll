package com.example.exitpoll.model;

import java.util.Locale;

public class Item {
    private final long _id;
    public final String vote;
    public final String score;
    public final String image;

    public Item(long _id, String vote, String score, String image) {
        this._id = _id;
        this.vote = vote;
        this.score = score;
        this.image = image;
    }

    @Override
    public String toString()
    {
        String msg = String.format(
                Locale.getDefault(),
                "NAME: %s\nID: %s",
                this.vote,
                this._id
        );
        return msg;
    }
}
