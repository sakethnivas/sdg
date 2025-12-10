package com.sdg.goals.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Goal8")

public class EigthGoal {
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
	private String Informal_Employment;
	@Column
	private Integer Hourly_Earnings_per_day;
	@Column
	private String Is_he_or_she_having_Bank_Account;
	@Column 
	private String timestamp;
	public EigthGoal() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public EigthGoal(String volunteer, String mandal, String village, String urbanOrRural, int house_Sequence,
			String name, String gender, LocalDate dOB, int age, long aadhaar, long contact_Number,
			String informal_Employment, Integer hourly_Earnings_per_day, String is_he_or_she_having_Bank_Account, String timestamp) {
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
		Informal_Employment = informal_Employment;
		Hourly_Earnings_per_day = hourly_Earnings_per_day;
		Is_he_or_she_having_Bank_Account = is_he_or_she_having_Bank_Account;
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
	public String getInformal_Employment() {
		return Informal_Employment;
	}
	public void setInformal_Employment(String informal_Employment) {
		Informal_Employment = informal_Employment;
	}
	public Integer getHourly_Earnings_per_day() {
		return Hourly_Earnings_per_day;
	}
	public void setHourly_Earnings_per_day(Integer hourly_Earnings_per_day) {
		Hourly_Earnings_per_day = hourly_Earnings_per_day;
	}
	public String getIs_he_or_she_having_Bank_Account() {
		return Is_he_or_she_having_Bank_Account;
	}
	public void setIs_he_or_she_having_Bank_Account(String is_he_or_she_having_Bank_Account) {
		Is_he_or_she_having_Bank_Account = is_he_or_she_having_Bank_Account;
	}
	@Override
	public String toString() {
		return "EigthGoal [SNo=" + SNo + ", Volunteer=" + Volunteer + ", Mandal=" + Mandal + ", Village=" + Village
				+ ", UrbanOrRural=" + UrbanOrRural + ", House_Sequence=" + House_Sequence + ", Name=" + Name
				+ ", Gender=" + Gender + ", DOB=" + DOB + ", Age=" + Age + ", Aadhaar=" + Aadhaar + ", Contact_Number="
				+ Contact_Number + ", Informal_Employment=" + Informal_Employment + ", Hourly_Earnings_per_day="
				+ Hourly_Earnings_per_day + ", Is_he_or_she_having_Bank_Account=" + Is_he_or_she_having_Bank_Account
				+ ", timestamp=" + timestamp + "]";
	}

	
}
