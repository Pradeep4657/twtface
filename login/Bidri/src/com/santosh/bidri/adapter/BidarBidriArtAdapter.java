package com.santosh.bidri.adapter;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bidri.R;
import com.santosh.bidri.data.BidarBidriArtData;


public class BidarBidriArtAdapter extends ArrayAdapter<BidarBidriArtData> {
	
	ArrayList<BidarBidriArtData> list;
	Activity a;
	//private DisplayImageOptions options;
	//ImageLoader imageLoader = null;

	public BidarBidriArtAdapter(Activity context, int textViewResourceId, ArrayList<BidarBidriArtData> data) {
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
		ImageView bidarBidriArtImage;
		TextView bidarBidriArttName;
		TextView bidarBidriArtDescription;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		 View v = convertView;
	        ViewHolder holder;
	     
	        if (v == null) {
	            LayoutInflater vi =(LayoutInflater)a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	            v = vi.inflate(R.layout.bidar_bidri_art_row, null);
	            holder = new ViewHolder();
	            holder.bidarBidriArttName=(TextView)v.findViewById(R.id.bidrArtName);
	            holder.bidarBidriArtDescription=(TextView)v.findViewById(R.id.bidrArtDescription);
	            holder.bidarBidriArtImage=(ImageView)v.findViewById(R.id.bidrArtImage);
	             v.setTag(holder);
	        }
	        else
	        {
	        	 holder=(ViewHolder)v.getTag();
	        }
	        BidarBidriArtData data=list.get(position);
	        holder.bidarBidriArttName.setText(data.getBidriArtName());
	        holder.bidarBidriArtDescription.setText(data.getBidriArtDescription());
	        String u=data.getBidriArtImage();
	        String uri=uri ="@drawable/"+data.getBidriArtImage();
	        Log.v("i","i==>"+uri);
	        int imageResource = a.getResources().getIdentifier(uri, null, a.getPackageName());
	       Drawable res =a. getResources().getDrawable(imageResource);
	        if(res!=null){
	        	 holder.bidarBidriArtImage.setImageDrawable(res);
	        }
	      //  imageLoader.displayImage(data.getCatUrl(), holder.catImage);
	        
	        return v;
	 
	}

}