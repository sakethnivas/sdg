package com.sdg.goals.helper;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.sdg.goals.exception.NoDataAvailableException;
import com.sdg.goals.model.ConfigParam;

public class ConfigParamHelper {
	
	
	
	public static List<ConfigParam> ConfigtoDB(List<Map<String, String>> data) throws NoDataAvailableException {
        List<ConfigParam> config = new ArrayList<ConfigParam>();
        int listLength = data.size();
        for (int i =0;i<listLength;i++) {
        	ConfigParam configparam = new ConfigParam();
        	String configKey = data.get(i).get("configkey");
        	String configValue = data.get(i).get("configvalue");
        	configparam.setConfigkey(configKey);
        	configparam.setConfigvalue(configValue);
        	config.add(configparam);
        }
        List<ConfigParam> updatedconfig = updateConfig(config);
        return updatedconfig;
    }
    public static List<ConfigParam> updateConfig(List<ConfigParam> previousconfig) throws NoDataAvailableException {
        List<ConfigParam> Updatedconfig = new ArrayList<ConfigParam>();
        LinkedHashMap<String, String> temporaryMap = new LinkedHashMap<>();
        for (ConfigParam configData : previousconfig) {
        	ConfigParam configparam = new ConfigParam();
            String configKey = configData.getConfigkey();
            String configValue = configData.getConfigvalue();
        	configparam.setConfigkey(configKey);
        	configparam.setConfigvalue(configValue);
        	temporaryMap.put(configKey, configValue);
        }
        if (temporaryMap.get("Water use efficiency for rural").equalsIgnoreCase("no data available")) {
        	if (temporaryMap.get("Water use efficiency for urban").equalsIgnoreCase("no data available")) {
        		temporaryMap.put("Water use efficiency for Total", "No data available");
        	}
        	else {
        		temporaryMap.put("Water use efficiency for Total", temporaryMap.get("Water use efficiency for urban"));
        	}
        }
    	if (temporaryMap.get("Water use efficiency for urban").equalsIgnoreCase("no data available")) {
        	if (temporaryMap.get("Water use efficiency for rural").equalsIgnoreCase("no data available")) {
        		temporaryMap.put("Water use efficiency for Total", "No data available");
        	}
        	else {
        		temporaryMap.put("Water use efficiency for Total", temporaryMap.get("Water use efficiency for rural"));
        	}
        }
    	if(!(temporaryMap.get("Water use efficiency for rural").equalsIgnoreCase("no data available"))&&!(temporaryMap.get("Water use efficiency for urban").equalsIgnoreCase("no data available"))) {
    		if(temporaryMap.get("Water use efficiency for Total").equalsIgnoreCase("no data available")) {
    		throw new NoDataAvailableException();
    		}
    	}
    	if (temporaryMap.get("Water resource management for rural").equalsIgnoreCase("no data available")) {
        	if (temporaryMap.get("Water resource management for urban").equalsIgnoreCase("no data available")) {
        		temporaryMap.put("Water resource management for total", "No data available");
        	}
        	else {
        		temporaryMap.put("Water resource management for total", temporaryMap.get("Water resource management for urban"));
        	}
        }
    	if (temporaryMap.get("Water resource management for urban").equalsIgnoreCase("no data available")) {
        	if (temporaryMap.get("Water resource management for rural").equalsIgnoreCase("no data available")) {
        		temporaryMap.put("Water resource management for total", "No data available");
        	}
        	else {
        		temporaryMap.put("Water resource management for total", temporaryMap.get("Water resource management for rural"));
        	}
        }

    	if(!(temporaryMap.get("Water resource management for rural").equalsIgnoreCase("no data available"))&&!(temporaryMap.get("Water resource management for urban").equalsIgnoreCase("no data available"))) {
    		if(temporaryMap.get("Water resource management for total").equalsIgnoreCase("no data available")) {
    		throw new NoDataAvailableException();
    		}

    	}
    	

    	if (temporaryMap.get("Levels of waterstress for urban").equalsIgnoreCase("no data available")) {
        	if (temporaryMap.get("Levels of waterstress for rural").equalsIgnoreCase("no data available")) {
        		temporaryMap.put("Levels of waterstress for Total", "No data available");
        	}
        	else {
        		temporaryMap.put("Levels of waterstress for Total", temporaryMap.get("Levels of waterstress for rural"));
        	}
        }
    	if (temporaryMap.get("Levels of waterstress for rural").equalsIgnoreCase("no data available")) {
        	if (temporaryMap.get("Levels of waterstress for urban").equalsIgnoreCase("no data available")) {
        		temporaryMap.put("Levels of waterstress for Total", "No data available");
        	}
        	else {
        		temporaryMap.put("Levels of waterstress for Total", temporaryMap.get("Levels of waterstress for urban"));
        	}
        }
    	if(!(temporaryMap.get("Levels of waterstress for rural").equalsIgnoreCase("no data available"))&&!(temporaryMap.get("Levels of waterstress for urban").equalsIgnoreCase("no data available"))) {
    		if(temporaryMap.get("Levels of waterstress for Total").equalsIgnoreCase("no data available")) {
    		throw new NoDataAvailableException();
    		}

    	}
        	
    	
    	for(Map.Entry<String, String> entry : temporaryMap.entrySet()) {
        	ConfigParam updatedConfigParam= new ConfigParam();
    		String key = entry.getKey();
            String value = entry.getValue();
        	updatedConfigParam.setConfigkey(key);
        	updatedConfigParam.setConfigvalue(value);
        	Updatedconfig.add(updatedConfigParam);
    	}
        return Updatedconfig;
    }
}