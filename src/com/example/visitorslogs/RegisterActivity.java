package com.example.visitorslogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends Activity {
	DatabaseHelper mydb;
	EditText name;
	EditText email;
	EditText password;
	Button register;
	Button viewall;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set View to register.xml
        setContentView(R.layout.activity_register);
        mydb = new DatabaseHelper(this);
   
        name = (EditText) findViewById(R.id.reg_fullname);
        email = (EditText) findViewById(R.id.reg_email);
        password = (EditText) findViewById(R.id.reg_password);
        TextView loginScreen = (TextView) findViewById(R.id.link_to_login);
        register = (Button) findViewById(R.id.btnRegister);
        viewall = (Button) findViewById(R.id.viewDB);
        addData();
        viewAll();
        // Listening to Login Screen link
        loginScreen.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// Switching to Login Screen/closing register screen
				Intent i = new Intent(getApplicationContext(), LoginActivity.class);
				startActivity(i);
				finish();
			}
		});
    }
    
    public void addData() {
    	
    	register.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				
				boolean isInserted = mydb.insertData(name.getText().toString(), 
										email.getText().toString(),
										password.getText().toString()
									);
				if(isInserted == true)
                    Toast.makeText(RegisterActivity.this,"Account Created Successfully",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(RegisterActivity.this,"Account not Created",Toast.LENGTH_LONG).show();
            
				
				// Switching to Login Screen/closing register screen
				Intent i = new Intent(getApplicationContext(), LoginActivity.class);
				startActivity(i);
				finish(); 
			}
		});
    }
    
    public void viewAll() {
    	viewall.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				
				Cursor res = mydb.getAllData();
				if(res.getCount() == 0) {
					showMessage("Error","Nothing Found");
					return;
				}
				
				StringBuffer buffer = new StringBuffer();
				while(res.moveToNext()) {
					buffer.append("Id :"+res.getString(0)+"\n");
					buffer.append("Name :"+res.getString(1)+"\n");
					buffer.append("Email :"+res.getString(2)+"\n");
					buffer.append("Password :"+res.getString(3)+"\n \n \n");
				}
				showMessage("Data",buffer.toString());
			}
		});
    }
    
    public void showMessage(String title, String message) {
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	builder.setCancelable(true);
    	builder.setTitle(title);
    	builder.setMessage(message);
    	builder.show();
    }
}