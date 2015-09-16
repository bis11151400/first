package com.examsple.testt;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;

public class Site extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_site);

		//Simple Old Notification
		findViewById(R.id.button1).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View arg0) {
						oldNotification();
					}
				});
		
		//Old Notification With PendingIntent
		findViewById(R.id.button1).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View arg0) {
						notificationWithPendingIntent();
					}
				});
	
	}

	public void oldNotification() {

		Notification notif = new Notification(android.R.drawable.btn_star,"Old Notification", System.currentTimeMillis());

		notif.setLatestEventInfo(Site.this, "old Title","Old Notification Message", null);

		NotificationManager notifManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

		notifManager.notify(0, notif);
	}


	public void notificationWithPendingIntent() {

		Intent notiIntent = new Intent(Site.this,MainActivity.class);

		PendingIntent notiPendingIntent = PendingIntent.getActivity(Site.this, 0, notiIntent, 0);
		
		Notification notif = new Notification(android.R.drawable.btn_star,"Old Notification", System.currentTimeMillis());

		notif.setLatestEventInfo(Site.this, "old Title","Old Notification Message", notiPendingIntent);

		NotificationManager notifManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

		notifManager.notify(0, notif);

	}

}
