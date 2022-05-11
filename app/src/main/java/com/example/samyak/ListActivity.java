package com.example.samyak;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class ListActivity extends AppCompatActivity  implements View.OnClickListener {

    TextView tv;
   EditText et;
    Button ab;
    String date;
    DatabaseReference dr;
    private static final String TAG = AssignTaskActivity.class.getSimpleName();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);
tv=(TextView)findViewById(R.id.tt);


        String nameff="Task";
        String sc="100";
        dr = FirebaseDatabase.getInstance().getReference().child(nameff).child(sc);
        dr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String task= dataSnapshot.child("et1").getValue().toString();
                //String id= dataSnapshot.child("id").getValue().toString();
                //String roleAssigned= dataSnapshot.child("task1").getValue().toString();

                tv.setText(task);
               // Toast.makeText(getApplicationContext(),"name",Toast.LENGTH_LONG).show();
                //Toast.makeText(getApplicationContext(),id,Toast.LENGTH_LONG).show();
                //Toast.makeText(getApplicationContext(),roleAssigned,Toast.LENGTH_LONG).show();
               /* for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    String name1 = ds.getKey();
                    Toast.makeText(getApplicationContext(),name1,Toast.LENGTH_LONG).show();
               }
*/
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });









        Button bb = (Button) findViewById(R.id.com);
        final RelativeLayout rl = (RelativeLayout) findViewById(R.id.hide);
        TextView tv=(TextView)findViewById(R.id.tt);

         ab = (Button) findViewById(R.id.exten);
        final DatePicker dd = (DatePicker) findViewById(R.id.cal);
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rl.setVisibility(View.GONE);
                Toast.makeText(ListActivity.this, "Task completed, wait for approval!", Toast.LENGTH_SHORT).show();
            }

        });

        ab.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {


        if (v == ab) {
            // Get Current Date
            final Calendar c = Calendar.getInstance();
            int mYear = c.get(Calendar.YEAR);
            int mMonth = c.get(Calendar.MONTH);
            int mDay = c.get(Calendar.DAY_OF_MONTH);



            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            //Toast.makeText(ListActivity.this, "Extention requested for "+date, Toast.LENGTH_SHORT).show();
                            monthOfYear = monthOfYear+1;
                            date = dayOfMonth+"-"+monthOfYear+"-"+year;
                            Toast.makeText(ListActivity.this, "Extension requested for "+date, Toast.LENGTH_SHORT).show();


                            String id= "Extension";
                            dr = FirebaseDatabase.getInstance().getReference("RequestExtension");
                            db3 d1 = new db3(date);
                            dr.child(id).setValue(d1);


                        }
                    }, mYear, mMonth, mDay);





            datePickerDialog.show();


        }



    }




}