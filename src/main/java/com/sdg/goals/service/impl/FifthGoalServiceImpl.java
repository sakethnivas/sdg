package com.sdg.goals.service.impl;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sdg.goals.helper.FifthGoalHelper;
import com.sdg.goals.model.FifthGoal;
import com.sdg.goals.repository.FifthGoalRepository;
import com.sdg.goals.service.FifthGoalService;
@Service
public class FifthGoalServiceImpl implements FifthGoalService {
	private static final Logger logger = LoggerFactory.getLogger(FifthGoalServiceImpl.class);

	@Autowired
   
    private FifthGoalRepository fifthGoalRepository;

	

	@Override
    public void save(MultipartFile file) {
        try {
            List<FifthGoal> goal5 = FifthGoalHelper.excelToGoals(file.getInputStream(),file);
            fifthGoalRepository.deleteAll();
            fifthGoalRepository.saveAll(goal5);
      	     logger.info("Fifth goal values are saved to repository");

        } catch (IOException e) {
	    	logger.error("fail to save Fifth goal sheet",e);

            throw new RuntimeException("Failed to store the FIFTH GOAL" + e.getMessage());
        }
    }
	
}
