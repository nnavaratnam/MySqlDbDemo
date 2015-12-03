package com.easyway2in.mysqldbdemo;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by prabeesh on 7/14/2015.
 */
public class BackgroundTask extends AsyncTask<String, Void, String> {


    Context ctx;
    BackgroundTask(Context ctx){
        this.ctx=ctx;
    }

    @Override
    protected void onPreExecute(){
        super.onPreExecute();
    }


    @Override
    protected String doInBackground(String... params) {
        String reg_url = "http://127.0.0.1/Test/register.php";
        String login_url = "http://127.0.0.1/Test/login.php";
        String method = params[0];
        if(method.equals("register")){
            String name = params[1];
            String firstname = params[2];
            String mailAdress = params[3];
            String username = params[4];
            String password = params[5];

            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);

                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));

                String data = URLEncoder.encode("name","UTF-8") + "=" +URLEncoder.encode(name, "UTF-8") +"&"+
                        URLEncoder.encode("firstname","UTF-8") + "=" +URLEncoder.encode(firstname, "UTF-8") +"&"+
                        URLEncoder.encode("mailAdress","UTF-8") + "=" +URLEncoder.encode(mailAdress, "UTF-8") +"&"+
                        URLEncoder.encode("username","UTF-8") + "=" +URLEncoder.encode(username, "UTF-8") +"&"+
                        URLEncoder.encode("password","UTF-8") + "=" +URLEncoder.encode(password, "UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();

                return "Registration Success...";

            }catch(MalformedURLException e){
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    @Override
    protected void onProgressUpdate (Void... values){
        super.onProgressUpdate(values);
    }


    @Override
    protected void onPostExecute(String result){
        Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
    }

}
