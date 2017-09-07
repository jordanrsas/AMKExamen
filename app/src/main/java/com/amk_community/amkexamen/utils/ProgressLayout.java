package com.amk_community.amkexamen.utils;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amk_community.amkexamen.R;

import butterknife.ButterKnife;

/**
 * Created by Jordan on 06/09/2017.
 */

public class ProgressLayout extends LinearLayout {
    private TextView txtMessage;
    private FrameLayout frameProgresGif;

    public ProgressLayout(Context context) {
        super(context);
        init();
    }

    public ProgressLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ProgressLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(infService);
        li.inflate(R.layout.progress_layout, this, true);
        txtMessage = ButterKnife.findById(this, R.id.txtMessage);
        frameProgresGif = ButterKnife.findById(this, R.id.frameProgresGif);
        setBackgroundResource(R.color.bg_progress);
    }

    public void setTextMessage(String message) {
        txtMessage.setText(message);
    }

    public void setBackgroundColor(@DrawableRes int color) {
        setBackgroundResource(color);
    }

    public void setVisivilityImage(int visibility) {
        frameProgresGif.setVisibility(visibility);
    }

}
