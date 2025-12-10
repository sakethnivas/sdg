package com.sdg.goals.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sdg.goals.model.FifthGoal;


public interface FifthGoalRepository  extends JpaRepository<FifthGoal, Integer> {
	@Query(value="select count(*) as counts from sdg.goal5 union all\r\n"
			+ "select count(CASE WHEN voilence_against_women='yes' or marriageand_family='yes' or eandeb='yes' THEN 1 END) as counts from sdg.goal5 union all\r\n"
			+ "select count(case when gender='F' Then 1 end) from sdg.goal5 union all\r\n"
			+ "select count(case when gender='M' Then 1 end) from sdg.goal5 union all\r\n"
			+ "select count(CASE WHEN voilence_against_women='yes' THEN 1 END) as counts from sdg.goal5 union all\r\n"
			+ "select count(CASE WHEN marriageand_family='yes' THEN 1 END) counts from sdg.goal5 union all\r\n"
			+ "select count(CASE WHEN eandeb='yes' THEN 1 END) as counts from sdg.goal5 union all\r\n"
			+ "select count(case when sexual_voilence='yes' and gender='F' and age>=15 and age<=24 Then 1 end) from sdg.goal5 union all\r\n"
			+ "select count(case when sexual_voilence='yes' and gender='F' and age>=25 and age<=35 Then 1 end) from sdg.goal5 union all\r\n"
			+ "select count(case when sexual_voilence='yes' and gender='F' and age>=36 and age<=49 Then 1 end) from sdg.goal5 union all\r\n"
			+ "select count(case when eandeb='yes' and gender='F' Then 1 end) from sdg.goal5 union all\r\n"
			+ "select count(case when married_before_18years='yes' and gender='F' Then 1 end) from sdg.goal5 union all\r\n"
			+ "select count(case when undergone_genital_mutilation_or_cutting='yes' and gender='F' Then 1 end) from sdg.goal5 union all\r\n"
			+ "select ifnull(sum(unpaid_time_on_domestic_and_care_work_hours_or_day),0) from sdg.goal5 where gender = 'F' and age>=15 union all\r\n"
			+ "select ifnull(sum(unpaid_time_on_domestic_and_care_work_hours_or_day),0) from sdg.goal5 where gender = 'M' and age>=15 union all\r\n"
			+ "select count(case when is_she_a_parlimentarian='yes' and gender='F' Then 1 end) from sdg.goal5 union all\r\n"
			+ "select count(case when is_she_a_local_government_elect='yes' and gender='F' Then 1 end) from sdg.goal5 union all\r\n"
			+ "select count(case when is_she_manager_or_senior_manager='M' and gender='F' Then 1 end) from sdg.goal5 union all\r\n"
			+ "select count(case when is_she_manager_or_senior_manager='SM' and gender='F' Then 1 end) from sdg.goal5 union all\r\n"
			+ "select count(case when rights_over_agri_land='yes' and gender='F' Then 1 end) from sdg.goal5 union all\r\n"
			+ "select count(case when rights_over_agri_land='yes' and gender='M' Then 1 end) from sdg.goal5 union all\r\n"
			+ "select count(case when own_a_mobile_phone_and_use_internet='yes' Then 1 end) from sdg.goal5;",nativeQuery=true)
	List<Float> fifthGoalLeafNodeValues();
	
	@Query(value="SELECT timestamp FROM sdg.goal5 LIMIT 1;",nativeQuery=true)
	String fifthGoalDate();
}
