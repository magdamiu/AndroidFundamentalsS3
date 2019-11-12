package com.android.myfirstandroidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.TooManyListenersException;

public class FoodActivity extends AppCompatActivity {

    private List<String> foodList;
    private Spinner spinnerFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        initView();
        getDataSource();
        displaySpinnerList();
    }

    private void initView() {
        spinnerFood = findViewById(R.id.spinnerFood);
    }

    private void createToast() {
        Toast.makeText(this, "selected", Toast.LENGTH_LONG).show();
    }

    private ArrayAdapter<String> getSpinnerAdapter() {
        return new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, foodList);
    }

    private void displaySpinnerList() {
        spinnerFood.setAdapter(getSpinnerAdapter());
    }

    private void getDataSource() {
        foodList = new ArrayList<>();
        foodList.add("pizza");
        foodList.add("paste");
        foodList.add("burger");
        foodList.add("humus");
        foodList.add("tiramisu");
        foodList.add("ceafa de porc");
        foodList.add("falafel");
        foodList.add("mamaliga");
        foodList.add("risotto");
        foodList.add("foie gras");
    }
}
