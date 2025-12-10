package com.sdg.goals.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sdg.goals.model.ConfigParam;

public interface ConfigParamRepository extends JpaRepository<ConfigParam, String> {
	
	@Query(value ="select IFNULL(configvalue, 'No data available') AS configvalue from sdg.config_param where configkey = 'Water use efficiency for rural' union all\r\n"
			+ "select IFNULL(configvalue, 'No data available') AS configvalue from sdg.config_param where configkey = 'Water use efficiency for urban' union all\r\n"
			+ "select IFNULL(configvalue, 'No data available') AS configvalue from sdg.config_param where configkey = 'Water use efficiency for Total' union all\r\n"
			+ "select IFNULL(configvalue, 'No data available') AS configvalue from sdg.config_param where configkey = 'Levels of waterstress for rural' union all\r\n"
			+ "select IFNULL(configvalue, 'No data available') AS configvalue from sdg.config_param where configkey = 'Levels of waterstress for urban' union all\r\n"
			+ "select IFNULL(configvalue, 'No data available') AS configvalue from sdg.config_param where configkey = 'Levels of waterstress for Total' union all\r\n"
			+ "select IFNULL(configvalue, 'No data available') AS configvalue from sdg.config_param where configkey = 'Water resource management for rural' union all\r\n"
			+ "select IFNULL(configvalue, 'No data available') AS configvalue from sdg.config_param where configkey = 'Water resource management for urban' union all\r\n"
			+ "select IFNULL(configvalue, 'No data available') AS configvalue from sdg.config_param where configkey = 'Water resource management for total' union all\r\n"
			+ "select IFNULL(configvalue, 'No data available') AS configvalue from sdg.config_param where configkey = 'Energy efficiency' union all\r\n"
			+ "select IFNULL(configvalue, 'No data available') AS configvalue from sdg.config_param where configkey = 'Number of ATMs' union all\r\n"
			+ "select IFNULL(configvalue, 'No data available') AS configvalue from sdg.config_param where configkey = 'Number of commercial bank branches' union all\r\n"
			+ "select IFNULL(configvalue, 'No data available') AS configvalue from sdg.config_param where configkey = 'Road access' union all\r\n"
			+ "select IFNULL(configvalue, 'No data available') AS configvalue from sdg.config_param where configkey = 'passenger volume' union all\r\n"
			+ "select IFNULL(configvalue, 'No data available') AS configvalue from sdg.config_param where configkey = 'R and D expenditure'",nativeQuery = true)
	List<String> configList();

//	ConfigParam findByconfigkey(String configkey);

}
