package com.sdg.goals.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import com.sdg.goals.helper.ConfigParamHelper;
import com.sdg.goals.model.ConfigParam;
import com.sdg.goals.repository.ConfigParamRepository;
import com.sdg.goals.service.ConfigParamService;
@Service
public class ConfigParamServiceImpl implements ConfigParamService, ApplicationRunner {
	private static final Logger logger = LoggerFactory.getLogger(ConfigParamServiceImpl.class);


	@Autowired
    private  ConfigParamRepository configParamRepo;
	 private boolean isDataSaved = false;
    
//    public ConfigParamServiceImpl(ConfigParamRepository configParamRepo) {
//        this.configParamRepo = configParamRepo;
//    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
    	if (!isDataSaved && configParamRepo.count() <15) {
        List<String> columnData = List.of("Water use efficiency for rural",
                "Water use efficiency for urban",
                "Water use efficiency for Total",
                "Levels of waterstress for rural",
                "Levels of waterstress for urban",
                "Levels of waterstress for Total",
                "Water resource management for rural",
                "Water resource management for urban",
                "Water resource management for total",
                "Energy efficiency",
                "Number of ATMs",
                "Number of commercial bank branches",
                "Road access",
                "passenger volume",
                "R and D expenditure"); // Provide your 15 values here
        saveColumnData(columnData);
        isDataSaved = true;
	     logger.info("Application argumens are successfully inserted");

        }
    }

    public void saveColumnData(List<String> columnData) {
        // Iterate over the columnData list and save each value to the database
        for (String value : columnData) {
            ConfigParam configParam = new ConfigParam();
            // Set the necessary properties of the ConfigParam object
            configParam.setConfigkey(value);
            configParamRepo.save(configParam);
        }
    }
    @Override
    public void updatedata(List<Map<String, String>> data) {
	      List<ConfigParam> config;
			config = ConfigParamHelper.ConfigtoDB(data);
		      configParamRepo.saveAll(config);

		     logger.info("Configparam data updated successfully");

	}

    @Override
	public List< Map<String, Object>> previousdata(){
		List<Map<String, Object>> retList = new ArrayList<>();
		String[] primaryKeyStrings = {
				"Water use efficiency for rural",
                "Water use efficiency for urban",
                "Water use efficiency for Total",
                "Levels of waterstress for rural",
                "Levels of waterstress for urban",
                "Levels of waterstress for Total",
                "Water resource management for rural",
                "Water resource management for urban",
                "Water resource management for total",
                "Energy efficiency",
                "Number of ATMs",
                "Number of commercial bank branches",
                "Road access",
                "Passenger volume",
                "R and D expenditure"
		};
		for (int i=0; i<=configParamRepo.count()-1;i++) {
			Map<String, Object> configMap = new HashMap<>();
			Optional<ConfigParam> optionalconfig = configParamRepo.findById(primaryKeyStrings[i]);
			ConfigParam configParam = optionalconfig.get();
			configMap.put("configkey", configParam.getConfigkey());
			if(configParam.getConfigvalue() == null) {
				configMap.put("configvalue", "No data available");
			}
			else {
			configMap.put("configvalue", configParam.getConfigvalue());
			}
			retList.add(configMap);
		}
		return retList;
	}	
	

    // Other methods in your service implementation
    // ...
}
