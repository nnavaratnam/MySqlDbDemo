package com.easyway2in.mysqldbdemo;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class Register extends Activity {
    EditText etName, etFirstName, etMailAdress, etUsername, etPassword;
    String name, firstName, mailAdress, username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
        etName = (EditText) findViewById(R.id.etName);
        etFirstName = (EditText) findViewById(R.id.etFirstName);
        etMailAdress = (EditText) findViewById(R.id.etMailAdress);
        etUsername = (EditText) findViewById(R.id.new_username);
        etPassword = (EditText) findViewById(R.id.new_password);
    }

    public void userReg(View view){

        name = etName.getText().toString();
        firstName = etFirstName.getText().toString();
        mailAdress = etMailAdress.getText().toString();
        username = etUsername.getText().toString();
        password = etPassword.getText().toString();

        String method = "register";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,name, firstName, mailAdress, username, password);
        finish();

    }

}
