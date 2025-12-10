package com.sdg.goals.service.impl;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sdg.goals.exception.UnknownGoalException;
import com.sdg.goals.helper.FirstGoalHelper;
import com.sdg.goals.helper.LeafNodeHelper;
import com.sdg.goals.model.FirstGoal;
import com.sdg.goals.repository.FirstGoalRepository;
import com.sdg.goals.service.FirstGoalService;
@Service
public class FirstGoalServiceImpl implements FirstGoalService{
	private static final Logger logger = LoggerFactory.getLogger(FirstGoalServiceImpl.class);

	@Autowired
    private FirstGoalRepository firstGoalRepository;
	
	@Autowired
	private LeafNodeHelper leafNodeHelper;
	
	
  	
  	
	@Override
    public void save(MultipartFile file) {
        try {
            List<FirstGoal> goal1 = FirstGoalHelper.excelToGoals(file.getInputStream(),file);
            firstGoalRepository.deleteAll();
            firstGoalRepository.saveAll(goal1);
      	     logger.info("First goal values are saved to repository");

        } catch (IOException e) {
	    	logger.error("fail to save First goal sheet",e);

            throw new RuntimeException("Failed to store the FIRST GOAL" + e.getMessage());
        }
    }
	//List<Long> iplCounts = firstGoalRepository.getIplCountByGenderAndAge();
	
	@Override
	public String valueBySubtargetId(int STId, int Value) {
		if(STId>0&&STId<22) {
				return leafNodeHelper.firstValueCalculations().get(STId).get(1).get(Value)+"";
			}
			else if(STId>21 && STId<39){
				return leafNodeHelper.secondValueCalculations().get(STId).get(1).get(Value)+"";
			}
			else if(STId>38 && STId<65){
				return leafNodeHelper.thirdValueCalculations().get(STId).get(1).get(Value)+"";
			}	
			else if(STId>64 && STId<124){
				return leafNodeHelper.fourthValueCalculations().get(STId).get(1).get(Value)+"";
			}
			else if(STId>123 && STId<164){
				return leafNodeHelper.fifthValueCalculations().get(STId).get(1).get(Value)+"";
			    }
			else if(STId>163 && STId<205) {
				return leafNodeHelper.sixthValueCalculations().get(STId).get(1).get(Value)+"";
			}
			else if(STId>204 && STId<210) {
				return leafNodeHelper.seventhValueCalculations().get(STId).get(1).get(Value)+"";
		    }
			else if(STId>209 && STId<236) {
				return leafNodeHelper.eigthValueCalculations().get(STId).get(1).get(Value)+"";
		    }
			else if(STId>235 && STId<255) {
				return leafNodeHelper.ninthValueCalculations().get(STId).get(1).get(Value)+"";
		    }
			else if(STId>254 && STId<275) {
				return leafNodeHelper.tenthValueCalculations().get(STId).get(1).get(Value)+"";
		    }
			else {
				throw new UnknownGoalException("Cannot extract the values for the goal which is'nt formulated yet");
			}
		}
	@Override
	public String keyBySubtargetId(int STId, int Value) {
		if(STId>0&&STId<22) {

				return leafNodeHelper.firstValueCalculations().get(STId).get(0).get(Value)+"";
			}
			else if(STId>21 && STId<39){
				return leafNodeHelper.secondValueCalculations().get(STId).get(0).get(Value)+"";
			}
			else if(STId>38 && STId<65){
				return leafNodeHelper.thirdValueCalculations().get(STId).get(0).get(Value)+"";
			}	
			else if(STId>64 && STId<124){
				return leafNodeHelper.fourthValueCalculations().get(STId).get(0).get(Value)+"";
			}
			else if(STId>123 && STId<164){
				return leafNodeHelper.fifthValueCalculations().get(STId).get(0).get(Value)+"";
			    }
			else if(STId>163 && STId<205) {
				return leafNodeHelper.sixthValueCalculations().get(STId).get(0).get(Value)+"";
			}
			else if(STId>204 && STId<210) {
				return leafNodeHelper.seventhValueCalculations().get(STId).get(0).get(Value)+"";
		    }
			else if(STId>209 && STId<236) {
				return leafNodeHelper.eigthValueCalculations().get(STId).get(0).get(Value)+"";
		    }
			else if(STId>235 && STId<255) {
				return leafNodeHelper.ninthValueCalculations().get(STId).get(0).get(Value)+"";
		    }
			else if(STId>254 && STId<275) {
				return leafNodeHelper.tenthValueCalculations().get(STId).get(0).get(Value)+"";
		    }
			else {
				throw new UnknownGoalException("Cannot extract the values for the goal which is'nt formulated yet");
			}
			}
	
	@Override
	public int getListSize(int STId) {
		if(STId>0&&STId<22) {
				return leafNodeHelper.firstValueCalculations().get(STId).get(0).size();
			}
			else if(STId>21 && STId<39){
				return leafNodeHelper.secondValueCalculations().get(STId).get(0).size();
			}
			else if(STId>38 && STId<65){
				return leafNodeHelper.thirdValueCalculations().get(STId).get(0).size();
			}
			else if(STId>64 && STId<124){
				return leafNodeHelper.fourthValueCalculations().get(STId).get(0).size();
			}
		    else if (STId>123 && STId<164){
			return leafNodeHelper.fifthValueCalculations().get(STId).get(0).size();
		    }
			else if(STId>163 && STId<205) {
				return leafNodeHelper.sixthValueCalculations().get(STId).get(0).size();
			}
			else if(STId>204 && STId<210) {
				return leafNodeHelper.seventhValueCalculations().get(STId).get(0).size();
		    }
			else if(STId>209 && STId<236) {
				return leafNodeHelper.eigthValueCalculations().get(STId).get(0).size();
		    }
			else if(STId>235 && STId<255) {
				return leafNodeHelper.ninthValueCalculations().get(STId).get(0).size();
		    }
			else if(STId>254 && STId<275) {
				return leafNodeHelper.tenthValueCalculations().get(STId).get(0).size();
		    }
		    else {
		    	return 1;
		    }
		    
	}

	
}