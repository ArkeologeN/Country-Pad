package com.arkeologen.countrypad;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

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
	
	private ArrayList<Country> _countries;
	
	public MainActivity() {
		Log.v("INFO","Constructor Called");
		this._countries = new ArrayList<Country>();
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        InputStream is = this.getResources().openRawResource(R.raw.countries);
        this.xmlCountryParsing(is);
        setListAdapter(new CountryArrayAdapter(this, R.layout.countrieslist, this._countries));
    }
    
    private void xmlCountryParsing(InputStream is) {
    	try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = builder.parse(is,null);
			NodeList countries = doc.getElementsByTagName("country");
			for (int k = 0; k < countries.getLength(); k++) {
				Element elm = (Element)countries.item(k);
				Country country = new Country();
				country.setCountryCode(elm.getAttribute("code").toString());
				country.setCountryName(elm.getAttribute("name").toString());
				this._countries.add(country);
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
    }
}