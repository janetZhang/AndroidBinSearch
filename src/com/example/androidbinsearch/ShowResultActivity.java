package com.example.androidbinsearch;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ShowResultActivity extends Activity {
    @TargetApi(9)
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the message from the intent
        Intent intent = getIntent();
        
        Bundle extras = intent.getExtras();        
        String inputValueMessage = extras.getString(MainActivity.INPUT_MESSAGE);
        String keyValue = extras.getString(MainActivity.KEYVALUE_MESSAGE);

        
		String [] inputValues;// = new String[12];
		int [] inputIntValue;
		if(!inputValueMessage.isEmpty()){
			inputValues = inputValueMessage.split(",");
		}else{
			return ;
		}
		DetectError check = new DetectError();
		
		inputIntValue = check.InputValueCheck(inputValues);

		if(inputIntValue!=null & check.keyValueCheck(keyValue)){// If all inputs are legal then sort and search array
			check.binSearch(check.arraySort(inputIntValue),
					check.InputValueCheck(inputValues), Integer.valueOf(keyValue));

		}

        // Create the text view
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText("InputValues:"+inputValueMessage+"\n Key value: "+keyValue+"\n Show result "+check.getResult());
      //  textView.setText(check.getResult());

        // Set the text view as the activity layout
        setContentView(textView); 
        
       // setContentView(R.layout.activity_show_result);
       // getActionBar().setDisplayHomeAsUpEnabled(true);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_show_result, menu);
        return true;
    }

    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    

}
