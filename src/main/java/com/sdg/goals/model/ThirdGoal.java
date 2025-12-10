package com.sdg.goals.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Goal3")
public class ThirdGoal {
	@Column
	@Id
	private int SNo;
	@Column
	private String volunteer;
	@Column
	private String mandal;
	@Column
	private String village;
	@Column
	private String urban_Rural;
	@Column
	private int  house_Sequence;
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
	//Target-3.1
	@Column
	private String Maternal_Mortality;
	@Column
	private String Births_Attended_by_SHP;  // no
	@Column
	private String Infant_Deaths;
	@Column
	private String Under5_MR;
	@Column
	private String Neonatal_deaths;
	@Column
	private String HIV_infected;
	@Column
	private String Tuberculosis_infected;
	@Column
	private String Malaria_Infected;
	@Column
	private String Need_InterventionOrCheck_Up;
	@Column
	private String Hepatitis_B_infected;
	@Column
	private String Mortality_Rate_by__CD_CD_CRD;
	@Column
	private String Suicidal_Death;
	@Column
	private String Alcoholic_Disorder;
	@Column
	private Integer Alcoholic_Consumption;
	@Column
	private String Road_Traffic_deaths;
	@Column
	private String Women_Reproductive;
	@Column
	private String Adolescent_birth;
	@Column 
	private String timestamp;
	public ThirdGoal() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	public String getTimestamp() {
		return timestamp;
	}




	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}




	public ThirdGoal(int sNo, String volunteer, String mandal, String village, String urban_Rural, int house_Sequence,
			String name, String gender, LocalDate dOB, int age, long aadhaar, long contact_Number,
			String maternal_Mortality, String births_Attended_by_SHP, String infant_Deaths, String under5_MR,
			String neonatal_deaths, String hIV_infected, String tuberculosis_infected, String malaria_Infected,
			String need_InterventionOrCheck_Up, String hepatitis_B_infected, String mortality_Rate_by__CD_CD_CRD,
			String suicidal_Death, String alcoholic_Disorder, Integer alcoholic_Consumption, String road_Traffic_deaths,
			String women_Reproductive, String adolescent_birth, String timestamp) {
		super();
		SNo = sNo;
		this.volunteer = volunteer;
		this.mandal = mandal;
		this.village = village;
		this.urban_Rural = urban_Rural;
		this.house_Sequence = house_Sequence;
		Name = name;
		Gender = gender;
		DOB = dOB;
		Age = age;
		Aadhaar = aadhaar;
		Contact_Number = contact_Number;
		Maternal_Mortality = maternal_Mortality;
		Births_Attended_by_SHP = births_Attended_by_SHP;
		Infant_Deaths = infant_Deaths;
		Under5_MR = under5_MR;
		Neonatal_deaths = neonatal_deaths;
		HIV_infected = hIV_infected;
		Tuberculosis_infected = tuberculosis_infected;
		Malaria_Infected = malaria_Infected;
		Need_InterventionOrCheck_Up = need_InterventionOrCheck_Up;
		Hepatitis_B_infected = hepatitis_B_infected;
		Mortality_Rate_by__CD_CD_CRD = mortality_Rate_by__CD_CD_CRD;
		Suicidal_Death = suicidal_Death;
		Alcoholic_Disorder = alcoholic_Disorder;
		Alcoholic_Consumption = alcoholic_Consumption;
		Road_Traffic_deaths = road_Traffic_deaths;
		Women_Reproductive = women_Reproductive;
		Adolescent_birth = adolescent_birth;
		this.timestamp = timestamp;
	}




	public int getSNo() {
		return SNo;
	}
	public void setSNo(int sNo) {
		SNo = sNo;
	}
	public String getVolunteer() {
		return volunteer;
	}
	public void setVolunteer(String volunteer) {
		this.volunteer = volunteer;
	}
	public String getMandal() {
		return mandal;
	}
	public void setMandal(String mandal) {
		this.mandal = mandal;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public String getUrban_Rural() {
		return urban_Rural;
	}
	public void setUrban_Rural(String urban_Rural) {
		this.urban_Rural = urban_Rural;
	}
	public int getHouse_Sequence() {
		return house_Sequence;
	}
	public void setHouse_Sequence(int house_Sequence) {
		this.house_Sequence = house_Sequence;
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
	public String getMaternal_Mortality() {
		return Maternal_Mortality;
	}
	public void setMaternal_Mortality(String maternal_Mortality) {
		Maternal_Mortality = maternal_Mortality;
	}
	public String getBirths_Attended_by_SHP() {
		return Births_Attended_by_SHP;
	}
	public void setBirths_Attended_by_SHP(String births_Attended_by_SHP) {
		Births_Attended_by_SHP = births_Attended_by_SHP;
	}
	public String getInfant_Deaths() {
		return Infant_Deaths;
	}
	public void setInfant_Deaths(String infant_Deaths) {
		Infant_Deaths = infant_Deaths;
	}
	public String getUnder5_MR() {
		return Under5_MR;
	}
	public void setUnder5_MR(String under5_MR) {
		Under5_MR = under5_MR;
	}
	public String getNeonatal_deaths() {
		return Neonatal_deaths;
	}
	public void setNeonatal_deaths(String neonatal_deaths) {
		Neonatal_deaths = neonatal_deaths;
	}
	public String getHIV_infected() {
		return HIV_infected;
	}
	public void setHIV_infected(String hIV_infected) {
		HIV_infected = hIV_infected;
	}
	public String getTuberculosis_infected() {
		return Tuberculosis_infected;
	}
	public void setTuberculosis_infected(String tuberculosis_infected) {
		Tuberculosis_infected = tuberculosis_infected;
	}
	public String getMalaria_Infected() {
		return Malaria_Infected;
	}
	public void setMalaria_Infected(String malaria_Infected) {
		Malaria_Infected = malaria_Infected;
	}
	public String getNeed_InterventionOrCheck_Up() {
		return Need_InterventionOrCheck_Up;
	}
	public void setNeed_InterventionOrCheck_Up(String need_InterventionOrCheck_Up) {
		Need_InterventionOrCheck_Up = need_InterventionOrCheck_Up;
	}
	public String getHepatitis_B_infected() {
		return Hepatitis_B_infected;
	}
	public void setHepatitis_B_infected(String hepatitis_B_infected) {
		Hepatitis_B_infected = hepatitis_B_infected;
	}
	public String getMortality_Rate_by__CD_CD_CRD() {
		return Mortality_Rate_by__CD_CD_CRD;
	}
	public void setMortality_Rate_by__CD_CD_CRD(String mortality_Rate_by__CD_CD_CRD) {
		Mortality_Rate_by__CD_CD_CRD = mortality_Rate_by__CD_CD_CRD;
	}
	public String getSuicidal_Death() {
		return Suicidal_Death;
	}
	public void setSuicidal_Death(String suicidal_Death) {
		Suicidal_Death = suicidal_Death;
	}
	public String getAlcoholic_Disorder() {
		return Alcoholic_Disorder;
	}
	public void setAlcoholic_Disorder(String alcoholic_Disorder) {
		Alcoholic_Disorder = alcoholic_Disorder;
	}
	public Integer getAlcoholic_Consumption() {
		return Alcoholic_Consumption;
	}
	public void setAlcoholic_Consumption(Integer alcoholic_Consumption) {
		Alcoholic_Consumption = alcoholic_Consumption;
	}
	public String getRoad_Traffic_deaths() {
		return Road_Traffic_deaths;
	}
	public void setRoad_Traffic_deaths(String road_Traffic_deaths) {
		Road_Traffic_deaths = road_Traffic_deaths;
	}
	public String getWomen_Reproductive() {
		return Women_Reproductive;
	}
	public void setWomen_Reproductive(String women_Reproductive) {
		Women_Reproductive = women_Reproductive;
	}
	public String getAdolescent_birth() {
		return Adolescent_birth;
	}
	public void setAdolescent_birth(String adolescent_birth) {
		Adolescent_birth = adolescent_birth;
	}




	@Override
	public String toString() {
		return "ThirdGoal [SNo=" + SNo + ", volunteer=" + volunteer + ", mandal=" + mandal + ", village=" + village
				+ ", urban_Rural=" + urban_Rural + ", house_Sequence=" + house_Sequence + ", Name=" + Name + ", Gender="
				+ Gender + ", DOB=" + DOB + ", Age=" + Age + ", Aadhaar=" + Aadhaar + ", Contact_Number="
				+ Contact_Number + ", Maternal_Mortality=" + Maternal_Mortality + ", Births_Attended_by_SHP="
				+ Births_Attended_by_SHP + ", Infant_Deaths=" + Infant_Deaths + ", Under5_MR=" + Under5_MR
				+ ", Neonatal_deaths=" + Neonatal_deaths + ", HIV_infected=" + HIV_infected + ", Tuberculosis_infected="
				+ Tuberculosis_infected + ", Malaria_Infected=" + Malaria_Infected + ", Need_InterventionOrCheck_Up="
				+ Need_InterventionOrCheck_Up + ", Hepatitis_B_infected=" + Hepatitis_B_infected
				+ ", Mortality_Rate_by__CD_CD_CRD=" + Mortality_Rate_by__CD_CD_CRD + ", Suicidal_Death="
				+ Suicidal_Death + ", Alcoholic_Disorder=" + Alcoholic_Disorder + ", Alcoholic_Consumption="
				+ Alcoholic_Consumption + ", Road_Traffic_deaths=" + Road_Traffic_deaths + ", Women_Reproductive="
				+ Women_Reproductive + ", Adolescent_birth=" + Adolescent_birth + ", timestamp=" + timestamp + "]";
	}

	
	
	
}
