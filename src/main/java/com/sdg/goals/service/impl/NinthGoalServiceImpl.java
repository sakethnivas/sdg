package com.sdg.goals.service.impl;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sdg.goals.helper.NinthGoalHelper;
import com.sdg.goals.model.NinthGoal;
import com.sdg.goals.repository.NinthGoalRepository;
import com.sdg.goals.service.NinthGoalService;
@Service 
public class NinthGoalServiceImpl implements NinthGoalService {
	private static final Logger logger = LoggerFactory.getLogger(NinthGoalServiceImpl.class);

	@Autowired
	NinthGoalRepository ninthGoalRepository;

	@Override
	public void save(MultipartFile file) {
	    try {
            List<NinthGoal> goal9 = NinthGoalHelper.excelToGoals(file.getInputStream(),file);
            ninthGoalRepository.deleteAll();
            ninthGoalRepository.saveAll(goal9);
      	     logger.info("Ninth goal values are saved to repository");


        } catch (IOException e) {
	    	logger.error("fail to save Ninth goal sheet",e);

            throw new RuntimeException("Failed to store the Tenth GOAL" + e.getMessage());
        }
	}
	

}
