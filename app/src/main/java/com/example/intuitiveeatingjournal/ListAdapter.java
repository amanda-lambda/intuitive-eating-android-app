package com.example.intuitiveeatingjournal;

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
    private Context context;


    public ListAdapter(Context context, ArrayList<String> entries, ArrayList<String> befores, ArrayList<String> afters) {
        this.entries = entries;
        this.befores = befores;
        this.afters = afters;
        this.context = context;
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
        Button beforeButton = (Button)view.findViewById(R.id.before_btn);
        Button afterButton = (Button)view.findViewById(R.id.after_btn);

        // Setting views
        String entry = entries.get(position);
        String before = befores.get(position);
        String after = afters.get(position);

        entryView.setText(entry);
        beforeButton.setText(before);
        afterButton.setText(after);

        return view;
    }
}

