package com.sdg.goals.service.impl;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sdg.goals.helper.SeventhGoalHelper;
import com.sdg.goals.model.SeventhGoal;
import com.sdg.goals.repository.SeventhGoalRepository;
import com.sdg.goals.service.SeventhGoalService;
@Service
public class SeventhGoalServiceImpl implements SeventhGoalService{
	private static final Logger logger = LoggerFactory.getLogger(SeventhGoalServiceImpl.class);

	@Autowired
	SeventhGoalRepository seventhGoalRepository;

	@Override
	public void save(MultipartFile file) {
	    try {
            List<SeventhGoal> goal7 = SeventhGoalHelper.excelToGoals(file.getInputStream(),file);
            seventhGoalRepository.deleteAll();
            seventhGoalRepository.saveAll(goal7);
      	     logger.info("Seventh goal values are saved to repository");

        } catch (IOException e) {
	    	logger.error("fail to save Seventh goal sheet",e);

            throw new RuntimeException("Failed to store the SEVENTH GOAL" + e.getMessage());
        }
	}
	
}
