package com.sdg.goals.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sdg.goals.model.FirstGoal;

public interface FirstGoalRepository extends JpaRepository<FirstGoal, Integer> {

	@Query(value="select count(*) from sdg.goal1 union all\r\n"
			+ "select count(CASE WHEN ipl='Yes' and gender='F' and age >= 15 THEN 1 END) as counts from sdg.goal1 union all\r\n"
			+ "select count(CASE WHEN ipl='Yes' and gender='M' and age >= 15 THEN 1 END)  from sdg.goal1 union all\r\n"
			+ "select count(CASE WHEN npl='Yes' and urban_or_rural='urban'  and age >= 15 THEN 1 END) as counts from sdg.goal1 union all \r\n"
			+ "select count(CASE WHEN npl='Yes' and urban_or_rural='rural' and age >= 15 THEN 1 END) as counts from sdg.goal1 union all\r\n"
			+ "select count(CASE WHEN age < 12 THEN 1 END) as counts from sdg.goal1 union all\r\n"
			+ "select count(CASE WHEN multi_dimentional_poverty_line='Yes' and age < 12 THEN 1 END) as counts from sdg.goal1 union all\r\n"
			+ "select count(distinct house_sequence) as counts from sdg.goal1 union all\r\n"
			+ "select count(CASE WHEN children_orhouseholds_cash_benefits='Yes' and gender='F' and age<12 THEN 1 END) as counts from sdg.goal1 union all\r\n"
			+ "select count(CASE WHEN children_orhouseholds_cash_benefits='Yes' and gender='M' and age<12 THEN 1 END) as counts from sdg.goal1 union all\r\n"
			+ "select count(CASE WHEN work_injury_benefits='Yes' and gender='F' THEN 1 END) as counts from sdg.goal1 union all\r\n"
			+ "select count(CASE WHEN work_injury_benefits='Yes' and gender='M' THEN 1 END) as counts from sdg.goal1 union all\r\n"
			+ "select count(CASE WHEN maternity_cash_benefits ='Yes' and gender='F' THEN 1 END) as counts from sdg.goal1 union all\r\n"
			+ "select count(CASE WHEN pension_benefits ='Yes' THEN 1 END) as counts from sdg.goal1 union all\r\n"
			+ "select count(CASE WHEN poor_population_receiving_sacb ='Yes' and gender='F' THEN 1 END) as counts from sdg.goal1 union all\r\n"
			+ "select count(CASE WHEN poor_population_receiving_sacb ='Yes' and gender='M' THEN 1 END) as counts from sdg.goal1 union all\r\n"
			+ "select count(CASE WHEN disability_cash_benefits ='Yes' THEN 1 END) as counts from sdg.goal1 union all\r\n"
			+ "select count(CASE WHEN unemployment_cash_benefits ='Yes' THEN 1 END) as counts from sdg.goal1 union all\r\n"
			+ "select count(CASE WHEN labour_market_program ='Yes' THEN 1 END) as counts from sdg.goal1 union all\r\n"
			+ "select count(CASE WHEN social_insurance_coverage ='Yes' THEN 1 END) as counts from sdg.goal1 union all\r\n"
			+ "select count(CASE WHEN bdw ='Yes' THEN 1 END) as counts from sdg.goal1 union all\r\n"
			+ "select count(CASE WHEN bss ='Yes' THEN 1 END) as counts from sdg.goal1 union all\r\n"
			+ "select count(CASE WHEN age >=15 THEN 1 END) as counts from sdg.goal1;",nativeQuery=true)
	List<Float> firstGoalLeafNodeValues();
	
	@Query(value="SELECT timestamp FROM sdg.goal1 LIMIT 1;",nativeQuery=true)
	String firstGoalDate();
}