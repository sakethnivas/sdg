package com.sdg.goals.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    void uploadSheets(MultipartFile file, Map<String, String> errors) throws Exception;
    boolean hasExcelFormat1(MultipartFile file);
}