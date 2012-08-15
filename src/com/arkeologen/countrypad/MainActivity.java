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
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends ListActivity {
    /** Called when the activity is first created. */
	
	private ArrayList<Country> _countries;
	private EditText _txtSearchCountry = null;
	private static CountryArrayAdapter _adapter = null;
	
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
        _adapter = new CountryArrayAdapter(this, R.layout.countrieslist, this._countries);
        setListAdapter(_adapter);
        _txtSearchCountry = (EditText)findViewById(R.id.txtCountrySearch);
        this.setTextFilter();
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
    
    private void setTextFilter() {
    	if (this._txtSearchCountry != null && this._txtSearchCountry instanceof EditText) {
    		this._txtSearchCountry.addTextChangedListener(new TextWatcher() {
				
				@Override
				public void onTextChanged(CharSequence s, int start, int before, int count) {
					_adapter.getFilter().filter(s.toString());
				}
				
				@Override
				public void beforeTextChanged(CharSequence s, int start, int count,
						int after) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void afterTextChanged(Editable s) {
					// TODO Auto-generated method stub
					
				}
			});
    	}
    }
}