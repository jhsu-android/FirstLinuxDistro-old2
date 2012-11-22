package com.jasonhsu.firstlinuxdistro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

// This is the script called by Intro.java .
// Note that this script calls FragmentQuestions.java
public class ActivityQuestions extends FragmentActivity implements FragmentQuestions.OnMenufragListener {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Use the display at res/layout/general.xml
		setContentView(R.layout.general);
	}
	
	// Note that this onMenufrag function is called by FragmentQuestions.java
	@Override
	public void onMenufrag(String s) {
		// get body fragment (native method is getFragmentManager)
		FragmentAnswer fragment1 = (FragmentAnswer) getSupportFragmentManager().findFragmentById(R.id.fragment_answer);
	    
	    // If fragment is in the current layout and is not null, set the text.
		if ((fragment1 != null) && fragment1.isInLayout()) {
	    	fragment1.setText(s);
	      	} 
		// If the fragment is null or isn't in the current layout, 
		// call ActivityAnswer.java.
	    else {
	         Intent intent1 = new Intent(this,ActivityAnswer.class);
	         intent1.putExtra("value",s);
	         startActivity(intent1);
	    }      
	}
}
