package com.koshka.origami;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.koshka.origami.login.LoginActivity;
import com.koshka.origami.login.UserProfileActivity;
import com.koshka.origami.login.fragments.CreateOrigamiFragment;
import com.koshka.origami.login.fragments.Fragment1;
import com.koshka.origami.login.fragments.Fragment2;
import com.koshka.origami.login.fragments.Fragment3;
import com.koshka.origami.login.fragments.FriendListFragment;
import com.koshka.origami.login.fragments.MyOrigamiListFragment;
import com.koshka.origami.model.Friend;
import com.koshka.origami.model.Origami;
import com.koshka.origami.model.User;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by imuntean on 7/20/16.
 */
public class MainActivity extends AppCompatActivity {
    private final static String TAG = "MainActivity";

    private FragmentPagerAdapter mPagerAdapter;
    private ViewPager mViewPager;

    private DatabaseReference mRef;
    private DatabaseReference mUserRef;
    private FirebaseAuth mAuth;

    private int backButtonCount;

    @BindView(android.R.id.content)
    View mRootView;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser == null) {
            startActivity(LoginActivity.createIntent(this));
            finish();
            return;
        }

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        // Create the adapter that will return a fragment for each section
        mPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            private final Fragment[] mFragments = new Fragment[]{
                    new MyOrigamiListFragment(),
                    new FriendListFragment(),


            };
            private final String[] mFragmentNames = new String[]{
                    "Origami",
                    "Friends",
            };

            @Override
            public Fragment getItem(int position) {
                return mFragments[position];
            }

            @Override
            public int getCount() {
                return mFragments.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mFragmentNames[position];
            }
        };
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.mainViewPager);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setCurrentItem(0);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }

    public static Intent createIntent(Context context) {
        Intent in = new Intent();
        in.setClass(context, MainActivity.class);
        return in;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_profile:
                startActivity(new Intent(MainActivity.this, UserProfileActivity.class));
                return true;
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }


    @Override
    public void onBackPressed() {
        if (backButtonCount >= 1) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } else {
            Snackbar.make(mRootView, "Press back once again to close the application.", Snackbar.LENGTH_SHORT).show();
            backButtonCount++;
        }
    }
}
