package com.arkeologen.countrypad;



import android.os.AsyncTask;

public class CountryAsyncTask extends AsyncTask<String[], Integer, String[]> {
	
	private String[] _countryNames;
	
	@Override
	protected String[] doInBackground(String[]... args) {
		// Make a API CALL HERE
		this._countryNames = new String[] {
				"Pakistan","India","Australia"
		};
		return this._countryNames;
	}

}
