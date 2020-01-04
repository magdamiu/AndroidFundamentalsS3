package com.android.myfirstandroidapplication.retrofit_sample;

import java.util.List;

public interface OnGetUsersCallback {

    void onSuccess(List<User> users);

    void onError();
}