package com.amk_community.amkexamen.models;

import java.util.Map;

/**
 * Created by Jordan on 06/09/2017.
 */

public class GenresResponse extends Genres {
    private Map<String, String> subgenres;

    public Map<String, String> getSubgenres() {
        return subgenres;
    }

    public void setSubgenres(Map<String, String> subgenres) {
        this.subgenres = subgenres;
    }
}
