package com.example.dkuberski.budzet;


import android.content.Intent;
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

    public void goToRegister(View view) throws Exception
    {
        Intent register = new Intent(this, Register.class);
        startActivity(register);
    }

    public void click(View view) throws Exception
    {
        if(sendPost2(view))
        {
            Toast.makeText(this, "Pomyslnie zalogowano", Toast.LENGTH_SHORT).show();
            Intent main = new Intent(this, MainActivity.class);
            startActivity(main);
        }
        else Toast.makeText(this, "Niepoprawny adres e-mail lub haslo", Toast.LENGTH_LONG).show();

    }

        public boolean sendPost2(View view) throws Exception {
            EditText loginEmail = (EditText) findViewById(R.id.loginEmailEditText);
            String loginEmailTxt = loginEmail.getText().toString();
            EditText loginPassword = (EditText) findViewById(R.id.loginPasswordEditText);
            String loginPasswordTxt = loginPassword.getText().toString();




            new LoginHandler().execute(loginEmailTxt,loginPasswordTxt);

            if(LoginHandler.getDziala() == 0 ){
                return false;
            }
            else
            {
                return true;

            }
        }

}
