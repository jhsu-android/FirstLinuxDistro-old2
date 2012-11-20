package com.jasonhsu.firstlinuxdistro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentQuestions extends Fragment {

	Button ButtonSubmit;
	private OnMenufragListener menufragListener;

	// interface for communication with activity
	public interface OnMenufragListener {
		public void onMenufrag(String s);
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			menufragListener = (OnMenufragListener) activity;
		} 
		catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()+" must implement OnMenufragListener");
		}
	}
	   
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}
	   
	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_questions,container,false);
	      
		// Response when the Submit button is clicked
		ButtonSubmit = (Button)view.findViewById(R.id.button_submit);
	    ButtonSubmit.setOnClickListener(new View.OnClickListener() {
	    	@Override
	    	public void onClick(View v) {
	    		sendAnswerToActivity ("TEST");
	    	}
	    });
	      
	    return view;
	}
	
	private void sendAnswerToActivity(String s) {
		menufragListener.onMenufrag(s);
	}
	
	private void DecideResponse () {
		
	}
	
}
