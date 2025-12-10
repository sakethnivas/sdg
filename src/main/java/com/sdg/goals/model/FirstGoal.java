package com.sdg.goals.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Goal1")
public class FirstGoal {
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
	private Long Aadhaar;
	@Column
	private Long Contact_Number;
	@Column
	
	//Target-1.1
	private String Profession;
	@Column
	private Integer EarningsPerMonth;
	@Column
	private String IPL;
	
	//Target-1.2
	@Column
	private String NPL;
	@Column
	private String ChildrenOrhouseholds_cash_benefits;
	@Column
	private String Multi_Dimentional_Poverty_Line;
	
	//Target-1.3
	@Column
	private String Work_Injury_Benefits;
	@Column
	private String Maternity_Cash_Benefits;
	@Column
	private String Pension_Benefits;
	@Column
	private String Poor_Population_receiving_SACB;
	@Column
	private String Disability_Cash_Benefits;
	@Column
	private String Unemployment_Cash_Benefits;
	@Column
	private String Labour_Market_Program;
	@Column
	private String Social_Insurance_Coverage;
	
	//Target-1.4
	@Column
	private String BDW;
	@Column
	private String BSS;
	@Column 
	private String timestamp;
	
	
	public FirstGoal() {
		super();
	}


	


	public String getTimeStamp() {
		return timestamp;
	}





	public void setTimeStamp(String timeStamp) {
		this.timestamp = timeStamp;
	}





	public FirstGoal(String volunteer, String mandal, String village, String urbanOrRural, int house_Sequence,
			String name, String gender, LocalDate dOB, int age, Long aadhaar, Long contact_Number, String profession,
			Integer earningsPerMonth, String iPL, String nPL, String childrenOrhouseholds_cash_benefits,
			String multi_Dimentional_Poverty_Line, String work_Injury_Benefits, String maternity_Cash_Benefits,
			String pension_Benefits, String poor_Population_receiving_SACB, String disability_Cash_Benefits,
			String unemployment_Cash_Benefits, String labour_Market_Program, String social_Insurance_Coverage,
			String bDW, String bSS,String timestamp) {
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
		Profession = profession;
		EarningsPerMonth = earningsPerMonth;
		IPL = iPL;
		NPL = nPL;
		ChildrenOrhouseholds_cash_benefits = childrenOrhouseholds_cash_benefits;
		Multi_Dimentional_Poverty_Line = multi_Dimentional_Poverty_Line;
		Work_Injury_Benefits = work_Injury_Benefits;
		Maternity_Cash_Benefits = maternity_Cash_Benefits;
		Pension_Benefits = pension_Benefits;
		Poor_Population_receiving_SACB = poor_Population_receiving_SACB;
		Disability_Cash_Benefits = disability_Cash_Benefits;
		Unemployment_Cash_Benefits = unemployment_Cash_Benefits;
		Labour_Market_Program = labour_Market_Program;
		Social_Insurance_Coverage = social_Insurance_Coverage;
		BDW = bDW;
		BSS = bSS;
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


	public Long getAadhaar() {
		return Aadhaar;
	}


	public void setAadhaar(Long aadhaar) {
		Aadhaar = aadhaar;
	}


	public Long getContact_Number() {
		return Contact_Number;
	}


	public void setContact_Number(Long contact_Number) {
		Contact_Number = contact_Number;
	}


	public String getProfession() {
		return Profession;
	}


	public void setProfession(String profession) {
		Profession = profession;
	}


	public Integer getEarningsPerMonth() {
		return EarningsPerMonth;
	}


	public void setEarningsPerMonth(Integer earningsPerMonth) {
		EarningsPerMonth = earningsPerMonth;
	}


	public String getIPL() {
		return IPL;
	}


	public void setIPL(String iPL) {
		IPL = iPL;
	}


	public String getNPL() {
		return NPL;
	}


	public void setNPL(String nPL) {
		NPL = nPL;
	}


	public String getChildrenOrhouseholds_cash_benefits() {
		return ChildrenOrhouseholds_cash_benefits;
	}


	public void setChildrenOrhouseholds_cash_benefits(String childrenOrhouseholds_cash_benefits) {
		ChildrenOrhouseholds_cash_benefits = childrenOrhouseholds_cash_benefits;
	}


	public String getMulti_Dimentional_Poverty_Line() {
		return Multi_Dimentional_Poverty_Line;
	}


	public void setMulti_Dimentional_Poverty_Line(String multi_Dimentional_Poverty_Line) {
		Multi_Dimentional_Poverty_Line = multi_Dimentional_Poverty_Line;
	}


	public String getWork_Injury_Benefits() {
		return Work_Injury_Benefits;
	}


	public void setWork_Injury_Benefits(String work_Injury_Benefits) {
		Work_Injury_Benefits = work_Injury_Benefits;
	}


	public String getMaternity_Cash_Benefits() {
		return Maternity_Cash_Benefits;
	}


	public void setMaternity_Cash_Benefits(String maternity_Cash_Benefits) {
		Maternity_Cash_Benefits = maternity_Cash_Benefits;
	}


	public String getPension_Benefits() {
		return Pension_Benefits;
	}


	public void setPension_Benefits(String pension_Benefits) {
		Pension_Benefits = pension_Benefits;
	}


	public String getPoor_Population_receiving_SACB() {
		return Poor_Population_receiving_SACB;
	}


	public void setPoor_Population_receiving_SACB(String poor_Population_receiving_SACB) {
		Poor_Population_receiving_SACB = poor_Population_receiving_SACB;
	}


	public String getDisability_Cash_Benefits() {
		return Disability_Cash_Benefits;
	}


	public void setDisability_Cash_Benefits(String disability_Cash_Benefits) {
		Disability_Cash_Benefits = disability_Cash_Benefits;
	}


	public String getUnemployment_Cash_Benefits() {
		return Unemployment_Cash_Benefits;
	}


	public void setUnemployment_Cash_Benefits(String unemployment_Cash_Benefits) {
		Unemployment_Cash_Benefits = unemployment_Cash_Benefits;
	}


	public String getLabour_Market_Program() {
		return Labour_Market_Program;
	}


	public void setLabour_Market_Program(String labour_Market_Program) {
		Labour_Market_Program = labour_Market_Program;
	}


	public String getSocial_Insurance_Coverage() {
		return Social_Insurance_Coverage;
	}


	public void setSocial_Insurance_Coverage(String social_Insurance_Coverage) {
		Social_Insurance_Coverage = social_Insurance_Coverage;
	}


	public String getBDW() {
		return BDW;
	}


	public void setBDW(String bDW) {
		BDW = bDW;
	}


	public String getBSS() {
		return BSS;
	}


	public void setBSS(String bSS) {
		BSS = bSS;
	}





	@Override
	public String toString() {
		return "FirstGoal [SNo=" + SNo + ", Volunteer=" + Volunteer + ", Mandal=" + Mandal + ", Village=" + Village
				+ ", UrbanOrRural=" + UrbanOrRural + ", House_Sequence=" + House_Sequence + ", Name=" + Name
				+ ", Gender=" + Gender + ", DOB=" + DOB + ", Age=" + Age + ", Aadhaar=" + Aadhaar + ", Contact_Number="
				+ Contact_Number + ", Profession=" + Profession + ", EarningsPerMonth=" + EarningsPerMonth + ", IPL="
				+ IPL + ", NPL=" + NPL + ", ChildrenOrhouseholds_cash_benefits=" + ChildrenOrhouseholds_cash_benefits
				+ ", Multi_Dimentional_Poverty_Line=" + Multi_Dimentional_Poverty_Line + ", Work_Injury_Benefits="
				+ Work_Injury_Benefits + ", Maternity_Cash_Benefits=" + Maternity_Cash_Benefits + ", Pension_Benefits="
				+ Pension_Benefits + ", Poor_Population_receiving_SACB=" + Poor_Population_receiving_SACB
				+ ", Disability_Cash_Benefits=" + Disability_Cash_Benefits + ", Unemployment_Cash_Benefits="
				+ Unemployment_Cash_Benefits + ", Labour_Market_Program=" + Labour_Market_Program
				+ ", Social_Insurance_Coverage=" + Social_Insurance_Coverage + ", BDW=" + BDW + ", BSS=" + BSS
				+ ", year=" + timestamp + "]";
	}


	
	
	
	
	
}
