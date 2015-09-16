package com.examsple.testt;



import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TabHost;
import android.app.TabActivity;
import android.content.Intent;
import android.widget.TabHost.TabSpec;

public class MainActivity2 extends TabActivity {
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity2);
		
		TabHost tabHost = getTabHost();
        
        // Site tab
        TabSpec sitetab = tabHost.newTabSpec("Site");
        sitetab.setIndicator("سایت");
        Intent Intent1 = new Intent(this, Site.class);
        sitetab.setContent(Intent1);
         
        // About Tab
        TabSpec abouttab = tabHost.newTabSpec("About");       
        abouttab.setIndicator("ورود دبیران و اساتید");
        Intent Intent2 = new Intent(this, About.class);
        abouttab.setContent(Intent2);

        tabHost.addTab(sitetab);
        tabHost.addTab(abouttab); 

	}

}