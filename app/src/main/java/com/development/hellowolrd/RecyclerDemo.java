package com.development.hellowolrd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class RecyclerDemo extends AppCompatActivity {
    MovieAdapter movieAdapter;
    List<Movie> movieList;
    RecyclerView movies_recycler;
    private static String URL = "https://raw.githubusercontent.com/FEND16/movie-json-data/master/json/top-rated-indian-movies-02.json";

    public void load_list(){
        movieList = new ArrayList<>();
        StringRequest request = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array = new JSONArray(response);
                    for(int i = 0; i < array.length(); i++){
                        JSONObject object = array.getJSONObject(i);
                        Movie movie = new Movie();
                        movie.setName(object.getString("title"));
                        movie.setUrl("https://raw.githubusercontent.com/FEND16/movie-json-data/master/img/" + object.getString("poster"));
                        movie.setRating(object.getDouble("imdbRating"));

                        movieList.add(movie);
                    }
                }catch (JSONException e){
                    Toast.makeText(getApplicationContext(), "Invalid handling", Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(request);
    }

    public void init_recycler(){
        load_list();
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("Loading Recycler view Data");
        dialog.show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    dialog.dismiss();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                }
            }
        }, 2000);
        movieAdapter = new MovieAdapter(movieList);
        //RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());
        RecyclerView.LayoutManager manager = new GridLayoutManager(getApplicationContext(), 1);
        movies_recycler.setLayoutManager(manager);
        movies_recycler.setItemAnimator(new DefaultItemAnimator());
        movies_recycler.setAdapter(movieAdapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_demo);

        movies_recycler = findViewById(R.id.movie_recycler);
        //load_list();
        init_recycler();
    }
}