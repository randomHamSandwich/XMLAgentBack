package com.xml.agBa.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long idComment;
	@Column
	public String text;
	
    @Version
    @Column( name = "version",nullable = false, columnDefinition = "int default 0")
    private int version;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "id_user")
	private EndUser endUser;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "id_ad")
	private Ad ad;
	
	

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Comment(Long idComment, String text, int version, EndUser endUser, Ad ad) {
		super();
		this.idComment = idComment;
		this.text = text;
		this.version = version;
		this.endUser = endUser;
		this.ad = ad;
	}



	public Long getIdComment() {
		return idComment;
	}



	public void setIdComment(Long idComment) {
		this.idComment = idComment;
	}



	public String getText() {
		return text;
	}



	public void setText(String text) {
		this.text = text;
	}



	public int getVersion() {
		return version;
	}



	public void setVersion(int version) {
		this.version = version;
	}



	public EndUser getEndUser() {
		return endUser;
	}



	public void setEndUser(EndUser endUser) {
		this.endUser = endUser;
	}



	public Ad getAd() {
		return ad;
	}



	public void setAd(Ad ad) {
		this.ad = ad;
	}

	
	
	
	
	
	

}