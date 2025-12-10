package com.sdg.goals.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sdg.goals.model.ThirdGoal;

public interface ThirdGoalRepository extends JpaRepository<ThirdGoal, Integer> {
		@Query(value = "select count(*) from sdg.goal3 union all\r\n"
				+ "select count(CASE WHEN maternal_mortality='Yes' THEN 1 END) as counts from sdg.goal3 union all\r\n"
				+ "select count(CASE WHEN births_attended_by_shp='Yes' THEN 1 END) as counts from sdg.goal3 union all\r\n"
				+ "select count(CASE WHEN neonatal_deaths='Yes' THEN 1 END) as counts from sdg.goal3 union all\r\n"
				+ "select count(CASE WHEN hiv_infected='Yes' and gender='F' and age>15 THEN 1 END) as counts from sdg.goal3 union all\r\n"
				+ "select count(CASE WHEN hiv_infected='Yes' and gender='M' and age>15 THEN 1 END) as counts from sdg.goal3 union all\r\n"
				+ "select count(CASE WHEN tuberculosis_infected = 'Yes' THEN 1 END) as counts from sdg.goal3 union all\r\n"
				+ "select count(CASE WHEN malaria_infected = 'Yes' THEN 1 END) as counts from sdg.goal3 union all\r\n"
				+ "select count(CASE WHEN need_intervention_or_check_up = 'Yes' THEN 1 END) as counts from sdg.goal3 union all\r\n"
				+ "select count(CASE WHEN hepatitis_b_infected = 'Yes' THEN 1 END) as counts from sdg.goal3 union all\r\n"
				+ "select count(CASE WHEN mortality_rate_by__cd_cd_crd = 'Yes' and gender='F' and age>30 and age<70 THEN 1 END) as counts from sdg.goal3 union all\r\n"
				+ "select count(CASE WHEN mortality_rate_by__cd_cd_crd = 'Yes' and gender='M' and age>30 and age<70 THEN 1 END) as counts from sdg.goal3 union all\r\n"
				+ "select count(CASE WHEN suicidal_death='Yes' and gender='F' THEN 1 END) as counts from sdg.goal3 union all\r\n"
				+ "select count(CASE WHEN suicidal_death='Yes' and gender='M' THEN 1 END) as counts from sdg.goal3 union all\r\n"
				+ "select count(CASE WHEN alcoholic_disorder='Yes' and gender='F' THEN 1 END) as counts from sdg.goal3 union all\r\n"
				+ "select count(CASE WHEN alcoholic_disorder='Yes' and gender='M' THEN 1 END) as counts from sdg.goal3 union all\r\n"
				+ "select ifnull(sum(alcoholic_consumption),0) as counts from sdg.goal3 where gender='F' union all\r\n"
				+ "select ifnull(sum(alcoholic_consumption),0) as counts from sdg.goal3 where gender='M' union all\r\n"
				+ "select count(CASE WHEN road_traffic_deaths='Yes' THEN 1 END) as counts from sdg.goal3 union all\r\n"
				+ "select count(CASE WHEN women_reproductive='Yes' and gender='F' and age>18 and age<49 THEN 1 END) as counts from sdg.goal3 union all\r\n"
				+ "select count(CASE WHEN age>=30 and age<=70 THEN 1 END) as counts from sdg.goal3 union all\r\n"
				+ "select count(CASE WHEN adolescent_birth='Yes' and gender='F' and age>10 and age<18 THEN 1 END) as counts from sdg.goal3 union all\r\n"
				+ "select count(CASE WHEN age>=18 and age<=49 THEN 1 END) as counts from sdg.goal3 union all\r\n"
				+ "select count(CASE WHEN age>=10 and age<=18 THEN 1 END) as counts from sdg.goal3 ;",nativeQuery=true)
		List<Float> thirdGoalLeafNodeValues();
	    @Query(value="select infant_deaths from sdg.goal3;",nativeQuery=true)
		List<String> thirdGoalInfantDeaths();
		
		@Query(value = "select under5_mr from sdg.goal3;",nativeQuery = true)
		List<String> thirdGoalUnderAgeMR();
		@Query(value="SELECT timestamp FROM sdg.goal3 LIMIT 1;",nativeQuery=true)
		String thirdGoalDate();
}
