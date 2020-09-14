package com.example.intuitiveeatingjournal;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.FileUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class FragmentToday extends Fragment {

    private ListView listView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_today, container, false);

        // Button to add an entry
        FloatingActionButton addButton = rootView.findViewById(R.id.buttonAddEntry);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddEntryActivity.class);
                startActivity(intent);
            }
        });

        // List View
        MainActivity activity = (MainActivity) getActivity();
        listView = (ListView) rootView.findViewById(R.id.listView);
        ListAdapter adapter = new ListAdapter(activity, activity.entries, activity.befores, activity.afters);
        listView.setAdapter(adapter);
        return rootView;
    }
}