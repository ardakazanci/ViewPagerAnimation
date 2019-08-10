package com.ardakazanci.viewpageranimation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.ardakazanci.viewpageranimation.transformer.DepthPageTransformer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

	ViewPagerAdapter viewPagerAdapter;
	ViewPager viewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		viewPager = findViewById(R.id.pager);
		viewPagerAdapter = new ViewPagerAdapter(MainActivity.this, getData());
		viewPager.setAdapter(viewPagerAdapter);
		viewPager.setPageTransformer(true,new DepthPageTransformer());
	}

	private List<ImageModel> getData() {

		List<ImageModel> imageModelList = new ArrayList<>();
		ImageModel imageModel = new ImageModel(R.drawable.free_image_1);
		imageModelList.add(imageModel);
		ImageModel imageModel2 = new ImageModel(R.drawable.free_image_2);
		imageModelList.add(imageModel2);
		ImageModel imageModel3 = new ImageModel(R.drawable.free_image_3);
		imageModelList.add(imageModel3);
		return imageModelList;


	}
}
