package com.sdg.goals.message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class ResponseMessage {
	private static final Logger logger = LoggerFactory.getLogger(ResponseMessage.class);

	  private String message;

	  public ResponseMessage(String message) {
	    this.message = message;
	  }

	  public String getMessage() {
		     logger.info("Response Message returned successfully");

	    return message;
	  }

	  public void setMessage(String message) {
	    this.message = message;
	  }

	}