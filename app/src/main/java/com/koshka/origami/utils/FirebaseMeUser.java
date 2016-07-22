package com.koshka.origami.utils;

import android.util.Log;
import android.widget.ArrayAdapter;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.koshka.origami.R;
import com.koshka.origami.model.Friend;
import com.koshka.origami.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by imuntean on 7/21/16.
 */
public class FirebaseMeUser {

    private final static String TAG = "FirebaseMeUser";

    private static User me;
    private static DatabaseReference mDatabase;
    private static DatabaseReference mRef;
    private static FirebaseAuth mAuth;

    public static User getMeFromDb(){

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();
        mDatabase.child("users").child(mAuth.getCurrentUser().getUid()).addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // Get user value
                        me = dataSnapshot.getValue(User.class);

                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.w(TAG, "getUser:onCancelled", databaseError.toException());
                    }
                });
        return me;
    }
}
