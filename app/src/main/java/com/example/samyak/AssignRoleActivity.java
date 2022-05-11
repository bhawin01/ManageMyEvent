package com.example.samyak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AssignRoleActivity extends AppCompatActivity {


    AutoCompleteTextView task;
    Button button;
    Spinner spinner;
    DatabaseReference dr;

        private static final String TAG = AssignRoleActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign_role);


        task = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        button = (Button) findViewById(R.id.assignTask1);
        spinner = (Spinner) findViewById(R.id.emailList);
        dr = FirebaseDatabase.getInstance().getReference("Role");




        AutoCompleteTextView autocomplete;

        String[] arr = { "Volunteer Head", "Tech Head","Event Day Head",
                "Creative Head", "Logistics Head", "Finance Head"};

        autocomplete = (AutoCompleteTextView)
                findViewById(R.id.autoCompleteTextView1);

        ArrayAdapter<String> adapt = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item, arr);

        autocomplete.setThreshold(2);
        autocomplete.setAdapter(adapt);





        Spinner spinner = (Spinner) findViewById(R.id.emailList);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.email_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setPrompt("Select the email address!");
// Apply the adapter to the spinner
        spinner.setAdapter(
                new NothingSelectedSpinnerAdapter(
                        adapter,
                        R.layout.contact_spinner_row_nothing_selected,
                        // R.layout.contact_spinner_nothing_selected_dropdown, // Optional
                        this));


    }


    void Show(View v) {

        Toast.makeText(getApplicationContext(),"Role Assigned!",Toast.LENGTH_LONG).show();


            String task1 = task.getText().toString();
        String emailSelected = spinner.getSelectedItem().toString();

        String id= "100";

        db1 d1 = new db1(id,task1, emailSelected);
        dr.child(id).setValue(d1);

//Toast.makeText(getApplicationContext(),"",Toast.LENGTH_LONG).show();
    }

}
