package com.vision.model;

import java.util.UUID;
import javax.persistence.Id;
import org.hibernate.annotations.Type;

import com.vision.viewmodel.MasterViewModel;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Transient;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "slider")
public class SliderModel{

 	@Id
	@Type(type = "org.hibernate.type.PostgresUUIDType")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private UUID id;	//NOT NULL DEFAULT uuid_generate_v4() 

	@Column(name = "slide_image")
	private String slideImage;

	@Column(name = "title")
	private String title;

	@Transient
	private MasterViewModel masterViewModel;


	public UUID getId(){
		return this.id;
	}

	public void  setId(UUID id){
		this.id = id;
	}

	public String getSlideImage(){
		return this.slideImage;
	}

	public void  setSlideImage(String slideImage){
		this.slideImage = slideImage;
	}

	public String getTitle(){
		return this.title;
	}

	public void  setTitle(String title){
		this.title = title;
	}

	public MasterViewModel getMasterViewModel(){
		return this.masterViewModel;
	}

	public void  setMasterViewModel(MasterViewModel masterViewModel){
		this.masterViewModel = masterViewModel;
	}



}
