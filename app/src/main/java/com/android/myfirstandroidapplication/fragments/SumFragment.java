package com.android.myfirstandroidapplication.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.android.myfirstandroidapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SumFragment extends Fragment {

    private EditText editTextFirst;
    private EditText editTextSecond;
    private Button buttonSendSum;

    public SumFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sum, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        editTextFirst = view.findViewById(R.id.editTextFirst);
        editTextSecond = view.findViewById(R.id.editTextSecond);
        buttonSendSum = view.findViewById(R.id.buttonSendSum);

        buttonSendSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
            }
        });
    }

    private void sendData() {
        int firstNumber = Integer.valueOf(editTextFirst.getText().toString());
        int secondNumber = Integer.valueOf(editTextSecond.getText().toString());
        TheListener theListener = (TheListener) getActivity();
        theListener.add(firstNumber, secondNumber);
    }

}
