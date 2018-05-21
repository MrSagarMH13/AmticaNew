package com.amtica.hrms.packg;

import java.util.List;

import com.amtica.hrms.packg.details.PackageDetailsDTO;

public class PackageDTO {
	private String packageId;
	private String createdBy;
	private String createdDateTime;
	private String description;
	private Boolean isActive;
	private String lastModifiedBy;
	private String lastModifiedDateTime;
	private String minUserAllowed;
	private String packageName;
	private String pricePerUserPerMonth;
	private String pricePerUserPerYear;
	private String trialPeriodDays;
	private List<PackageDetailsDTO> packageDetails;

	public String getPackageId() {
		return packageId;
	}

	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(String createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public String getLastModifiedDateTime() {
		return lastModifiedDateTime;
	}

	public void setLastModifiedDateTime(String lastModifiedDateTime) {
		this.lastModifiedDateTime = lastModifiedDateTime;
	}

	public String getMinUserAllowed() {
		return minUserAllowed;
	}

	public void setMinUserAllowed(String minUserAllowed) {
		this.minUserAllowed = minUserAllowed;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getPricePerUserPerMonth() {
		return pricePerUserPerMonth;
	}

	public void setPricePerUserPerMonth(String pricePerUserPerMonth) {
		this.pricePerUserPerMonth = pricePerUserPerMonth;
	}

	public String getPricePerUserPerYear() {
		return pricePerUserPerYear;
	}

	public void setPricePerUserPerYear(String pricePerUserPerYear) {
		this.pricePerUserPerYear = pricePerUserPerYear;
	}

	public String getTrialPeriodDays() {
		return trialPeriodDays;
	}

	public void setTrialPeriodDays(String trialPeriodDays) {
		this.trialPeriodDays = trialPeriodDays;
	}

	public List<PackageDetailsDTO> getPackageDetails() {
		return packageDetails;
	}

	public void setPackageDetails(List<PackageDetailsDTO> packageDetails) {
		this.packageDetails = packageDetails;
	}

}
