package com.android.myfirstandroidapplication.storage_sample.room_sample.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = Company.class,
        parentColumns = "id",
        childColumns = "company_id",
        onDelete = ForeignKey.CASCADE))
public class Employee {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int employeeId;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "company_id")
    private int companyId;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    /*public Employee(int employeeId, String name, int companyId) {
        this.employeeId = employeeId;
        this.name = name;
        this.companyId = companyId;
    }*/

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", companyId=" + companyId +
                '}';
    }
}