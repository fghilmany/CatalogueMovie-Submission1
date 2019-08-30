package com.example.moviecatalogue;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class FilmAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Film> films;

    public void setFilms(ArrayList<Film> films) {
        this.films = films;
    }

    public FilmAdapter(Context context) {
        this.context = context;
        films = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return films.size();
    }

    @Override
    public Object getItem(int i) {
        return films.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        Film film = (Film) getItem(i);
        viewHolder.bind(film);
        return view;
    }

    private class ViewHolder{
        private TextView txtName;
        private TextView txtDesc;
        private ImageView imgPhoto;

        ViewHolder(View view){
            txtName = view.findViewById(R.id.tv_name);
            txtDesc = view.findViewById(R.id.tv_desc);
            imgPhoto = view.findViewById(R.id.img_photo);
        }

        void bind(Film film){
            txtName.setText(film.getName());
            txtDesc.setText(film.getDesc());
            imgPhoto.setImageResource(film.getPhoto());
        }
    }
}
