package com.android.myfirstandroidapplication.storage_sample.room_sample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.myfirstandroidapplication.R;
import com.android.myfirstandroidapplication.activity_sample.MainActivity;
import com.android.myfirstandroidapplication.storage_sample.room_sample.entity.Company;
import com.android.myfirstandroidapplication.storage_sample.room_sample.entity.Employee;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class CompanyAndEmployeesActivity extends AppCompatActivity {

    private static final String TAG = CompanyAndEmployeesActivity.class.getName();

    private TextView dataTextView;
    AppDatabase databaseCreator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_and_employees);

        databaseCreator = AppDatabase.getAppDatabase(getApplicationContext());
        dataTextView = (TextView) findViewById(R.id.textViewDisplayData);
        insertData();
    }

    private void insertData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    DatabaseInitializer.initializeDb(databaseCreator);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }

    public void getDataOnClick(View view) {
        final LiveData<List<Company>> companiesLiveData = databaseCreator.companyDao().getAllCompaniesOrdered();
        final LiveData<List<Company>> companiesByNameLiveData = databaseCreator.companyDao().getCompanies("Apple");
        final LiveData<List<Employee>> employeesLiveData = databaseCreator.employeeDao().getAllEmployees();

        if (companiesLiveData != null) {
            companiesLiveData.observe(this, new Observer<List<Company>>() {
                @Override
                public void onChanged(@Nullable List<Company> countries) {
                    dataTextView.setText(countries.toString() + "\n\n\n");
                }
            });
        }

        if (companiesByNameLiveData != null) {
            companiesByNameLiveData.observe(this, new Observer<List<Company>>() {
                @Override
                public void onChanged(@Nullable List<Company> countries) {
                    dataTextView.append("selected = " + countries.toString() + "\n\n\n");
                }
            });
        }

        if (employeesLiveData != null) {
            employeesLiveData.observe(this, new Observer<List<Employee>>() {
                @Override
                public void onChanged(@Nullable List<Employee> employees) {
                    dataTextView.append(employees.toString() + "\n\n\n");
                }
            });
        }
    }
}