package com.example.fragmentinterfaceactivityjava;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class OverviewFragment extends Fragment {


    private OnItemSelectedListener listener;

    public OverviewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_overview, container, false);

        Button button = view.findViewById(R.id.updateButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail(" ");
            }
        });
        
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof OnItemSelectedListener) {
            listener = (OnItemSelectedListener) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implement OverviewFragment.OnItemSelectedListener");
        }
    }

    interface OnItemSelectedListener  {
        void onRssItemSelected(String text);
    }

    private void updateDetail(String uri) {

        String newTime = System.currentTimeMillis() + uri;
        // send data to activity
        listener.onRssItemSelected(newTime);
    }

}
