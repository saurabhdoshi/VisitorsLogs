package com.example.visitorslogs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class ResidentActivity extends Activity implements OnItemSelectedListener {

 Spinner spinnerCountry, spinnerCity;
 Button submit1;

 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_resident);
  spinnerCountry = (Spinner) findViewById(R.id.spinnerCountry);
  spinnerCity = (Spinner) findViewById(R.id.spinnerCity);
  spinnerCountry.setOnItemSelectedListener(this);
  submit1 = (Button) findViewById(R.id.btnSubmit);
 
 
 submit1.setOnClickListener(new OnClickListener() {
     
     @Override
     public void onClick(View view) {
     	Intent i = new Intent(getApplicationContext(), VisitorActivity.class);
			startActivity(i);
			finish();
     }
 });
}

 @Override
 public void onItemSelected(AdapterView<?> parent, View arg1, int pos,
   long arg3) {
  parent.getItemAtPosition(pos);
  if (pos == 0) {
   ArrayAdapter<CharSequence> adapter = ArrayAdapter
     .createFromResource(this, R.array.city_india,
       android.R.layout.simple_spinner_item);
   spinnerCity.setAdapter(adapter);
  } else if (pos == 1) {
   ArrayAdapter<CharSequence> adapter = ArrayAdapter
     .createFromResource(this, R.array.city_pakisthan,
       android.R.layout.simple_spinner_item);
   spinnerCity.setAdapter(adapter);
  } else if (pos == 2) {
   ArrayAdapter<CharSequence> adapter = ArrayAdapter
     .createFromResource(this, R.array.city_srilanka,
       android.R.layout.simple_spinner_item);
   spinnerCity.setAdapter(adapter);
  }
 }

 @Override
 public void onNothingSelected(AdapterView<?> arg0) {
 }
}

