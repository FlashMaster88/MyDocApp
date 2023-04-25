package com.example.mydocapp;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class UserSignUp extends AppCompatActivity {

    Button newusersignup;
    EditText mobilenum;
    EditText newuseremail;
    EditText userdob;
    EditText newuserpwd;
    String s1 ,s2;
    Spinner spinner;

    String[] CountryCode = {"+33","+34","+39","+49"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_sign_up);

        newusersignup = findViewById(R.id.newusersignup);
        mobilenum = findViewById(R.id.mobilenum);
        newuseremail = findViewById(R.id.newuseremail);
        userdob = findViewById(R.id.userdob);
        newuserpwd = findViewById(R.id.newuserpwd);

        setTitle("User SignUp Page");

        spinner = findViewById(R.id.spinner);

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,CountryCode);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa);
        spinner.getSelectedItemPosition();

        newusersignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertBuilder =
                        new AlertDialog.Builder(UserSignUp.this);
                alertBuilder.setTitle("Attention");
                alertBuilder.setMessage("Done signing up?");
                alertBuilder.setNegativeButton(android.R.string.no,
                        null);

                alertBuilder.setPositiveButton(android.R.string.yes,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(UserSignUp.this, "New user created successfully!" +"\n"+
                                                "Welcome to MyDocApp!",
                                        Toast.LENGTH_LONG).show();
                                s1 = newuseremail.getText().toString();
                                s2 = newuserpwd.getText().toString();
                                UserData c = new UserData();
                                c.userid = s1 ;
                                c.password = s2;
                                Singleton.getInstance().addUser(c);

                                finish();
                                Intent intent = new Intent(UserSignUp.this,
                                        MainActivity.class);
                                startActivity(intent);

                            }});
                                alertBuilder.create().show();
                            }
                        });

    }
}