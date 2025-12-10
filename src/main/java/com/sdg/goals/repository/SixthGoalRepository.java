package com.sdg.goals.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sdg.goals.model.SixthGoal;

public interface SixthGoalRepository extends JpaRepository<SixthGoal, Integer> {
	@Query(value ="select count(*) as counts from sdg.goal6 union all\r\n"
			+ "select count(distinct house_sequence) as counts from sdg.goal6 where urban_or_rural='rural' union all\r\n"
			+ "select count(distinct house_sequence) as counts from sdg.goal6 where urban_or_rural='urban' union all\r\n"
			+ "select count(case when urban_or_rural='rural' Then 1 end) from sdg.goal6 union all\r\n"
			+ "select count(case when urban_or_rural='urban' Then 1 end) from sdg.goal6 union all\r\n"
			+ "select count(distinct house_sequence) as counts from sdg.goal6 where urban_or_rural='rural' and have_the_drinking_water_facility='yes' union all\r\n"
			+ "select count(distinct house_sequence) as counts from sdg.goal6 where urban_or_rural='urban' and have_the_drinking_water_facility='yes' union all\r\n"
			+ "select count(case when urban_or_rural='rural' and practicing_open_defecation='yes' Then 1 end) from sdg.goal6 union all\r\n"
			+ "select count(case when urban_or_rural='urban' and practicing_open_defecation='yes' Then 1 end) from sdg.goal6 union all\r\n"
			+ "select count(case when urban_or_rural='rural' and sanitation_services_available='yes' Then 1 end) from sdg.goal6 union all\r\n"
			+ "select count(case when urban_or_rural='urban' and sanitation_services_available='yes' Then 1 end) from sdg.goal6 union all\r\n"
			+ "select count(case when urban_or_rural='rural' and handwashing_services_available='yes' Then 1 end) from sdg.goal6 union all\r\n"
			+ "select count(case when urban_or_rural='urban' and handwashing_services_available='yes' Then 1 end) from sdg.goal6 union all\r\n"
			+ "select count(case when urban_or_rural='rural' and have_waste_water_flows_facility='yes' Then 1 end) from sdg.goal6 union all\r\n"
			+ "select count(case when urban_or_rural='urban' and have_waste_water_flows_facility='yes' Then 1 end) from sdg.goal6 union all\r\n"
			+ "select count(case when urban_or_rural='rural' and type_of_water_quality_in_use='Filtered/RO Water' Then 1 end) from sdg.goal6 union all\r\n"
			+ "select count(case when urban_or_rural='urban' and type_of_water_quality_in_use='Filtered/RO Water' Then 1 end) from sdg.goal6 union all\r\n"
			+ "select count(case when urban_or_rural='rural' and type_of_water_quality_in_use='Ground Water' Then 1 end) from sdg.goal6 union all\r\n"
			+ "select count(case when urban_or_rural='urban' and type_of_water_quality_in_use='Ground Water' Then 1 end) from sdg.goal6 union all\r\n"
			+ "select count(case when urban_or_rural='rural' and type_of_water_quality_in_use='Open Water' Then 1 end) from sdg.goal6 union all\r\n"
			+ "select count(case when urban_or_rural='urban' and type_of_water_quality_in_use='Open Water' Then 1 end) from sdg.goal6 union all\r\n"
			+ "select count(case when urban_or_rural='rural' and type_of_water_quality_in_use='River Water' Then 1 end) from sdg.goal6 union all\r\n"
			+ "select count(case when urban_or_rural='urban' and type_of_water_quality_in_use='River Water' Then 1 end) from sdg.goal6 ;",nativeQuery=true)
	List<Float> sixthGoalLeafNodeValues();
	
	@Query(value="SELECT CASE WHEN EXISTS (SELECT 1 FROM sdg.goal6 WHERE urban_or_rural='rural') THEN IFNULL(water_use_efficiency, 'No data available') ELSE 'No data available'END as result_1 FROM sdg.goal6 LIMIT 1;",nativeQuery = true)
	String waterUseEfficiencyOfRural();
	@Query(value="SELECT CASE WHEN EXISTS (SELECT 1 FROM sdg.goal6 WHERE urban_or_rural='urban') THEN IFNULL(water_use_efficiency, 'No data available') ELSE 'No data available'END as result_1\r\n"
			+ "FROM sdg.goal6\r\n"
			+ "LIMIT 1;",nativeQuery = true)
	String waterUseEfficiencyOfUrban();
	@Query(value="SELECT CASE WHEN EXISTS (SELECT 1 FROM sdg.goal6 WHERE urban_or_rural='rural') THEN IFNULL(levels_of_water_stress, 'No data available') ELSE 'No data available'END as result_1 FROM sdg.goal6 LIMIT 1;",nativeQuery = true)
	String levelsOfWaterStressRural();
	@Query(value="SELECT CASE WHEN EXISTS (SELECT 1 FROM sdg.goal6 WHERE urban_or_rural='urban')THEN IFNULL(levels_of_water_stress, 'No data available')\r\n"
			+ "    ELSE 'No data available'\r\n"
			+ "  END as result_4\r\n"
			+ "FROM sdg.goal6\r\n"
			+ "LIMIT 1;\r\n"
			+ "",nativeQuery = true)
	String levelsOfWaterStressUrban();
	@Query(value="SELECT CASE WHEN EXISTS (SELECT 1 FROM sdg.goal6 WHERE urban_or_rural='rural') THEN IFNULL(water_resource_management_implementation, 'No data available') ELSE 'No data available'END as result_1 FROM sdg.goal6 LIMIT 1;\r\n"
			+ "",nativeQuery = true)
	String waterResourceManagementOrImplementationRural();
	@Query(value="SELECT CASE WHEN EXISTS (SELECT 1 FROM sdg.goal6 WHERE urban_or_rural='urban')THEN IFNULL(water_resource_management_implementation, 'No data available')\r\n"
			+ "    ELSE 'No data available'\r\n"
			+ "  END as result_6\r\n"
			+ "FROM sdg.goal6\r\n"
			+ "LIMIT 1;",nativeQuery = true)
	String waterResourceManagementOrImplementationUrban();
	@Query(value="SELECT timestamp FROM sdg.goal6 LIMIT 1;",nativeQuery=true)
	String sixthGoalDate();
}
