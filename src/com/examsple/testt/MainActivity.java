package com.examsple.testt;

import android.R.anim;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RemoteViews;
import android.view.Menu;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);
        
        
        
        
        
        
        
       
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
        @Override
        public void run() {
        finish();
        startActivity(new Intent(MainActivity.this, MainActivity2.class));

        }
        }, 8000);
        final Button b =(Button) findViewById(R.id.button1);
        Animation anim=AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim);
		b.startAnimation(anim);

        b.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Animation anim=AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim);
				b.startAnimation(anim);
				
			}
			
			
			
		});
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return super.onCreateOptionsMenu(menu);
}
};