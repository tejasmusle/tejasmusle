package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

public class datab extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "signup.db";
    public static final String TABLE_NAME = "regis_table";
    public static final String col_id ="id";
    public static final String col_NAME = "name";
    public static final String col_dob = "dob";
    public static final String col_PH = "phoneno";
    public static final String col_EM = "email";
    public static final String col_PASS = "pass";
    private SQLiteDatabase db;
    private Boolean edittextchecker;

    public datab(Context context) {
        super(context, DATABASE_NAME, null, 4);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE "+TABLE_NAME+" (" +col_id +" INTEGER PRIMARY KEY AUTOINCREMENT, "
                + col_NAME + " TEXT," + col_dob + " TEXT," +
                 col_PH + " TEXT," + col_EM + " TEXT," + col_PASS + " TEXT"+")";


        //db.execSQL("create table " + TABLE_NAME +" (id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,dob TEXT,phoneno TEXT,email TEXT,pass TEXT)");

          db.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

   public String loginfunction(String user_name)
   {
       db=this.getWritableDatabase();

       String query="select name,pass from " +TABLE_NAME;
       Cursor cursor=db.rawQuery(query,null);
       String a,b;
       b="wrong password";

         if(cursor.moveToFirst()){
             do{  a=cursor.getString(0);
                // Log.d("username",a);
                 if(a.equals(user_name))
                 {
                     b=cursor.getString(1);
                     break;
                 }

             }while(cursor.moveToNext());

         }
   return b;
   }
  public boolean checkEmail(String email) {
      db = this.getWritableDatabase();
      String query = "select * from " + TABLE_NAME + " where " + col_EM + " =" + "'" + email + "'";
      Cursor cursor = db.rawQuery(query, null);
      if (cursor.getCount() <= 0) {
          cursor.close();
          return false;

      }else {
          cursor.close();
          return true;
      }
  }


    public boolean insertdata(userdata userdata ) {
        db = this.getWritableDatabase();
        ContentValues cont = new ContentValues();
        cont.put(col_NAME, userdata.getName().trim());
        cont.put(col_dob, userdata.getDob());
        cont.put(col_PH, userdata.getPh());
        cont.put(col_EM, userdata.getEmail());
        cont.put(col_PASS, userdata.getPass().trim());
     //   Log.d("tony", String.valueOf(cont));

        long result = db.insert(TABLE_NAME, null, cont);
           if(result == -1)
                     return false;
               else
                   return true;


    }



    }
