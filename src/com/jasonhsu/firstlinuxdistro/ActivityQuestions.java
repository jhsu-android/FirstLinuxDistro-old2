package com.jasonhsu.firstlinuxdistro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class ActivityQuestions extends FragmentActivity implements FragmentQuestions.OnMenufragListener {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.general);
		
		
	}
	
	@Override
	public void onMenufrag(String s) {
		// get body fragment (native method is getFragmentManager)
		FragmentAnswer fragment1 = (FragmentAnswer) getSupportFragmentManager().findFragmentById(R.id.fragment_answer);
	      
		// if fragment is not null and in layout, set text, else launch BodyActivity
	    if ((fragment1 != null) && fragment1.isInLayout()) {
	    	fragment1.setText(s);
	      	} 
	    else {
	         Intent intent = new Intent(this,ActivityAnswer.class);
	         intent.putExtra("value",s);
	         startActivity(intent);
	    }      
	}
}
