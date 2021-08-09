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
@Table(name = "deposite")
public class DepositeModel{

 	@Id
	@Type(type = "org.hibernate.type.PostgresUUIDType")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private UUID id;	//NOT NULL DEFAULT uuid_generate_v4() 

	@Column(name = "deposite_date")
	private Date depositeDate;

	@Column(name = "deposite_amount")
	private int depositeAmount;	//DEFAULT 000 

	@Column(name = "diposite_pic")
	private String dipositePic;

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

	public Date getDepositeDate(){
		return this.depositeDate;
	}

	public void  setDepositeDate(Date depositeDate){
		this.depositeDate = depositeDate;
	}

	public int getDepositeAmount(){
		return this.depositeAmount;
	}

	public void  setDepositeAmount(int depositeAmount){
		this.depositeAmount = depositeAmount;
	}

	public String getDipositePic(){
		return this.dipositePic;
	}

	public void  setDipositePic(String dipositePic){
		this.dipositePic = dipositePic;
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
