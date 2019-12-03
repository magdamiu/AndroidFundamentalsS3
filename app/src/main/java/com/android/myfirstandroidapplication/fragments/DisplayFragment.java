package com.android.myfirstandroidapplication.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.myfirstandroidapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DisplayFragment extends Fragment {

    private TextView textViewDisplay;

    private String message;

    public DisplayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_display, container, false);
        initView(view);

        //String message = getMessageFromActivityWithBundle();
        String message = getMessageFromActivityWithMethod();
        textViewDisplay.setText(message);
        return view;
    }

    private String getMessageFromActivityWithBundle() {
        Bundle bundle = getArguments();
        return bundle.getString(MessageActivity.MESS);
    }

    private String getMessageFromActivityWithMethod() {
        return this.message;
    }

    private void initView(View view) {
        textViewDisplay = view.findViewById(R.id.textViewDisplay);
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
