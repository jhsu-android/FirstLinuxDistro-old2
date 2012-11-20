package com.jasonhsu.firstlinuxdistro;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

public class ActivityAnswer extends FragmentActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Check orientation to avoid crash (not necessary in landscape)
		if (getResources().getConfiguration().orientation==Configuration.ORIENTATION_LANDSCAPE) {
			finish();
			return;
		} 
		else { 
			setContentView(R.layout.general_a_only);
		}
		
		// Show body content as requested in Intent extra
	    Bundle extras = getIntent().getExtras();
	    if (extras != null) {
	    	// get data from Intent extra
	    	String s = extras.getString("value");
	    	// get body fragment
	    	FragmentAnswer fragment1 = (FragmentAnswer) getSupportFragmentManager().findFragmentById(R.id.fragment_answer);
	        // if fragment is not null and in layout set text
	        if ((fragment1 != null) && fragment1.isInLayout()) {
	            fragment1.setText(s);
	        }
	    }
	}
}
