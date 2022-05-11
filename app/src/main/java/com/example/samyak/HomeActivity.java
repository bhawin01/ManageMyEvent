package com.example.samyak;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeActivity extends AppCompatActivity {


    TextView tv;
   DatabaseReference dr, dr1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);


        tv= (TextView)findViewById(R.id.role);



        String nameff="Role";
        String sc="100";
        dr = FirebaseDatabase.getInstance().getReference().child(nameff).child(sc);
       dr.addValueEventListener(new ValueEventListener() {
            @Override
           public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

               String email= dataSnapshot.child("emailSelected").getValue().toString();
               String id= dataSnapshot.child("id").getValue().toString();
                String roleAssigned= dataSnapshot.child("task1").getValue().toString();

                tv.setText("You are the "+roleAssigned);
                 Toast.makeText(getApplicationContext(),"name",Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),id,Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),roleAssigned,Toast.LENGTH_LONG).show();
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










  /*      tv = (TextView)findViewById(R.id.role);
        dr = FirebaseDatabase.getInstance().getReference();





        dr1 = dr.child("Role");
        dr1.child("task1").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                tv.setText("You are the " +value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




*/

    }
}


