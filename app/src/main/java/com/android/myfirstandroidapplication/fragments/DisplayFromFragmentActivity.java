package com.android.myfirstandroidapplication.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TextView;

import com.android.myfirstandroidapplication.R;

public class DisplayFromFragmentActivity extends AppCompatActivity implements TheListener {

    private TextView textViewSum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_from_fragment);

        initView();
    }

    private void initView() {
        textViewSum = findViewById(R.id.textViewSum);
        //SumFragment sumFragment = new SumFragment();
        //replaceFragment(sumFragment);
        replaceFragment(new SumFragment());
    }

    @Override
    public void add(int firstNumber, int secondNumber) {
        int sum = firstNumber + secondNumber;
        textViewSum.setText(sum + "");
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content_sum, fragment);
        fragmentTransaction.commit();
    }
}
