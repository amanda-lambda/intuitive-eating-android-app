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

        // Interleave
        MainActivity activity = (MainActivity) getActivity();

        // Grid View
        GridView gridView = (GridView) rootView.findViewById(R.id.gridView);
        gridView.setAdapter(new ArrayAdapter<String>(activity, R.layout.cell, activity.befores));
        return rootView;
    }
}