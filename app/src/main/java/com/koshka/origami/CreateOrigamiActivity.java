package com.koshka.origami;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.koshka.origami.login.LoginActivity;
import butterknife.ButterKnife;

/**
 * Created by imuntean on 7/20/16.
 */
public class CreateOrigamiActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser == null) {
            startActivity(LoginActivity.createIntent(this));
            finish();
            return;
        }



        setContentView(R.layout.create_origami_activity);
        ButterKnife.bind(this);
    }

    public static Intent createIntent(Context context) {
        Intent in = new Intent();
        in.setClass(context, CreateOrigamiActivity.class);
        return in;
    }
}
