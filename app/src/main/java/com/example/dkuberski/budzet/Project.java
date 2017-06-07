package com.example.dkuberski.budzet;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


import android.util.Log;

public class Project extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);
    }

    private ArrayList<Projects> listaWoj;
    listaWoj = new ArrayList<Projects>();

    public void sendPost(View view) throws Exception {
        TextView nazwaProjektu = (TextView) findViewById(R.id.textView6);
        String nazwaProjektuTxt = nazwaProjektu.getText().toString();
        TextView opisProjektu = (TextView) findViewById(R.id.textView5);
        String opisProjektuTxt = opisProjektu.getText().toString();
        Spinner wojewodztwo = (Spinner) findViewById(R.id.WojewodztwoTxt);
        String wojewodztwoTxt = wojewodztwo.getSelectedItem().toString();


        new DataBaseHandler().execute(nazwaProjektuTxt,opisProjektuTxt,wojewodztwoTxt);
    }


    public void getWojewodztwa(View view) {
        new GetMethodDemo().execute("http://217.61.16.10/mateusz/getWoj.php");
    }
    private String readStream(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader r = new BufferedReader(new InputStreamReader(is),1000);
        for (String line = r.readLine(); line != null; line =r.readLine()){
            sb.append(line);
        }
        is.close();
        return sb.toString();
    }

    public class Projects {
        int id;
        String nazwa;
        public Projects(){}

        public Projects(int id, String nazwa) {
            this.id = id;
            this.nazwa = nazwa;
        }
        public void setId(int id){
            this.id = id;
        }

        public void setName(String nazwa){
            this.nazwa = nazwa;
        }

        public int getId(){
            return this.id;
        }

        public String getName(){
            return this.nazwa;
        }
    }
    public class GetMethodDemo extends AsyncTask<String, Void, String> {


        String server_response;
        @Override
        protected String doInBackground(String... strings) {
            URL url;
            HttpURLConnection urlConnection;
            try {
                url = new URL(strings[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                int responseCode = urlConnection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    server_response = readStream(urlConnection.getInputStream());
                    Log.v("CatalogClient", server_response);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                url = new URL(strings[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        urlConnection.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null)
                    System.out.println(inputLine);
                in.close();
                Log.v("bufferv ", server_response);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.e("Response", "" + server_response);
            TextView textView = (TextView) findViewById(R.id.TextView4);

            Gson gson = new Gson();
            Projects[] projectsArray = gson.fromJson(server_response, Projects[].class);

            StringBuilder test = new StringBuilder();

            for (int i = 0; i < projectsArray.length; i++){
                test.append("Nazwa: ");
                test.append(projectsArray[i].id);
                test.append(" Opis: ");
                test.append(projectsArray[i].nazwa);
                test.append("\n");
            }

            textView.setText(test.toString());

            // chyba niepotrzebne txtCategory.setText("");

            // -----
            List<String> lables = new ArrayList<String>();



            for (int i = 0; i < listaWoj.size(); i++) {
                lables.add(listaWoj.get(i).getName());
            }
/* to chyba tez nie potrzebne
            // Creating adapter for spinner
            ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, lables);

            // Drop down layout style - list view with radio button
            spinnerAdapter
                    .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            // attaching data adapter to spinner
            spinnerFood.setAdapter(spinnerAdapter);

*/
        }
    }
// ------


}

