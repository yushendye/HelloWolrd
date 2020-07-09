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

import java.util.ArrayList;
import java.util.List;

public class RecyclerDemo extends AppCompatActivity {
    MovieAdapter movieAdapter;
    List<Movie> movieList;
    RecyclerView movies_recycler;

    public void load_list(){
        movieList = new ArrayList<>();
        movieList.add(new Movie("https://media.harrypotterfanzone.com/philosophers-stone-theatrical-poster-405x0-c-default.jpg", "Harry Potter and the Philosophers Stone", 9.5));
        movieList.add(new Movie("https://media.harrypotterfanzone.com/chamber-of-secrets-theatrical-poster-600x0-c-default.jpg", "Harry Potter and the Chamber of Secrets", 9.3));
        movieList.add(new Movie("https://media.harrypotterfanzone.com/prisoner-of-azkaban-theatrical-poster-320x0-c-default.jpg", "Harry Potter and the Prisoner of Azkaban", 9.6));
        movieList.add(new Movie("https://media.harrypotterfanzone.com/goblet-of-fire-theatrical-poster-600x0-c-default.jpg", "Harry Potter and the Goblet of Fire", 9.7));
        movieList.add(new Movie("https://media.harrypotterfanzone.com/order-of-the-phoenix-theatrical-poster-2-538x0-c-default.jpg", "Harry Potter and the Order of Pheonx", 9.0));
        movieList.add(new Movie("https://media.harrypotterfanzone.com/half-blood-prince-theatrical-poster-600x0-c-default.jpg", "Harry Potter and the Half Blood Prince", 9.8));
        movieList.add(new Movie("https://media.harrypotterfanzone.com/deathly-hallows-part-1-harry-poster-480x0-c-default.jpg", "Harry Potter and the Daethly Hallows Part I", 9.9));
        movieList.add(new Movie("https://media.harrypotterfanzone.com/deathly-hallows-part-2-it-all-ends-poster-2-432x0-c-default.jpg", "Harry Potter and the Daethly Hallows Part II", 9.9));
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


        init_recycler();
    }
}