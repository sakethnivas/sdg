package com.sdg.goals.service.impl;
import java.io.InputStream;
import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sdg.goals.helper.GoalHelper;
import com.sdg.goals.service.EigthGoalService;
import com.sdg.goals.service.FifthGoalService;
import com.sdg.goals.service.FirstGoalService;
import com.sdg.goals.service.FourthGoalService;
import com.sdg.goals.service.GoalService;
import com.sdg.goals.service.NinthGoalService;
import com.sdg.goals.service.SecondGoalService;
import com.sdg.goals.service.SeventhGoalService;
import com.sdg.goals.service.SixthGoalService;
import com.sdg.goals.service.SubTargetService;
import com.sdg.goals.service.TargetService;
import com.sdg.goals.service.TenthGoalService;
import com.sdg.goals.service.ThirdGoalService;
import com.sdg.goals.service.UploadService;

@Service
public class UploadServiceImpl implements UploadService {
	private static final Logger logger = LoggerFactory.getLogger(UploadServiceImpl.class);

    @Autowired
    private GoalService goalService;

    @Autowired
    private TargetService targetService;

    @Autowired
    private SubTargetService subtargetService;
    
    @Autowired
    private FirstGoalService firstGoalService;
    
    @Autowired
    private SecondGoalService secondGoalService;
    
    @Autowired
    private ThirdGoalService thirdGoalService;
    
    @Autowired
    private FourthGoalService fourthGoalService;
    @Autowired
    private FifthGoalService fifthGoalService;
    @Autowired
    private SixthGoalService sixthGoalService;
    @Autowired
    private SeventhGoalService seventhGoalService;
    @Autowired
    private EigthGoalService eigthGoalService;
    @Autowired
    private NinthGoalService ninthGoalService;
    @Autowired
    private TenthGoalService tenthGoalService;
    @Autowired
    public  GoalHelper goalHelper;

    @Override
    public void uploadSheets(MultipartFile file, Map<String, String> errors) throws Exception {
        if (!hasExcelFormat1(file)) {
            errors.put("formatError", "Please upload an excel file for " + file.getOriginalFilename()+ "data!");
            return;
        }
        Workbook workbook = null;
        try (InputStream inputStream = file.getInputStream()) {
            workbook = WorkbookFactory.create(inputStream);
            String sheetname = workbook.getSheetName(0);
            if (sheetname.equals("GOALS")) {
                if (workbook.getNumberOfSheets() == 3&&workbook.getSheetName(1).equals("TARGETS")&&workbook.getSheetName(2).equals("SUB TARGETS")) {
                    goalService.save(file);
                    targetService.save(file);
                    subtargetService.save(file);
                } else {
                    errors.put("SheetError", "All Three Sheets Should Be Present with names [GOALS,TARGETS,SUB TARGETS] If The Excel File Contains Goals Sheet");
                    return;
                }
            } else {
                switch (sheetname) {
                    case "GOALS":
                        break;
                    case "GOAL1":

                        firstGoalService.save(file);
                 	     logger.info("successfully uploaded ",sheetname);

                        break;
                    case "GOAL2":
                        secondGoalService.save(file);
                 	     logger.info("successfully uploaded ",sheetname);

                        break;
                    case "GOAL3":
                        thirdGoalService.save(file);
                 	     logger.info("successfully uploaded ",sheetname);

                        break;
                    case "GOAL4":
                        fourthGoalService.save(file);
                 	     logger.info("successfully uploaded ",sheetname);

                        break;
                    case "GOAL5":
                        fifthGoalService.save(file);
                 	     logger.info("successfully uploaded ",sheetname);

                        break;
                    case "GOAL6":
                    	sixthGoalService.save(file);
                 	     logger.info("successfully uploaded ",sheetname);

                    	break;
                    case "GOAL7":
                    	seventhGoalService.save(file);
                 	     logger.info("successfully uploaded ",sheetname);

                    	break;
                    case "GOAL8":
                    	eigthGoalService.save(file);
                 	     logger.info("successfully uploaded ",sheetname);

                    	break;
                    case "GOAL9":
                    	ninthGoalService.save(file);
                 	     logger.info("successfully uploaded ",sheetname);

                    	break;
                    case "GOAL10":
                    	tenthGoalService.save(file);
                 	     logger.info("successfully uploaded ",sheetname);

                    	break;
                    default:
                  	     logger.info("Invalid sheet name",sheetname);

                        errors.put("sheetError", "Invalid sheet name specified: "+sheetname);
                        return;
                }
            }
        } catch (Exception e) {
	    	logger.error("Unable to upload the file ",e);

            errors.put("UploadError",e.getMessage());
            return;
        } finally {
            if (workbook != null) {
                workbook.close();
            }
        }
    }
    

    


    @Override
	public boolean hasExcelFormat1(MultipartFile file) {
		
		return goalHelper.hasExcelFormat1(file);
	}

	

	
   
}