package com.arkeologen.countrypad;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CountryDBHelper extends SQLiteOpenHelper {
	
	private static final String DATABASE_NAME = "countrypaddb";
	
	public CountryDBHelper(Context context) {
		super(context,DATABASE_NAME,null,1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		/**
		 *  Create a Countries Table & Insert the list of COUNTRIES
		 */
		String sql = "CREATE TABLE IF NOT EXISTS countries ("+
						"_id INTEGER PRIMARY KEY AUTO_INCREMENT, "+
						"country_code TEXT, "+
						"country_name TEXT)";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

}
