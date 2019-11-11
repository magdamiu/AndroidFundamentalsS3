package com.android.myfirstandroidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.service.autofill.TextValueSanitizer;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextEmail;
    private TextView textViewResult;
    private CheckBox checkBoxTermeni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        setContentView(R.layout.new_form);

        initView();

        logs();
    }

    private void initView() {
        editTextEmail = findViewById(R.id.editTextEmail);
        textViewResult = findViewById(R.id.textViewResult);
        checkBoxTermeni = findViewById(R.id.checkboxTermeni);
    }

    private void logs() {
        Log.e("name", "android");
        Log.w("version", "android 10");
        Log.i("curs", "android fundamentals");
    }

    public void getValuesOnClick(View view) {
        if (editTextEmail != null) {
            String result = editTextEmail.getText().toString();
            if (result != null && !result.isEmpty()) {
                if (checkBoxTermeni != null && checkBoxTermeni.isChecked()) {
                    textViewResult.setText(result + " termeni acceptati " + checkBoxTermeni.isChecked());
                } else {
                    textViewResult.setText(result + " termenii nu sunt acceptati " + checkBoxTermeni.isChecked());
                }
            } else {
                editTextEmail.setError("Te rog completeaza adresa");
            }
        }
    }
}
