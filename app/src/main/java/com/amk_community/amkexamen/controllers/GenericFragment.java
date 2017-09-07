package com.amk_community.amkexamen.controllers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by Jordan on 06/09/2017.
 */

public abstract class GenericFragment extends Fragment {

    protected View rootview;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    @NonNull
    public String getFragmentTag() {
        return getClass().getSimpleName();
    }

    /**
     * Método para inicializar los views del fragment
     */
    public abstract void initViews();
}
