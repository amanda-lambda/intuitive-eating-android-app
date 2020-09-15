package com.example.intuitiveeatingjournal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class FragmentStats extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_stats, container, false);

        MainActivity activity = (MainActivity) getActivity();
        PixelGridView pixelGrid = new PixelGridView(activity);
        pixelGrid.setNumColumns(4);
        pixelGrid.setNumRows(6);

//        setContentView(pixelGrid);

        return pixelGrid;
    }
}