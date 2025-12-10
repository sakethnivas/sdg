package com.sdg.goals.service.impl;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sdg.goals.helper.FourthGoalHelper;
import com.sdg.goals.model.FourthGoal;
import com.sdg.goals.repository.FourthGoalRepository;
import com.sdg.goals.service.FourthGoalService;
@Service
public class FourthGoalServiceImpl implements FourthGoalService {
	private static final Logger logger = LoggerFactory.getLogger(FourthGoalServiceImpl.class);

	@Autowired
	FourthGoalRepository fourthGoalRepository;

	@Override
	public void save(MultipartFile file) {
	    try {
            List<FourthGoal> goal4 = FourthGoalHelper.excelToGoals(file.getInputStream(),file);
            fourthGoalRepository.deleteAll();
            fourthGoalRepository.saveAll(goal4);
      	     logger.info("Fourth goal values are saved to repository");

        } catch (IOException e) {
	    	logger.error("fail to save Fourth goal sheet",e);

            throw new RuntimeException("Failed to store the SECOND GOAL" + e.getMessage());
        }
	}
	

}
