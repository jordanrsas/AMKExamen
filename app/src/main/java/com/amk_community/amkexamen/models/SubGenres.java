package com.amk_community.amkexamen.models;

import org.json.JSONObject;

/**
 * Created by Jordan on 06/09/2017.
 */

public class SubGenres extends Genres {
    private JSONObject subgenres;

    public JSONObject getSubgenres() {
        return subgenres;
    }

    public void setSubgenres(JSONObject subgenres) {
        this.subgenres = subgenres;
    }
}
