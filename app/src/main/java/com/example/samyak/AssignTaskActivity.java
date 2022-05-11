package com.example.samyak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AssignTaskActivity extends AppCompatActivity {

  EditText et;
    Button bt;
    AutoCompleteTextView autocomplete;

    DatabaseReference dr;

    private static final String TAG = AssignTaskActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign_task);


        bt = (Button)findViewById(R.id.assignTask);
        et = (EditText)findViewById(R.id.taskValue);

        dr = FirebaseDatabase.getInstance().getReference("Task");












        String[] arr = { "Volunteer Head", "Tech Head","Event Day Head",
                "Creative Head", "Logistics Head", "Finance Head"};

            autocomplete = (AutoCompleteTextView)
                    findViewById(R.id.autoCompleteTextView2);

            ArrayAdapter<String> adapter = new ArrayAdapter<String>
                    (this,android.R.layout.select_dialog_item, arr);

            autocomplete.setThreshold(2);
            autocomplete.setAdapter(adapter);
        }



    void Show1(View v) {

        Toast.makeText(getApplicationContext(),"Task Assigned!",Toast.LENGTH_LONG).show();


        String autocomplete1 = autocomplete.getText().toString();
        String et1 = et.getText().toString();


        String id= "100";
        db2 d1 = new db2(id,autocomplete1, et1);
        dr.child(id).setValue(d1);

//Toast.makeText(getApplicationContext(),"",Toast.LENGTH_LONG).show();
    }



}

