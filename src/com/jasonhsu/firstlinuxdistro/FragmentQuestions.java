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
	      
		ButtonSubmit = (Button)view.findViewById(R.id.button_submit);
	    ButtonSubmit.setOnClickListener(new View.OnClickListener() {
	    	@Override
	    	public void onClick(View v) {
	    		sendAnswerToFragment ("TEST");
	    	}
	    });
	      
	    return view;
	}
	
	private void sendAnswerToFragment (String s) {
		FragmentAnswer fragment1 = (FragmentAnswer) getActivity().getSupportFragmentManager().findFragmentById(R.id.fragment_answer);
		if ((fragment1 != null) && fragment1.isInLayout()) {
	         fragment1.setText(s);
	    } 
		else {
	         Intent intent = new Intent(getActivity().getApplicationContext(),ActivityAnswer.class);
	         intent.putExtra("value",s);
	         startActivity(intent);
		}
	}
}
