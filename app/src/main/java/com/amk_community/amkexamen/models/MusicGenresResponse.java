package com.amk_community.amkexamen.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Jordan on 06/09/2017.
 */

public class MusicGenresResponse {
    @SerializedName("34")
    private GenresResponse response;

    public GenresResponse getResponse() {
        return response;
    }

    public void setResponse(GenresResponse response) {
        this.response = response;
    }
}
