package com.vision.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

import com.vision.viewmodel.MasterViewModel;

@Entity
@Table(name = "user_roles")
public class UserRolesModel {

	@Id
	@Type(type = "org.hibernate.type.PostgresUUIDType")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private UUID id; // NOT NULL DEFAULT uuid_generate_v4()

	@Column(name = "user_id")
	private UUID userId;

	@Column(name = "username")
	private String username;

	@Column(name = "fullname")
	private String fullname;

	@Column(name = "email")
	private String email;

	@Column(name = "mobile")
	private String mobile;

	@Column(name = "created_by_username")
	private String createdByUsername;

	@Column(name = "created_by_fullname")
	private String createdByFullname;

	@Column(name = "created_by_email")
	private String createdByEmail;

	@Column(name = "created_on")
	private Date createdOn; // DEFAULT CURRENT_DATE

	@Column(name = "created_at")
	private Timestamp createdAt; // DEFAULT LOCALTIMESTAMP

	@Column(name = "updated_by_username")
	private String updatedByUsername;

	@Column(name = "updated_by_fullname")
	private String updatedByFullname;

	@Column(name = "updated_by_email")
	private String updatedByEmail;

	@Column(name = "updated_on")
	private Date updatedOn; // DEFAULT CURRENT_DATE

	@Column(name = "updated_at")
	private Timestamp updatedAt; // DEFAULT LOCALTIMESTAMP

	@Column(name = "is_approved")
	private boolean isApproved; // DEFAULT false

	@Column(name = "approved_by_username")
	private String approvedByUsername;

	@Column(name = "approved_by_fullname")
	private String approvedByFullname;

	@Column(name = "approved_by_email")
	private String approvedByEmail;

	@Column(name = "approved_on")
	private Date approvedOn; // DEFAULT CURRENT_DATE

	@Column(name = "approved_at")
	private Timestamp approvedAt; // DEFAULT LOCALTIMESTAMP

	@Column(name = "role")
	private String role;

	@Transient
	private MasterViewModel masterViewModel;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCreatedByUsername() {
		return createdByUsername;
	}

	public void setCreatedByUsername(String createdByUsername) {
		this.createdByUsername = createdByUsername;
	}

	public String getCreatedByFullname() {
		return createdByFullname;
	}

	public void setCreatedByFullname(String createdByFullname) {
		this.createdByFullname = createdByFullname;
	}

	public String getCreatedByEmail() {
		return createdByEmail;
	}

	public void setCreatedByEmail(String createdByEmail) {
		this.createdByEmail = createdByEmail;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedByUsername() {
		return updatedByUsername;
	}

	public void setUpdatedByUsername(String updatedByUsername) {
		this.updatedByUsername = updatedByUsername;
	}

	public String getUpdatedByFullname() {
		return updatedByFullname;
	}

	public void setUpdatedByFullname(String updatedByFullname) {
		this.updatedByFullname = updatedByFullname;
	}

	public String getUpdatedByEmail() {
		return updatedByEmail;
	}

	public void setUpdatedByEmail(String updatedByEmail) {
		this.updatedByEmail = updatedByEmail;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	public String getApprovedByUsername() {
		return approvedByUsername;
	}

	public void setApprovedByUsername(String approvedByUsername) {
		this.approvedByUsername = approvedByUsername;
	}

	public String getApprovedByFullname() {
		return approvedByFullname;
	}

	public void setApprovedByFullname(String approvedByFullname) {
		this.approvedByFullname = approvedByFullname;
	}

	public String getApprovedByEmail() {
		return approvedByEmail;
	}

	public void setApprovedByEmail(String approvedByEmail) {
		this.approvedByEmail = approvedByEmail;
	}

	public Date getApprovedOn() {
		return approvedOn;
	}

	public void setApprovedOn(Date approvedOn) {
		this.approvedOn = approvedOn;
	}

	public Timestamp getApprovedAt() {
		return approvedAt;
	}

	public void setApprovedAt(Timestamp approvedAt) {
		this.approvedAt = approvedAt;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public MasterViewModel getMasterViewModel() {
		return masterViewModel;
	}

	public void setMasterViewModel(MasterViewModel masterViewModel) {
		this.masterViewModel = masterViewModel;
	}

}
