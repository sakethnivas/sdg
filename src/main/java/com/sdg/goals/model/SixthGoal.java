package com.sdg.goals.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Goal6")
public class SixthGoal {

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
	private String Have_the_drinking_water_facility;                               
	@Column	                                                       
	private String Practicing_Open_Defecation;                                     
	@Column	                                                       
	private String Sanitation_Services_available;                                  
	@Column	                                                       
	private String Handwashing_Services_available;                                 
	@Column	                                                       
	private String Have_Waste_Water_Flows_Facility;                                
	@Column	                                                       
	private String Type_of_Water_Quality_in_Use;                                   

	@Column 
	private String timestamp;
	public SixthGoal() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public SixthGoal(String volunteer, String mandal, String village, String urbanOrRural, int house_Sequence,
			String name, String gender, LocalDate dOB, int age, long aadhaar, long contact_Number,
			String have_the_drinking_water_facility, String practicing_Open_Defecation,
			String sanitation_Services_available, String handwashing_Services_available,
			String have_Waste_Water_Flows_Facility, String type_of_Water_Quality_in_Use, String timestamp) {
		super();
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
		Have_the_drinking_water_facility = have_the_drinking_water_facility;
		Practicing_Open_Defecation = practicing_Open_Defecation;
		Sanitation_Services_available = sanitation_Services_available;
		Handwashing_Services_available = handwashing_Services_available;
		Have_Waste_Water_Flows_Facility = have_Waste_Water_Flows_Facility;
		Type_of_Water_Quality_in_Use = type_of_Water_Quality_in_Use;
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
	public String getHave_the_drinking_water_facility() {
		return Have_the_drinking_water_facility;
	}
	public void setHave_the_drinking_water_facility(String have_the_drinking_water_facility) {
		Have_the_drinking_water_facility = have_the_drinking_water_facility;
	}
	public String getPracticing_Open_Defecation() {
		return Practicing_Open_Defecation;
	}
	public void setPracticing_Open_Defecation(String practicing_Open_Defecation) {
		Practicing_Open_Defecation = practicing_Open_Defecation;
	}
	public String getSanitation_Services_available() {
		return Sanitation_Services_available;
	}
	public void setSanitation_Services_available(String sanitation_Services_available) {
		Sanitation_Services_available = sanitation_Services_available;
	}
	public String getHandwashing_Services_available() {
		return Handwashing_Services_available;
	}
	public void setHandwashing_Services_available(String handwashing_Services_available) {
		Handwashing_Services_available = handwashing_Services_available;
	}
	public String getHave_Waste_Water_Flows_Facility() {
		return Have_Waste_Water_Flows_Facility;
	}
	public void setHave_Waste_Water_Flows_Facility(String have_Waste_Water_Flows_Facility) {
		Have_Waste_Water_Flows_Facility = have_Waste_Water_Flows_Facility;
	}
	public String getType_of_Water_Quality_in_Use() {
		return Type_of_Water_Quality_in_Use;
	}
	public void setType_of_Water_Quality_in_Use(String type_of_Water_Quality_in_Use) {
		Type_of_Water_Quality_in_Use = type_of_Water_Quality_in_Use;
	}
	@Override
	public String toString() {
		return "SixthGoal [SNo=" + SNo + ", Volunteer=" + Volunteer + ", Mandal=" + Mandal + ", Village=" + Village
				+ ", UrbanOrRural=" + UrbanOrRural + ", House_Sequence=" + House_Sequence + ", Name=" + Name
				+ ", Gender=" + Gender + ", DOB=" + DOB + ", Age=" + Age + ", Aadhaar=" + Aadhaar + ", Contact_Number="
				+ Contact_Number + ", Have_the_drinking_water_facility=" + Have_the_drinking_water_facility
				+ ", Practicing_Open_Defecation=" + Practicing_Open_Defecation + ", Sanitation_Services_available="
				+ Sanitation_Services_available + ", Handwashing_Services_available=" + Handwashing_Services_available
				+ ", Have_Waste_Water_Flows_Facility=" + Have_Waste_Water_Flows_Facility
				+ ", Type_of_Water_Quality_in_Use=" + Type_of_Water_Quality_in_Use + ", timestamp=" + timestamp + "]";
	}
	
}
