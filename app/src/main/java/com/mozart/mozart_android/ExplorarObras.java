package com.mozart.mozart_android;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.mozart.custom_view_volley.AppController;
import com.mozart.custom_view_volley.CustomListAdapter;
import com.mozart.custom_view_volley.ModelWork;


public class ExplorarObras extends Fragment {
    Typeface RobotoThin,RobotoRegular,RobotoMedium,RobotoLight,iconFonts,enterFont;
    View view;
    // Log tag
    private static final String TAG = MainActivity.class.getSimpleName();

    // Movies json url
    private static final String url = "http://mozart.ngrok.io/api/worksets/";
//    private static final String url = "http://api.androidhive.info/json/movies.json";
    private ProgressDialog pDialog;
    private List<ModelWork> workList = new ArrayList<ModelWork>();
    private ListView listView;
    private CustomListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_explorar_obras, container, false);

        cargarFuentes();

        listView = (ListView) view.findViewById(R.id.list);
        adapter = new CustomListAdapter(getActivity(), workList);
        listView.setAdapter(adapter);

        pDialog = new ProgressDialog(getActivity());
        // Showing progress dialog before making http request
        pDialog.setMessage("Cargando Obras...");
        pDialog.show();

        // Creating volley request obj
        JsonArrayRequest workRequest = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, "succ3ess"+ response.toString());
                        hidePDialog();
                        // Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);
                                ModelWork movie = new ModelWork();
                                movie.setTitle(obj.getString("title"));
                                movie.setThumbnailUrl(obj.getString("image"));
                                movie.setRating(((Number) obj.get("rating"))
                                        .doubleValue());
                                movie.setYear(obj.getInt("releaseYear"));

                                // Genre is json array
                                JSONArray genreArry = obj.getJSONArray("genre");
                                ArrayList<String> genre = new ArrayList<String>();
                                for (int j = 0; j < genreArry.length(); j++) {
                                    genre.add((String) genreArry.get(j));
                                }
                                movie.setGenre(genre);

                                // adding movie to movies array
                                workList.add(movie);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        // notifying list adapter about data changes
                        // so that it renders the list view with updated data
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());

            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(workRequest);

        return view;
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        hidePDialog();
    }
    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }
    public void cargarFuentes(){
        RobotoLight = Typeface.createFromAsset(getActivity().getAssets(),"Roboto-Light.ttf");
        RobotoRegular = Typeface.createFromAsset(getActivity().getAssets(),"Roboto-Regular.ttf");
        RobotoMedium = Typeface.createFromAsset(getActivity().getAssets(),"Roboto-Medium.ttf");

    }

}
