package com.example.bidri;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.santosh.bidri.adapter.BidarBidriArtAdapter;
import com.santosh.bidri.adapter.BidarMonumentsAdapter;
import com.santosh.bidri.data.BidarBidriArtData;
import com.santosh.bidri.data.BidarMonumentsData;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class BidarBidriArtActivity extends Activity {
	GridView bidarBidriArtList;
	ArrayList<BidarBidriArtData> listData;
	BidarBidriArtAdapter adapter;
	BidarBidriArtData d;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bidar_bidri_art_activity);
		bidarBidriArtList=(GridView)findViewById(R.id.bidarbidriArtList);

		
		listData=new ArrayList<BidarBidriArtData>();
		parseJson();
		
        adapter=new BidarBidriArtAdapter(BidarBidriArtActivity.this, R.layout.bidar_bidri_art_row, listData);
        bidarBidriArtList.setAdapter(adapter);
        bidarBidriArtList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
					long arg3) {
				
				Intent intent=new Intent(getApplicationContext(), BidarDetailActivity.class);
				
				startActivity(intent);
				
			}
		});
	}

	private void parseJson() {
		//Get Data From Text Resource File Contains Json Data.    
		InputStream inputStream = getResources().openRawResource(R.raw.bidri);
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		int ctr;
		try {
		    ctr = inputStream.read();
		    while (ctr != -1) {
		        byteArrayOutputStream.write(ctr);
		        ctr = inputStream.read();
		    }
		    inputStream.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
		try {
			JSONObject obj=new JSONObject(byteArrayOutputStream.toString());
			JSONArray array=obj.getJSONArray("data");
			int size=array.length();
			for(int i=0;i<size;i++){
			//	String name=array.getJSONObject(i).getString("title");
				//String description=array.getJSONObject(i).getString("description");
				String url=array.getJSONObject(i).getString("image_url");
				d=new BidarBidriArtData("", url, "");
		      //  Log.v("i","i==>"+url);

				listData.add(d);
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
