package com.example.visitorslogs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
	
	public static final String DATABASE_NAME = "VisitorsLog.db";
	public static final String TABLE_NAME = "CreateAccount";
	public static final String ACCOUNT_COLUMN_ID = "Id";
	public static final String ACCOUNT_COLUMN_NAME = "Name";
	public static final String ACCOUNT_COLUMN_EMAIL = "Email";
	public static final String ACCOUNT_COLUMN_PASSWORD = "Password";
	
	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, 1);
		SQLiteDatabase db = this.getWritableDatabase();
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table"+" "+TABLE_NAME+ "(ID INTEGER PRIMARY KEY, NAME TEXT, EMAIL TEXT, PASSWORD TEXT)");
		
	}


	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS" +TABLE_NAME);
		onCreate(db);
	}
	
	public boolean insertData(String name,String email,String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ACCOUNT_COLUMN_NAME,name);
        contentValues.put(ACCOUNT_COLUMN_EMAIL,email);
        contentValues.put(ACCOUNT_COLUMN_PASSWORD,password);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
	
	public Cursor getAllData() {
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor res = db.rawQuery("Select * from"+" "+TABLE_NAME, null);
		return res;
	}
 
	public boolean validateUser(String username, String password){
		   Cursor c = getReadableDatabase().rawQuery(
		            "SELECT * FROM " + TABLE_NAME + " WHERE "
		                    + ACCOUNT_COLUMN_EMAIL + "='" + username +"'AND "+ACCOUNT_COLUMN_PASSWORD+"='"+password+"'" ,  null);
		   if (c.getCount()>0)
		      return true;
		      return false;
		}
	

}
