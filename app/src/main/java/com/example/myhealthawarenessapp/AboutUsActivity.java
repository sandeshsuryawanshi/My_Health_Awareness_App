package com.example.myhealthawarenessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.net.URI;

import static android.net.Uri.*;

public class AboutUsActivity extends AppCompatActivity {
    Button phybtn, defbtn, infbtn, degbtn, skinbtn, conbtn, aboutbtn, coronabtn;
    FirebaseAuth mAuth;
    FirebaseUser mUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        phybtn = findViewById(R.id.phybtn);
        defbtn = findViewById(R.id.defbtn);
        infbtn = findViewById(R.id.infbtn);
        degbtn = findViewById(R.id.degbtn);
        skinbtn = findViewById(R.id.skinbtn);
        conbtn = findViewById(R.id.conbtn);
        aboutbtn = findViewById(R.id.aboutbtn);
        coronabtn = findViewById(R.id.coronabtn);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        aboutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(getApplicationContext(), devolopedby.class);
                startActivity(i1);

            }
        });
        defbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3 = new Intent(getApplicationContext(), Deficiency_Activity.class);
                startActivity(i3);

            }
        });
        degbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i4 = new Intent(getApplicationContext(), Degenerative_Activity.class);
                startActivity(i4);

            }
        });
        skinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i5 = new Intent(getApplicationContext(), Skin_Activity.class);
                startActivity(i5);

            }
        });
        conbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i6 = new Intent(getApplicationContext(), Contigious_Activity.class);
                startActivity(i6);

            }
        });
        infbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(getApplicationContext(), Infectious_Activity.class);
                startActivity(i2);

            }
        });
        phybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i5 = new Intent(getApplicationContext(), PhysicologicalActivity.class);
                startActivity(i5);

            }
        });
        coronabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i6 = new Intent(Intent.ACTION_VIEW);
                i6.setData(Uri.parse("https://covid19.who.int/?gclid=CjwKCAjwwab7BRBAEiwAapqpTA0hJpvlCwDfhD3nnvc2iPaXSj2cRVcqCBZOFeVMGxg7rFq5YYAZthoCnikQAvD_BwE"));
                startActivity(i6);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        int log = item.getItemId();
//
//        if (log == R.id.logout){
//            updateUI(mUser);
//        }
//
//
//        return super.onOptionsItemSelected(item);
//
//    }

    private  void updateUI(FirebaseUser user)
    {
        if (user != null) {
            mAuth.signOut();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

}

}
