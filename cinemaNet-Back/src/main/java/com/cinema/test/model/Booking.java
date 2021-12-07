package com.cinema.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JoinColumn( name="customer_Id")
	@ManyToOne(fetch=FetchType.EAGER)
	private Customer customer;
	@JoinColumn( name="function_Id")
	@OneToOne(fetch=FetchType.EAGER)
	private FunctionM function; 
	@Column(unique=false, name="Status",length=10,nullable=false)
	private String status;
	@Column(unique=false, name="Chair_Location",length=4,nullable=false)
	private String chairLocation;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public FunctionM getFunction() {
		return function;
	}

	public void setFunction(FunctionM function) {
		this.function = function;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getChairLocation() {
		return chairLocation;
	}

	public void setChairLocation(String chairLocation) {
		this.chairLocation = chairLocation;
	}
	

	
}
