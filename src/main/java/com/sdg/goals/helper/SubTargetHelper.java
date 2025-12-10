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

import com.sdg.goals.model.SubTarget;
import com.sdg.goals.model.Target;
import com.sdg.goals.service.TargetService;


public class SubTargetHelper {
	private static final Logger logger = LoggerFactory.getLogger(SubTargetHelper.class);
	@Autowired
	public
	TargetService targetservice;
  public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
  

  public static boolean hasExcelFormat(MultipartFile file) {

	    if (!TYPE.equals(file.getContentType())) {
	      return false;
	    }

	    return true;
	  }

	  public static List<SubTarget> excelToSubTargets(InputStream is,MultipartFile file) {
	    try {
	    	
	     
	      Workbook workbook = new XSSFWorkbook(is);
	        Map<String, String> errorMap = new HashMap<>();
//	      if(workbook.getSheetName(2).equals("SUB TARGETS")) {
//	    	  System.out.println("err===============================");
//	    	  errorMap.put("SheetError","invalid ");
//	      }
	      Sheet sheet = workbook.getSheetAt(2);
	     
	      Iterator<Row> rows = sheet.iterator();
	      List<SubTarget> subtargets = new ArrayList<SubTarget>();
	      Row headerRow = sheet.getRow(0);
	        List<String> headerNames = new ArrayList<>();

	        Map<String, String> headerMap = new HashMap<>();
		       headerMap.put("subtargetid","SubTargetId");
		       headerMap.put("subtargetname","SubTargetName");
		       headerMap.put("subtargetdescription","SubTargetDescription");
		       headerMap.put("units","Units");
		       headerMap.put("targetid","TargetID");
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

	        SubTarget subtarget = new SubTarget();

//	        int cellIdx = 0;
	        for(String head:headerNames) {
		          Cell currentCell = cellsInRow.next();

		          switch (head) {
	          case "subtargetid":
	        	  if (currentCell.getCellType()==CellType.NUMERIC) {
	        	  subtarget.setSubtargetid((int) currentCell.getNumericCellValue());
	        	  }
	        	  else {
	        		  errorMap.put("TargetId", "Invalid value, must be a number , at row "+(currentCell.getRowIndex()+1)+" in Sheet "+sheet.getSheetName()+" in ["+file.getOriginalFilename()+"]");
				}
	            break;
	          case "subtargetname":
	        	  if (currentCell.getCellType()==CellType.STRING) {
	        	  subtarget.setSubtargetname(currentCell.getStringCellValue());
	        	  }
	        	  else {
	        		  errorMap.put("TargetId", "Invalid value, must be a text , at row "+(currentCell.getRowIndex()+1)+" in Sheet "+sheet.getSheetName()+" in ["+file.getOriginalFilename()+"]");
				}
		            break;
	          case "subtargetdescription":
	        	  if (currentCell.getCellType()==CellType.STRING) {
	        	  subtarget.setSubtargetdescription(currentCell.getStringCellValue());
	        	  }
	        	  else {
	        		  errorMap.put("TargetId", "Invalid value, must be a text , at row "+(currentCell.getRowIndex()+1)+" in Sheet "+sheet.getSheetName()+" in ["+file.getOriginalFilename()+"]");
				}
		            break;
	          case "status":
	        	  if (currentCell.getCellType()==CellType.STRING) {
	        	  subtarget.setStatus(currentCell.getStringCellValue());
	        	  }
	        	  else {
	        		  errorMap.put("TargetId", "Invalid value, must be a text , at row "+(currentCell.getRowIndex()+1)+" in Sheet "+sheet.getSheetName()+" in ["+file.getOriginalFilename()+"]");
				}
	        	  break;
	          case "units":
	        	  if (currentCell.getCellType()==CellType.STRING) {
	        	  subtarget.setSubtargetUnits(currentCell.getStringCellValue());
	        	  }
	        	  else {
	        		  errorMap.put("TargetId", "Invalid value, must be a text , at row "+(currentCell.getRowIndex()+1)+" in Sheet "+sheet.getSheetName()+" in ["+file.getOriginalFilename()+"]");
				}
		            break;
	          case "targetid":
	        	  if (currentCell.getCellType()==CellType.NUMERIC) {
	        	  int targetId = (int) currentCell.getNumericCellValue();
	              Target target = new Target();
	              subtarget.setTarget(target);
	              subtarget.setTargetid(targetId);
	        	  }
	              else {
	        		  errorMap.put("TargetId", "Invalid value, must be a number , at row "+(currentCell.getRowIndex()+1)+" in Sheet "+sheet.getSheetName()+" in ["+file.getOriginalFilename()+"]");
				}
	              break; 
	          default:
	            break;
	          }

//	          cellIdx++;
	        }

	        subtargets.add(subtarget);
	      }

	      workbook.close();
	      logger.info("Subtargets sheet has exported to SubTargetService successfully");
	      if (!errorMap.isEmpty()) {
	            throw new RuntimeException(errorMap.toString());
	        }
	   return subtargets;
	    } catch (IOException e) {
	    	logger.error("fail to parse Subtargets sheet",e);
	      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
	    }
	  }
	}