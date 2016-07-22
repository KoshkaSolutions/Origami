package com.koshka.origami.login.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.firebase.ui.auth.AuthUI;
import com.koshka.origami.CreateOrigamiActivity;
import com.koshka.origami.R;
import com.koshka.origami.TestingActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by imuntean on 7/20/16.
 */
public class CreateOrigamiFragment extends Fragment {


    @BindView(R.id.create_origami_button)
    Button createOrigamiButton;

    @BindView(R.id.testButton)
    Button testButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_origami, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @OnClick(R.id.create_origami_button)
    public void createOrigamiButtonOnClick(View view) {
       startActivity(CreateOrigamiActivity.createIntent(getActivity()));
    }
    @OnClick(R.id.testButton)
    public void onTestButtonClick(View view) {
        startActivity(TestingActivity.createIntent(getActivity()));
    }
}
