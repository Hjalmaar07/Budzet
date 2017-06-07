package com.example.dkuberski.budzet;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class Login extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void click(View view) throws Exception
    {
        if(sendPost2(view))
        {

        }

    }

        public boolean sendPost2(View view) throws Exception {
            EditText loginEmail = (EditText) findViewById(R.id.loginEmailEditText);
            String loginEmailTxt = loginEmail.getText().toString();
            EditText loginPassword = (EditText) findViewById(R.id.loginPasswordEditText);
            String loginPasswordTxt = loginPassword.getText().toString();




            new LoginHandler().execute(loginEmailTxt,loginPasswordTxt);

            if(response.toString() != "Problim"){
                return false;
            }
            else
            {
                return true;

            }
        }

}
