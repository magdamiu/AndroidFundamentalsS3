package com.android.myfirstandroidapplication.retrofit_sample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.android.myfirstandroidapplication.R;
import com.android.myfirstandroidapplication.challenges.Logging;

import java.util.List;

public class GithubActivity extends AppCompatActivity {

    private UsersRepository usersRepository;
    private IssuesRepository issuesRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github);

        getUsers();

        Issue issue = new Issue();
        issue.setTitle("This is a test #2");
        issue.setBody("Post an issue from code :) ");

        String token = "token ";
        postIssue("magdamiu", "AndroidFundamentalsS3", token, issue);

    }

    private void getUsers() {
        usersRepository = UsersRepository.getInstance();

        usersRepository.getUsers(new OnGetUsersCallback() {
            @Override
            public void onSuccess(List<User> users) {
                StringBuilder stringBuilder = new StringBuilder();
                for (User user : users) {
                    stringBuilder.append(user.toString() + " /// ");
                }
                Logging.show("Github users = ", users.toString());
                Toast.makeText(GithubActivity.this, stringBuilder.toString(), Toast.LENGTH_LONG)
                        .show();
            }

            @Override
            public void onError() {
                Logging.show("error Github users = ", "check the code :D ");
                Toast.makeText(GithubActivity.this, "error getting the Github users",
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    private void postIssue(String user, String repo, String token, Issue issue) {
        issuesRepository = IssuesRepository.getInstance();

        issuesRepository.postIssue(new OnPostIssueCallback() {
            @Override
            public void onSuccess(Issue issueResult) {
                Logging.show("Github issue = ", issueResult.toString());
                Toast.makeText(GithubActivity.this, issueResult.toString(), Toast.LENGTH_LONG)
                        .show();
            }

            @Override
            public void onError() {
                Logging.show("error Github post issue = ", "check the code :D ");
                Toast.makeText(GithubActivity.this, "error posting an issue",
                        Toast.LENGTH_LONG).show();
            }
        }, user, repo, token, issue);
    }
}