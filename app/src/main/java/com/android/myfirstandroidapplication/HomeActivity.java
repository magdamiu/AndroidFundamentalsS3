package com.android.myfirstandroidapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.myfirstandroidapplication.activity_sample.FoodActivity;
import com.android.myfirstandroidapplication.activity_sample.LifecycleActivity;
import com.android.myfirstandroidapplication.activity_sample.MainActivity;
import com.android.myfirstandroidapplication.fragments.AlertsActivity;
import com.android.myfirstandroidapplication.recycler_view_sample.FruitsActivity;
import com.android.myfirstandroidapplication.retrofit_sample.GithubActivity;
import com.android.myfirstandroidapplication.storage_sample.room_sample.CompanyAndEmployeesActivity;
import com.android.myfirstandroidapplication.tab_sample.TabsActivity;

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

    public void openTabsOnClick(View view) {
        startActivity(new Intent(this, TabsActivity.class));
    }

    public void navDrawerOnClick(View view) {
        startActivity(new Intent(this, com.android.myfirstandroidapplication.fragments.HomeActivity.class));
    }

    public void dateAndDateTimePickerOnClick(View view) {
        startActivity(new Intent(this, AlertsActivity.class));
    }

    public void retrofitSampleOnClick(View view) {
        startActivity(new Intent(this, GithubActivity.class));
    }

    public void roomSampleOnClick(View view) {
        startActivity(new Intent(this, CompanyAndEmployeesActivity.class));
    }
}
