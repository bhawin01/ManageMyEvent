package com.example.samyak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class AdminLogoutActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_logout);

        btn = (Button)findViewById(R.id.adminLogout);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AdminLogoutActivity.this, LoginActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Logged out!",Toast.LENGTH_LONG).show();

            }
        });





    }
}
