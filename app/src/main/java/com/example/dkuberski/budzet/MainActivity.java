package com.example.dkuberski.budzet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void goToLogin(View v)
    {
        Intent login = new Intent(this, Login.class);
        startActivity(login);
    }
    public void goToProject(View v)
    {
        Intent Project = new Intent(this, Project.class);
        startActivity(Project);
    }



}
