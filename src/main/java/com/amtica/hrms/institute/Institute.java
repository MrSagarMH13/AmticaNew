package com.amtica.hrms.institute;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.transaction.Transactional.TxType;

import com.amtica.hrms.feature.Feature;
import com.amtica.hrms.institute.branch.Branches;
import com.amtica.hrms.packg.details.PackageDetail;
import com.amtica.hrms.tax.Tax;

@Entity
@Table(name="Institute")
@NamedQuery(name="Institute.findAll", query="select i from Institute i")
public class Institute {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer instituteId;
	
	@Column(length=12)
	private String contact;
	
	@Column(length=45)
	private String registrationNum;
	
	@Column(length=45)
	private String ownerEmailId;
	
	@Column(length=45)
	private String pass;
	
	@Column
	private Integer minUserCount;
	
	@Column(length=35)
	private String selectedPlan;
	
	@Column
	private boolean isDeleted=Boolean.FALSE;


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "countryId")
	private Tax tax;
	
	
	@OneToMany(mappedBy="institute")
	private List<Branches> branchesList;
	
	
	
	public boolean isDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Integer getInstituteId() {
		return instituteId;
	}

	public void setInstituteId(Integer instituteId) {
		this.instituteId = instituteId;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getRegistrationNum() {
		return registrationNum;
	}

	public void setRegistrationNum(String registrationNum) {
		this.registrationNum = registrationNum;
	}

	public String getOwnerEmailId() {
		return ownerEmailId;
	}

	public void setOwnerEmailId(String ownerEmailId) {
		this.ownerEmailId = ownerEmailId;
	}

	public Integer getMinUserCount() {
		return minUserCount;
	}

	public void setMinUserCount(Integer minUserCount) {
		this.minUserCount = minUserCount;
	}

	public String getSelectedPlan() {
		return selectedPlan;
	}

	public void setSelectedPlan(String selectedPlan) {
		this.selectedPlan = selectedPlan;
	}

	public Tax getTax() {
		return tax;
	}

	public void setTax(Tax tax) {
		this.tax = tax;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	

	

	public List<Branches> getBranchesList() {
		return branchesList;
	}

	public void setBranchesList(List<Branches> branchesList) {
		this.branchesList = branchesList;
	}

	public Branches addBranches(Branches branches){
		
		getBranchesList().add(branches);
		branches.setInstitute(this);
		return branches;
	}
	
	public Branches removeBranches(Branches branches){
		
		getBranchesList().remove(branches);
		branches.setInstitute(null);
		return branches;
	}
	
	
	

}
