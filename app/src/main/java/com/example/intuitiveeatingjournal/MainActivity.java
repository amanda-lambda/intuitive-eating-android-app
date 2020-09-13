package com.example.intuitiveeatingjournal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.BundleCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

//    TODO: Make this items
    public Bundle bundle;
    public static ArrayList<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Tab Layout
        TabLayout tabLayout = findViewById(R.id.tabBar);
        TabItem tabToday = findViewById(R.id.tabToday);
        TabItem tabStats = findViewById(R.id.tabStats);
        TabItem tabHistory = findViewById(R.id.tabHistory);
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

        // items
        items = new ArrayList<String>();
        readItems();
//        items.add("First Item");
//        items.add("Second Item");

        // Passing on intent
        Bundle results = getIntent().getBundleExtra("item");
        if (results != null) {
            String value1 = results.getString("entry");
            items.add(value1);
            writeItems();
        }
    }

    // Save and persist items to file
    private void readItems() {
        File filesDir = getFilesDir();
        File f = new File(filesDir, "journal.txt");
        try {
            items = new ArrayList<String>(FileUtils.readLines(f));
        } catch (IOException e) {
            items = new ArrayList<String>();
        }
    }

    private void writeItems() {
        File filesDir = getFilesDir();
        File f = new File(filesDir, "journal.txt");
        try {
            FileUtils.writeLines(f, items);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}