package com.arkeologen.countrypad;


import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CountryArrayAdapter extends ArrayAdapter<ArrayList<Country>> {
	
	private final Context _context;
	private final ArrayList<Country> _countries;
	private final int _layoutID;
	
	public CountryArrayAdapter(Context context, int textViewResourceId, ArrayList<Country> countries) {
		super(context, textViewResourceId);
		this._context = context;	
		this._layoutID = textViewResourceId;
		this._countries = countries;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return this._countries.size();
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View rowView = null;
		try {
			LayoutInflater inflator = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			rowView = inflator.inflate(this._layoutID, parent,false);
			TextView countryName = (TextView) rowView.findViewById(R.id.ctryName);
			if (this._countries.size() > 0) {
				Country country = this._countries.get(position);
				countryName.setText(country.getCountryName().toString());
			}
			
		} catch( Exception e) {
			e.printStackTrace();
		}
		return rowView;
	}
}
