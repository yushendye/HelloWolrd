package com.development.hellowolrd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class HorizontalRecycler extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Movie> movieList;
    MovieAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_recycler);
        recyclerView = findViewById(R.id.horizontal_recycler);
        init_recycler();
    }

    public void initlist(){
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
        initlist();
        adapter = new MovieAdapter(movieList);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }
}