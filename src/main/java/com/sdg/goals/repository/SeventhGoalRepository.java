package com.sdg.goals.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sdg.goals.model.SeventhGoal;

public interface SeventhGoalRepository extends JpaRepository<SeventhGoal, Integer> {
	@Query(value="select count(distinct house_sequence) as counts from sdg.goal7 union all \r\n"
			+ "SELECT COUNT(DISTINCT house_sequence) AS counts FROM sdg.goal7 WHERE access_to_electricity= 'Yes' union all\r\n"
			+ "SELECT COUNT(DISTINCT house_sequence) AS counts FROM sdg.goal7 WHERE primary_use_of_clean_fuels_and_technology= 'Yes' union all\r\n"
			+ "SELECT COUNT(DISTINCT house_sequence) AS counts FROM sdg.goal7 WHERE renewable_energy_usage = 'Yes' ;",nativeQuery=true)
	List<Float> seventhGoalLeafNodeValues();
	@Query(value="SELECT IFNULL(energy_efficicency, 'No data available') as result FROM sdg.goal7 where urban_or_rural='rural' Limit 1",nativeQuery=true)
	String energyEfficiency();
	@Query(value="SELECT timestamp FROM sdg.goal7 LIMIT 1;",nativeQuery=true)
	String seventhGoalDate();
}

