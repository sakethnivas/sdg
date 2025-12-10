package com.sdg.goals.service.impl;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sdg.goals.helper.SecondGoalHelper;
import com.sdg.goals.model.SecondGoal;
import com.sdg.goals.repository.SecondGoalRepository;
import com.sdg.goals.service.SecondGoalService;
@Service
public class SecondGoalServiceImpl implements SecondGoalService{
	private static final Logger logger = LoggerFactory.getLogger(SecondGoalServiceImpl.class);

	@Autowired
    private SecondGoalRepository secondGoalRepository;

	@Override
    public void save(MultipartFile file) {
        try {
            List<SecondGoal> goal2 = SecondGoalHelper.excelToGoals(file.getInputStream(),file);
            secondGoalRepository.deleteAll();
            secondGoalRepository.saveAll(goal2);
      	     logger.info("Second goal values are saved to repository");


        } catch (IOException e) {
	    	logger.error("fail to save Second goal sheet",e);

            throw new RuntimeException("Failed to store the SECOND GOAL" + e.getMessage());
        }
    }
	
}
