package com.example.fragmentinterfaceactivityjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements
        OverviewFragment.OnItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onRssItemSelected(String text) {

        // get the FragmentManager with the getSupportFragmentManager()
        FragmentManager fragmentManager = getSupportFragmentManager();
        DetailsFragment detailsFragment = (DetailsFragment) fragmentManager
                .findFragmentById(R.id.detailsFragment);
        detailsFragment.setText(text);

        // alternatively use the getSupportFragmentManager() right away.
      /*  DetailsFragment detailsFragment = (DetailsFragment)getSupportFragmentManager()
                .findFragmentById(R.id.detailsFragment);
        detailsFragment.setText(text);
      */
    }
}
