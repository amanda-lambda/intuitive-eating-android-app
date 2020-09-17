package com.example.intuitiveeatingjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class AddEntryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_entry);

        // Seekbar
        SeekBar sk = (SeekBar) findViewById(R.id.hungerBefore);
        sk.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                TextView t = (TextView) findViewById(R.id.textView4);
                t.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // Seekbar
        SeekBar sk2 = (SeekBar) findViewById(R.id.hungerAfter);
        sk2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                TextView t = (TextView) findViewById(R.id.textView5);
                t.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    /** Called when the user taps the Send button */
    /** Sent to MainActivity, then TodayFragment */
    public void sendMessage(View view) {
        Snackbar.make(view, "bllop a Snackbar", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();

        // Get the form objects
        EditText editText = (EditText) findViewById(R.id.foodEntry);
        SeekBar seekbar1 = (SeekBar) findViewById(R.id.hungerBefore);
        SeekBar seekbar2 = (SeekBar) findViewById(R.id.hungerAfter);

        // Extract form information
        String entry = editText.getText().toString();
        int before = seekbar1.getProgress();
        int after = seekbar2.getProgress();

        Bundle bundle = new Bundle();
        bundle.putString("entry", entry);
        bundle.putString("before", String.valueOf(before));
        bundle.putString("after", String.valueOf(after));

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("item", bundle);
        startActivity(intent);
    }
}