package com.example.intuitiveeatingjournal;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.ScrollView;

import java.util.ArrayList;


public class FragmentStats extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_stats, container, false);

        // Interleave
        MainActivity activity = (MainActivity) getActivity();
        ArrayList<String> cellValues = new ArrayList<String>();
        ArrayList<Integer> cellColors = new ArrayList<Integer>();

        int numColumns = 13;
        int middleColumn = (numColumns - 1) / 2;
        int numEntries = activity.befores.size();
        int numRows = (numEntries + middleColumn - 1) / middleColumn;

        int count1 = 0;
        int count2 = 0;
        for (int j = 0; j < numRows; j++) {
            // Before half
            for (int i = 0; i < middleColumn; i++) {
                if (count1 >= numEntries) {
                    cellValues.add("");
                    cellColors.add(Color.WHITE);
                    continue;
                }
                String before = activity.befores.get(count1);
                Integer before_pos = new Integer(before);
                Integer before_color = activity.colors.get(before_pos);
                cellValues.add(before);
                cellColors.add(before_color);
                count1 = count1 +1;
            }
            // Empty
            cellValues.add("");
            cellColors.add(Color.WHITE);

            // After half
            for (int i = 0; i < middleColumn; i++) {
                if (count2 >= numEntries) {
                    cellValues.add("");
                    cellColors.add(Color.WHITE);
                    continue;
                }
                String after = activity.afters.get(count2);
                Integer after_pos = new Integer(after);
                Integer after_color = activity.colors.get(after_pos);
                cellValues.add(after);
                cellColors.add(after_color);
                count2 = count2 + 1;
            }
        }

        Log.d("cellVAlues length", String.valueOf(cellValues.size()));
        Log.d("cellColors length", String.valueOf(cellColors.size()));
        // Grid View
        GridView gridView = (GridView) rootView.findViewById(R.id.gridView);
        gridView.setAdapter(new GridAdapter(activity, R.layout.cell, cellValues, cellColors));
        return rootView;
    }
}