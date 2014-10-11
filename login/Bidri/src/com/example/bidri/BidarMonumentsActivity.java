package com.example.bidri;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.santosh.bidri.adapter.BidarMonumentsAdapter;
import com.santosh.bidri.data.BidarMonumentsData;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;

public class BidarMonumentsActivity extends Activity {
	
	GridView bidarMonumentList;
	ArrayList<BidarMonumentsData> listData;
	BidarMonumentsAdapter adapter;
	BidarMonumentsData d;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bidar_monuments_activity);
		listData=new ArrayList<BidarMonumentsData>();
		parseJson();
		bidarMonumentList=(GridView)findViewById(R.id.bidarMonumentList);
		
		
        adapter=new BidarMonumentsAdapter(BidarMonumentsActivity.this, R.layout.bidar_monument_row, listData);
        bidarMonumentList.setAdapter(adapter);
        bidarMonumentList.setOnItemClickListener(new OnItemClickListener() {

 			@Override
 			public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
 					long arg3) {
 				
 				Intent intent=new Intent(getApplicationContext(), BidarDetailActivity.class);
 				intent.putExtra("title", listData.get(pos).getBidarMonumentName());
 				intent.putExtra("description", listData.get(pos).getBidarMonumentDescription());
 				intent.putExtra("image_uri", listData.get(pos).getBidarMonumentImage());
 				startActivity(intent);
 				
 			}
 		});
        

		
	}

	private void parseJson() {
		//Get Data From Text Resource File Contains Json Data.    
		InputStream inputStream = getResources().openRawResource(R.raw.monuments);
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
				String name=array.getJSONObject(i).getString("title");
				String description=array.getJSONObject(i).getString("description");
				String url=array.getJSONObject(i).getString("image_url");
				d=new BidarMonumentsData(name, url, description);
				listData.add(d);
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
