package com.amtica.hrms.packg.details;

import com.amtica.hrms.feature.Feature;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class PackageDetailsDTO {

	private String id;
	private String createdBy;
	private String createdDateTime;
	private Boolean isDeleted;
	private String lastModifiedBy;
	private String lastModifiedDateTime;
	private String featureId;
	private String featureName;
	
	@JsonIgnore
	private Feature myFeature;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
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

	public String getFeatureId() {
		return featureId;
	}

	public void setFeatureId(String featureId) {
		this.featureId = featureId;
	}

	public String getFeatureName() {
		return featureName;
	}

	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}

	public Feature getMyFeature() {
		return myFeature;
	}

	public void setMyFeature(Feature myFeature) {
		this.myFeature = myFeature;
	}

}
