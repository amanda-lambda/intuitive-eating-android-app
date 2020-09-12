package com.example.intuitiveeatingjournal;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;


public class FragmentToday extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_today, container, false);

        FloatingActionButton addButton = rootView.findViewById(R.id.buttonAddEntry);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent = new Intent(getActivity(), AddEntryActivity.class);
                startActivity(intent);
            }
        });
        return rootView;
    }

    public void updateList(Bundle args) {
        String entry = args.getString("entry");
        Integer before = args.getInt("before");
        Integer after = args.getInt("after");
        Snackbar.make(this.getView(), entry, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}