package com.amtica.hrms.packg.details;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.amtica.hrms.feature.Feature;

/**
 * The persistent class for the PackageDetails database table.
 * 
 */
@Entity
@Table(name = "PackageDetails")
@NamedQuery(name = "PackageDetail.findAll", query = "SELECT p FROM PackageDetail p")
public class PackageDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer id;

	@Column(length = 25)
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDateTime;

	private Boolean isDeleted = Boolean.FALSE;

	@Column(length = 25)
	private String lastModifiedBy;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedDateTime;

	// bi-directional many-to-one association to Feature
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FeatureId")
	private Feature feature;

	// bi-directional many-to-one association to Package

	/*
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "PackageId") private Package createPackage;
	 */

	@Column(name = "PackageId")
	private Integer packageId;

	public PackageDetail() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Boolean getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
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

	public Feature getFeature() {
		return this.feature;
	}

	public void setFeature(Feature feature) {
		this.feature = feature;
	}

	public Integer getPackageId() {
		return packageId;
	}

	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}
	/*
	 * public Package getCreatePackage() { return createPackage; }
	 * 
	 * public void setCreatePackage(Package createPackage) { this.createPackage
	 * = createPackage; }
	 */

}