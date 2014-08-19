package com.example.androidbinsearch;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	public final static String INPUT_MESSAGE = "INPUT_MESSAGE";
	public final static String KEYVALUE_MESSAGE = "KEYVALUE_MESSAGE";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    /** Called when the user clicks the Search button */
    @TargetApi(9)
	public void startSearch(View view) {
        // Do something in response to button
    	Intent intent = new Intent(this, ShowResultActivity.class);
    	
    	EditText inputMessageText = (EditText) findViewById(R.input.input_message);
    	EditText inputTargetText = (EditText) findViewById(R.target.input_target);
    	String inputValueMessage = inputMessageText.getText().toString();
    	String keyValue = inputTargetText.getText().toString();
    	
    	Bundle extras = new Bundle();
    	extras.putString(INPUT_MESSAGE,inputValueMessage);
    	extras.putString(KEYVALUE_MESSAGE,keyValue);
    	intent.putExtras(extras);

    	startActivity(intent);
    }
    
}
