package com.android.myfirstandroidapplication.retrofit_sample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.myfirstandroidapplication.R;
import com.android.myfirstandroidapplication.challenges.Logging;

import java.util.List;

public class GithubActivity extends AppCompatActivity {

    private UsersRepository usersRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github);

        usersRepository = UsersRepository.getInstance();

        usersRepository.getUsers(new OnGetUsersCallback() {
            @Override
            public void onSuccess(List<User> users) {
                StringBuilder stringBuilder = new StringBuilder();
                for (User user : users) {
                    stringBuilder.append(user.toString() + " /// ");
                }
                Logging.show("Github users = ", users.toString());
                Toast.makeText(GithubActivity.this, stringBuilder.toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError() {
                Logging.show("error Github users = ", "check the code :D ");
                Toast.makeText(GithubActivity.this, "error getting the Github users",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}