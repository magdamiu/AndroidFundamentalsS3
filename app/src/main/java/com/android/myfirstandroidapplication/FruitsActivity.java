package com.android.myfirstandroidapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class FruitsActivity extends AppCompatActivity {

    private List<Fruit> fruits;

    private RecyclerView recyclerViewFruits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruits);
        initView();
        getFruits();
        setLayoutManager();
        setAdapter();
    }

    private void initView() {
        recyclerViewFruits = findViewById(R.id.recyclerViewFruits);
    }

    private void setLayoutManager() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewFruits.setLayoutManager(layoutManager);
    }

    private void setAdapter() {
        FruitsAdapter fruitsAdapter = new FruitsAdapter(fruits);
        recyclerViewFruits.setAdapter(fruitsAdapter);
    }

    private void getFruits() {
        fruits = new ArrayList<>();

        fruits.add(new Fruit("capsuni", "rosu",
                "https://cdn3.vectorstock.com/i/1000x1000/67/02/garden-strawberry-icon-vector-22516702.jpg"));
        fruits.add(new Fruit("banana", "galben"));
        fruits.add(new Fruit("mere", "verde"));
        fruits.add(new Fruit("fructul pasiunii", "portocaliu"));
        fruits.add(new Fruit("mure", "albastru"));
        fruits.add(new Fruit("mango", "galben"));
        fruits.add(new Fruit("afine", "albastru"));
        fruits.add(new Fruit("pepene", "rosu"));
        fruits.add(new Fruit("pomelo", "galben"));
        fruits.add(new Fruit("kiwi", "verde"));
        fruits.add(new Fruit("pere", "galben"));
    }
}
