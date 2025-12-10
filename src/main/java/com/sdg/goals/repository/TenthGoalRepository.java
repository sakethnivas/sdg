package com.sdg.goals.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sdg.goals.model.TenthGoal;

public interface TenthGoalRepository extends JpaRepository<TenthGoal, Integer> {
	@Query(value="select count(*) from sdg.goal10 union all\r\n"
			+ "select count(case when gender='f' and age >15 then 1 end) from sdg.goal10 union all\r\n"
			+ "select count(case when gender='m' and age >15 then 1 end) from sdg.goal10 union all\r\n"
			+ "select sum(income_per_capita_per_year) from sdg.goal10 where gender = 'f' and age>15 union all\r\n"
			+ "select sum(income_per_capita_per_year) from sdg.goal10 where gender = 'm' and age>15 union all\r\n"
			+ "select count(case when below_40percent_of_income = 'yes' and age >15 then 1 end) from sdg.goal10 union all\r\n"
			+ "select count(case when living_below_50percent_of_medium_income = 'yes' then 1 end) from sdg.goal10 union all\r\n"
			+ "select count(case when felt_descriminated_in_a_year_period = 'yes' then 1 end) from sdg.goal10;",nativeQuery=true)
	List<Float> tenthGoalLeafNodeValues();
	@Query(value="SELECT timestamp FROM sdg.goal10 LIMIT 1;",nativeQuery=true)
	String tenthGoalDate();
}
