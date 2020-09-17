package com.example.intuitiveeatingjournal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;


public class FragmentStats extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_stats, container, false);

        // Make pixel grid
        MainActivity activity = (MainActivity) getActivity();
        PixelGridView pixelGrid = new PixelGridView(activity, activity.colors, activity.befores, activity.afters);

        return pixelGrid;
    }
}