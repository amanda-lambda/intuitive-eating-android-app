package com.example.intuitiveeatingjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;

public class AddEntryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_entry);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        EditText editText = (EditText) findViewById(R.id.foodEntry);
        SeekBar seekbar1 = (SeekBar) findViewById(R.id.hungerBefore);
        SeekBar seekbar2 = (SeekBar) findViewById(R.id.hungerAfter);

        String entry = editText.getText().toString();
        int before = seekbar1.getProgress();
        int after = seekbar2.getProgress();

        Bundle bundle = new Bundle();
        bundle.putString("entry", entry);
        bundle.putInt("before", before);
        bundle.putInt("after", after);

        FragmentToday fragmentToday = (FragmentToday)
                getSupportFragmentManager().findFragmentById(R.id.fragmentToday);

        fragmentToday.updateList(bundle);
    }
}