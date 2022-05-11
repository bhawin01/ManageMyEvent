package com.example.samyak;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class NotifAdminActivity extends AppCompatActivity {

    DatabaseReference dr, dr1;
    Button button;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notif_admin);

        tv = (TextView)findViewById(R.id.tt5);


        String nameff="RequestExtension";
        String sc="Extension";

        dr = FirebaseDatabase.getInstance().getReference().child(nameff).child(sc);
        dr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String email= dataSnapshot.child("date").getValue().toString();
               // String id= dataSnapshot.child("id").getValue().toString();
                //String roleAssigned= dataSnapshot.child("task1").getValue().toString();

                tv.setText("Extension requested till "+email);

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





        final RelativeLayout rl = (RelativeLayout) findViewById(R.id.hide5);
        button = (Button) findViewById(R.id.com5);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(NotifAdminActivity.this, "Task Approved", Toast.LENGTH_SHORT).show();
                rl.setVisibility(View.GONE);

            }

        });


    }
}
