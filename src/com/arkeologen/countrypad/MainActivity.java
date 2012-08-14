package com.arkeologen.countrypad;


import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends ListActivity {
    /** Called when the activity is first created. */
	
	private String[] _countries;
	
	public MainActivity() {
		Log.v("INFO","Constructor Called");
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        String[] args = new String[] {};
        this._countries = new CountryAsyncTask().doInBackground(args);
        Log.v("VERBOX","Country Length @ Main"+this._countries.length);
        setListAdapter(new CountryArrayAdapter(this, R.layout.countrieslist, this._countries));
    }
}