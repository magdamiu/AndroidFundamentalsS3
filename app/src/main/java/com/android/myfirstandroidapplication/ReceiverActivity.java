package com.android.myfirstandroidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ReceiverActivity extends AppCompatActivity {

    private TextView textViewReceivedMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);
        initView();

        // varianta 2
        Bundle bundle = getIntent().getExtras();
        if(bundle != null && bundle.containsKey(LifecycleActivity.MESSAGE)) {
            String receivedMessage = bundle.getString(LifecycleActivity.MESSAGE);
            textViewReceivedMessage.setText(receivedMessage);

            Intent intent = new Intent();
            intent.putExtra(LifecycleActivity.MESSAGE, receivedMessage + " (am primit)");
            setResult(RESULT_OK, intent);
            finish();
        }
    }

    private void initView() {
        textViewReceivedMessage = findViewById(R.id.textViewReceivedMessage);
    }
}
