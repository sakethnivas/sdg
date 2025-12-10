package com.sdg.goals.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Goal7")
public class SeventhGoal {


	@Column
	@Id
	private int SNo;
	@Column
	private String Volunteer;
	@Column
	private String Mandal;
	@Column
	private String Village;
	@Column
	private String UrbanOrRural;
	@Column
	private int House_Sequence;
	@Column
	private String Name;
	@Column
	private String Gender;
	@Column
	private LocalDate DOB;
	@Column
	private int Age;
	@Column
	private long Aadhaar;
	@Column
	private long Contact_Number;
	            
	@Column	                                                       
	private String Access_to_Electricity;
                              
	@Column	                                                       
	private String Primary_use_of_Clean_fuels_and_Technology;
                                   
	@Column	                                                       
	private String Renewable_energy_usage;

	@Column 
	private String timestamp;
	
	public SeventhGoal() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public String getTimestamp() {
		return timestamp;
	}



	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}



	public SeventhGoal(int sNo, String volunteer, String mandal, String village, String urbanOrRural,
			int house_Sequence, String name, String gender, LocalDate dOB, int age, long aadhaar, long contact_Number,
			String access_to_Electricity, String primary_use_of_Clean_fuels_and_Technology,
			String renewable_energy_usage,  String timestamp) {
		super();
		SNo = sNo;
		Volunteer = volunteer;
		Mandal = mandal;
		Village = village;
		UrbanOrRural = urbanOrRural;
		House_Sequence = house_Sequence;
		Name = name;
		Gender = gender;
		DOB = dOB;
		Age = age;
		Aadhaar = aadhaar;
		Contact_Number = contact_Number;
		Access_to_Electricity = access_to_Electricity;
		Primary_use_of_Clean_fuels_and_Technology = primary_use_of_Clean_fuels_and_Technology;
		Renewable_energy_usage = renewable_energy_usage;
		this.timestamp = timestamp;
	}



	public int getSNo() {
		return SNo;
	}
	public void setSNo(int sNo) {
		SNo = sNo;
	}
	public String getVolunteer() {
		return Volunteer;
	}
	public void setVolunteer(String volunteer) {
		Volunteer = volunteer;
	}
	public String getMandal() {
		return Mandal;
	}
	public void setMandal(String mandal) {
		Mandal = mandal;
	}
	public String getVillage() {
		return Village;
	}
	public void setVillage(String village) {
		Village = village;
	}
	public String getUrbanOrRural() {
		return UrbanOrRural;
	}
	public void setUrbanOrRural(String urbanOrRural) {
		UrbanOrRural = urbanOrRural;
	}
	public int getHouse_Sequence() {
		return House_Sequence;
	}
	public void setHouse_Sequence(int house_Sequence) {
		House_Sequence = house_Sequence;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public LocalDate getDOB() {
		return DOB;
	}
	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public long getAadhaar() {
		return Aadhaar;
	}
	public void setAadhaar(long aadhaar) {
		Aadhaar = aadhaar;
	}
	public long getContact_Number() {
		return Contact_Number;
	}
	public void setContact_Number(long contact_Number) {
		Contact_Number = contact_Number;
	}
	public String getAccess_to_Electricity() {
		return Access_to_Electricity;
	}
	public void setAccess_to_Electricity(String access_to_Electricity) {
		Access_to_Electricity = access_to_Electricity;
	}
	public String getPrimary_use_of_Clean_fuels_and_Technology() {
		return Primary_use_of_Clean_fuels_and_Technology;
	}
	public void setPrimary_use_of_Clean_fuels_and_Technology(String primary_use_of_Clean_fuels_and_Technology) {
		Primary_use_of_Clean_fuels_and_Technology = primary_use_of_Clean_fuels_and_Technology;
	}
	public String getRenewable_energy_usage() {
		return Renewable_energy_usage;
	}
	public void setRenewable_energy_usage(String renewable_energy_usage) {
		Renewable_energy_usage = renewable_energy_usage;
	}

	@Override
	public String toString() {
		return "SeventhGoal [SNo=" + SNo + ", Volunteer=" + Volunteer + ", Mandal=" + Mandal + ", Village=" + Village
				+ ", UrbanOrRural=" + UrbanOrRural + ", House_Sequence=" + House_Sequence + ", Name=" + Name
				+ ", Gender=" + Gender + ", DOB=" + DOB + ", Age=" + Age + ", Aadhaar=" + Aadhaar + ", Contact_Number="
				+ Contact_Number + ", Access_to_Electricity=" + Access_to_Electricity
				+ ", Primary_use_of_Clean_fuels_and_Technology=" + Primary_use_of_Clean_fuels_and_Technology
				+ ", Renewable_energy_usage=" + Renewable_energy_usage + ", timestamp=" + timestamp + "]";
	}


	
}
