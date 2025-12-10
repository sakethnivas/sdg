package com.sdg.goals.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Goal9")
public class NinthGoal {
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
	private String Road_Access_Connectivity;
	@Column
	private Integer  Manufacturing_Value_Gross_Earnings;

	@Column
	private String Manufacturing_Employment;

	@Column
	private String SSI_Proposal_or_Facility_owned;

	@Column
	private String SSI_with_loan_or_line_of_credit_received;

	@Column
	private String R_and_D_Professional;
	@Column
	private String Use_of_Technology_Internet_Facility;
	@Column 
	private String timestamp;
	public NinthGoal() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public String getTimestamp() {
		return timestamp;
	}



	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}



	public NinthGoal(String volunteer, String mandal, String village, String urbanOrRural, int house_Sequence,
			String name, String gender, LocalDate dOB, int age, long aadhaar, long contact_Number,
			String road_Access_Connectivity, Integer manufacturing_Value_Gross_Earnings, String manufacturing_Employment,
			String sSI_Proposal_or_Facility_owned, String sSI_with_loan_or_line_of_credit_received,
			String r_and_D_Professional, String use_of_Technology_Internet_Facility, String timestamp) {
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
		Road_Access_Connectivity = road_Access_Connectivity;
		Manufacturing_Value_Gross_Earnings = manufacturing_Value_Gross_Earnings;
		Manufacturing_Employment = manufacturing_Employment;
		SSI_Proposal_or_Facility_owned = sSI_Proposal_or_Facility_owned;
		SSI_with_loan_or_line_of_credit_received = sSI_with_loan_or_line_of_credit_received;
		R_and_D_Professional = r_and_D_Professional;
		Use_of_Technology_Internet_Facility = use_of_Technology_Internet_Facility;
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
	public String getRoad_Access_Connectivity() {
		return Road_Access_Connectivity;
	}
	public void setRoad_Access_Connectivity(String road_Access_Connectivity) {
		Road_Access_Connectivity = road_Access_Connectivity;
	}
	public Integer getManufacturing_Value_Gross_Earnings() {
		return Manufacturing_Value_Gross_Earnings;
	}
	public void setManufacturing_Value_Gross_Earnings(Integer manufacturing_Value_Gross_Earnings) {
		Manufacturing_Value_Gross_Earnings = manufacturing_Value_Gross_Earnings;
	}
	public String getManufacturing_Employment() {
		return Manufacturing_Employment;
	}
	public void setManufacturing_Employment(String manufacturing_Employment) {
		Manufacturing_Employment = manufacturing_Employment;
	}
	public String getSSI_Proposal_or_Facility_owned() {
		return SSI_Proposal_or_Facility_owned;
	}
	public void setSSI_Proposal_or_Facility_owned(String sSI_Proposal_or_Facility_owned) {
		SSI_Proposal_or_Facility_owned = sSI_Proposal_or_Facility_owned;
	}
	public String getSSI_with_loan_or_line_of_credit_received() {
		return SSI_with_loan_or_line_of_credit_received;
	}
	public void setSSI_with_loan_or_line_of_credit_received(String sSI_with_loan_or_line_of_credit_received) {
		SSI_with_loan_or_line_of_credit_received = sSI_with_loan_or_line_of_credit_received;
	}
	public String getR_and_D_Professional() {
		return R_and_D_Professional;
	}
	public void setR_and_D_Professional(String r_and_D_Professional) {
		R_and_D_Professional = r_and_D_Professional;
	}
	public String getUse_of_Technology_Internet_Facility() {
		return Use_of_Technology_Internet_Facility;
	}
	public void setUse_of_Technology_Internet_Facility(String use_of_Technology_Internet_Facility) {
		Use_of_Technology_Internet_Facility = use_of_Technology_Internet_Facility;
	}



	@Override
	public String toString() {
		return "NinethGoal [SNo=" + SNo + ", Volunteer=" + Volunteer + ", Mandal=" + Mandal + ", Village=" + Village
				+ ", UrbanOrRural=" + UrbanOrRural + ", House_Sequence=" + House_Sequence + ", Name=" + Name
				+ ", Gender=" + Gender + ", DOB=" + DOB + ", Age=" + Age + ", Aadhaar=" + Aadhaar + ", Contact_Number="
				+ Contact_Number + ", Road_Access_Connectivity=" + Road_Access_Connectivity
				+ ", Manufacturing_Value_Gross_Earnings=" + Manufacturing_Value_Gross_Earnings
				+ ", Manufacturing_Employment=" + Manufacturing_Employment + ", SSI_Proposal_or_Facility_owned="
				+ SSI_Proposal_or_Facility_owned + ", SSI_with_loan_or_line_of_credit_received="
				+ SSI_with_loan_or_line_of_credit_received + ", R_and_D_Professional=" + R_and_D_Professional
				+ ", Use_of_Technology_Internet_Facility=" + Use_of_Technology_Internet_Facility + ", timestamp="
				+ timestamp + "]";
	}
	
	

	
	

	

}
