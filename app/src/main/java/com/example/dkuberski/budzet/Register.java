package com.example.dkuberski.budzet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void sendPost2(View view) throws Exception {
        EditText registerLogin = (EditText) findViewById(R.id.editText3);
        String registerLoginTxt = registerLogin.getText().toString();
        EditText registerEmail = (EditText) findViewById(R.id.registerEmailEditText);
        String registerEmailTxt = registerEmail.getText().toString();
        EditText registerPassword = (EditText) findViewById(R.id.registerPasswordEditText);
        String registerPasswordTxt = registerPassword.getText().toString();


        new RegisterHandler().execute(registerLoginTxt,registerEmailTxt,registerPasswordTxt);
    }

}
