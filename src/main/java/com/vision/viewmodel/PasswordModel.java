package com.vision.viewmodel;

import java.util.UUID;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

public class PasswordModel{

 	@Id
	@Type(type = "org.hibernate.type.PostgresUUIDType")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;	//NOT NULL DEFAULT uuid_generate_v4() 

	private String username;

	private String personName;

	private String pwd;

	private String prevPwd1;
	
	private String prevPwd2;

	private String prevPwd3;

	private String prevPwd4;

	private String hint;

	private String dataDigest;

	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPrevPwd1() {
		return prevPwd1;
	}

	public void setPrevPwd1(String prevPwd1) {
		this.prevPwd1 = prevPwd1;
	}

	public String getPrevPwd2() {
		return prevPwd2;
	}

	public void setPrevPwd2(String prevPwd2) {
		this.prevPwd2 = prevPwd2;
	}

	public String getPrevPwd3() {
		return prevPwd3;
	}

	public void setPrevPwd3(String prevPwd3) {
		this.prevPwd3 = prevPwd3;
	}

	public String getPrevPwd4() {
		return prevPwd4;
	}

	public void setPrevPwd4(String prevPwd4) {
		this.prevPwd4 = prevPwd4;
	}

	public String getHint() {
		return hint;
	}

	public void setHint(String hint) {
		this.hint = hint;
	}

	public String getDataDigest() {
		return dataDigest;
	}

	public void setDataDigest(String dataDigest) {
		this.dataDigest = dataDigest;
	}

	public PasswordModel() {}

	


}
