package com.amtica.hrms.feature;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.amtica.hrms.packg.details.PackageDetail;

/**
 * @author Sagar Mob: +91-9545059400
 */
@Entity
@Table(name = "Features")
@NamedQuery(name = "Feature.findAll", query = "SELECT f FROM Feature f")
public class Feature implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer id;

	@Column(length = 25)
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDateTime;

	@Column(length = 250)
	private String description;

	private Boolean isDeleted = Boolean.FALSE;

	@Column(length = 25)
	private String lastModifiedBy;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedDateTime;

	@Column(nullable = false, length = 45)
	private String name;

	// bi-directional many-to-one association to PackageDetail
	@OneToMany(mappedBy = "feature")
	private List<PackageDetail> packageDetails;

	public Feature() {
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PackageDetail> getPackageDetails() {
		return this.packageDetails;
	}

	public void setPackageDetails(List<PackageDetail> packageDetails) {
		this.packageDetails = packageDetails;
	}

	public PackageDetail addPackageDetail(PackageDetail packageDetail) {
		getPackageDetails().add(packageDetail);
		packageDetail.setFeature(this);

		return packageDetail;
	}

	public PackageDetail removePackageDetail(PackageDetail packageDetail) {
		getPackageDetails().remove(packageDetail);
		packageDetail.setFeature(null);

		return packageDetail;
	}

}