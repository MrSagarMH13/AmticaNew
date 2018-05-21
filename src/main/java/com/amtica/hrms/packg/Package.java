package com.amtica.hrms.packg;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the Packages database table.
 * 
 */
@Entity
@Table(name = "Packages")
@NamedQuery(name = "Package.findAll", query = "SELECT p FROM Package p")
public class Package implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer packageId;

	@Column(length = 25)
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDateTime;

	@Column(length = 250)
	private String description;

	private Boolean isActive = Boolean.TRUE;

	@Column(length = 25)
	private String lastModifiedBy;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedDateTime;

	private Integer minUserAllowed;

	@Column(nullable = false, length = 25)
	private String packageName;

	@Column(precision = 10, scale = 2)
	private BigDecimal pricePerUserPerMonth;

	@Column(precision = 10, scale = 2)
	private BigDecimal pricePerUserPerYear;

	private Integer trialPeriodDays;

	// bi-directional many-to-one association to PackageDetail
	/*@OneToMany(mappedBy = "package")
	private List<PackageDetail> packageDetails;
*/
	public Package() {
	}

	public Integer getPackageId() {
		return this.packageId;
	}

	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDateTime() {
		return this.createdDateTime;
	}

	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getLastModifiedBy() {
		return this.lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Date getLastModifiedDateTime() {
		return this.lastModifiedDateTime;
	}

	public void setLastModifiedDateTime(Date lastModifiedDateTime) {
		this.lastModifiedDateTime = lastModifiedDateTime;
	}

	public Integer getMinUserAllowed() {
		return this.minUserAllowed;
	}

	public void setMinUserAllowed(Integer minUserAllowed) {
		this.minUserAllowed = minUserAllowed;
	}

	public String getPackageName() {
		return this.packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public BigDecimal getPricePerUserPerMonth() {
		return this.pricePerUserPerMonth;
	}

	public void setPricePerUserPerMonth(BigDecimal pricePerUserPerMonth) {
		this.pricePerUserPerMonth = pricePerUserPerMonth;
	}

	public BigDecimal getPricePerUserPerYear() {
		return this.pricePerUserPerYear;
	}

	public void setPricePerUserPerYear(BigDecimal pricePerUserPerYear) {
		this.pricePerUserPerYear = pricePerUserPerYear;
	}

	public Integer getTrialPeriodDays() {
		return this.trialPeriodDays;
	}

	public void setTrialPeriodDays(Integer trialPeriodDays) {
		this.trialPeriodDays = trialPeriodDays;
	}

	/*
	 * public List<PackageDetail> getPackageDetails() { return
	 * this.packageDetails; }
	 * 
	 * public void setPackageDetails(List<PackageDetail> packageDetails) {
	 * this.packageDetails = packageDetails; }
	 * 
	 * public PackageDetail addPackageDetail(PackageDetail packageDetail) {
	 * getPackageDetails().add(packageDetail);
	 * packageDetail.setCreatePackage(this);
	 * 
	 * return packageDetail; }
	 * 
	 * public PackageDetail removePackageDetail(PackageDetail packageDetail) {
	 * getPackageDetails().remove(packageDetail);
	 * packageDetail.setCreatePackage(null);
	 * 
	 * return packageDetail; }
	 */

}