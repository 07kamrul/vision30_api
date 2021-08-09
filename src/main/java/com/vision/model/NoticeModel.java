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
@Table(name = "notice")
public class NoticeModel{

 	@Id
	@Type(type = "org.hibernate.type.PostgresUUIDType")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private UUID id;	//NOT NULL DEFAULT uuid_generate_v4() 

	@Column(name = "notice_title")
	private String noticeTitle;

	@Column(name = "descriptions")
	private String descriptions;

	@Column(name = "publish_date")
	private Date publishDate;

	@Transient
	private MasterViewModel masterViewModel;


	public UUID getId(){
		return this.id;
	}

	public void  setId(UUID id){
		this.id = id;
	}

	public String getNoticeTitle(){
		return this.noticeTitle;
	}

	public void  setNoticeTitle(String noticeTitle){
		this.noticeTitle = noticeTitle;
	}

	public String getDescriptions(){
		return this.descriptions;
	}

	public void  setDescriptions(String descriptions){
		this.descriptions = descriptions;
	}

	public Date getPublishDate(){
		return this.publishDate;
	}

	public void  setPublishDate(Date publishDate){
		this.publishDate = publishDate;
	}

	public MasterViewModel getMasterViewModel(){
		return this.masterViewModel;
	}

	public void  setMasterViewModel(MasterViewModel masterViewModel){
		this.masterViewModel = masterViewModel;
	}



}
