package com.arkeologen.countrypad;

public class Country {
	
	private boolean _isBasic = true;
	private String _cCode,_cName,_continent,_capital,_currencyCode,_language = null;
	private Double _areaInSqKm,_population,_west,_north,_east,_south = null;
	
	/**
	 * 
	 * @param isBasic Boolean
	 * Set if we need to use whole object or just basic instance
	 */
	public void setIsBasic(boolean isBasic) {
		this._isBasic = isBasic;
	}
	
	/**
	 * 
	 * @return Boolean
	 * Either Country Orientation is complete or Basic
	 */
	public boolean getIsBasic() {
		return this._isBasic;
	}
	
	/**
	 * 
	 * @param _ccode String
	 * Set the country code value
	 */
	public void setCountryCode(String ccode) {
		this._cCode = ccode;
	}
	
	/**
	 * 
	 * @return String
	 * Returns Country Code
	 */
	public String getCountryCode() {
		return this._cCode;
	}
	
	/**
	 * 
	 * @param cname String
	 * Set the Fullname of Country
	 */
	public void setCountryName(String cname) {
		this._cName = cname;
	}
	
	/**
	 * 
	 * @return String
	 * Get the fullname of the country
	 */
	public String getCountryName() {
		return this._cName;
	}
	
	/**
	 * 
	 * @param continent
	 * Set the country's continent
	 */
	public void setContinent(String continent) {
		this._continent = continent;
	}
	
	/**
	 * 
	 * @return String
	 *  Returns the continent
	 */
	public String getContinent() {
		return this._continent;
	}
	
	/**
	 * 
	 * @param capital
	 * Set the capital city of state / country
	 */
	public void setCapital(String capital) {
		this._capital = capital;
	}
	
	/**
	 * 
	 * @return String
	 * returns Capital City of state / Country
	 */
	public String getCapital() {
		return this._capital;
	}
	
	/**
	 * 
	 * @param curr
	 * Set the currency of the country
	 */
	public void setCurrency(String curr) {
		this._currencyCode = curr;
	}
	
	/**
	 * 
	 * @return String
	 * Get the currency of the country
	 */
	public String getCurrency() {
		return this._currencyCode;
	}
	
	/**
	 * 
	 * @param lang
	 * Set the Language of the country
	 */
	public void setLanguage(String lang) {
		this._language = lang;
	}
	
	/**
	 * 
	 * @return String
	 * Get the language of the Country
	 */
	public String getLanguage() {
		return this._language;
	}
	
	/**
	 * 
	 * @param sqkm
	 * Set the Square KiloMeter distance of the country
	 */
	public void setAreaInSqKm(Double sqkm) {
		this._areaInSqKm = sqkm;
	}
	
	/**
	 * 
	 * @return Number (Double)
	 * Get the Square KiloMeter distance of the country
	 */
	public Double getAreaInSqKm() {
		return this._areaInSqKm;
	}
	
	/**
	 * 
	 * @param population
	 * Set the Population of Peoples in the country
	 */
	public void setPopulation(Double population) {
		this._population = population;
	}
	
	/**
	 * 
	 * @return Number (Double)
	 * Get the Population of Peoples in the country
	 */
	public Double getPopulation() {
		return this._population;
	}
	
	/**
	 * 
	 * @param west
	 * Set the coordinates of the country from WEST
	 */
	public void setFromWest(Double west) {
		this._west = west;
	}
	
	/**
	 * 
	 * @return Number (Double)
	 * Get the coordinates of the country from WEST
	 */
	public Double getFromWest() {
		return this._west;
	}
	
	/**
	 * 
	 * @param north
	 * Set the coordinates of the country from NORTH
	 */
	public void setFromNorth(Double north) {
		this._north = north;
	}
	
	/**
	 * 
	 * @return Number (Double)
	 * Get the coordinates of the country from North
	 */
	public Double getFromNorth() {
		return this._north;
	}
	
	/**
	 * 
	 * @param east
	 * Set the coordinates of the country from EAST
	 */
	public void setFromEast(Double east) {
		this._east = east;
	}
	
	/**
	 * 
	 * @return Number (Double)
	 * Get the coordinates of the country from EAST
	 */
	public Double getFromEast() {
		return this._east;
	}
	
	/**
	 * 
	 * @param south
	 * Set the coordinates of the country from SOUTH
	 */
	public void setFromSouth(Double south) {
		this._south = south;
	}
	
	/**
	 * 
	 * @return Number (Double)
	 * Get the coordinates of the country from SOUTH
	 */
	public Double getFromSouth() {
		return this._south;
	}
	
}