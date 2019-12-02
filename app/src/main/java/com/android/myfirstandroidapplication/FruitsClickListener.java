package com.android.myfirstandroidapplication;

import android.view.View;

public interface FruitsClickListener {
     void onClick(View view, int position);
     void onLongClick(View view, int position);
}