package com.example.intuitiveeatingjournal;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class GridAdapter extends ArrayAdapter {
    private  ArrayList<String> objects;
    private  ArrayList<Integer> colors;
    private Context context;
    private MainActivity activity;

    public GridAdapter(Context context, int resource, ArrayList<String> objects, ArrayList<Integer> colors) {
        super(context, resource, objects);
        this.objects = objects;
        this.colors = colors;
        this.context = context;
        this.activity = (MainActivity) context;
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get view
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.cell, null);
        }

        // Get items
        String val = objects.get(position);
        Integer color = colors.get(position);

        // Set views
        TextView textView = (TextView) view.findViewById(R.id.gridItem);
        textView.setText(String.valueOf(val));
        textView.setBackgroundColor(color);
        return view;
    }
}
