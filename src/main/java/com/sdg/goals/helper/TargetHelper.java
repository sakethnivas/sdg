package com.sdg.goals.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.sdg.goals.model.Goal;
import com.sdg.goals.model.Target;
import com.sdg.goals.service.GoalService;



public class TargetHelper {
	private static final Logger logger = LoggerFactory.getLogger(TargetHelper.class);
	@Autowired
	 public  GoalService goalservice;
  public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
  

  public static  boolean hasExcelFormat(MultipartFile file) {

	    if (!TYPE.equals(file.getContentType())) {
	      return false;
	    }

	    return true;
	  }

	  public static  List<Target> excelToTargets(InputStream is,MultipartFile file) {
	    try {
	    	
	     
	      Workbook workbook = new XSSFWorkbook(is);

	      Sheet sheet = workbook.getSheetAt(1);
	     
	      Iterator<Row> rows = sheet.iterator();
	      List<Target> targets = new ArrayList<Target>();
	      Row headerRow = sheet.getRow(0);
	        List<String> headerNames = new ArrayList<>();
	        Map<String, String> errorMap = new HashMap<>();
		       Map<String, String> headerMap = new HashMap<>();
		       headerMap.put("targetid","TargetId");
		       headerMap.put("targetname","TargetName");
		       headerMap.put("targetdescription","TargetDescription");
		       headerMap.put("goalid","GoalId");

	        for (Cell cell : headerRow) {
	            String cellValue = cell.getStringCellValue().replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
	            if(headerNames.contains(cellValue)) {
	            	errorMap.put("HeaderRepeatError", "Header name repeated: "+headerMap.get(cellValue));
	            	workbook.close();
		            throw new RuntimeException(errorMap.toString());
	            }

	            headerNames.add(cellValue);
	        }
		       List<String> mandatoryHeaderList = new ArrayList<>(headerMap.keySet());
		        List<String> notFoundList = new ArrayList<>();
		        for (String str : mandatoryHeaderList) {
		            if (!headerNames.contains(str)) {
		                notFoundList.add(headerMap.get(str));
		            }
		        }
		       if (!headerNames.containsAll(mandatoryHeaderList)) {
		    	   	errorMap.put("ColumnNotFoundError",notFoundList.toString());
		       }
	      int rowNumber = 0;
	      while (rows.hasNext()) {
	        Row currentRow = rows.next();

	        if (rowNumber == 0) {
	          rowNumber++;
	          continue;
	        }

	        Iterator<Cell> cellsInRow = currentRow.iterator();

	        Target target = new Target();

//	        int cellIdx = 0;
	        for(String head:headerNames) {
		          Cell currentCell = cellsInRow.next();

		          switch (head) {
	        
	          case "targetid":
	        	  	if (currentCell.getCellType()==CellType.NUMERIC) {
			            target.setTargetid((int)currentCell.getNumericCellValue());
					}
	        	  	else {
		        		  errorMap.put("TargetId", "Invalid value, must be a number , at row "+(currentCell.getRowIndex()+1)+" in Sheet "+sheet.getSheetName()+" in ["+file.getOriginalFilename()+"]");
					}
		            break;
		             
	          case "targetname":
	        	  if (currentCell.getCellType()==CellType.STRING) {
					target.setTargetname(currentCell.getStringCellValue());
				}
		            
		            else {
		        		  errorMap.put("TargetName", "Invalid value, must be a text , at row "+(currentCell.getRowIndex()+1)+" in Sheet "+sheet.getSheetName()+" in ["+file.getOriginalFilename()+"]");
					}
		            break; 
		            
	          case "targetdescription":
	        	  if (currentCell.getCellType()==CellType.STRING) {
								         target.setTargetdescription(currentCell.getStringCellValue());

				}
			         else {
		        		  errorMap.put("TargetDescription", "Invalid value, must be a text , at row "+(currentCell.getRowIndex()+1)+" in Sheet "+sheet.getSheetName()+" in ["+file.getOriginalFilename()+"]");

					}
			         break;
		      
	          case "goalid":
	        	  if (currentCell.getCellType()==CellType.NUMERIC) {
					int goalId = (int) currentCell.getNumericCellValue();
	              Goal goal = new Goal();
	              target.setGoal(goal);
	              target.setGoalid(goalId);
				}
	              
	              else {
	        		  errorMap.put("GoalId", "Invalid value, must be a number , at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
				}
	              break;
		            
	          
	          default:
	            break;
	          }

//	          cellIdx++;
	        }

	        targets.add(target);
	      }

	      workbook.close();
	      logger.info("Targets sheet has exported to TargetService successfully");
	      if (!errorMap.isEmpty()) {
	            throw new RuntimeException(errorMap.toString());
	        }
	   return targets;
	    } catch (IOException e) {
	    	logger.error("fail to parse targets sheet",e);
	      throw new RuntimeException("fail to parse targets sheet: " + e.getMessage());
	    }
	  }
	}