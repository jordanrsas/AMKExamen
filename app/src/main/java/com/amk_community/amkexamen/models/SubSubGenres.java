package com.amk_community.amkexamen.models;

import java.util.List;

/**
 * Created by Jordan on 06/09/2017.
 */

public class SubSubGenres extends Genres {
    private List<Genres> subgenres;

    public List<Genres> getSubgenres() {
        return subgenres;
    }

    public void setSubgenres(List<Genres> subgenres) {
        this.subgenres = subgenres;
    }
}
