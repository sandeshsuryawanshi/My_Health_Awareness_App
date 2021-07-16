package com.example.myhealthawarenessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText userName,password;
    private Button loginbtn,registerbtn;
    private ProgressDialog p;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        userName = findViewById(R.id.et_email);
        password = findViewById(R.id.et_password);
        loginbtn = findViewById(R.id.b1);
        registerbtn = findViewById(R.id.b2);

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(i);
                finish();
            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                p = new ProgressDialog(MainActivity.this);
                p.setTitle("Loading...");
                p.setMessage("please wait...");
                p.setCancelable(false);
                p.setCanceledOnTouchOutside(false);
                if(userName.getText().toString().isEmpty() && password.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Please enter login id and password",Toast.LENGTH_SHORT).show();
                }
                else {

                    p.show();

                mAuth.signInWithEmailAndPassword(userName.getText().toString(), password.getText().toString())
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d("taskLogin", "signInWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();

                                    FirebaseUser currentUser = mAuth.getCurrentUser();

                                    p.dismiss();
                                    if (currentUser != null)
                                    {
                                        Intent in = new Intent(MainActivity.this,AboutUsActivity.class);
                                        startActivity(in);
                                        finish();
                                    }
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w("taskLogin", "signInWithEmail:failure", task.getException());
                                    p.dismiss();
                                    Toast.makeText(MainActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }

                                // ...
                            }
                        });
            }}
        });


    }
}
