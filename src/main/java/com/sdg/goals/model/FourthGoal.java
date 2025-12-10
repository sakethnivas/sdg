package com.sdg.goals.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Goal4")
public class FourthGoal {

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
	private String Educational_Proficiency;
	@Column
	private String PPE;
	@Column
	private String Primary_School;
	@Column
	private String LSS;
	@Column
	private String USS;
	@Column
	private String F_And_NFE_Training;
	@Column
	private String ICT_Participation;
	@Column
	private String Teaching_Level;
	@Column
	private String Highest_Education;
	@Column
	private String Profession;
	@Column 
	private String timestamp;
	public FourthGoal() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public FourthGoal(int sNo, String volunteer, String mandal, String village, String urbanOrRural, int house_Sequence,
			String name, String gender, LocalDate dOB, int age, long aadhaar, long contact_Number,
			String educational_Proficiency, String pPE, String primary_School, String lSS, String uSS,
			String f_And_NFE_Training, String iCT_Participation, String teaching_Level, String highest_Education,
			String profession, String timestamp) {
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
		Educational_Proficiency = educational_Proficiency;
		PPE = pPE;
		Primary_School = primary_School;
		LSS = lSS;
		USS = uSS;
		F_And_NFE_Training = f_And_NFE_Training;
		ICT_Participation = iCT_Participation;
		Teaching_Level = teaching_Level;
		Highest_Education = highest_Education;
		Profession = profession;
		this.timestamp = timestamp;
	}



	public String getTimestamp() {
		return timestamp;
	}



	public void setTimestamp(String timestamp) {
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
	public String getEducational_Proficiency() {
		return Educational_Proficiency;
	}
	public void setEducational_Proficiency(String educational_Proficiency) {
		Educational_Proficiency = educational_Proficiency;
	}
	public String getPPE() {
		return PPE;
	}
	public void setPPE(String pPE) {
		PPE = pPE;
	}
	public String getPrimary_School() {
		return Primary_School;
	}
	public void setPrimary_School(String primary_School) {
		Primary_School = primary_School;
	}
	public String getLSS() {
		return LSS;
	}
	public void setLSS(String lSS) {
		LSS = lSS;
	}
	public String getUSS() {
		return USS;
	}
	public void setUSS(String uSS) {
		USS = uSS;
	}
	public String getF_And_NFE_Training() {
		return F_And_NFE_Training;
	}
	public void setF_And_NFE_Training(String f_And_NFE_Training) {
		F_And_NFE_Training = f_And_NFE_Training;
	}
	public String getICT_Participation() {
		return ICT_Participation;
	}
	public void setICT_Participation(String iCT_Participation) {
		ICT_Participation = iCT_Participation;
	}
	public String getTeaching_Level() {
		return Teaching_Level;
	}
	public void setTeaching_Level(String teaching_Level) {
		Teaching_Level = teaching_Level;
	}
	public String getHighest_Education() {
		return Highest_Education;
	}
	public void setHighest_Education(String highest_Education) {
		Highest_Education = highest_Education;
	}
	public String getProfession() {
		return Profession;
	}
	public void setProfession(String profession) {
		Profession = profession;
	}



	@Override
	public String toString() {
		return "FourthGoal [SNo=" + SNo + ", Volunteer=" + Volunteer + ", Mandal=" + Mandal + ", Village=" + Village
				+ ", UrbanOrRural=" + UrbanOrRural + ", House_Sequence=" + House_Sequence + ", Name=" + Name
				+ ", Gender=" + Gender + ", DOB=" + DOB + ", Age=" + Age + ", Aadhaar=" + Aadhaar + ", Contact_Number="
				+ Contact_Number + ", Educational_Proficiency=" + Educational_Proficiency + ", PPE=" + PPE
				+ ", Primary_School=" + Primary_School + ", LSS=" + LSS + ", USS=" + USS + ", F_And_NFE_Training="
				+ F_And_NFE_Training + ", ICT_Participation=" + ICT_Participation + ", Teaching_Level=" + Teaching_Level
				+ ", Highest_Education=" + Highest_Education + ", Profession=" + Profession + ", timestamp=" + timestamp
				+ "]";
	}

	
	
	
}
