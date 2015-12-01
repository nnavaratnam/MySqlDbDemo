package com.easyway2in.mysqldbdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends Activity {

    EditText etUsername,etPassword;
    String login_name,login_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




    public void userReg(View view){


        startActivity(new Intent(this,Register.class));
    }

    public void userLogin(View view){
        login_name = etUsername.getText().toString();
        login_pass = etPassword.getText().toString();
        String method = "login";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,login_name,login_pass);
    }
}