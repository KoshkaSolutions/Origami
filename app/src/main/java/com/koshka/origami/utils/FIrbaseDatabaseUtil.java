package com.koshka.origami.utils;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.koshka.origami.model.Friend;
import com.koshka.origami.model.User;

/**
 * Created by imuntean on 7/22/16.
 */
public class FIrbaseDatabaseUtil {

    private DatabaseReference mRef;
    private DatabaseReference mMe;
    private FirebaseAuth mAuth;

    public FIrbaseDatabaseUtil() {
        mRef = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();
    }

    public static User getMe(){

        User user = new User();

        /*DatabaseReference mUserRef = mRef.child("users");
        final DatabaseReference mMe = mUserRef.child(mAuth.getCurrentUser().getUid()).child("friendList");

        final Query query = mUserRef.orderByChild("email").equalTo(friendEmail.getText().toString());

        query.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if (dataSnapshot.getValue() != null){
                    User user = dataSnapshot.getValue(User.class);
                    Friend friend = new Friend();
                    friend.setDisplayName(user.getDisplayName());
                    friend.setEmail(user.getEmail());
                    friend.setUid(user.getUid());
                    mMe.push().setValue(friend);
                } else {

                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
*/

        return user;
    }
}
