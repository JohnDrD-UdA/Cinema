package com.cinema.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMERS")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, name="user_name", length = 50, nullable = false, updatable = false)
	private String userName;
	
	@Column(unique = false, name="names", length = 50, nullable = false, updatable = true)
	private String nombres;
	
	@Column(unique = false, name="last_name", length = 50, nullable = false, updatable = true)
	private String apellidos;
	
	@Column(unique = false, name="document", length = 30, nullable = false, updatable = false)
	private String document;
	
	@Column(unique = false, name="doc_type", length = 30, nullable = false, updatable = false)
	private String docType;
	@Column(nullable=true,updatable=true)
	private Boolean Admin;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}
	
	public boolean checkUserName() {
		int check1=this.getUserName().indexOf('@');
		int check2=this.getUserName().indexOf(".com");
		if(check1==-1 || check1==0) {return false;}
		if(check2==check1+1 || check2==-1) {return false;}
		return true;
		
	}
	

}
