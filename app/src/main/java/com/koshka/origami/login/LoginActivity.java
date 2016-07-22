package com.koshka.origami.login;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.MainThread;
import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.koshka.origami.MainActivity;
import com.koshka.origami.R;
import com.koshka.origami.login.fragments.Fragment1;
import com.koshka.origami.login.fragments.Fragment2;
import com.koshka.origami.login.fragments.Fragment3;


import java.util.ArrayList;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.relex.circleindicator.CircleIndicator;

/**
 * Created by imuntean on 7/19/16.
 */
public class LoginActivity extends AppCompatActivity {

    private static final String UNCHANGED_CONFIG_VALUE = "CHANGE-ME";

    private static final String GOOGLE_TOS_URL =
            "https://www.google.com/policies/terms/";

    private static final int RC_SIGN_IN = 100;
    private int backButtonCount;

    @BindView(R.id.sign_in)
    Button mSignIn;

    @BindView(R.id.language_button)
    Button languageButton;

    @BindView(android.R.id.content)
    View mRootView;

    @BindView(R.id.title_text)
    TextView titleTextView;


    private FragmentPagerAdapter mPagerAdapter;
    private ViewPager mViewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FirebaseAuth auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null) {
            startActivity(MainActivity.createIntent(this));
            finish();
        }

        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        // Create the adapter that will return a fragment for each section
        mPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            private final Fragment[] mFragments = new Fragment[]{
                    new Fragment1(),
                    new Fragment2(),
                    new Fragment3(),


            };
            @Override
            public Fragment getItem(int position) {
                return mFragments[position];
            }

            @Override
            public int getCount() {
                return mFragments.length;
            }

        };
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setCurrentItem(0);
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(mViewPager);

        final Typeface font = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/actonia.ttf");

        titleTextView.setTypeface(font);


       /* if (!isGoogleConfigured() || !isFacebookConfigured()) {
            showSnackbar(R.string.configuration_required);
        }*/
    }

    @OnClick(R.id.sign_in)
    public void signIn(View view) {
        if (isNetworkConnected() == true){
            startActivityForResult(
                    AuthUI.getInstance().createSignInIntentBuilder()
                            .setTheme(getSelectedTheme())
                            .setLogo(getSelectedLogo())
                            .setProviders(getSelectedProviders())
                            .setTosUrl(getSelectedTosUrl())
                            .build(),
                    RC_SIGN_IN);

        }
       else {
            Snackbar.make(mRootView, "No internet connection", Snackbar.LENGTH_LONG).show();
        }
    }

    @OnClick(R.id.language_button)
    public void changeLanguage(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.choose_language)
                .setItems(R.array.languages, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case 0:
                                setLocale("en");
                                Snackbar.make(mRootView, ""+which, Snackbar.LENGTH_SHORT).show();
                                break;
                            case 1:
                                setLocale("rus");
                                break;
                            case 2:
                               setLocale("fr");
                                break;
                            case 3:
                                setLocale("de");
                                break;
                            case 4:
                                setLocale("es");
                                break;
                            case 5:
                                setLocale("ro");
                            default: setLocale("en");
                                break;
                        }
                    }
                });
    builder.show();


    }

    private void setLocale(String lang) {
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, LoginActivity.class);
        startActivity(refresh);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            handleSignInResponse(resultCode, data);
            return;
        }

        showSnackbar(R.string.unknown_response);
    }

    @MainThread
    private void handleSignInResponse(int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            startActivity(MainActivity.createIntent(this));
            finish();
            return;
        }

        if (resultCode == RESULT_CANCELED) {
            showSnackbar(R.string.sign_in_cancelled);
            return;
        }

        showSnackbar(R.string.unknown_sign_in_response);
    }

    @MainThread
    @StyleRes
    private int getSelectedTheme() {
        return R.style.PurpleTheme;
    }

    @MainThread
    @DrawableRes
    private int getSelectedLogo() {
        return AuthUI.NO_LOGO;
    }

    @MainThread
    private String[] getSelectedProviders() {
        ArrayList<String> selectedProviders = new ArrayList<>();

            selectedProviders.add(AuthUI.EMAIL_PROVIDER);

       /* if (mUseFacebookProvider.isChecked()) {
            selectedProviders.add(AuthUI.FACEBOOK_PROVIDER);
        }

        if (mUseGoogleProvider.isChecked()) {
            selectedProviders.add(AuthUI.GOOGLE_PROVIDER);
        }*/

        return selectedProviders.toArray(new String[selectedProviders.size()]);
    }

    @MainThread
    private String getSelectedTosUrl() {

        return GOOGLE_TOS_URL;
    }

    @MainThread
    private boolean isGoogleConfigured() {
        return !UNCHANGED_CONFIG_VALUE.equals(
                getResources().getString(R.string.default_web_client_id));
    }

    @MainThread
    private boolean isFacebookConfigured() {
        return !UNCHANGED_CONFIG_VALUE.equals(
                getResources().getString(R.string.facebook_application_id));
    }

    @MainThread
    private void showSnackbar(@StringRes int errorMessageRes) {
        Snackbar.make(mRootView, errorMessageRes, Snackbar.LENGTH_LONG).show();
    }

    public static Intent createIntent(Context context) {
        Intent in = new Intent();
        in.setClass(context, LoginActivity.class);
        return in;
    }

    @Override
    public void onBackPressed() {
        if (backButtonCount >= 1) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } else {
            //Toast.makeText(this, "Press the back button once again to close the application.", Toast.LENGTH_SHORT).show();
            Snackbar.make(mRootView, "Press back once again to close the application.", Snackbar.LENGTH_SHORT).show();
            backButtonCount++;
        }
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }
}
