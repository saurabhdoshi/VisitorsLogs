package com.example.visitorslogs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class VisitorActivity extends Activity{
	Button btnRegister;
	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.visitor_register);
	  btnRegister = (Button)findViewById(R.id.btnRegister);
	  btnRegister.setOnClickListener(new OnClickListener() {
	     
	     @Override
	     public void onClick(View view) {
	     	Intent i = new Intent(getApplicationContext(), LoginActivity.class);
				startActivity(i);
				finish();
	     }
	 });
	}
}
