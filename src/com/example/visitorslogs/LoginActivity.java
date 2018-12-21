package com.example.visitorslogs;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends Activity {
	DatabaseHelper mydb;
    // User name
    private EditText et_Username;
    // Password
    private EditText et_Password;
    // Sign In
    private Button bt_SignIn;
    // Message
    private TextView tv_Message;
    
    //Create account
    private TextView reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mydb = new DatabaseHelper(this);
        // Initialization
        et_Username = (EditText) findViewById(R.id.et_Username);
        et_Password = (EditText) findViewById(R.id.et_Password);
        bt_SignIn = (Button) findViewById(R.id.bt_SignIn);
        tv_Message = (TextView) findViewById(R.id.tv_Message);
        reg = (TextView) findViewById(R.id.textView1);
         
        bt_SignIn.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View view) {
                // Stores User name
                String username = String.valueOf(et_Username.getText());
                // Stores Password
                String password = String.valueOf(et_Password.getText());
                
                // Validates the User name and Password for admin, admin
                
                if (mydb.validateUser(username,password) == true) {
                    tv_Message.setText("Login Successful!");
                    Intent i = new Intent(getApplicationContext(), ResidentActivity.class);
    				startActivity(i);
    				finish();
                } else {
                    tv_Message.setText("Login Unsuccessful!");
                }
                
            }
        });
        
        reg.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View view) {
            	Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
				startActivity(i);
				finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }

}

