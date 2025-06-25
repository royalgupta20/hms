package com.example.demo.model;

import lombok.Data;
import lombok.Setter;

@Data
@Setter
public class odel {

    int Id;
    public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getFIRSTNAME() {
		return FIRSTNAME;
	}
	public void setFIRSTNAME(String fIRSTNAME) {
		FIRSTNAME = fIRSTNAME;
	}
	public String getLASTNAME() {
		return LASTNAME;
	}
	public void setLASTNAME(String lASTNAME) {
		LASTNAME = lASTNAME;
	}
	public String getSTREET() {
		return STREET;
	}
	public void setSTREET(String sTREET) {
		STREET = sTREET;
	}
	public String getCITY() {
		return CITY;
	}
	public void setCITY(String cITY) {
		CITY = cITY;
	}
	String FIRSTNAME;
    String LASTNAME;
    String STREET;
    String CITY;
	
}
