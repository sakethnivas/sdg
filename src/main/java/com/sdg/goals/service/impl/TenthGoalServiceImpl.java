package com.sdg.goals.service.impl;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sdg.goals.helper.TenthGoalHelper;
import com.sdg.goals.model.TenthGoal;
import com.sdg.goals.repository.TenthGoalRepository;
import com.sdg.goals.service.TenthGoalService;
@Service
public class TenthGoalServiceImpl implements TenthGoalService {
	private static final Logger logger = LoggerFactory.getLogger(TenthGoalServiceImpl.class);

@Autowired
TenthGoalRepository tenthGoalRepository;
	@Override
	public void save(MultipartFile file) {
		try {
            List<TenthGoal> goal10 = TenthGoalHelper.excelToGoals(file.getInputStream(),file);
            tenthGoalRepository.deleteAll();
            tenthGoalRepository.saveAll(goal10);
      	     logger.info("Tenth goal values are saved to repository");


        } catch (IOException e) {
	    	logger.error("fail to save Tenth goal sheet",e);

            throw new RuntimeException("Failed to store the Tenth GOAL" + e.getMessage());
        }
	}

}
