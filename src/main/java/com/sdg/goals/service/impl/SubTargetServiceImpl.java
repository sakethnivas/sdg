package com.sdg.goals.service.impl;



import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sdg.goals.helper.SubTargetHelper;
import com.sdg.goals.model.SubTarget;
import com.sdg.goals.repository.SubTargetRepository;
import com.sdg.goals.service.SubTargetService;



@Service
public class SubTargetServiceImpl implements SubTargetService {
	private static final Logger logger = LoggerFactory.getLogger(SubTargetServiceImpl.class);

  @Autowired
  SubTargetRepository repository;

  public void save(MultipartFile file) {
    try {
      List<SubTarget> subtargets = SubTargetHelper.excelToSubTargets(file.getInputStream(),file);
      logger.info("Subtargets table has imported from SubTargetHelper");
      repository.deleteAll();

      repository.saveAll(subtargets);
      logger.info("Subtargets table saved to repository");
    } catch (IOException e) {
        throw new RuntimeException("fail to store Subtargets data: " + e.getMessage());
    }
  }

  public List<SubTarget> getAllSubtargets() {
    return repository.findAll();
  }

@Override
public List<SubTarget> findAll() {
	return repository.findAll();
}


}

