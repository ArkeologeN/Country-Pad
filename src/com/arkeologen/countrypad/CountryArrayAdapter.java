package com.arkeologen.countrypad;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CountryArrayAdapter extends ArrayAdapter<String> {
	
	private final Context _context;
	private final String[] _countries;
	private final int _layoutID;
	
	public CountryArrayAdapter(Context context, int textViewResourceId, String[] countries) {
		super(context, textViewResourceId, countries);
		this._context = context;	
		this._layoutID = textViewResourceId;
		this._countries = countries;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflator = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflator.inflate(this._layoutID, parent,false);
		TextView countryName = (TextView) rowView.findViewById(R.id.ctryName);
		Log.i("Country Length",this._countries.length+"");
		countryName.setText(this._countries[position]);
		return rowView;
	}
}
