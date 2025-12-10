package com.sdg.goals.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sdg.goals.model.SubTarget;

public interface SubTargetService {
    void save(MultipartFile file);
    List<SubTarget> getAllSubtargets();
	List<SubTarget> findAll();
}

