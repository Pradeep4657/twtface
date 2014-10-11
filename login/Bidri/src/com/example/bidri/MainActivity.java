package com.example.bidri;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {
	private LinearLayout bidarMonuments;
	private RelativeLayout bidriArt;
	private LinearLayout reachBidar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bidarMonuments=(LinearLayout)findViewById(R.id.bidarMonuments);
		bidriArt=(RelativeLayout)findViewById(R.id.bidarBidriArt);
		reachBidar=(LinearLayout)findViewById(R.id.ReachBidar);
		
		bidarMonuments.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(getApplicationContext(), BidarMonumentsActivity.class);
				startActivity(intent);
			}
		});
		bidriArt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				Intent intent=new Intent(getApplicationContext(), BidarBidriArtActivity.class);
				startActivity(intent);
			}
		});
		reachBidar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(getApplicationContext(), ReachBidarActivity.class);
				startActivity(intent);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
