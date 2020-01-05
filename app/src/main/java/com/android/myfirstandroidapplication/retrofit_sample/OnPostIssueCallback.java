package com.android.myfirstandroidapplication.retrofit_sample;

import java.util.List;

public interface OnPostIssueCallback {
    void onSuccess(Issue issue);
    void onError();
}
