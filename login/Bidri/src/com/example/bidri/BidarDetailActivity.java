package com.example.bidri;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class BidarDetailActivity extends Activity {

	String name;
	String desc;
	TextView mTitle;
	TextView mDescription;
	ImageView mImage;
	String image_uri;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bidar_details_activity);
		mTitle=(TextView)findViewById(R.id.detailTitle);
		mDescription=(TextView)findViewById(R.id.descText);
		mImage=(ImageView)findViewById(R.id.image);
		
		if (getIntent() != null) {
			name=getIntent().getStringExtra("title");
			desc=getIntent().getStringExtra("description");
			image_uri=getIntent().getStringExtra("image_uri");
		}
		mTitle.setText(name);
		mDescription.setText(desc);
		    String uri=uri = "@drawable/"+image_uri;
	        int imageResource = getResources().getIdentifier(uri, null, getPackageName());
	        Drawable res = getResources().getDrawable(imageResource);
	        mImage.setImageDrawable(res);
	}
}
