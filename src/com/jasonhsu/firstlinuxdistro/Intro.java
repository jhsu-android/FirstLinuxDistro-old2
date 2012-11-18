package com.jasonhsu.firstlinuxdistro;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class Intro extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);
    }
    
    // Provide the option of running the ActivityQuestions.java script.
    // This option is exercised when you press the Continue button.
    public void showOptions(View v) {
    	startActivity(new Intent(this, ActivityQuestions.class));
    	}
}
