package com.amk_community.amkexamen.interfaces.managers;

/**
 * Created by Jordan on 06/09/2017.
 */

public interface FilterActivityManager {
    void showLoader(String message);

    void hideLoader();

    void loadArtistFragment();

    void loadAlbumsFragments();

    void showError(String message);
}
