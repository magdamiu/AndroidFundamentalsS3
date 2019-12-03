package com.android.myfirstandroidapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void uiElementsOnClick(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void spinnerWithFoodOnClick(View view) {
        startActivity(new Intent(this, FoodActivity.class));
    }

    public void recyclerViewWithFruitsOnClick(View view) {
        startActivity(new Intent(this, FruitsActivity.class));
    }

    public void activitiesOnClick(View view) {
        startActivity(new Intent(this, LifecycleActivity.class));
    }

    public void openStaticFragmentOnClick(View view) {
        startActivity(new Intent(this, FragmentActivity.class));
    }
}
