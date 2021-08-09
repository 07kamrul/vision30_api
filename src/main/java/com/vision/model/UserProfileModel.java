package com.vision.model;

import java.util.UUID;
import javax.persistence.Id;
import org.hibernate.annotations.Type;

import com.vision.viewmodel.MasterViewModel;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import java.sql.Date;
import javax.persistence.Transient;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_profile")
public class UserProfileModel{

 	@Id
	@Type(type = "org.hibernate.type.PostgresUUIDType")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private UUID id;	//NOT NULL DEFAULT uuid_generate_v4() 

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "full_name")
	private String fullName;

	@Column(name = "profile_pic")
	private String profilePic;

	@Column(name = "date_joined")
	private Date dateJoined;

	@Column(name = "father_name")
	private String fatherName;

	@Column(name = "mother_name")
	private String motherName;

	@Column(name = "nationality")
	private String nationality;

	@Column(name = "gender")
	private String gender;	//DEFAULT 'Male' 

	@Column(name = "occupation")
	private String occupation;

	@Column(name = "designation")
	private String designation;

	@Column(name = "company")
	private String company;

	@Column(name = "nid")
	private String nid;

	@Column(name = "member_id")
	private int memberId;

	@Column(name = "phone")
	private String phone;

	@Column(name = "email")
	private String email;

	@Column(name = "date_of_birth")
	private Date dateOfBirth;

	@Column(name = "marital_status")
	private String maritalStatus;	//DEFAULT 'Single' 

	@Column(name = "religion")
	private String religion;

	@Column(name = "permanent_address")
	private String permanentAddress;

	@Column(name = "present_address")
	private String presentAddress;

	@Column(name = "nominee_name")
	private String nomineeName;

	@Column(name = "relation")
	private String relation;

	@Column(name = "nominee_father_name")
	private String nomineeFatherName;

	@Column(name = "nominee_mother_name")
	private String nomineeMotherName;

	@Column(name = "nominee_phone")
	private String nomineePhone;

	@Column(name = "nominee_date_of_birth")
	private Date nomineeDateOfBirth;

	@Column(name = "nominee_gender")
	private String nomineeGender;	//DEFAULT 'Male' 

	@Column(name = "nominee_marital_status")
	private String nomineeMaritalStatus;	//DEFAULT 'Single' 

	@Column(name = "nominee_religion")
	private String nomineeReligion;

	@Column(name = "nominee_nid")
	private String nomineeNid;

	@Column(name = "nominee_present_address")
	private String nomineePresentAddress;

	@Column(name = "nominee_permanent_address")
	private String nomineePermanentAddress;

	@Column(name = "account_no")
	private String accountNo;

	@Column(name = "bank_name")
	private String bankName;

	@Column(name = "branch_address")
	private String branchAddress;

	@Column(name = "user_id")
	private UUID userId;

	@Column(name = "username")
	private String username;

	@Column(name = "is_user")
	private boolean isUser;	//NOT NULL 

	@Column(name = "is_admin")
	private boolean isAdmin;	//NOT NULL 

	@Transient
	private MasterViewModel masterViewModel;


	public UUID getId(){
		return this.id;
	}

	public void  setId(UUID id){
		this.id = id;
	}

	public String getFirstName(){
		return this.firstName;
	}

	public void  setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getLastName(){
		return this.lastName;
	}

	public void  setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getFullName(){
		return this.fullName;
	}

	public void  setFullName(String fullName){
		this.fullName = fullName;
	}

	public String getProfilePic(){
		return this.profilePic;
	}

	public void  setProfilePic(String profilePic){
		this.profilePic = profilePic;
	}

	public Date getDateJoined(){
		return this.dateJoined;
	}

	public void  setDateJoined(Date dateJoined){
		this.dateJoined = dateJoined;
	}

	public String getFatherName(){
		return this.fatherName;
	}

	public void  setFatherName(String fatherName){
		this.fatherName = fatherName;
	}

	public String getMotherName(){
		return this.motherName;
	}

	public void  setMotherName(String motherName){
		this.motherName = motherName;
	}

	public String getNationality(){
		return this.nationality;
	}

	public void  setNationality(String nationality){
		this.nationality = nationality;
	}

	public String getGender(){
		return this.gender;
	}

	public void  setGender(String gender){
		this.gender = gender;
	}

	public String getOccupation(){
		return this.occupation;
	}

	public void  setOccupation(String occupation){
		this.occupation = occupation;
	}

	public String getDesignation(){
		return this.designation;
	}

	public void  setDesignation(String designation){
		this.designation = designation;
	}

	public String getCompany(){
		return this.company;
	}

	public void  setCompany(String company){
		this.company = company;
	}

	public String getNid(){
		return this.nid;
	}

	public void  setNid(String nid){
		this.nid = nid;
	}

	public int getMemberId(){
		return this.memberId;
	}

	public void  setMemberId(int memberId){
		this.memberId = memberId;
	}

	public String getPhone(){
		return this.phone;
	}

	public void  setPhone(String phone){
		this.phone = phone;
	}

	public String getEmail(){
		return this.email;
	}

	public void  setEmail(String email){
		this.email = email;
	}

	public Date getDateOfBirth(){
		return this.dateOfBirth;
	}

	public void  setDateOfBirth(Date dateOfBirth){
		this.dateOfBirth = dateOfBirth;
	}

	public String getMaritalStatus(){
		return this.maritalStatus;
	}

	public void  setMaritalStatus(String maritalStatus){
		this.maritalStatus = maritalStatus;
	}

	public String getReligion(){
		return this.religion;
	}

	public void  setReligion(String religion){
		this.religion = religion;
	}

	public String getPermanentAddress(){
		return this.permanentAddress;
	}

	public void  setPermanentAddress(String permanentAddress){
		this.permanentAddress = permanentAddress;
	}

	public String getPresentAddress(){
		return this.presentAddress;
	}

	public void  setPresentAddress(String presentAddress){
		this.presentAddress = presentAddress;
	}

	public String getNomineeName(){
		return this.nomineeName;
	}

	public void  setNomineeName(String nomineeName){
		this.nomineeName = nomineeName;
	}

	public String getRelation(){
		return this.relation;
	}

	public void  setRelation(String relation){
		this.relation = relation;
	}

	public String getNomineeFatherName(){
		return this.nomineeFatherName;
	}

	public void  setNomineeFatherName(String nomineeFatherName){
		this.nomineeFatherName = nomineeFatherName;
	}

	public String getNomineeMotherName(){
		return this.nomineeMotherName;
	}

	public void  setNomineeMotherName(String nomineeMotherName){
		this.nomineeMotherName = nomineeMotherName;
	}

	public String getNomineePhone(){
		return this.nomineePhone;
	}

	public void  setNomineePhone(String nomineePhone){
		this.nomineePhone = nomineePhone;
	}

	public Date getNomineeDateOfBirth(){
		return this.nomineeDateOfBirth;
	}

	public void  setNomineeDateOfBirth(Date nomineeDateOfBirth){
		this.nomineeDateOfBirth = nomineeDateOfBirth;
	}

	public String getNomineeGender(){
		return this.nomineeGender;
	}

	public void  setNomineeGender(String nomineeGender){
		this.nomineeGender = nomineeGender;
	}

	public String getNomineeMaritalStatus(){
		return this.nomineeMaritalStatus;
	}

	public void  setNomineeMaritalStatus(String nomineeMaritalStatus){
		this.nomineeMaritalStatus = nomineeMaritalStatus;
	}

	public String getNomineeReligion(){
		return this.nomineeReligion;
	}

	public void  setNomineeReligion(String nomineeReligion){
		this.nomineeReligion = nomineeReligion;
	}

	public String getNomineeNid(){
		return this.nomineeNid;
	}

	public void  setNomineeNid(String nomineeNid){
		this.nomineeNid = nomineeNid;
	}

	public String getNomineePresentAddress(){
		return this.nomineePresentAddress;
	}

	public void  setNomineePresentAddress(String nomineePresentAddress){
		this.nomineePresentAddress = nomineePresentAddress;
	}

	public String getNomineePermanentAddress(){
		return this.nomineePermanentAddress;
	}

	public void  setNomineePermanentAddress(String nomineePermanentAddress){
		this.nomineePermanentAddress = nomineePermanentAddress;
	}

	public String getAccountNo(){
		return this.accountNo;
	}

	public void  setAccountNo(String accountNo){
		this.accountNo = accountNo;
	}

	public String getBankName(){
		return this.bankName;
	}

	public void  setBankName(String bankName){
		this.bankName = bankName;
	}

	public String getBranchAddress(){
		return this.branchAddress;
	}

	public void  setBranchAddress(String branchAddress){
		this.branchAddress = branchAddress;
	}

	public UUID getUserId(){
		return this.userId;
	}

	public void  setUserId(UUID userId){
		this.userId = userId;
	}

	public String getUsername(){
		return this.username;
	}

	public void  setUsername(String username){
		this.username = username;
	}

	public boolean isUser(){
		return this.isUser;
	}

	public void  setUser(boolean isUser){
		this.isUser = isUser;
	}

	public boolean isAdmin(){
		return this.isAdmin;
	}

	public void  setAdmin(boolean isAdmin){
		this.isAdmin = isAdmin;
	}

	public MasterViewModel getMasterViewModel(){
		return this.masterViewModel;
	}

	public void  setMasterViewModel(MasterViewModel masterViewModel){
		this.masterViewModel = masterViewModel;
	}



}
