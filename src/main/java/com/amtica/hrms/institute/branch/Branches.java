package com.amtica.hrms.institute.branch;

import java.util.List;

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

import com.amtica.hrms.institute.Institute;

@Entity
@Table(name="Branches")
@NamedQuery(name="Branches.findAll", query="select b from Branches b")
public class Branches {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer branchId;
	
	@Column(length=45)
	private String branchName;
	
	@Column(length=45)
	private String branchAddress;
	
	@Column(length=45)
	private String emailAddress;
	
	@Column(length=45)
	private String pass;
	
	@Column
	private boolean isTrue=Boolean.TRUE;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="instituteId")
	private Institute institute;

	
	
	
	public boolean getIsTrue() {
		return isTrue;
	}

	public void setIsTrue(boolean isTrue) {
		this.isTrue = isTrue;
	}

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Institute getInstitute() {
		return institute;
	}

	public void setInstitute(Institute institute) {
		this.institute = institute;
	}

	

	
	
	
	
}
