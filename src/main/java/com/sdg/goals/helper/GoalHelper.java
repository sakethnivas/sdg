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
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.sdg.goals.model.Goal;


@Component
public class GoalHelper {
  public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
  
  

  public static boolean hasExcelFormat(MultipartFile goalFile) {
	  
	    if (!TYPE.equals(goalFile.getContentType())) {
	      return false;
	    }

	    return true;
	  }

	  public static List<Goal> excelToGoals(InputStream is,MultipartFile file) {
	    try {
	    	
	     
	      Workbook workbook = new XSSFWorkbook(is);

	      Sheet sheet = workbook.getSheetAt(0);
	     
	      Iterator<Row> rows = sheet.iterator();
	      List<Goal> goals = new ArrayList<Goal>();
//
	      Row headerRow = sheet.getRow(0);
	        List<String> headerNames = new ArrayList<>();
	        Map<String, String> errorMap = new HashMap<>();
		       Map<String, String> headerMap = new HashMap<>();
		       headerMap.put("goalid","GoalId");
		       headerMap.put("goalname","GoalName");
		       headerMap.put("goaldescription","GoalDescription");


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
	        System.out.println(headerNames);
	      int rowNumber = 0;
	      while (rows.hasNext()) {
	        Row currentRow = rows.next();
	        if (rowNumber==0) {
				rowNumber++;
				continue;
			}
	      

	        Iterator<Cell> cellsInRow = currentRow.iterator();
	        


	        Goal goal = new Goal();

//	        int cellIdx = 0;
	        for(String head:headerNames) {
	          Cell currentCell = cellsInRow.next();

	          switch (head) {
	          case "goalid":
	        	  if(currentCell.getCellType()==CellType.NUMERIC) {
	            goal.setGoalid((int) currentCell.getNumericCellValue());
	        	  }
	        	  else {
	        		  errorMap.put("GoalId","Invalid value, must be a number , at row "+(currentCell.getRowIndex()+1)+" in Sheet "+sheet.getSheetName()+" in ["+file.getOriginalFilename()+"]");
	        	  }
	            break;

	          case "goalname":
	        	  if(currentCell.getCellType()==CellType.STRING) {
	            goal.setGoalname(currentCell.getStringCellValue());
	        	  }
	        	  else {
	        		  errorMap.put("GoalName", "Invalid value, must be a text , at row "+(currentCell.getRowIndex()+1)+" in Sheet "+sheet.getSheetName()+" in ["+file.getOriginalFilename()+"]");
	        	  }
	            break;
	          case "goaldescription":
	        	  if(currentCell.getCellType()==CellType.STRING) {
	            goal.setGoaldescription(currentCell.getStringCellValue());
	        	  }
	        	  else {
	        		  errorMap.put("GoalDescription", "Invalid value, must be a text , at row "+(currentCell.getRowIndex()+1)+" in Sheet "+sheet.getSheetName()+" in ["+file.getOriginalFilename()+"]");
				}
	            break;

	           default:
	            break;
	          }

	        }

	        goals.add(goal);
	      }

	      workbook.close();
	      if (!errorMap.isEmpty()) {
	            throw new RuntimeException(errorMap.toString());
	        }
	   return goals;
	    } catch (IOException e) {
	      throw new RuntimeException("fail to parse Goals sheet: " + e.getMessage());
	    }
	  }
	 

	public boolean hasExcelFormat1(MultipartFile file) {
		 String contentType = file.getContentType();
	        return contentType != null && (
	                contentType.equals("application/vnd.ms-excel") || contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
	        );
	}

	
	}