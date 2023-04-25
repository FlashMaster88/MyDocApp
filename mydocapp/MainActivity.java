package com.example.mydocapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int position ;
    Button signupbutton;
    Button loginbutton;
    Button lookusers;
    EditText userpassword;
    EditText useremail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Singleton.getInstance().setContext(MainActivity.this);



        signupbutton = findViewById(R.id.signupbutton);
        loginbutton = findViewById(R.id.loginbutton);
        lookusers = findViewById(R.id.lookusers);

        useremail = findViewById(R.id.useremail);
        userpassword = findViewById(R.id.userpassword);
        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,
                        UserSignUp.class);
                startActivity(intent);

            }});

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i = 0; i <= Singleton.getInstance().getUsers().size(); i++) {

                    UserData user = Singleton.getInstance().getUsers().get(position);
                    String a1 = user.userid;
                    String a2 = user.password;

                    if (useremail.getText().toString().equals(a1) && userpassword.getText().toString().equals(a2)) {

                        Toast.makeText(MainActivity.this, "Login Successfully!",
                                Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MainActivity.this,
                                SelectDocPage.class);
                        startActivity(intent);

                    }
                    position++;
                }
            }
            });

        lookusers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    AlertDialog.Builder pswdDialog = new AlertDialog.Builder(MainActivity.this);
                    pswdDialog.setTitle("Enter Password");

                    final EditText input = new EditText(MainActivity.this);
                    pswdDialog.setView(input);

                    pswdDialog.setPositiveButton("Login", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            String password = input.getText().toString();
                            if (password.equals("admin")) {
                                Intent intent = new Intent(MainActivity.this, UserDetails.class);
                                startActivity(intent);
                                dialogInterface.dismiss();
                            }else{
                                Toast.makeText(MainActivity.this, "Incorrect password", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                    pswdDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });

                    pswdDialog.show();
            }});


    }

}
