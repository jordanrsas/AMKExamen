package com.amk_community.amkexamen.controllers;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.amk_community.amkexamen.R;
import com.amk_community.amkexamen.interfaces.ProgressView;
import com.amk_community.amkexamen.utils.ProgressLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jordan on 06/09/2017.
 */

public class BaseActivity extends AppCompatActivity implements ProgressView {
    @BindView(R.id.progressGIF)
    ProgressLayout progressGIF;

    @Override
    public void showProgressLayout(String msg) {
        progressGIF.setTextMessage(msg);
        progressGIF.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgresLayout() {
        progressGIF.setVisibility(View.GONE);
    }

    public void initViews() {
        ButterKnife.bind(this);
    }
}
