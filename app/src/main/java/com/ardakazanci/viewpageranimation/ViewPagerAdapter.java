package com.ardakazanci.viewpageranimation;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {

	private Activity activity;
	private List<ImageModel> imageModelList;
	LayoutInflater layoutInflater;

	public ViewPagerAdapter(Activity activity, List<ImageModel> imageModelList) {
		this.activity = activity;
		this.imageModelList = imageModelList;
	}


	@Override
	public int getCount() {
		return imageModelList.size();
	}

	@Override
	public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {

		return view == object;

	}

	@NonNull
	@Override
	public Object instantiateItem(@NonNull ViewGroup container, int position) {
		layoutInflater = (LayoutInflater) activity.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View itemView = layoutInflater.inflate(R.layout.viewpager_item, container, false);

		ImageView imageView = itemView.findViewById(R.id.imageView);

		imageView.setBackgroundResource(imageModelList.get(position).getImage());

		container.addView(itemView);

		return itemView;
	}

	@Override
	public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
		((ViewPager) container).removeView((View) object);
	}
}
