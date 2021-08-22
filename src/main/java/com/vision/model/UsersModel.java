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
@Table(name = "users")
public class UsersModel {

	@Id
	@Type(type = "org.hibernate.type.PostgresUUIDType")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private UUID id; // NOT NULL DEFAULT uuid_generate_v4()

	@Column(name = "username")
	private String username;

	@Column(name = "user_password")
	private String userPassword;

	@Column(name = "email")
	private String email;

	@Column(name = "is_user")
	private boolean isUser; // NOT NULL

	@Column(name = "is_admin")
	private boolean isAdmin; // NOT NULL

	@Column(name = "date_joined")
	private Date dateJoined; // NOT NULL

	@Column(name = "member_id")
	private int memberId; // NOT NULL

	@Transient
	private MasterViewModel masterViewModel;

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isUser() {
		return this.isUser;
	}

	public void setUser(boolean isUser) {
		this.isUser = isUser;
	}

	public boolean isAdmin() {
		return this.isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Date getDateJoined() {
		return this.dateJoined;
	}

	public void setDateJoined(Date dateJoined) {
		this.dateJoined = dateJoined;
	}

	public int getMemberId() {
		return this.memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public MasterViewModel getMasterViewModel() {
		return this.masterViewModel;
	}

	public void setMasterViewModel(MasterViewModel masterViewModel) {
		this.masterViewModel = masterViewModel;
	}

}
