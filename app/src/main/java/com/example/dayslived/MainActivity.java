package com.example.dayslived;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        LoginManager lManager = new LoginManager();
//        lManager.createUsers("Stanley","Lalanne");
    }

    public void authenticateUser(View v){
            Intent intent = new Intent(this, datePickerActivity.class);
            EditText uname = (EditText) findViewById(R.id.userName);
            EditText pword = (EditText) findViewById(R.id.password);
            String name = uname.getText().toString();
            String psswd = pword.getText().toString();

            Boolean isValid = LoginManager.isKnownUser(name, psswd);

            if (isValid == true) {
                intent.putExtra("msg", "Welcome " + name);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(getApplicationContext(), "Wrong Credentials. Try Again", Toast.LENGTH_LONG).show();
            }
        }

    }
