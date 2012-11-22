package com.jasonhsu.firstlinuxdistro;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

public class ActivityAnswer extends FragmentActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// If landscape mode is in place, skip to past this if/else statement.
		if (getResources().getConfiguration().orientation==Configuration.ORIENTATION_LANDSCAPE) {
			finish();
			return;
		} 
		// If portrait mode is in place, use the layout defined in 
		// res/layout/general_a_only.xml
		// This is necessary to avoid crashing.
		else { 
			setContentView(R.layout.general_a_only);
		}
		
		// Show body content as requested in Intent extra
	    Bundle extras = getIntent().getExtras();
	    if (extras != null) {
	    	// Get data from Intent extra
	    	String s = extras.getString("value");
	    	
	    	// Get answer fragment
	    	FragmentAnswer fragment1 = (FragmentAnswer) getSupportFragmentManager().findFragmentById(R.id.fragment_answer);
	    	
	        // If the fragment is not null and is in the layout, set text.
	        if ((fragment1 != null) && fragment1.isInLayout()) {
	            fragment1.setText(s);
	        }
	    }
	}
}
