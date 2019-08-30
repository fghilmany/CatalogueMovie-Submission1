package com.example.moviecatalogue;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] dataName ;
    private String[] dataDesc;
    private TypedArray dataImage;
    private FilmAdapter adapter;
    private ArrayList<Film> films;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new FilmAdapter(this);

        ListView listView = findViewById(R.id.movie_list);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, dataName);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Film film = new Film();
                film.setPhoto(dataImage.getResourceId(i,-1));
                film.setName(dataName[i]);
                film.setDesc(dataDesc[i]);
                Intent goToDetail = new Intent(MainActivity.this, DetailAct.class);
                goToDetail.putExtra(DetailAct.EXTRA_FILM, film);
                Toast.makeText(MainActivity.this, films.get(i).getName(), Toast.LENGTH_SHORT).show();
                startActivity(goToDetail);
            }
        });
    }

    private void addItem(){
        films = new ArrayList<>();

        for (int i = 0; i< dataName.length;i++){
            Film film = new Film();
            film.setPhoto(dataImage.getResourceId(i, -1));
            film.setName(dataName[i]);
            film.setDesc(dataDesc[i]);
            films.add(film);
        }
        adapter.setFilms(films);
    }

    private void prepare(){
        dataName = getResources().getStringArray(R.array.data_name);
        dataDesc = getResources().getStringArray(R.array.data_desc);
        dataImage = getResources().obtainTypedArray(R.array.data_image);
    }
}
