package com.example.moviecatalogue;

import android.app.Person;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailAct extends AppCompatActivity {

    public static final String EXTRA_FILM = "extra_film";
    private TextView tvName;
    private TextView tvDesc;
    private ImageView imgPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvName = findViewById(R.id.tv_name);
        tvDesc = findViewById(R.id.tv_desc);
        imgPhoto = findViewById(R.id.img_photo);

        Film film = getIntent().getParcelableExtra(EXTRA_FILM);
        tvName.setText(film.getName());
        tvDesc.setText(film.getDesc());
        imgPhoto.setImageResource(film.getPhoto());

    }
}
