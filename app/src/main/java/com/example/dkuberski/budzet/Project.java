package com.example.dkuberski.budzet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Project extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);
    }

    public void sendPost(View view) throws Exception {
        EditText nazwaProjektu = (EditText) findViewById(R.id.NazwaInsert);
        String nazwaProjektuTxt = nazwaProjektu.getText().toString();
        EditText miejsceProjektu = (EditText) findViewById(R.id.MiejsceTxt);
        String miejsceProjektuTxt = miejsceProjektu.getText().toString();
        EditText opisProjektu = (EditText) findViewById(R.id.OpisTxt);
        String opisProjektuTxt = opisProjektu.getText().toString();

        try {
            // open a connection to the site
            String sURL = "217.61.16.10/mateusz/add_project.php?";
            sURL += "nazwaProjektu="+nazwaProjektuTxt +
                    "&"+
                    "opisProjektu="+opisProjektuTxt;

            URL url = new URL(sURL);
            URLConnection con = url.openConnection();
            // activate the output
            con.setDoOutput(true);
            /*PrintStream ps = new PrintStream(con.getOutputStream());
            // send your parameters to your site
            ps.print(nazwaProjektuTxt);
            ps.print(miejsceProjektuTxt);
            ps.print(opisProjektuTxt);
*/
            // we have to get the input stream in order to actually send the request
            con.getInputStream();

            // close the print stream
            //ps.close();
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }


    }
}

