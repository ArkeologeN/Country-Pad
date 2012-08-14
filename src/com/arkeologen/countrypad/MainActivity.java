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

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends ListActivity {
    /** Called when the activity is first created. */
	
	private String[] _countries;
	
	public MainActivity() {
		Log.v("INFO","Constructor Called");
		this._countries = new String[] {};
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        InputStream is = this.getResources().openRawResource(R.raw.countries);
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = builder.parse(is,null);
			NodeList country = doc.getElementsByTagName("country");
			Log.i("Country Count:",country.getLength()+"");
			for (int k = 0; k < country.getLength(); k++) {
				Element elm = (Element)country.item(k);
				Log.v("Counter:",k+"");
				//Log.v("Attribs Name:",elm.getAttribute("name").toString());
				//this._countries[k] = elm.getAttribute("name").toString();
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		Log.v("Adapter Countries:",this._countries.length+"");
        setListAdapter(new CountryArrayAdapter(this, R.layout.countrieslist, this._countries));
    }
}