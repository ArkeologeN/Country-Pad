package com.arkeologen.countrypad;


import java.util.ArrayList;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

public class CountryArrayAdapter extends ArrayAdapter<ArrayList<Country>> implements Filterable {
	
	private final Context _context;
	private ArrayList<Country> _mFCountries;
	private final ArrayList<Country> _mItems;
	private final int _layoutID;
	private Filter _filter = null;
	private static Object mSync = new Object();
	
	@SuppressWarnings("unchecked")
	public CountryArrayAdapter(Context context, int textViewResourceId, ArrayList<Country> countries) {
		super(context, textViewResourceId);
		this._context = context;	
		this._layoutID = textViewResourceId;
		this._mFCountries = countries;
		this._mItems = (ArrayList<Country>) countries.clone();
		this._filter = new CountryFilter();
		
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return this._mFCountries.size();
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View rowView = null;
		try {
			LayoutInflater inflator = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			rowView = inflator.inflate(this._layoutID, parent,false);
			TextView countryName = (TextView) rowView.findViewById(R.id.ctryName);
			if (this._mFCountries.size() > 0) {
				Country country = this._mFCountries.get(position);
				countryName.setText(country.getCountryName().toString());
			}
			
		} catch( Exception e) {
			e.printStackTrace();
		}
		return rowView;
	}
	
	@Override
	public Filter getFilter() {
		if (this._filter == null) {
			this._filter = new CountryFilter();
		}
		return this._filter;
	}
	
	private class CountryFilter extends Filter {

		@Override
		protected FilterResults performFiltering(CharSequence constraint) {
			constraint = constraint.toString().toLowerCase();
			FilterResults results = new FilterResults();
			try {				
				if ( constraint != null && constraint.length() >0) {
					ArrayList<Country> filtered = new ArrayList<Country>();
					ArrayList<Country> backStack = new ArrayList<Country>();
					synchronized (mSync) {
						backStack.addAll(_mItems);
					}
					for (int k = 0; k < backStack.size(); k++) {
						Country ctry = backStack.get(k);
						if (ctry.getCountryName().toString().toLowerCase().contains(constraint)) {
							filtered.add(ctry);
							results.count = filtered.size();
							results.values = filtered;
						}
					}
				} else {
					synchronized (mSync) {
						results.count  = _mItems.size();
						results.values = _mItems;
					}
				}
			} catch (Exception ex) {
				Log.d("Exception:",ex.toString());
			}
			return results;
		}

		@SuppressWarnings("unchecked")
		@Override
		protected void publishResults(CharSequence constraint,
				FilterResults results) {
			_mFCountries = (ArrayList<Country>) results.values;
			clear();
			for (int j = 0; j < _mFCountries.size(); j++) {
				add(_mFCountries);
			}
			
			notifyDataSetInvalidated();
		}
		
	}
}
