package com.arkeologen.countrypad;



import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

public class CountryAsyncTask extends AsyncTask<String[], Integer, String[]> {
	
	private String[] _countryNames;
	private Context _context;
	
	public CountryAsyncTask(Context context) {
		this._context = context;
	}
	
	@Override
	protected String[] doInBackground(String[]... args) {

		InputStream is = this._context.getResources().openRawResource(R.raw.countries);
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = builder.parse(is,null);
			NodeList country = doc.getElementsByTagName("country");
			Log.i("Country Count:",country.getLength()+"");
			for (int k = 0; k < country.getLength(); k++) {
				//Element elm = (Element)country.item(k);
				Log.i("Country Count:",k+"");
				///this._countryNames[k] = elm.getAttribute("name").toString();
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this._countryNames;
	}
}