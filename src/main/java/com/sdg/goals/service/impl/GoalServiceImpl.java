package com.sdg.goals.service.impl;



import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sdg.goals.exception.ResourceNotFoundException;
import com.sdg.goals.exception.UnknownGoalException;
import com.sdg.goals.helper.GoalHelper;
import com.sdg.goals.model.Goal;
import com.sdg.goals.model.SubTarget;
import com.sdg.goals.model.Target;
import com.sdg.goals.repository.GoalRepository;
import com.sdg.goals.service.DateService;
import com.sdg.goals.service.FirstGoalService;
import com.sdg.goals.service.GoalService;


@Service
public class GoalServiceImpl implements GoalService {
	private static final Logger logger = LoggerFactory.getLogger(GoalServiceImpl.class);
  @Autowired
  GoalRepository repository;
  @Autowired
  FirstGoalService firstGoalService;
  @Autowired
  DateService dateService;

  public void save(MultipartFile goalFile) {
    try {
      List<Goal> goals = GoalHelper.excelToGoals(goalFile.getInputStream(),goalFile);
      logger.info("Goals table has imported from GoalHelper");
      repository.deleteAll();

      repository.saveAll(goals);
      logger.info("Goal table saved to repository");
    } catch (IOException e) {
      throw new RuntimeException("fail to store goals data: "+e);
    }
  }

  public List<Goal> getAllGoals() {
	     logger.info("Successfully returned all the goals");

    return repository.findAll();
  }
  
  public Goal findById(int goalId) {
      Optional<Goal> goal = repository.findById(goalId);
      if (goal.isPresent()) {
 	     logger.info("successfully identified the goal");

          return goal.get();
      }
      return null;
  }
  @Override
  public Map<String, Object> getGoalDetails(int goalId) {
      Optional<Goal> optionalGoal = repository.findById(goalId);
      if (optionalGoal.isPresent()) {
          Goal goal = optionalGoal.get();
          List<Target> targets = goal.getTargets();

          List<List<Map<String, Object>>> subtargetsList = new ArrayList<>();

          for (Target target : targets) {
              List<Map<String, Object>> subtargets = new ArrayList<>();
              for (SubTarget subtarget : target.getSubtargets()) {
                  Map<String, Object> subtargetMap = new HashMap<>();
                  subtargetMap.put("subtargetId", subtarget.getSubtargetid());
                  subtargetMap.put("subtargetName", subtarget.getSubtargetname());
                  subtargets.add(subtargetMap);
              }
              subtargetsList.add(subtargets);
          }

          Map<String, Object> response = new HashMap<>();
          response.put("goalId", goal.getGoalid());
          response.put("goalName", goal.getGoalname());
          response.put("goaldescription", goal.getGoaldescription());
          List<Map<String, Object>> targetsList = new ArrayList<>();
          int i = 0;
          for (Target target : targets) {
              Map<String, Object> targetMap = new HashMap<>();
              targetMap.put("targetid", target.getTargetid());
              targetMap.put("targetname", target.getTargetname());
              targetMap.put("subtargets", subtargetsList.get(i));
              targetsList.add(targetMap);
              i++;
          }
          response.put("targets", targetsList);
 	     logger.info("goal details are returned successfully");

          return response;
      } else {
	    	logger.error("Unable to return goal details");

          throw new ResourceNotFoundException("Goal not found with id: " + goalId);
      }
  }
  @Override
  public List<Map<String, Object>> getPannelGoalDetails(int goalId) {
      Optional<Goal> optionalGoal = repository.findById(goalId);
      if (optionalGoal.isPresent()) {
	        Goal goal = optionalGoal.get();
	        List<Target> targets = goal.getTargets();
	        List<List<Map<String, Object>>> subtargetsList = new ArrayList<>();
	          for (Target target : targets) {
	              List<Map<String, Object>> subtargets = new ArrayList<>();
	              for (SubTarget subtarget : target.getSubtargets()) {
	                  Map<String, Object> subtargetMap = new HashMap<>();
	                  subtargetMap.put("name", subtarget.getSubtargetdescription());
	                  subtargets.add(subtargetMap);
	              }
	              subtargetsList.add(subtargets);
	          }
	          List<Map<String, Object>> targetsList = new ArrayList<>();
	          int i = 0;
	          for (Target target : targets) {
	              Map<String, Object> targetMap = new HashMap<>();
	              targetMap.put("header", "TARGET");
	              targetMap.put("number", target.getTargetname().substring(7));
	              targetMap.put("name", target.getTargetdescription());
	              targetMap.put("children", subtargetsList.get(i));
	              targetsList.add(targetMap);
	              i++;
	          }
	 	     logger.info("Panel details are returned successfully");

	          return targetsList;


      } else {
 	     logger.info("Unable to return paneldetails");

          throw new ResourceNotFoundException("Goal not found with id: " + goalId);
      }
  }
  
  @Override
  public Map<String, Object> getGoalDetail(int goalId) {
	    Optional<Goal> optionalGoal = repository.findById(goalId);
	    if (optionalGoal.isPresent()) {
	        Goal goal = optionalGoal.get();
	        List<Target> targets = goal.getTargets();

	        List<List<Map<String, Object>>> subtargetsList = new ArrayList<>();
	        for (Target target : targets) {
	        		
	        	
	            List<Map<String, Object>> subtargets = new ArrayList<>();
	            for (SubTarget subtarget : target.getSubtargets()) {
	            	if(subtarget.getStatus().equalsIgnoreCase("enable")) {
	                LinkedHashMap<String, Object> subtargetMap = new LinkedHashMap<>();
	                subtargetMap.put("display", subtarget.getSubtargetdescription()+" | "+subtarget.getSubtargetUnits());
	                subtargetMap.put("parent", target.getTargetname());
	                if(subtarget.getSubtargetdescription().trim().length()>=50) {
	                subtargetMap.put("name", subtarget.getSubtargetdescription().trim().substring(0, Math.min(subtarget.getSubtargetdescription().length(), 50))+".. |"+subtarget.getSubtargetUnits());
	                }
	                else {
		                subtargetMap.put("name", subtarget.getSubtargetdescription().trim()+" | "+subtarget.getSubtargetUnits());
	                }
	               
	                List<Map<String, Object>> dataValuesList = new ArrayList<>();
	               
	                for(int leafkey=0;leafkey<firstGoalService.getListSize(subtarget.getSubtargetid());leafkey++) {
	                	 try {
	                	LinkedHashMap<String, Object> dataValuesMap= new LinkedHashMap<>();
	                	dataValuesMap.put("name", firstGoalService.keyBySubtargetId(subtarget.getSubtargetid(),leafkey));
	                	if(firstGoalService.valueBySubtargetId(subtarget.getSubtargetid(),leafkey).toLowerCase().contains("no data available")) { 
    	                	dataValuesMap.put("value", firstGoalService.valueBySubtargetId(subtarget.getSubtargetid(),leafkey));
                    		dataValuesMap.put("display", firstGoalService.keyBySubtargetId(subtarget.getSubtargetid(),leafkey)+" "+firstGoalService.valueBySubtargetId(subtarget.getSubtargetid(),leafkey));
	                	}
	                	else {
	                		String valueString = firstGoalService.valueBySubtargetId(subtarget.getSubtargetid(),leafkey);
	                		if(valueString.trim().length()>=25) {
	                			valueString = valueString.substring(0, 25)+"..";
	                		}
	                		if(subtarget.getSubtargetUnits().equalsIgnoreCase("percent")) {
	    	                	dataValuesMap.put("value", valueString +"% ("+dateService.uploadedYear(subtarget.getSubtargetid())+")");
	                    		dataValuesMap.put("display", firstGoalService.keyBySubtargetId(subtarget.getSubtargetid(),leafkey)+" "+firstGoalService.valueBySubtargetId(subtarget.getSubtargetid(),leafkey) +"% ("+dateService.uploadedYear(subtarget.getSubtargetid())+")");

	                		}
	                		else if (subtarget.getSubtargetUnits().toLowerCase().contains("count")) {
	                			String leftpartString = firstGoalService.valueBySubtargetId(subtarget.getSubtargetid(),leafkey);
	                			int dotIndex = leftpartString.indexOf(".");
	                			if (dotIndex != -1) {
		    	                	dataValuesMap.put("value", firstGoalService.valueBySubtargetId(subtarget.getSubtargetid(),leafkey).substring(0, dotIndex)+" ("+dateService.uploadedYear(subtarget.getSubtargetid())+")");
		                    		dataValuesMap.put("display", firstGoalService.keyBySubtargetId(subtarget.getSubtargetid(),leafkey)+" "+firstGoalService.valueBySubtargetId(subtarget.getSubtargetid(),leafkey).substring(0, dotIndex)+" ("+dateService.uploadedYear(subtarget.getSubtargetid())+")");
	                		    }
	                			else {
	    	                	dataValuesMap.put("value", firstGoalService.valueBySubtargetId(subtarget.getSubtargetid(),leafkey)+" ("+dateService.uploadedYear(subtarget.getSubtargetid())+")");
	                    		dataValuesMap.put("display", firstGoalService.keyBySubtargetId(subtarget.getSubtargetid(),leafkey)+" "+firstGoalService.valueBySubtargetId(subtarget.getSubtargetid(),leafkey)+" ("+dateService.uploadedYear(subtarget.getSubtargetid())+")");
	                			}
	                		}
	                		else if(subtarget.getSubtargetUnits().toLowerCase().contains("hrs")){
	    	                	dataValuesMap.put("value", valueString +"Hrs ("+dateService.uploadedYear(subtarget.getSubtargetid())+")");
	                    		dataValuesMap.put("display", firstGoalService.keyBySubtargetId(subtarget.getSubtargetid(),leafkey)+" "+firstGoalService.valueBySubtargetId(subtarget.getSubtargetid(),leafkey) +"Hrs ("+dateService.uploadedYear(subtarget.getSubtargetid())+")");

	                		}
	                		else {
	    	                	dataValuesMap.put("value", valueString +" ("+dateService.uploadedYear(subtarget.getSubtargetid())+")");
	                    		dataValuesMap.put("display", firstGoalService.keyBySubtargetId(subtarget.getSubtargetid(),leafkey)+" "+firstGoalService.valueBySubtargetId(subtarget.getSubtargetid(),leafkey) +" ("+dateService.uploadedYear(subtarget.getSubtargetid())+")");
	                		}
	                		
	                		
	                		
	                		}
	                	dataValuesMap.put("parent", subtarget.getSubtargetname());
	                	dataValuesList.add(dataValuesMap);
	                }catch(UnknownGoalException e) {
	                	LinkedHashMap<String, Object> dataValuesMap= new LinkedHashMap<>();
                		dataValuesMap.put("display","No data available" );
	                	dataValuesMap.put("name", "No data available");
	                	dataValuesMap.put("parent", subtarget.getSubtargetname());
	                	dataValuesList.add(dataValuesMap);
	                	continue;
	                }
	                
	                }
	                subtargetMap.put("children", dataValuesList);
	                subtargets.add(subtargetMap);
	            }
	            }
	            subtargetsList.add(subtargets);
	        	
	        }

	        LinkedHashMap<String, Object> response = new LinkedHashMap<>();
	        response.put("display", goal.getGoaldescription());
	        response.put("parent", "null");
	        response.put("name", goal.getGoaldescription());
	        List<Map<String, Object>> targetsList = new ArrayList<>();
	        int i = 0;
	        for (Target target : targets) {
	        	if(!subtargetsList.get(i).isEmpty()) {
	            LinkedHashMap<String, Object> targetMap = new LinkedHashMap<>();
	            targetMap.put("name",target.getTargetname());
	            targetMap.put("display",target.getTargetname());
	            targetMap.put("parent",goal.getGoalname());
	            targetMap.put("children", subtargetsList.get(i));
	            targetsList.add(targetMap);
	        	}
	            i++;
	        }
	        response.put("children", targetsList);
		     logger.info("Tree goal details are returned successfully");

	        return response;
	    } else {
	        throw new ResourceNotFoundException("Goal not found with id: " + goalId);
	    }
	}  



}

