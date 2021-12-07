package com.cinema.test.DTO;

import java.util.List;

public class ResponseListDTO {
	private List list;
	private String status;
	
	
	public ResponseListDTO(List list, String status) {
		super();
		this.list = list;
		this.status = status;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
