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
@Table(name = "total_cost")
public class TotalCostModel{

 	@Id
	@Type(type = "org.hibernate.type.PostgresUUIDType")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private UUID id;	//NOT NULL DEFAULT uuid_generate_v4() 

	@Column(name = "cost_date")
	private Date costDate;

	@Column(name = "reason")
	private String reason;

	@Column(name = "amount")
	private int amount;

	@Transient
	private MasterViewModel masterViewModel;


	public UUID getId(){
		return this.id;
	}

	public void  setId(UUID id){
		this.id = id;
	}

	public Date getCostDate(){
		return this.costDate;
	}

	public void  setCostDate(Date costDate){
		this.costDate = costDate;
	}

	public String getReason(){
		return this.reason;
	}

	public void  setReason(String reason){
		this.reason = reason;
	}

	public int getAmount(){
		return this.amount;
	}

	public void  setAmount(int amount){
		this.amount = amount;
	}

	public MasterViewModel getMasterViewModel(){
		return this.masterViewModel;
	}

	public void  setMasterViewModel(MasterViewModel masterViewModel){
		this.masterViewModel = masterViewModel;
	}



}
