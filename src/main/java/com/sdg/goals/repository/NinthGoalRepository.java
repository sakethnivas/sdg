package com.sdg.goals.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sdg.goals.model.NinthGoal;

public interface NinthGoalRepository extends JpaRepository<NinthGoal, Integer> {
	@Query(value="select count(*) from sdg.goal9 union all\r\n"
			+ "select count(case when manufacturing_value_gross_earnings!=0 then 1 end) from sdg.goal9 union all\r\n"
			+ "select count(case when manufacturing_employment!='na' then 1 end) from sdg.goal9 union all\r\n"
			+ "select count(case when ssi_proposal_or_facility_owned!='na' then 1 end) from sdg.goal9 union all\r\n"
			+ "select count(case when ssi_with_loan_or_line_of_credit_received!='na' then 1 end) from sdg.goal9 union all\r\n"
			+ "select count(case when r_and_d_professional!='na' then 1 end) from sdg.goal9 union all\r\n"
			+ "select count(case when use_of_technology_internet_facility!='na' then 1 end) from sdg.goal9 union all\r\n"
			+ "select sum(manufacturing_value_gross_earnings) from sdg.goal9 union all\r\n"
			+ "select count(case when manufacturing_employment='yes' then 1 end) from sdg.goal9 union all\r\n"
			+ "select count(case when ssi_proposal_or_facility_owned='yes' then 1 end) from sdg.goal9 union all\r\n"
			+ "select count(case when ssi_with_loan_or_line_of_credit_received='yes' then 1 end) from sdg.goal9 union all\r\n"
			+ "select count(case when r_and_d_professional='yes' then 1 end) from sdg.goal9 union all\r\n"
			+ "select count(case when use_of_technology_internet_facility='yes' then 1 end) from sdg.goal9;",nativeQuery=true)
	List<Float> ninthGoalLeafNodeValues();
	@Query(value="SELECT timestamp FROM sdg.goal9 LIMIT 1;",nativeQuery=true)
	String ninthGoalDate();
}
