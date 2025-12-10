package com.sdg.goals.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Goal2")
public class SecondGoal {
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
	private Long Aadhaar;
	@Column
	private long Contact_Number;
	//Target2.1
	@Column
	private String Undernourish_Category;
	@Column
	private String Prevalence_of_Undernourishment;
	//Target2.2
	@Column
	private Integer  Height;
	@Column
	private Integer Weight;
	@Column
	private String Stunted;
	@Column
	private String Wasted;
	@Column
	private String Over_Weight;
	//Target2.3
	@Column
	private Long Productivity;
	//Target2.5
	@Column
	private String Plant_Breeds_Storage_Facility_Available;
	@Column 
	private String timestamp;
	public SecondGoal() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	public String getTimestamp() {
		return timestamp;
	}




	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}




	public SecondGoal(int sNo, String volunteer, String mandal, String village, String urban_Rural, int house_Sequence,
			String name, String gender, LocalDate dOB, int age, Long aadhaar, long contact_Number,
			String undernourish_Category, String prevalence_of_Undernourishment, Integer height, Integer weight, String stunted,
			String wasted, String over_Weight, Long productivity, String plant_Breeds_Storage_Facility_Available,
			String timestamp) {
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
		Undernourish_Category = undernourish_Category;
		Prevalence_of_Undernourishment = prevalence_of_Undernourishment;
		Height = height;
		Weight = weight;
		Stunted = stunted;
		Wasted = wasted;
		Over_Weight = over_Weight;
		Productivity = productivity;
		Plant_Breeds_Storage_Facility_Available = plant_Breeds_Storage_Facility_Available;
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
	public Long getAadhaar() {
		return Aadhaar;
	}
	public void setAadhaar(Long aadhaar) {
		Aadhaar = aadhaar;
	}
	public long getContact_Number() {
		return Contact_Number;
	}
	public void setContact_Number(long contact_Number) {
		Contact_Number = contact_Number;
	}
	public String getUndernourish_Category() {
		return Undernourish_Category;
	}
	public void setUndernourish_Category(String undernourish_Category) {
		Undernourish_Category = undernourish_Category;
	}
	public String getPrevalence_of_Undernourishment() {
		return Prevalence_of_Undernourishment;
	}
	public void setPrevalence_of_Undernourishment(String prevalence_of_Undernourishment) {
		Prevalence_of_Undernourishment = prevalence_of_Undernourishment;
	}
	public Integer getHeight() {
		return Height;
	}
	public void setHeight(Integer height) {
		Height = height;
	}
	public Integer getWeight() {
		return Weight;
	}
	public void setWeight(Integer weight) {
		Weight = weight;
	}
	public String getStunted() {
		return Stunted;
	}
	public void setStunted(String stunted) {
		Stunted = stunted;
	}
	public String getWasted() {
		return Wasted;
	}
	public void setWasted(String wasted) {
		Wasted = wasted;
	}
	public String getOver_Weight() {
		return Over_Weight;
	}
	public void setOver_Weight(String over_Weight) {
		Over_Weight = over_Weight;
	}
	public Long getProductivity() {
		return Productivity;
	}
	public void setProductivity(Long productivity) {
		Productivity = productivity;
	}
	public String getPlant_Breeds_Storage_Facility_Available() {
		return Plant_Breeds_Storage_Facility_Available;
	}
	public void setPlant_Breeds_Storage_Facility_Available(String plant_Breeds_Storage_Facility_Available) {
		Plant_Breeds_Storage_Facility_Available = plant_Breeds_Storage_Facility_Available;
	}




	@Override
	public String toString() {
		return "SecondGoal [SNo=" + SNo + ", volunteer=" + volunteer + ", mandal=" + mandal + ", village=" + village
				+ ", urban_Rural=" + urban_Rural + ", house_Sequence=" + house_Sequence + ", Name=" + Name + ", Gender="
				+ Gender + ", DOB=" + DOB + ", Age=" + Age + ", Aadhaar=" + Aadhaar + ", Contact_Number="
				+ Contact_Number + ", Undernourish_Category=" + Undernourish_Category
				+ ", Prevalence_of_Undernourishment=" + Prevalence_of_Undernourishment + ", Height=" + Height
				+ ", Weight=" + Weight + ", Stunted=" + Stunted + ", Wasted=" + Wasted + ", Over_Weight=" + Over_Weight
				+ ", Productivity=" + Productivity + ", Plant_Breeds_Storage_Facility_Available="
				+ Plant_Breeds_Storage_Facility_Available + ", timestamp=" + timestamp + "]";
	}

	
	
	
	
}
