package com.example.myapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.regex.Pattern;

import static android.util.Patterns.*;

public class signup extends AppCompatActivity {
    private EditText nam, dob, ph, em, pass,re_pass;
    private datab mydata;
    private Button com;
    final Pattern EMAIL_PATTERN = Pattern.compile("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$");
    private  DatePickerDialog.OnDateSetListener date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Button back = findViewById(R.id.back);
        mydata = new datab(this);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backin = new Intent(signup.this, MainActivity.class);
                startActivity(backin);

            }
        });

        nam = findViewById(R.id.nam);
        dob = findViewById(R.id.dob);
        ph = findViewById(R.id.ph);
        em = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        com = findViewById(R.id.save);
        re_pass=findViewById(R.id.re_pass);
        insertdata();

      dob.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Calendar cal=Calendar.getInstance();
              int year =cal.get(Calendar.YEAR);
              int month =cal.get(Calendar.MONTH);
              int day =cal.get(Calendar.DAY_OF_MONTH);
              DatePickerDialog dialog= new DatePickerDialog(signup.this, new DatePickerDialog.OnDateSetListener() {
                  @Override
                  public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                         dob.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                  }
              },year,month,day);
              dialog.getDatePicker();
           dialog.show();
          }
      });


    }

    public void insertdata() {
        com.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_name = nam.getText().toString().trim();
                String date_ofbirth = dob.getText().toString();
                String Phone_no = ph.getText().toString();
                String email = em.getText().toString();
                String password = pass.getText().toString().trim();
                String repass = re_pass.getText().toString();
                if (user_name.isEmpty()) {
                       nam.setError("fill the user name");
                       //  Toast.makeText(getApplicationContext(), "fill  the user name......", Toast.LENGTH_SHORT).show();

                   } else if (date_ofbirth.isEmpty()) {
                       dob.setError("fill the date of birth");
                       // Toast.makeText(getApplicationContext(), "fill the date of birth ", Toast.LENGTH_SHORT).show();
                   } else if (Phone_no.isEmpty()) {
                       ph.setError("fill the phone number");
                       // Toast.makeText(getApplicationContext(), "fill the phone number ", Toast.LENGTH_SHORT).show();
                   } else if (Phone_no.length() < 10) {
                       ph.setError("phone number is less then 10");
                       //    Toast.makeText(getApplicationContext(), "phone number is less then 10 ", Toast.LENGTH_SHORT).show();
                   }
                     else if (Phone_no.length() > 10) {
                    ph.setError("phone number is greater then 10");
                    //    Toast.makeText(getApplicationContext(), "phone number is less then 10 ", Toast.LENGTH_SHORT).show();
                    }
                else if (email.isEmpty()) {
                       em.setError("fill the email");
                       //  Toast.makeText(getApplicationContext(), "fill the email ", Toast.LENGTH_SHORT).show();
                   } else if (!EMAIL_PATTERN.matcher(email).matches()) {
                       em.setError("check the email");
                       //    Toast.makeText(getApplicationContext(), " check the pattern of email example@example.com ", Toast.LENGTH_SHORT).show();
                   } else if (mydata.checkEmail(email)) {
                       em.setError("email already exits");
                       //    Toast.makeText(getApplicationContext(), "fill the pass ", Toast.LENGTH_SHORT).show();
                   } else if (password.isEmpty()) {
                       pass.setError("Check the password again");
                       //    Toast.makeText(getApplicationContext(), "fill the pass ", Toast.LENGTH_SHORT).show();
                   } else if (!repass.equals(password)) {
                       re_pass.setError("Check the password again");
                       //    Toast.makeText(getApplicationContext(), "fill the pass ", Toast.LENGTH_SHORT).show();
                   }
               else{

                        userdata ur = new userdata(user_name, date_ofbirth, Phone_no, email, password);
                        Boolean r = mydata.insertdata(ur);
                        if (r == true) {
                            //Toast.makeText(getApplicationContext(), "Save", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(signup.this, relativelayout.class);
                            startActivity(intent);
                        } else
                            Toast.makeText(getApplicationContext(), "not save (error) try again......", Toast.LENGTH_SHORT).show();



                }
                }
        });

    }



}

