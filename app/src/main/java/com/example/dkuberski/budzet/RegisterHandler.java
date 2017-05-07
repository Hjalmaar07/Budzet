package com.example.dkuberski.budzet;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Mateusz on 24.04.2017.
 */

public class RegisterHandler extends AsyncTask<String, Void, Boolean> {

        RegisterHandler(String...args){}
    @Override
    protected Boolean doInBackground(String... params) {
        String registerLoginTxt = params[0];
        String registerEmailTxt = params[1];
        String registerPasswordTxt = params[2];
       try {
           String url = "http://217.61.16.10/mateusz/register.php";
           URL obj = new URL(url);
           HttpURLConnection con = (HttpURLConnection) obj.openConnection();

           con.setRequestMethod("POST");

           String str = "registerLoginTxt=" + registerLoginTxt + "&registerEmailTxt=" + registerEmailTxt + "&registerPasswordTxt=" + registerPasswordTxt;

           // Send post request
           con.setDoOutput(true);
           DataOutputStream wr = new DataOutputStream(con.getOutputStream());
           wr.writeBytes(str);
           wr.flush();
           wr.close();

           int responseCode = con.getResponseCode();
           System.out.println("\nSending 'POST' request to URL : " + url);
           System.out.println("Post parameters : " + str);
           System.out.println("Response Code : " + responseCode);

           BufferedReader in = new BufferedReader(
                   new InputStreamReader(con.getInputStream()));
           String inputLine;
           StringBuffer response = new StringBuffer();

           while ((inputLine = in.readLine()) != null) {
               response.append(inputLine);
           }
           in.close();

           //print result
           System.out.println(response.toString());
       }
       catch(Exception ex){
           Log.e("RegisterHandler","",ex);
       }
        return true;
    }
}
