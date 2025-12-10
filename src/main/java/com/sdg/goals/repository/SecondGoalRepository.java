package com.sdg.goals.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sdg.goals.model.SecondGoal;

public interface SecondGoalRepository extends JpaRepository<SecondGoal,Integer> {
//	@Query(value="select count(*) from sdg.goal2 union all\r\n"
//			+ "select count(CASE WHEN undernourish_category='Yes' THEN 1 END) as counts from sdg.goal2 union all\r\n"
//			+ "select count(CASE WHEN prevalence_of_undernourishment='Yes' THEN 1 END) as counts from sdg.goal2 union all\r\n"
//			+ "select count(CASE WHEN prevalence_of_undernourishment='Yes' and gender='F' and age>=15 THEN 1 END) as counts from sdg.goal2 union all\r\n"
//			+ "select count(CASE WHEN prevalence_of_undernourishment='Yes' and gender='M' and age>=15 THEN 1 END) as counts from sdg.goal2 union all\r\n"
//			+ "select count(CASE WHEN prevalence_of_undernourishment='Yes' and gender='F' THEN 1 END) as counts from sdg.goal2 union all\r\n"
//			+ "select count(CASE WHEN prevalence_of_undernourishment='Yes' and gender='M' THEN 1 END) as counts from sdg.goal2 union all\r\n"
//			+ "select count(CASE WHEN stunted='Yes' and age<5 THEN 1 END) as counts from sdg.goal2 union all\r\n"
//			+ "select count(CASE WHEN age<5 THEN 1 END) as counts from sdg.goal2 union all\r\n"
//			+ "select count(CASE WHEN over_weight='Yes' and age<5 THEN 1 END) as counts from sdg.goal2 union all\r\n"
//			+ "select count(CASE WHEN wasted='Yes' and age<5 THEN 1 END) as counts from sdg.goal2 union all\r\n"
//			+ "select SUM(productivity) as counts from sdg.goal2 union all\r\n"
//			+ "select count(CASE WHEN !productivity=0 THEN 1 END) as counts from sdg.goal2 union all\r\n"
//			+ "select count(CASE WHEN plant_breeds_storage_facility_available='Yes' THEN 1 END) as counts from sdg.goal2;",nativeQuery=true)
//	List<Float> secondGoalLeafNodeValues();
	@Query(value="select count(*) from sdg.goal2 union all\r\n"
			+ "select count(CASE WHEN undernourish_category='Yes' THEN 1 END) as counts from sdg.goal2 union all\r\n"
			+ "select count(CASE WHEN prevalence_of_undernourishment='Yes' THEN 1 END) as counts from sdg.goal2 union all\r\n"
			+ "select count(CASE WHEN prevalence_of_undernourishment='Yes' and gender='F' and age>=15 THEN 1 END) as counts from sdg.goal2 union all\r\n"
			+ "select count(CASE WHEN prevalence_of_undernourishment='Yes' and gender='M' and age>=15 THEN 1 END) as counts from sdg.goal2 union all\r\n"
			+ "select count(CASE WHEN prevalence_of_undernourishment='Yes' and gender='F' THEN 1 END) as counts from sdg.goal2 union all\r\n"
			+ "select count(CASE WHEN prevalence_of_undernourishment='Yes' and gender='M' THEN 1 END) as counts from sdg.goal2 union all\r\n"
			+ "select count(CASE WHEN stunted='Yes' and age<5 THEN 1 END) as counts from sdg.goal2 union all\r\n"
			+ "select count(CASE WHEN age<5 THEN 1 END) as counts from sdg.goal2 union all\r\n"
			+ "select count(CASE WHEN over_weight='Yes' and age<5 THEN 1 END) as counts from sdg.goal2 union all\r\n"
			+ "select count(CASE WHEN wasted='Yes' and age<5 THEN 1 END) as counts from sdg.goal2 union all\r\n"
			+ "select ifnull(SUM(productivity),0) as counts from sdg.goal2 union all\r\n"
			+ "select count(CASE WHEN !productivity=0 THEN 1 END) as counts from sdg.goal2 union all\r\n"
			+ "select count(CASE WHEN plant_breeds_storage_facility_available='Yes' THEN 1 END) as counts from sdg.goal2 union all \r\n"
			+"select count(CASE WHEN age>=15 THEN 1 END) as counts from sdg.goal2 ;",nativeQuery=true)
	List<Float> secondGoalLeafNodeValues();
	@Query(value="SELECT timestamp FROM sdg.goal2 LIMIT 1;",nativeQuery=true)
	String secondGoalDate();
}
