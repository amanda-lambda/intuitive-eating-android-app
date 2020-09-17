package com.example.intuitiveeatingjournal;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {
    private ArrayList<String> entries;
    private ArrayList<String> befores;
    private ArrayList<String> afters;
    private ArrayList<String> dates;
    private Context context;
    private MainActivity activity;


    public ListAdapter(Context context, ArrayList<String> entries, ArrayList<String> befores, ArrayList<String> afters, ArrayList<String> dates) {
        this.entries = entries;
        this.befores = befores;
        this.afters = afters;
        this.dates = dates;
        this.context = context;
        this.activity = (MainActivity) context;
    }

    @Override
    public int getCount() {
        return entries.size();
    }

    @Override
    public Object getItem(int pos) {
        return pos;
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_style, null);
        }

        // Getting views
        TextView entryView = (TextView) view.findViewById(R.id.list_item);
//        TextView dateView = (TextView) view.findViewById(R.id.date_item);
        Button beforeButton = (Button)view.findViewById(R.id.before_btn);
        Button afterButton = (Button)view.findViewById(R.id.after_btn);

        // Setting views
        String entry = entries.get(position);
        String before = befores.get(position);
        String after = afters.get(position);
        String date = dates.get(position);

        entryView.setText(entry + "\n" + date);
        beforeButton.setText(before);
        afterButton.setText(after);

        // Setting colors
        Integer before_pos = new Integer(before);
        Integer after_pos = new Integer(after);
        beforeButton.setBackgroundColor(activity.colors.get(before_pos));
        afterButton.setBackgroundColor(activity.colors.get(after_pos));

        return view;
    }
}

