package com.jasonhsu.firstlinuxdistro;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;

public class FragmentQuestions extends Fragment {

	Button ButtonSubmit;
	private OnMenufragListener menufragListener;
	
	Spinner spinner_purpose, spinner_age, spinner_memory;
	String str_purpose, str_age, str_memory;
	
	String[] array_purpose, array_age, array_mem;
	
	String purpose_rescue;
	String age_vista, age_xp, age_98, age_95;
	String mem_vista, mem_xp, mem_98, mem_95;
	

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
		
		// Criteria selected by the user through the spinner
		spinner_purpose = (Spinner)view.findViewById(R.id.spinnerPurpose);
		spinner_age = (Spinner)view.findViewById(R.id.spinnerAge);
		spinner_memory = (Spinner)view.findViewById(R.id.spinnerMemory);
		
		array_purpose = getResources().getStringArray(R.array.purpose_array);
		purpose_rescue = array_purpose [0];
		
		array_age = getResources().getStringArray(R.array.age_array);
		age_vista = array_age [0];
		age_xp = array_age [1];
		age_98 = array_age [2];
		age_95 = array_age [3];
		
		array_mem = getResources().getStringArray(R.array.memory_array);
		mem_vista = array_mem [0];
		mem_xp = array_mem [1];
		mem_98 = array_mem [2];
		mem_95 = array_mem [3];
	      
		// Response when the Submit button is clicked
		ButtonSubmit = (Button)view.findViewById(R.id.button_submit);
	    ButtonSubmit.setOnClickListener(new View.OnClickListener() {
	    	@Override
	    	public void onClick(View v) {
	    		str_purpose = String.valueOf(spinner_purpose.getSelectedItem());
	    		str_age = String.valueOf(spinner_age.getSelectedItem());
	    		str_memory = String.valueOf(spinner_memory.getSelectedItem().toString());
	    		
	    		String solution;
	    		String sol_puppy, sol_tiny; 
	    		String sol_mint_ubuntu, sol_mint_deb, sol_antix, sol_museum;
	    		sol_puppy = getResources().getString(R.string.solution_puppy);
	    		sol_tiny = getResources().getString(R.string.solution_tinycore);
	    		sol_mint_ubuntu = getResources().getString(R.string.solution_mint_ubuntu);
	    		sol_mint_deb = getResources().getString(R.string.solution_mint_debian);
	    		sol_antix = getResources().getString(R.string.solution_antix);
	    		sol_museum = getResources().getString(R.string.solution_museum);
	    		
	    		// Process inputs and display result
	    		if (str_purpose.equals(purpose_rescue)) {
	    			if (str_memory.equals (mem_95)) {
	    				sendAnswerToActivity (sol_tiny);
	    			}
	    			else {
	    				sendAnswerToActivity (sol_puppy);
	    			}
	    		}
	    		else {
	    			if (str_memory.equals(mem_95) | str_age.equals(age_95)) {
	    				sendAnswerToActivity (sol_museum);
	    			}
	    			else if (str_memory.equals(mem_98) | str_age.equals(age_98)) {
	    				sendAnswerToActivity (sol_antix);
	    			}
	    			else if (str_memory.equals(mem_xp) | str_age.equals(age_xp)) {
	    				sendAnswerToActivity (sol_mint_deb);
	    			}
	    			else {
	    				sendAnswerToActivity (sol_mint_ubuntu);
	    			}
	    		}
	    	}
	    });
	      
	    return view;
	}
	
	private void sendAnswerToActivity(String s) {
		menufragListener.onMenufrag(s);
	}
	
}
