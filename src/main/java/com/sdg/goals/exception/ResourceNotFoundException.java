package com.sdg.goals.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResourceNotFoundException extends RuntimeException {
	private static final Logger logger = LoggerFactory.getLogger(ResourceNotFoundException.class);

    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String message) {
  	  super(message);
  	  logger.error("resource not found ");

    }
}

