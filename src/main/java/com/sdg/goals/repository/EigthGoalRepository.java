package com.sdg.goals.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sdg.goals.model.EigthGoal;

public interface EigthGoalRepository extends JpaRepository<EigthGoal, Integer> {
	@Query(value = "select count(CASE WHEN  age>=15 THEN 1 END) as counts from sdg.goal8 union all\r\n"
			+ "select count(CASE WHEN  age>=15  and age <=24 THEN 1 END) as counts from sdg.goal8 union all\r\n"
			+ "select count(CASE WHEN  age>=5  and age <=14 THEN 1 END) as counts from sdg.goal8 union all\r\n"
			+ "select count(CASE WHEN informal_employment='employed' and age>=15 and gender='F' THEN 1 END) as counts from sdg.goal8 union all\r\n"
			+ "select count(CASE WHEN informal_employment='employed' and age>=15 and gender='M' THEN 1 END) as counts from sdg.goal8 union all\r\n"
			+ "SELECT SUM(hourly_earnings_per_day) FROM sdg.goal8 WHERE informal_employment='employed' and age>=15 and gender='F' union all\r\n"
			+ "SELECT SUM(hourly_earnings_per_day) FROM sdg.goal8 WHERE informal_employment='employed' and age>=15 and gender='M' union all\r\n"
			+ "select count(CASE WHEN informal_employment='unemployed' and age>=15 and gender='F' THEN 1 END) as counts from sdg.goal8 union all\r\n"
			+ "select count(CASE WHEN informal_employment='unemployed' and age>=15 and gender='M' THEN 1 END) as counts from sdg.goal8 union all\r\n"
			+ "select count(CASE WHEN informal_employment='unemployed' and age>=15 and age<=24 and gender='F' THEN 1 END) as counts from sdg.goal8 union all\r\n"
			+ "select count(CASE WHEN informal_employment='unemployed' and age>=15 and age<=24 and gender='M' THEN 1 END) as counts from sdg.goal8 union all\r\n"
			+ "select count(CASE WHEN informal_employment='employed' and age>=5 and age<=14 and gender='F' THEN 1 END) as counts from sdg.goal8 union all\r\n"
			+ "select count(CASE WHEN informal_employment='employed' and age>=5 and age<=14 and  gender='M' THEN 1 END) as counts from sdg.goal8 union all\r\n"
			+ "select count(CASE WHEN is_he_or_she_having_bank_account='yes' and age>=15 and  gender='F' THEN 1 END) as counts from sdg.goal8 union all\r\n"
			+ "select count(CASE WHEN is_he_or_she_having_bank_account='yes' and age>=15 and  gender='M' THEN 1 END) as counts from sdg.goal8 ",nativeQuery = true)
	List<Float> eigthGoalLeafNodeValues();
	
	
	@Query(value="SELECT timestamp FROM sdg.goal8 LIMIT 1;",nativeQuery=true)
	String eigthGoalDate();

}
