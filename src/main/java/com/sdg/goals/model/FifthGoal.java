package com.sdg.goals.model;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Goal5")
public class FifthGoal {
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
	private String Voilence_against_women;
	@Column
	private String MarriageandFamily;
	@Column
	private String EandEB;
	@Column
	private	String Sexual_Voilence;
	@Column
	private String Married_before_15years;
	@Column
	private String Married_before_18years;
	@Column
	private String Undergone_Genital_Mutilation_or_Cutting;
	@Column
	private Integer Unpaid_Time_on_domestic_and_care_work_Hours_or_day;
	@Column
	private String Is_She_a_Parlimentarian;
	@Column
	private String Is_She_a_Local_Government_Elect;
	@Column
	private String Is_She_Manager_orSenior_Manager;
	@Column
	private String Rights_Over_Agri_Land;
	@Column
	private String Own_a_Mobile_Phone_and_use_Internet;
	@Column 
	private String timestamp;
	public FifthGoal() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public FifthGoal(int sNo, String volunteer, String mandal, String village, String urbanOrRural, int house_Sequence,
			String name, String gender, LocalDate dOB, int age, long aadhaar, long contact_Number,
			String voilence_against_women, String marriageandFamily, String eandEB, String sexual_Voilence,
			String married_before_15years, String married_before_18years,
			String undergone_Genital_Mutilation_or_Cutting, Integer unpaid_Time_on_domestic_and_care_work_Hours_or_day,
			String is_She_a_Parlimentarian, String is_She_a_Local_Government_Elect,
			String is_She_Manager_orSenior_Manager, String rights_Over_Agri_Land,
			String own_a_Mobile_Phone_and_use_Internet, String timestamp) {
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
		Voilence_against_women = voilence_against_women;
		MarriageandFamily = marriageandFamily;
		EandEB = eandEB;
		Sexual_Voilence = sexual_Voilence;
		Married_before_15years = married_before_15years;
		Married_before_18years = married_before_18years;
		Undergone_Genital_Mutilation_or_Cutting = undergone_Genital_Mutilation_or_Cutting;
		Unpaid_Time_on_domestic_and_care_work_Hours_or_day = unpaid_Time_on_domestic_and_care_work_Hours_or_day;
		Is_She_a_Parlimentarian = is_She_a_Parlimentarian;
		Is_She_a_Local_Government_Elect = is_She_a_Local_Government_Elect;
		Is_She_Manager_orSenior_Manager = is_She_Manager_orSenior_Manager;
		Rights_Over_Agri_Land = rights_Over_Agri_Land;
		Own_a_Mobile_Phone_and_use_Internet = own_a_Mobile_Phone_and_use_Internet;
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
	public String getVoilence_against_women() {
		return Voilence_against_women;
	}
	public void setVoilence_against_women(String voilence_against_women) {
		Voilence_against_women = voilence_against_women;
	}
	public String getMarriageandFamily() {
		return MarriageandFamily;
	}
	public void setMarriageandFamily(String marriageandFamily) {
		MarriageandFamily = marriageandFamily;
	}
	public String getEandEB() {
		return EandEB;
	}
	public void setEandEB(String eandEB) {
		EandEB = eandEB;
	}
	public String getSexual_Voilence() {
		return Sexual_Voilence;
	}
	public void setSexual_Voilence(String sexual_Voilence) {
		Sexual_Voilence = sexual_Voilence;
	}
	public String getMarried_before_15years() {
		return Married_before_15years;
	}
	public void setMarried_before_15years(String married_before_15years) {
		Married_before_15years = married_before_15years;
	}
	public String getMarried_before_18years() {
		return Married_before_18years;
	}
	public void setMarried_before_18years(String married_before_18years) {
		Married_before_18years = married_before_18years;
	}
	public String getUndergone_Genital_Mutilation_or_Cutting() {
		return Undergone_Genital_Mutilation_or_Cutting;
	}
	public void setUndergone_Genital_Mutilation_or_Cutting(String undergone_Genital_Mutilation_or_Cutting) {
		Undergone_Genital_Mutilation_or_Cutting = undergone_Genital_Mutilation_or_Cutting;
	}
	public Integer getUnpaid_Time_on_domestic_and_care_work_Hours_or_day() {
		return Unpaid_Time_on_domestic_and_care_work_Hours_or_day;
	}
	public void setUnpaid_Time_on_domestic_and_care_work_Hours_or_day(
			Integer unpaid_Time_on_domestic_and_care_work_Hours_or_day) {
		Unpaid_Time_on_domestic_and_care_work_Hours_or_day = unpaid_Time_on_domestic_and_care_work_Hours_or_day;
	}
	public String getIs_She_a_Parlimentarian() {
		return Is_She_a_Parlimentarian;
	}
	public void setIs_She_a_Parlimentarian(String is_She_a_Parlimentarian) {
		Is_She_a_Parlimentarian = is_She_a_Parlimentarian;
	}
	public String getIs_She_a_Local_Government_Elect() {
		return Is_She_a_Local_Government_Elect;
	}
	public void setIs_She_a_Local_Government_Elect(String is_She_a_Local_Government_Elect) {
		Is_She_a_Local_Government_Elect = is_She_a_Local_Government_Elect;
	}
	public String getIs_She_Manager_orSenior_Manager() {
		return Is_She_Manager_orSenior_Manager;
	}
	public void setIs_She_Manager_orSenior_Manager(String is_She_Manager_orSenior_Manager) {
		Is_She_Manager_orSenior_Manager = is_She_Manager_orSenior_Manager;
	}
	public String getRights_Over_Agri_Land() {
		return Rights_Over_Agri_Land;
	}
	public void setRights_Over_Agri_Land(String rights_Over_Agri_Land) {
		Rights_Over_Agri_Land = rights_Over_Agri_Land;
	}
	public String getOwn_a_Mobile_Phone_and_use_Internet() {
		return Own_a_Mobile_Phone_and_use_Internet;
	}
	public void setOwn_a_Mobile_Phone_and_use_Internet(String own_a_Mobile_Phone_and_use_Internet) {
		Own_a_Mobile_Phone_and_use_Internet = own_a_Mobile_Phone_and_use_Internet;
	}

	@Override
	public String toString() {
		return "FifthGoal [SNo=" + SNo + ", Volunteer=" + Volunteer + ", Mandal=" + Mandal + ", Village=" + Village
				+ ", UrbanOrRural=" + UrbanOrRural + ", House_Sequence=" + House_Sequence + ", Name=" + Name
				+ ", Gender=" + Gender + ", DOB=" + DOB + ", Age=" + Age + ", Aadhaar=" + Aadhaar + ", Contact_Number="
				+ Contact_Number + ", Voilence_against_women=" + Voilence_against_women + ", MarriageandFamily="
				+ MarriageandFamily + ", EandEB=" + EandEB + ", Sexual_Voilence=" + Sexual_Voilence
				+ ", Married_before_15years=" + Married_before_15years + ", Married_before_18years="
				+ Married_before_18years + ", Undergone_Genital_Mutilation_or_Cutting="
				+ Undergone_Genital_Mutilation_or_Cutting + ", Unpaid_Time_on_domestic_and_care_work_Hours_or_day="
				+ Unpaid_Time_on_domestic_and_care_work_Hours_or_day + ", Is_She_a_Parlimentarian="
				+ Is_She_a_Parlimentarian + ", Is_She_a_Local_Government_Elect=" + Is_She_a_Local_Government_Elect
				+ ", Is_She_Manager_orSenior_Manager=" + Is_She_Manager_orSenior_Manager + ", Rights_Over_Agri_Land="
				+ Rights_Over_Agri_Land + ", Own_a_Mobile_Phone_and_use_Internet=" + Own_a_Mobile_Phone_and_use_Internet
				+ ", timestamp=" + timestamp + "]";
	}
	
	






	
	
	
}
