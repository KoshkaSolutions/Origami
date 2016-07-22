package com.koshka.origami;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.koshka.origami.login.LoginActivity;
import com.koshka.origami.model.Coordinate;
import com.koshka.origami.model.Friend;
import com.koshka.origami.model.User;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by imuntean on 7/20/16.
 */
public class TestingActivity extends AppCompatActivity {

    public static final String TAG = "Test";

    private DatabaseReference mRef;
    private DatabaseReference mUserRef;
    private FirebaseAuth mAuth;

    @BindView(R.id.save_button)
    Button saveButton;

    TextView view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser == null) {
            startActivity(LoginActivity.createIntent(this));
            finish();
            return;
        }

        mAuth = FirebaseAuth.getInstance();

        setContentView(R.layout.testing_activity);
        ButterKnife.bind(this);



    }

    @OnClick(R.id.save_button)
    public void saveUser(View view) {

        mRef = FirebaseDatabase.getInstance().getReference();
        mUserRef = mRef.child("users").child(mAuth.getCurrentUser().getUid());

        String uid = mAuth.getCurrentUser().getUid();
        String email = mAuth.getCurrentUser().getEmail();
        String displayName = mAuth.getCurrentUser().getDisplayName();
        String name = "User " + uid.substring(0, 6);

        List<Friend> friendList = new ArrayList<>();
        friendList.add(new Friend(uid));

        Coordinate coordinate = new Coordinate(49.187702,16.637893);



    }

    public static Intent createIntent(Context context) {
        Intent in = new Intent();
        in.setClass(context, TestingActivity.class);
        return in;
    }
}
