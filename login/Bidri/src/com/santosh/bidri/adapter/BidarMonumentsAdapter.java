package com.santosh.bidri.adapter;

import java.util.ArrayList;

import com.example.bidri.R;
import com.santosh.bidri.data.BidarMonumentsData;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class BidarMonumentsAdapter extends ArrayAdapter<BidarMonumentsData> {
	
	ArrayList<BidarMonumentsData> list;
	Activity a;
	//private DisplayImageOptions options;
	//ImageLoader imageLoader = null;

	public BidarMonumentsAdapter(Activity context, int textViewResourceId, ArrayList<BidarMonumentsData> data)
{
		super(context, textViewResourceId, data);
		this.list=data;
		this.a=context;
	/*	options = new DisplayImageOptions.Builder()
        .showImageForEmptyUri(R.drawable.ic_launcher)
        .showImageOnFail(R.drawable.ic_launcher).cacheInMemory().cacheOnDisc()
        .imageScaleType(ImageScaleType.IN_SAMPLE_INT).bitmapConfig(Bitmap.Config.RGB_565).build();
		  ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
          .threadPriority(Thread.MAX_PRIORITY - 2).memoryCacheSize( 2 * 1024 * 1024)
          .denyCacheImageMultipleSizesInMemory().discCacheFileNameGenerator(new Md5FileNameGenerator())
          .tasksProcessingOrder(QueueProcessingType.LIFO).enableLogging() 
          .build();
		  imageLoader = ImageLoader.getInstance();
		  imageLoader.init(config);*/

		
	}

	public static class ViewHolder{
		ImageView bidarMonumentImage;
		TextView bidarMonumentName;
		TextView bidarMonumentDescription;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		 View v = convertView;
	        ViewHolder holder;
	     
	        if (v == null) {
	            LayoutInflater vi =(LayoutInflater)a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	            v = vi.inflate(R.layout.bidar_monument_row, null);
	            holder = new ViewHolder();
	            holder.bidarMonumentName=(TextView)v.findViewById(R.id.monumentName);
	            holder.bidarMonumentDescription=(TextView)v.findViewById(R.id.monumentDescription);
	            holder.bidarMonumentImage=(ImageView)v.findViewById(R.id.monumentImage);
	      
	             v.setTag(holder);
	             
	        }
	        else
	        {
	        
	        	 holder=(ViewHolder)v.getTag();
	        	
	        }
	        BidarMonumentsData data=list.get(position);
	        holder.bidarMonumentName.setText(data.getBidarMonumentName());
	    //    holder.bidarMonumentDescription.setText(data.getBidarMonumentDescription());
	        String u=data.getBidarMonumentImage();
	        String uri=uri ="@drawable/"+data.getBidarMonumentImage();
	        int imageResource = a.getResources().getIdentifier(uri, null, a.getPackageName());
	       Drawable res =a. getResources().getDrawable(imageResource);
	        if(res!=null){
	        	 holder.bidarMonumentImage.setImageDrawable(res);
	        }
	   //   holder.bidarMonumentImage.setImageResource(R.drawable.iconssss);
	      
	      //  imageLoader.displayImage(data.getCatUrl(), holder.catImage);
	        
	        return v;
	 
	}

}

