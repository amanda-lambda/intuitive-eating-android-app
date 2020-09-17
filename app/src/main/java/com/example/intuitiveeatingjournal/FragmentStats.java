package com.example.intuitiveeatingjournal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.ScrollView;


public class FragmentStats extends Fragment {

    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_stats, container, false);

        // Make pixel grid
//        MainActivity activity = (MainActivity) getActivity();
//        PixelGridView pixelGrid = new PixelGridView(activity, activity.colors, activity.befores, activity.afters);
//
//        return pixelGrid;
        // List View
        MainActivity activity = (MainActivity) getActivity();
//        listView = (ListView) rootView.findViewById(R.id.statsGrid);
//        GridAdapter adapter = new GridAdapter(activity, activity.befores, activity.afters, activity.dates);
//        listView.setAdapter(adapter);
        GridView gridBefore = (GridView) rootView.findViewById(R.id.gridViewBefore);
//        GridView gridAfter = (GridView) rootView.findViewById(R.id.gridViewBefore);

        gridBefore.setAdapter(new ArrayAdapter<String>(activity, R.layout.cell, activity.befores));
//        gridAfter.setAdapter(new ArrayAdapter<String>(activity, R.layout.cell, activity.befores));
        return rootView;
    }
}