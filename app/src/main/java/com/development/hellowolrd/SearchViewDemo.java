package com.development.hellowolrd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SearchViewDemo extends AppCompatActivity {

    ListView listview;
    Spinner spn_categories;
    SearchView searchView;
    List<String> categories;
    List<String> items;

    ArrayAdapter<String> categoryAdapter;
    ArrayAdapter<String> arrayAdapter;

    void load_list(){
        items = new ArrayList<>();
        items.add("Harry Potter and the Philosopher's Stone");
        items.add("Harry Potter and the Chamber of the Secrets");
        items.add("Harry Potter and the Prisoner of the Azkaban");
        items.add("Harry Potter and the Goblet of Fire");
        items.add("Harry Potter and the Order of the Pheonix");
        items.add("Harry Potter and the Half Blood Prince");
        items.add("Harry Potter and the Deathly Hallows : Part 1");
        items.add("Harry Potter and the Deathly Hallows : Part 2");
        items.add("Harry Potter and the Cursed Child");
        items.add("Harry Potter and the Philosopher's Stone(Book)");
        items.add("Harry Potter and the Chamber of the Secrets(Book)");
        items.add("Harry Potter and the Prisoner of the Azkaban(Book)");
        items.add("Harry Potter and the Goblet of Fire(Book)");
        items.add("Harry Potter and the Order of the Pheonix(Book)");
        items.add("Harry Potter and the Half Blood Prince(Book)");
        items.add("Harry Potter and the Deathly Hallows(Book)");
        items.add("Chronicles of Narnia : The Witch, The Wordobe and the Lion");
        items.add("Chronicles of Narnia : Prince Caspian");
        items.add("Chronicles of Narnia : Voyage of the Dawn Trader");
        items.add("Chronicles of Narnia 4");
        items.add("Chronicles of Narnia 5");
        items.add("Chronicles of Narnia 6");
        items.add("Chronicles of Narnia 7");
        items.add("Chronicles of Narnia 8");
        items.add("Chronicles of Narnia 9");
        items.add("Avengers");
        items.add("Avengers: Age of Ultron");
        items.add("Avengers: Infinity War");
        items.add("Avengers: End Game");
        items.add("Star Wars: Episode 4, New Hope");
        items.add("Star Wars: Episode 5, Empire Strikes Back");
        items.add("Star Wars: Episode 6, Return of the Jedi");
        items.add("Star Wars: Episode 8");
        items.add("Star Wars: Episode 9");
        items.add("Star Wars: Episode 10");
        items.add("Star Wars: Episode 1, Phantom Menance");
        items.add("Star Wars: Episode 2, Attack of the Clones");
        items.add("Star Wars: Episode 3, Revenge of the Sith");
    }

    void load_categories(){
        categories = new ArrayList<>();
        categories.add("Harry Potter");
        categories.add("Narnia");
        categories.add("Avengers");
        categories.add("Star Wars");
    }

    void init_spinner(){
        load_categories();
        categoryAdapter = new ArrayAdapter<>(SearchViewDemo.this, android.R.layout.simple_spinner_item, categories);
        spn_categories.setAdapter(categoryAdapter);
    }

    public void init_list_view(){
        load_list();
        arrayAdapter = new ArrayAdapter<>(SearchViewDemo.this, R.layout.my_list_item, R.id.custom_text, items);
        listview.setAdapter(arrayAdapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view_demo);

        listview = findViewById(R.id.lsv_items_list);
        searchView = findViewById(R.id.searchview);
        spn_categories = findViewById(R.id.spn_movie_chooser);

        init_list_view();
        init_spinner();

        spn_categories.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                arrayAdapter.getFilter().filter(categories.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(items.contains(query))
                    arrayAdapter.getFilter().filter(query);
                else
                    Toast.makeText(SearchViewDemo.this, "Not Found!!", Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                arrayAdapter.getFilter().filter(newText);
                return false;
            }
        });
    }
}