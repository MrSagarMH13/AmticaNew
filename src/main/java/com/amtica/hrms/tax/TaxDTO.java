package com.amtica.hrms.tax;

public class TaxDTO {

	private String taxId;
	private String _Tax;
	private String countryCode;
	private String countryName;
	private byte[] flag;

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public String get_Tax() {
		return _Tax;
	}

	public void set_Tax(String _Tax) {
		this._Tax = _Tax;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public byte[] getFlag() {
		return flag;
	}

	public void setFlag(byte[] flag) {
		this.flag = flag;
	}

}
