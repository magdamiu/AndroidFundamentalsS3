package com.android.myfirstandroidapplication.storage_sample.room_sample;

import com.android.myfirstandroidapplication.storage_sample.room_sample.entity.Company;
import com.android.myfirstandroidapplication.storage_sample.room_sample.entity.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DatabaseInitializer {

    private static final String TAG = DatabaseInitializer.class.getName();
    private static final String[] COMPANIES = new String[]{
            "Google", "Apple", "LinkedIN"};

    static void initializeDb(AppDatabase db) {
        List<Company> companies = new ArrayList<>(COMPANIES.length);
        List<Employee> employees = new ArrayList<>();

        generateData(companies, employees);

        insertData(db, companies, employees);
    }

    private static void generateData(List<Company> companies, List<Employee> cities) {
        Random rnd = new Random();
        for (int i = 0; i < COMPANIES.length; i++) {
            Company company = new Company();
            company.setName(COMPANIES[i]);
            company.setCompanyId(i + 1);
            companies.add(company);
        }

        for (Company company : companies) {
            int citiesNumber = rnd.nextInt(5) + 1;
            for (int i = 0; i < citiesNumber; i++) {
                Employee employee = new Employee();
                employee.setCompanyId(company.getCompanyId());
                employee.setName("Employee " + (i + 1) + " from " + company.getName());
                cities.add(employee);
            }
        }

    }

    private static void insertData(final AppDatabase db, List<Company> companies, List<Employee>
            employees) {
        db.companyDao().insertAll(companies);
        db.employeeDao().insertAll(employees);
    }
}