package com.mangal.demoserver;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.mangal.demoserver.Common.Common;
import com.mangal.demoserver.Model.User;

public class MainActivity extends AppCompatActivity {

  /*  Button btnSignIn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSignIn=(Button)findViewById(R.id.btnsignIn);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent signIn=new Intent(MainActivity.this,SignIn.class);
                startActivity(signIn);
            }
        });
    }
}*/

    EditText edtPhone, edtPassword;
    Button btnSignIn;
    FirebaseDatabase db;
    DatabaseReference users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSignIn = findViewById(R.id.SignIn);
        edtPassword = (EditText) findViewById(R.id.EdtPassword);
        edtPhone = (EditText) findViewById(R.id.EdtPhone);

        //Init FireBase
        db = FirebaseDatabase.getInstance();
        users = db.getReference("user");
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signInUser(edtPhone.getText().toString(), edtPassword.getText().toString());
            }
        });
    }

    private void signInUser(String phone, String password) {
        final ProgressDialog mDialog = new ProgressDialog(MainActivity.this);
        mDialog.setMessage("Please waiting...");
        mDialog.show();
        final String localPhone = phone;
        final String localPassword = password;

        users.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(localPhone).exists()) {
                    mDialog.dismiss();
                    User user = dataSnapshot.child(localPhone).getValue(User.class);
                    user.setPhone(localPhone);
                    if (Boolean.parseBoolean(user.getIsStaff()))//if staff is true
                    {

                        if (user.getPassword().equals(localPassword)) {

                            Intent login =new Intent(MainActivity.this,Home.class);
                            Common.cureentUser=user;
                            startActivity(login);
                            finish();

                        } else

                            Toast.makeText(MainActivity.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                    } else

                        Toast.makeText(MainActivity.this, "Please login with Staff account", Toast.LENGTH_SHORT).show();
                } else

                {
                    mDialog.dismiss();
                    Toast.makeText(MainActivity.this, "User not exit in Dtabase", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}

