package com.sdg.goals.service.impl;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sdg.goals.helper.EigthGoalHelper;
import com.sdg.goals.model.EigthGoal;
import com.sdg.goals.repository.EigthGoalRepository;
import com.sdg.goals.service.EigthGoalService;
@Service
public class EigthGoalServiceImpl implements EigthGoalService{
	private static final Logger logger = LoggerFactory.getLogger(EigthGoalServiceImpl.class);

	@Autowired
	EigthGoalRepository eigthGoalRepository;
	@Override
	public void save(MultipartFile file) {
        try {
            List<EigthGoal> goal8 = EigthGoalHelper.excelToGoals(file.getInputStream(),file);
            eigthGoalRepository.deleteAll();
            eigthGoalRepository.saveAll(goal8);
   	     logger.info("Eigth goal values are saved to repository");


        } catch (IOException e) {
	    	logger.error("fail to save Eigth goal sheet",e);

            throw new RuntimeException("Failed to store the EIGTH GOAL" + e.getMessage());
        }

	}

}
