package com.amtica.hrms.tax;

import java.io.Serializable;
import javax.persistence.*;

import com.amtica.hrms.institute.Institute;
import com.amtica.hrms.packg.details.PackageDetail;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the Tax database table.
 * 
 */
@Entity
@Table(name = "Tax")
@NamedQuery(name = "Tax.findAll", query = "SELECT t FROM Tax t")
public class Tax implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer taxId;

	@Column(name = "Tax", precision = 10, scale = 2)
	private BigDecimal _Tax;

	@Column(length = 5)
	private String countryCode;

	@Column(length = 45)
	private String countryName;

	@Lob
	private byte[] flag;

	private Boolean isActive = Boolean.TRUE;

	@Column(length = 25)
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDateTime;

	@Column(length = 25)
	private String lastModifiedBy;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedDateTime;

	@OneToMany(mappedBy="tax")
	private List<Institute> instituteList;
	
	public Tax() {
	}

	public Integer getTaxId() {
		return this.taxId;
	}

	public void setTaxId(Integer taxId) {
		this.taxId = taxId;
	}

	public BigDecimal get_Tax() {
		return this._Tax;
	}

	public void set_Tax(BigDecimal _Tax) {
		this._Tax = _Tax;
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return this.countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public byte[] getFlag() {
		return this.flag;
	}

	public void setFlag(byte[] flag) {
		this.flag = flag;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Date getLastModifiedDateTime() {
		return lastModifiedDateTime;
	}

	public void setLastModifiedDateTime(Date lastModifiedDateTime) {
		this.lastModifiedDateTime = lastModifiedDateTime;
	}

	public List<Institute> getInstitute() {
		return instituteList;
	}

	public void setInstitute(List<Institute> instituteList) {
		this.instituteList = instituteList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Institute addInstitute(Institute institute) {
		getInstitute().add(institute);
		institute.setTax(this);

		return institute;
	}

	public Institute removeInstitue(Institute institute) {
		getInstitute().remove(institute);
		institute.setTax(null);

		return institute;
	}
}