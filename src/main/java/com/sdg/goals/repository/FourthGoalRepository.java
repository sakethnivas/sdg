package com.sdg.goals.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sdg.goals.model.FourthGoal;

public interface FourthGoalRepository  extends JpaRepository<FourthGoal, Integer> {
	@Query(value="select count(*) as counts from sdg.goal4 union all\r\n"
			+ "select count(CASE WHEN urban_or_rural='rural' THEN 1 END) as counts from sdg.goal4 union all\r\n"
			+ "select count(CASE WHEN urban_or_rural='urban' THEN 1 END) as counts from sdg.goal4 union all\r\n"
			+ "select count(CASE WHEN urban_or_rural='rural' and age>=3 and age<=5 THEN 1 END) as counts from sdg.goal4 union all\r\n"
			+ "select count(CASE WHEN urban_or_rural='urban' and age>=3 and age<=5 THEN 1 END) as counts from sdg.goal4 union all\r\n"
			+ "select count(CASE WHEN urban_or_rural='rural' and age>12 THEN 1 END) as counts from sdg.goal4 union all\r\n"
			+ "select count(CASE WHEN urban_or_rural='urban' and age>12 THEN 1 END) as counts from sdg.goal4 union all\r\n"
			+ "select count(CASE WHEN urban_or_rural='rural' and age>15 THEN 1 END) as counts from sdg.goal4 union all\r\n"
			+ "select count(CASE WHEN urban_or_rural='urban' and age>15 THEN 1 END) as counts from sdg.goal4 union all\r\n"
			+ "select count(CASE WHEN educational_proficiency='yes' and urban_or_rural = 'rural' and gender='F' THEN 1 END) as counts from sdg.goal4 union all\r\n"
			+ "select count(CASE WHEN educational_proficiency='yes' and urban_or_rural = 'rural' and gender='M' THEN 1 END) as counts from sdg.goal4 union all\r\n"
			+ "select count(CASE WHEN educational_proficiency='yes' and urban_or_rural = 'urban' and gender='F' THEN 1 END) as counts from sdg.goal4 union all\r\n"
			+ "select count(CASE WHEN educational_proficiency='yes' and urban_or_rural = 'urban' and gender='M' THEN 1 END) as counts from sdg.goal4 union all\r\n"
			+ "select count(CASE WHEN lss='yes' and urban_or_rural = 'rural' and  gender='F' THEN 1 END) as counts from sdg.goal4 union all\r\n"
			+ "select count(CASE WHEN lss='yes' and urban_or_rural = 'rural' and gender='M' THEN 1 END) as counts from sdg.goal4 union all\r\n"
			+ "select count(CASE WHEN lss='yes' and urban_or_rural = 'urban' and gender='F' THEN 1 END) as counts from sdg.goal4 union all\r\n"
			+ "select count(CASE WHEN lss='yes' and urban_or_rural = 'urban' and gender='M' THEN 1 END) as counts from sdg.goal4 union all\r\n"
			+ "select count(CASE WHEN primary_school='yes' and urban_or_rural = 'rural' and gender='F' THEN 1 END) as counts from sdg.goal4 union all\r\n"
			+ "select count(CASE WHEN primary_school='yes' and urban_or_rural = 'rural' and gender='M' THEN 1 END) as counts from sdg.goal4 union all\r\n"
			+ "select count(CASE WHEN primary_school='yes' and urban_or_rural = 'urban' and gender='F' THEN 1 END) as counts from sdg.goal4 union all\r\n"
			+ "select count(CASE WHEN primary_school='yes' and urban_or_rural = 'urban' and gender='M' THEN 1 END) as counts from sdg.goal4 union all\r\n"
			+ "select count(CASE WHEN uss='yes' and urban_or_rural = 'rural' and gender='F' THEN 1 END) as counts from sdg.goal4 union all\r\n"
			+ "select count(CASE WHEN uss='yes' and urban_or_rural = 'rural' and gender='M' THEN 1 END) as counts from sdg.goal4 union all\r\n"
			+ "select count(CASE WHEN uss='yes' and urban_or_rural = 'urban' and gender='F' THEN 1 END) as counts from sdg.goal4 union all\r\n"
			+ "select count(CASE WHEN uss='yes' and urban_or_rural = 'urban' and gender='M' THEN 1 END) as counts from sdg.goal4 union all\r\n"
			+ "select count(CASE WHEN urban_or_rural='urban' and educational_proficiency='yes' and ppe='yes' and primary_school='yes' and age>=3 and age<=5 THEN 1 END) as counts from sdg.goal4 union all\r\n"
			+ "select count(CASE WHEN urban_or_rural='rural' and educational_proficiency='yes' and ppe='yes' and primary_school='yes' and age>=3 and age<=5 THEN 1 END) as counts from sdg.goal4 union all\r\n"
			+ "select count(CASE WHEN urban_or_rural='urban' and gender='F' and ppe='yes' and age>=3 and age<=5 THEN 1 END) as counts from sdg.goal4 union all\r\n"
			+ "select count(CASE WHEN urban_or_rural='urban' and gender='M' and ppe='yes' and age>=3 and age<=5 THEN 1 END) as counts from sdg.goal4 union all\r\n"
			+ "select count(CASE WHEN urban_or_rural='rural' and gender='F' and ppe='yes' and age>=3 and age<=5 THEN 1 END) as counts from sdg.goal4 union all\r\n"
			+ "select count(CASE WHEN urban_or_rural='rural' and gender='M' and ppe='yes' and age>=3 and age<=5 THEN 1 END) as counts from sdg.goal4 union all\r\n"
			+ "select count(CASE WHEN urban_or_rural='urban' and gender='F' and f_and_nfe_training='yes' and age>12 THEN 1 END) as counts from sdg.goal4 union all\r\n"
			+ "select count(CASE WHEN urban_or_rural='urban' and gender='M' and f_and_nfe_training='yes' and age>12 THEN 1 END) as counts from sdg.goal4 union all\r\n"
			+ "select count(CASE WHEN urban_or_rural='rural' and gender='F' and f_and_nfe_training='yes' and age>12 THEN 1 END) as counts from sdg.goal4 union all\r\n"
			+ "select count(CASE WHEN urban_or_rural='rural' and gender='M' and f_and_nfe_training='yes' and age>12 THEN 1 END) as counts from sdg.goal4 union all\r\n"
			+ "select count(CASE WHEN urban_or_rural='urban' and gender='F' and ict_participation='yes' and age>15 THEN 1 END) as counts from sdg.goal4 union all\r\n"
			+ "select count(CASE WHEN urban_or_rural='urban' and gender='M' and ict_participation='yes' and age>15 THEN 1 END) as counts from sdg.goal4 union all\r\n"
			+ "select count(CASE WHEN urban_or_rural='rural' and gender='F' and ict_participation='yes' and age>15 THEN 1 END) as counts from sdg.goal4 union all\r\n"
			+ "select count(CASE WHEN urban_or_rural='rural' and gender='M' and ict_participation='yes' and age>15 THEN 1 END) as counts from sdg.goal4 union all\r\n"
			+ "select count(CASE WHEN teaching_level='lst' and gender = 'F' THEN 1 END) as counts from sdg.goal4 union all\r\n"
			+ "select count(CASE WHEN teaching_level='lst' and gender = 'M' THEN 1 END) as counts from sdg.goal4 union all\r\n"
			+ "select count(CASE WHEN teaching_level='ppt' and gender = 'F' THEN 1 END) as counts from sdg.goal4 union all\r\n"
			+ "select count(CASE WHEN teaching_level='ppt' and gender = 'M' THEN 1 END) as counts from sdg.goal4 union all\r\n"
			+ "select count(CASE WHEN teaching_level='pt' and gender = 'F' THEN 1 END) as counts from sdg.goal4 union all\r\n"
			+ "select count(CASE WHEN teaching_level='pt' and gender = 'M' THEN 1 END) as counts from sdg.goal4 union all\r\n"
			+ "select count(CASE WHEN teaching_level='st/ust' and gender = 'F' THEN 1 END) as counts from sdg.goal4 union all\r\n"
			+ "select count(CASE WHEN teaching_level='st/ust' and gender = 'M' THEN 1 END) as counts from sdg.goal4",nativeQuery=true)
	List<Float> fourthGoalLeafNodeValues();
	@Query(value="SELECT timestamp FROM sdg.goal4 LIMIT 1;",nativeQuery=true)
	String fourthGoalDate();
}
