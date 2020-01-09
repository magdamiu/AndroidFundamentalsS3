package com.android.myfirstandroidapplication.storage_sample.room_sample;

import android.content.Context;

import androidx.annotation.VisibleForTesting;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.android.myfirstandroidapplication.storage_sample.room_sample.dao.CompanyDao;
import com.android.myfirstandroidapplication.storage_sample.room_sample.dao.EmployeeDao;
import com.android.myfirstandroidapplication.storage_sample.room_sample.entity.Company;
import com.android.myfirstandroidapplication.storage_sample.room_sample.entity.Employee;

@Database(entities = {Company.class, Employee.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    static final String DATABASE_NAME = "company-db";

    private static AppDatabase INSTANCE;

    public abstract CompanyDao companyDao();
    public abstract EmployeeDao employeeDao();

    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DATABASE_NAME)
                            //.addMigrations(MIGRATION_1_2)
                            .build();
        }
        return INSTANCE;
    }



    /**
     * Migrate from:
     * version 1 - using Room
     * to
     * version 2 - using Room where the {@link Company} has an extra field: iso3
     */
    @VisibleForTesting
    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE Company "
                    + " ADD COLUMN ref_no TEXT");
        }
    };

    public static void destroyInstance() {
        INSTANCE = null;
    }
}