package com.koshka.origami.model;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.koshka.origami.R;

/**
 * Created by imuntean on 7/21/16.
 */
public class FriendHolder extends RecyclerView.ViewHolder {

    View mView;

    public FriendHolder(View itemView) {
        super(itemView);
    }

    public void setName(String name) {
        TextView friendName = (TextView) mView.findViewById(R.id.friend_name);
        friendName.setText(name);
    }

    public void setEmail(String email) {
        TextView friendName = (TextView) mView.findViewById(R.id.friend_email);
        friendName.setText(email);
    }


}
