package com.example.samyak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AdminLoginActivity extends AppCompatActivity {


    EditText et1, et2;
    Button btn;
    String email;
    String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);


        et1 = (EditText)findViewById(R.id.adminEmail);
        et2 = (EditText)findViewById(R.id.adminPassword);
        btn = (Button)findViewById(R.id.adminLogin);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = et1.getText().toString();
                password = et2.getText().toString();

                Toast.makeText(getApplicationContext(),email,Toast.LENGTH_LONG).show();

                if(email.equals("admin") && password.equals("admin"))
                {
                    Intent intent=new Intent(AdminLoginActivity.this,AdminActivity.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),"Welcome, Admin!",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Incorrect Credentials",Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}
