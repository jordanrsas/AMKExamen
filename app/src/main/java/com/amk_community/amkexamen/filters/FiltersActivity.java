package com.amk_community.amkexamen.filters;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.amk_community.amkexamen.R;
import com.amk_community.amkexamen.controllers.GenericFragment;
import com.amk_community.amkexamen.controllers.ToolBarActivity;
import com.amk_community.amkexamen.interfaces.enums.Direction;
import com.amk_community.amkexamen.interfaces.managers.FilterActivityManager;

/**
 * Created by Jordan on 06/09/2017.
 */

public class FiltersActivity extends ToolBarActivity implements FilterActivityManager {

    @IdRes
    int containerID;
    protected FragmentManager fragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filters);
        this.fragmentManager = getSupportFragmentManager();
        initViews();
    }

    @Override
    public void initViews() {
        super.initViews();
        loadFragment(GenresFragment.newInstance(), Direction.NONE, false);
    }

    protected void loadFragment(@NonNull GenericFragment fragment, @NonNull Direction Direction,
                                boolean addToBackStack) {
        loadFragment(fragment, R.id.container, Direction, addToBackStack);
    }

    protected void loadFragment(@NonNull GenericFragment fragment, @IdRes int idContainer, @NonNull Direction Direction,
                                boolean addToBackStack) {
        this.containerID = idContainer;
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (!Direction.equals(Direction.NONE)) {
            fragmentTransaction.setCustomAnimations(Direction.getEnterAnimation(), Direction.getExitAnimation(),
                    Direction.BACK.getEnterAnimation(), Direction.BACK.getExitAnimation());
        }
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.replace(idContainer, fragment, fragment.getFragmentTag()).commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void showLoader(String message) {
        showProgressLayout(message);
    }

    @Override
    public void hideLoader() {
        hideProgresLayout();
    }

    @Override
    public void loadArtistFragment() {

    }

    @Override
    public void loadAlbumsFragments() {

    }

    @Override
    public void showError(String message) {

    }
}
