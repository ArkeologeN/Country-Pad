package com.arkeologen.countrypad;

import android.os.Bundle;

import com.google.android.maps.MapActivity;

public class DetailsActivity extends MapActivity {
	
	@Override
	protected void onCreate(Bundle icicle) {
		// TODO Auto-generated method stub
		super.onCreate(icicle);
		setContentView(R.layout.countrydetails);
		
	}
	
	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

}
