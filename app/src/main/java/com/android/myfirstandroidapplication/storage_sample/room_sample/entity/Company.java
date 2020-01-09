package com.android.myfirstandroidapplication.storage_sample.room_sample.entity;

import android.graphics.Bitmap;
import android.location.Location;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.android.myfirstandroidapplication.storage_sample.room_sample.converter.DateConverter;

import java.util.Date;

@Entity(tableName = "Company")
public class Company {

    @PrimaryKey
    @ColumnInfo(name = "id")
    private int companyId;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "date_updated")
    @TypeConverters(DateConverter.class)
    private Date itemUpdatedDate;

    @Ignore
    Bitmap picture;

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getItemUpdatedDate() {
        return itemUpdatedDate;
    }

    public void setItemUpdatedDate(Date itemUpdatedDate) {
        this.itemUpdatedDate = itemUpdatedDate;
    }

    public Bitmap getPicture() {
        return picture;
    }

    public void setPicture(Bitmap picture) {
        this.picture = picture;
    }

    public Company() {
    }

    public Company(int companyId, String name, Date itemUpdatedDate, Bitmap picture) {
        this.companyId = companyId;
        this.name = name;
        this.itemUpdatedDate = itemUpdatedDate;
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", name='" + name + '\'' +
                ", itemUpdatedDate=" + itemUpdatedDate +
                ", picture=" + picture +
                '}';
    }
}