package com.example.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class relativelayout extends AppCompatActivity {

    private EditText username,pass;
    private Button login;
    private  datab datahelper;
    private  SQLiteDatabase obj;
    private  Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relativelayout);
        username=findViewById(R.id.email);
        pass=findViewById(R.id.pass);
        login=findViewById(R.id.log);
          datahelper=new datab(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                     if(username.getText().toString().isEmpty()){
                         username.setError("enter the username");
                     }
                      else if(pass.getText().toString().isEmpty()){
                          pass.setError("enter the password");
                     }
                     else {

                         if (v.getId() == R.id.log) {


                             String ur = username.getText().toString().trim();
                             String pas = pass.getText().toString().trim();
                             String password = datahelper.loginfunction(ur);
                             //  Log.d("pass",password);
                             if (pas.equals(password)) {
                                 Intent intent = new Intent(relativelayout.this, welcome.class);
                                 intent.putExtra("username",username.getText().toString());
                                 startActivity(intent);
                             } else
                                 Toast.makeText(getApplicationContext(), "fail", Toast.LENGTH_SHORT).show();
                         }
                     }
            }
        });

    }

}
