package com.amk_community.amkexamen.filters;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.amk_community.amkexamen.R;
import com.amk_community.amkexamen.controllers.GenericFragment;
import com.amk_community.amkexamen.models.GenresResponse;
import com.amk_community.amkexamen.models.MusicGenresResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import butterknife.ButterKnife;

/**
 * Created by Jordan on 06/09/2017.
 */

public class GenresFragment extends GenericFragment {

    private GenresResponse genresResponse;

    public static GenresFragment newInstance() {
        GenresFragment fragment = new GenresFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        rootview = inflater.inflate(R.layout.fragment_genders, container, false);
        initViews();
        return rootview;
    }

    @Override
    public void initViews() {
        ButterKnife.bind(this, rootview);
        getGednersServer();
    }

    private void getGednersServer() {
        RequestQueue queue = Volley.newRequestQueue(getContext());
        String url = "http://itunes.apple.com/WebObjects/MZStoreServices.woa/ws/genres?id=34";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        GsonBuilder builder = new GsonBuilder();
                        builder.registerTypeAdapter(
                                new TypeToken<Map<String, String>>() {
                                }.getType(),
                                new ArrayOfObjectsToMapDeserializer()
                        );
                        Gson gson = builder.create();
                        MusicGenresResponse res = gson.fromJson(response, MusicGenresResponse.class);
                        genresResponse = res.getResponse();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "Error en Volley", Toast.LENGTH_SHORT).show();
            }
        });

        queue.add(stringRequest);
    }

    private static String readDataFromResponseStream(BufferedReader responseReader) {
        StringBuilder builder = new StringBuilder();
        String line;
        try {
            while ((line = responseReader.readLine()) != null) {
                builder.append(line);
            }
            responseReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }


    private static HttpURLConnection openConnection(URL url) {
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private static BufferedReader createResponseReader(HttpURLConnection connection) {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return in;
    }

    class ArrayOfObjectsToMapDeserializer
            implements JsonDeserializer<Map<String, String>> {

        @Override
        public Map<String, String> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            Map<String, String> result = new HashMap<>();

            JsonObject object = json.getAsJsonObject();
            Set<Map.Entry<String, JsonElement>> entrySet = object.entrySet();

            return result;
        }
    }
}
