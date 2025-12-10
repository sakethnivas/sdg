package com.sdg.goals.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Goal10")
public class TenthGoal {
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
	private Long Income_Per_Capita_per_year;
	
	@Column
	private String Below_40Percent_of_Income;
	@Column
	private String  Living_Below_50Percent_of_Medium_Income;
	@Column
	private String Felt_Descriminated_In_a_Year_period;
	@Column
	private String timestamp;
	public TenthGoal() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TenthGoal(String volunteer, String mandal, String village, String urbanOrRural, int house_Sequence,
			String name, String gender, LocalDate dOB, int age, long aadhaar, long contact_Number,
			Long income_Per_Capita_per_year, String below_40Percent_of_Income,
			String living_Below_50Percent_of_Medium_Income, String felt_Descriminated_In_a_Year_period,
			String timestamp) {
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
		Income_Per_Capita_per_year = income_Per_Capita_per_year;
		Below_40Percent_of_Income = below_40Percent_of_Income;
		Living_Below_50Percent_of_Medium_Income = living_Below_50Percent_of_Medium_Income;
		Felt_Descriminated_In_a_Year_period = felt_Descriminated_In_a_Year_period;
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
	public Long getIncome_Per_Capita_per_year() {
		return Income_Per_Capita_per_year;
	}
	public void setIncome_Per_Capita_per_year(Long income_Per_Capita_per_year) {
		Income_Per_Capita_per_year = income_Per_Capita_per_year;
	}
	public String getBelow_40Percent_of_Income() {
		return Below_40Percent_of_Income;
	}
	public void setBelow_40Percent_of_Income(String below_40Percent_of_Income) {
		Below_40Percent_of_Income = below_40Percent_of_Income;
	}
	public String getLiving_Below_50Percent_of_Medium_Income() {
		return Living_Below_50Percent_of_Medium_Income;
	}
	public void setLiving_Below_50Percent_of_Medium_Income(String living_Below_50Percent_of_Medium_Income) {
		Living_Below_50Percent_of_Medium_Income = living_Below_50Percent_of_Medium_Income;
	}
	public String getFelt_Descriminated_In_a_Year_period() {
		return Felt_Descriminated_In_a_Year_period;
	}
	public void setFelt_Descriminated_In_a_Year_period(String felt_Descriminated_In_a_Year_period) {
		Felt_Descriminated_In_a_Year_period = felt_Descriminated_In_a_Year_period;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "TenthGoal [SNo=" + SNo + ", Volunteer=" + Volunteer + ", Mandal=" + Mandal + ", Village=" + Village
				+ ", UrbanOrRural=" + UrbanOrRural + ", House_Sequence=" + House_Sequence + ", Name=" + Name
				+ ", Gender=" + Gender + ", DOB=" + DOB + ", Age=" + Age + ", Aadhaar=" + Aadhaar + ", Contact_Number="
				+ Contact_Number + ", Income_Per_Capita_per_year=" + Income_Per_Capita_per_year
				+ ", Below_40Percent_of_Income=" + Below_40Percent_of_Income
				+ ", Living_Below_50Percent_of_Medium_Income=" + Living_Below_50Percent_of_Medium_Income
				+ ", Felt_Descriminated_In_a_Year_period=" + Felt_Descriminated_In_a_Year_period + ", timestamp="
				+ timestamp + "]";
	} 
	

}
