package com.sdg.goals.service.impl;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sdg.goals.helper.ThirdGoalHelper;
import com.sdg.goals.model.ThirdGoal;
import com.sdg.goals.repository.ThirdGoalRepository;
import com.sdg.goals.service.ThirdGoalService;

@Service
public class ThirdGoalServiceImpl implements ThirdGoalService {
	private static final Logger logger = LoggerFactory.getLogger(ThirdGoalServiceImpl.class);

	@Autowired
    private ThirdGoalRepository thirdGoalRepository;

	@Override
    public void save(MultipartFile file) {
        try {
            List<ThirdGoal> goal3 = ThirdGoalHelper.excelToGoals(file.getInputStream(),file);
            thirdGoalRepository.deleteAll();
            thirdGoalRepository.saveAll(goal3);
      	     logger.info("Third goal values are saved to repository");


        } catch (IOException e) {
	    	logger.error("fail to save Third goal sheet",e);

            throw new RuntimeException("Failed to store the THIRD GOAL" + e.getMessage());
        }
    }
	


}
