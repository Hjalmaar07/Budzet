package com.example.dkuberski.budzet;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by dkuberski on 2017-06-04.
 */

public class LoginHandler extends AsyncTask<String, Void, Boolean> {

    static private int dziala = 0;

    LoginHandler(String...args){}
    @Override
    protected Boolean doInBackground(String... params) {
        String loginEmailTxt = params[0];
        String loginPasswordTxt = params[1];
        try {
            String url = "http://217.61.16.10/mateusz/login.php";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();



            con.setRequestMethod("POST");

            String str = "registerEmailTxt=" + loginEmailTxt + "&registerPasswordTxt=" + loginPasswordTxt;

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
            if (response.toString() == "Problim")
            {
                dziala = 0;
            }
            else dziala = 1;

            //print result
            System.out.println(response.toString());





        }
        catch(Exception ex){
            Log.e("RegisterHandler","",ex);
        }
        return true;
    }

    static public int getDziala()
    {
        return dziala;
    }

}
