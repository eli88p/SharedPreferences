package com.example.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText usernameInput;
    EditText passwordInput;
    TextView infoText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameInput = (EditText) findViewById(R.id.usernameInput);
        passwordInput = (EditText) findViewById(R.id.passwordInput);
        infoText = (TextView) findViewById(R.id.textInfo);
    }

    //Save the users login info
    public void saveInfo(View view){
        SharedPreferences sharedPref = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("username", usernameInput.getText().toString());
        editor.putString("password", passwordInput.getText().toString());
        editor.apply();

        Toast.makeText(this, "Info saved!", Toast.LENGTH_LONG).show();
    }

    //Print out the saved data
    public void displayData(View view){
        SharedPreferences sharedPref = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        String name = sharedPref.getString("username", "");
        String pass = sharedPref.getString("password", "");
        infoText.setText(name + " " + pass);

    }
}
