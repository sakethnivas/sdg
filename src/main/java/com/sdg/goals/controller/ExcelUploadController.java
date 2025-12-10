package com.sdg.goals.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sdg.goals.dto.UserDTO;
import com.sdg.goals.exception.NoDataAvailableException;
import com.sdg.goals.helper.FirstGoalHelper;
import com.sdg.goals.model.Goal;
import com.sdg.goals.repository.FirstGoalRepository;
import com.sdg.goals.repository.ThirdGoalRepository;
import com.sdg.goals.service.ConfigParamService;
import com.sdg.goals.service.FirstGoalService;
import com.sdg.goals.service.GoalService;
import com.sdg.goals.service.SubTargetService;
import com.sdg.goals.service.TargetService;
import com.sdg.goals.service.UploadService;
import com.sdg.goals.service.UserService;

@CrossOrigin(origins={"*"})
@RestController
@RequestMapping("/api/excel")
public class ExcelUploadController {
	private static final Logger logger = LoggerFactory.getLogger(ExcelUploadController.class);
	  @Autowired
	  GoalService goalService;
	  @Autowired
	  TargetService targetService;
	  @Autowired
	  SubTargetService subtargetService;
	  
	  @Autowired
	  FirstGoalService firstGoalService;
	  @Autowired
	  UploadService uploadService;
	  @Autowired
	  ThirdGoalRepository thirdGoalRepository;
		
	  @Autowired
	 private UserService userService;
	  @Autowired
	  	FirstGoalRepository frep;
	  @Autowired
	  ConfigParamService configParamService;
	  
	  @PostMapping("/configdata")
	    public ResponseEntity<String> createConfig(@RequestBody List<Map<String, String>> data) {
		  try {
		  configParamService.updatedata(data);
		  logger.info("Successfully updated the config data");
	        return ResponseEntity.status(HttpStatus.OK).body("Data updated successfully");
		  } catch (NoDataAvailableException e) {
			  logger.info("The total must be specified if both rural and urban are specified");
			  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The total must be specified if both rural and urban are specified");
		}

	  }
	  @GetMapping("/getconfig")
	  public ResponseEntity<List<Map<String, Object>>> getAllConfigs() {
	      List<Map<String, Object>> configdata = configParamService.previousdata();
	      return ResponseEntity.ok().body(configdata);
	  }
	    @PostMapping("/create/user")
	    public ResponseEntity<String> createUser(@RequestBody Map<String, String> request) {
	        String username = request.get("username");
	        String password = request.get("password");
	        
	        // Check if the user already exists
	        if (userService.getUserByUsername(username) != null) {
	  	      logger.info("User already exists");
	            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists");
	        }

	       
	        // Create the new user
	        UserDTO userDTO = new UserDTO(username, password);
	        userService.createUser(userDTO);
		      logger.info("User created successfully");
	        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
	    }
	    
	    @PostMapping("/login")
	    public ResponseEntity<String> loginUser(@RequestBody Map<String, String> request) {
	        String username = request.get("username");
	        String password = request.get("password");
	        
	        // Check if the user already exists
	        if (userService.getUserByUsername(username) != null) {
	         //   return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists");
	        	if (userService.isUserAuthorized(username, password)) {
	      	      logger.info("login successfull");

	        		return ResponseEntity.status(HttpStatus.OK).body("login successful");
	        		
	        	}
	        	logger.info("Invalid username or password");
	        	return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
	        }
        	logger.info("Invalid username or password");

        	return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
	        
	    }
	    @PostMapping("/upload")
	    public ResponseEntity<String> uploadFiles(@RequestParam("file") MultipartFile file) {
	        Map<String, String> errors = new HashMap<>();
	        // if(file.getSize()>2097152) {
            //     return ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE).body("File is very large to uplaod");

        	// }

	        if (FirstGoalHelper.hasExcelFormat(file)) {
	            try {
	            	uploadService.uploadSheets(file, errors);
	                
	                if (!errors.isEmpty()) {
	    	        	logger.info("Errors uploading file: " + errors);

	                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors.values().toString().replace("=", " : ").replaceAll("[{}]", "").replaceFirst("\\[", "").replaceFirst("]$", ""));
	                }
	  		      logger.info("File uploaded successfully" + file.getOriginalFilename());

	  	        return ResponseEntity.status(HttpStatus.OK).body("File uploaded successfully: " + file.getOriginalFilename());

	            }
	            catch (Exception e) {
		        	logger.info("Error uploading file: " + e.getMessage());

	                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading file: " + e.getMessage());
	            }
	        } else {
	            errors.put("FormatError", "Only Excel files are allowed");
	        	logger.info("Errors uploading file: " + errors);
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors.toString().replace("=", " : ").replaceAll("[{}]", ""));
	        }
	    }
	  
	  @GetMapping("/goals/{goalid}")
	    public ResponseEntity<Map<String, Object>> getGoalDetails(@PathVariable("goalid") int goalId) {
	        Map<String, Object> response = goalService.getGoalDetails(goalId);
	        return ResponseEntity.ok(response);
	    }
	  
	  @GetMapping("/treegoals/{goalid}")
	    public ResponseEntity<Map<String, Object>> getGoalDetail(@PathVariable("goalid") int goalId) {
	        Map<String, Object> response = goalService.getGoalDetail(goalId);
	        return ResponseEntity.ok(response);
	    }
	  @GetMapping("/panelgoals/{goalid}")
	    public ResponseEntity<List<Map<String, Object>>> getpanelGoalDetail(@PathVariable("goalid") int goalId) {
		  List<Map<String, Object>> response = goalService.getPannelGoalDetails(goalId);
	        return ResponseEntity.ok(response);
	    }

	  
	    
	   @GetMapping("/goals")
		  public ResponseEntity<List<Goal>> getAllGoals() {
		    try { List<Goal> goals = goalService.getAllGoals();
		    	if (goals.isEmpty()) {
			        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      } 
		      return new ResponseEntity<>(goals, HttpStatus.OK);
		    } catch (Exception e) {
		    	
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		  }
	   

	  
	
}
