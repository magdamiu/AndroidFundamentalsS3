package com.android.myfirstandroidapplication.storage_sample.room_sample;

import com.android.myfirstandroidapplication.storage_sample.room_sample.dao.CompanyDao;

public class CompanyRepository {

    private final CompanyDao companyDao;

    public CompanyRepository(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }
}