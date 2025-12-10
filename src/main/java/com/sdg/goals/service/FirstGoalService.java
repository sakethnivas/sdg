package com.sdg.goals.service;

import org.springframework.web.multipart.MultipartFile;

public interface FirstGoalService {
	void save(MultipartFile file);
	public String valueBySubtargetId(int Id, int Value);
	public int getListSize(int SGId);
	String keyBySubtargetId(int Id, int Value);

}
