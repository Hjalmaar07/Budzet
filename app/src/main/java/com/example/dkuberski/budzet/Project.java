package com.example.dkuberski.budzet;

import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.sql.SQLException;

import javax.net.ssl.HttpsURLConnection;

public class Project extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);
    }

    public void sendPost(View view) throws Exception {
        EditText nazwaProjektu = (EditText) findViewById(R.id.NazwaInsert);
        String nazwaProjektuTxt = nazwaProjektu.getText().toString();
       // EditText miejsceProjektu = (EditText) findViewById(R.id.MiejsceTxt);
       // String miejsceProjektuTxt = miejsceProjektu.getText().toString();
        EditText opisProjektu = (EditText) findViewById(R.id.OpisTxt);
        String opisProjektuTxt = opisProjektu.getText().toString();

        new DataBaseHandler().execute(nazwaProjektuTxt,opisProjektuTxt);
    }

}

