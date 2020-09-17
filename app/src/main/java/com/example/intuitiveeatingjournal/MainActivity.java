package com.example.intuitiveeatingjournal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.BundleCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    public Bundle bundle;
    public static ArrayList<String> entries;
    public static ArrayList<String> befores;
    public static ArrayList<String> afters;
    public static ArrayList<Integer> colors;
    public static ArrayList<String> dates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Colors
        colors = new ArrayList<Integer>();
        colors.add(getResources().getColor(R.color.color0));
        colors.add(getResources().getColor(R.color.color1));
        colors.add(getResources().getColor(R.color.color2));
        colors.add(getResources().getColor(R.color.color3));
        colors.add(getResources().getColor(R.color.color4));
        colors.add(getResources().getColor(R.color.color5));
        colors.add(getResources().getColor(R.color.color6));
        colors.add(getResources().getColor(R.color.color7));
        colors.add(getResources().getColor(R.color.color8));
        colors.add(getResources().getColor(R.color.color9));
        colors.add(getResources().getColor(R.color.color10));

        // Tab Layout
        TabLayout tabLayout = findViewById(R.id.tabBar);
        TabItem tabToday = findViewById(R.id.tabToday);
        TabItem tabStats = findViewById(R.id.tabStats);
        final ViewPager viewPager = findViewById(R.id.viewPager);

        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(),
                tabLayout.getTabCount());

        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        // Get journal items
        entries = new ArrayList<String>();
        befores = new ArrayList<String>();
        afters = new ArrayList<String>();
        dates = new ArrayList<String>();
        readItems();

        // Get new journal item and write to file
        Bundle results = getIntent().getBundleExtra("item");
        if (results != null) {
            String entry = results.getString("entry");
            String before = results.getString("before");
            String after = results.getString("after");
            String date = results.getString("date");
            entries.add(entry);
            befores.add(before);
            afters.add(after);
            dates.add(date);
            writeItems();
        }

        // Reverse items (most recent first!)
        Collections.reverse(entries);
        Collections.reverse(befores);
        Collections.reverse(afters);
        Collections.reverse(dates);
    }

    // Save and persist items to file
    private void readItems() {
        File filesDir = getFilesDir();
        File f1 = new File(filesDir, "journal.txt");
        File f2 = new File(filesDir, "befores.txt");
        File f3 = new File(filesDir, "afters.txt");
        File f4 = new File(filesDir, "dates.txt");
        try {
            entries = new ArrayList<String>(FileUtils.readLines(f1));
            befores = new ArrayList<String>(FileUtils.readLines(f2));
            afters = new ArrayList<String>(FileUtils.readLines(f3));
            dates = new ArrayList<String>(FileUtils.readLines(f4));
        } catch (IOException e) {
            entries = new ArrayList<String>();
            befores = new ArrayList<String>();
            afters = new ArrayList<String>();
            dates = new ArrayList<String>();
        }
    }

    private void writeItems() {
        File filesDir = getFilesDir();
        File f1 = new File(filesDir, "journal.txt");
        File f2 = new File(filesDir, "befores.txt");
        File f3 = new File(filesDir, "afters.txt");
        File f4 = new File(filesDir, "dates.txt");
        try {
            FileUtils.writeLines(f1, entries);
            FileUtils.writeLines(f2, befores);
            FileUtils.writeLines(f3, afters);
            FileUtils.writeLines(f4, dates);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}