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
@Table(name = "amount")
public class AmountModel{

 	@Id
	@Type(type = "org.hibernate.type.PostgresUUIDType")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private UUID id;	//NOT NULL DEFAULT uuid_generate_v4() 

	@Column(name = "amount_date")
	private Date amountDate;

	@Column(name = "amount")
	private int amount;	//DEFAULT 0000 

	@Column(name = "status")
	private String status;

	@Column(name = "diposite_slip")
	private String dipositeSlip;

	@Column(name = "person_id")
	private UUID personId;

	@Column(name = "person_name")
	private String personName;

	@Column(name = "person_gender")
	private String personGender;	//DEFAULT 'Male' 

	@Column(name = "person_mobile")
	private String personMobile;

	@Column(name = "person_email")
	private String personEmail;

	@Column(name = "person_username")
	private String personUsername;

	@Transient
	private MasterViewModel masterViewModel;


	public UUID getId(){
		return this.id;
	}

	public void  setId(UUID id){
		this.id = id;
	}

	public Date getAmountDate(){
		return this.amountDate;
	}

	public void  setAmountDate(Date amountDate){
		this.amountDate = amountDate;
	}

	public int getAmount(){
		return this.amount;
	}

	public void  setAmount(int amount){
		this.amount = amount;
	}

	public String getStatus(){
		return this.status;
	}

	public void  setStatus(String status){
		this.status = status;
	}

	public String getDipositeSlip(){
		return this.dipositeSlip;
	}

	public void  setDipositeSlip(String dipositeSlip){
		this.dipositeSlip = dipositeSlip;
	}

	public UUID getPersonId(){
		return this.personId;
	}

	public void  setPersonId(UUID personId){
		this.personId = personId;
	}

	public String getPersonName(){
		return this.personName;
	}

	public void  setPersonName(String personName){
		this.personName = personName;
	}

	public String getPersonGender(){
		return this.personGender;
	}

	public void  setPersonGender(String personGender){
		this.personGender = personGender;
	}

	public String getPersonMobile(){
		return this.personMobile;
	}

	public void  setPersonMobile(String personMobile){
		this.personMobile = personMobile;
	}

	public String getPersonEmail(){
		return this.personEmail;
	}

	public void  setPersonEmail(String personEmail){
		this.personEmail = personEmail;
	}

	public String getPersonUsername(){
		return this.personUsername;
	}

	public void  setPersonUsername(String personUsername){
		this.personUsername = personUsername;
	}

	public MasterViewModel getMasterViewModel(){
		return this.masterViewModel;
	}

	public void  setMasterViewModel(MasterViewModel masterViewModel){
		this.masterViewModel = masterViewModel;
	}



}
