package com.sdg.goals.service.impl;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sdg.goals.helper.SixthGoalHelper;
import com.sdg.goals.model.SixthGoal;
import com.sdg.goals.repository.SixthGoalRepository;
import com.sdg.goals.service.SixthGoalService;
@Service
public class SixthGoalServiceImpl implements SixthGoalService {
	private static final Logger logger = LoggerFactory.getLogger(SixthGoalServiceImpl.class);

	@Autowired
	SixthGoalRepository sixthGoalRepository;

	@Override
	public void save(MultipartFile file) {
	    try {
            List<SixthGoal> goal6 = SixthGoalHelper.excelToGoals(file.getInputStream(),file);
            sixthGoalRepository.deleteAll();
            sixthGoalRepository.saveAll(goal6);
      	     logger.info("sixth goal values are saved to repository");


        } catch (IOException e) {
	    	logger.error("fail to save Sixth goal sheet",e);

            throw new RuntimeException("Failed to store the SECOND GOAL" + e.getMessage());
        }
	}
	
}
