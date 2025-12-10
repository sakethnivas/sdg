package com.sdg.goals.helper;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
import org.springframework.web.multipart.MultipartFile;

import com.sdg.goals.model.SixthGoal;

public class SixthGoalHelper {
	private static final Logger logger = LoggerFactory.getLogger(SixthGoalHelper.class);

	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	  public static boolean hasExcelFormat(MultipartFile sixthGoalFile) {
		  
		    if (!TYPE.equals(sixthGoalFile.getContentType())) {
		      return false;
		    }

		    return true;
		  }
	  public static List<SixthGoal> excelToGoals(InputStream is,MultipartFile file) {
		    try {
		    	
		     
		      Workbook workbook = new XSSFWorkbook(is);

		      Sheet sheet = workbook.getSheetAt(0);
		     
		      Iterator<Row> rows = sheet.rowIterator();
		      List<SixthGoal> goals = new ArrayList<SixthGoal>();
		      Row headerRow = sheet.getRow(0);
		        List<String> headerNames = new ArrayList<>();
			       Map<String, String> errorMap = new HashMap<>();
			       Map<String, String> headerMap = new HashMap<>();
			       headerMap.put("sno","S.No");
			       headerMap.put("volunteer","Volunteer");
			       headerMap.put("mandal","Mandal");
			       headerMap.put("village","Village");
			       headerMap.put("urbanrural","Urban/Rural");
			       headerMap.put("housesequence","House Sequence");
			       headerMap.put("name","Name");
			       headerMap.put("gender","Gender");
			       headerMap.put("dob","DOB");
			       headerMap.put("age","Age");
			       headerMap.put("aadhaar","Aadhaar");
			       headerMap.put("contactnumber","Contact Number");
			        headerMap.put("havethedrinkingwaterfacility", "Have the drinking water facility?");
			        headerMap.put("practicingopendefecation", "Practicing Open Defecation?");
			        headerMap.put("sanitationservicesavailable", "Sanitation Services available?");
			        headerMap.put("handwashingservicesavailable", "Handwashing Services available?");
			        headerMap.put("havewastewaterflowsfacility", "Have Waste Water Flows Facility?");
			        headerMap.put("typeofwaterqualityinuse", "Type of Water Quality in Use");

		        for (Cell cell : headerRow) {
		            String cellValue = cell.getStringCellValue().replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		            if(headerNames.contains(cellValue)) {
		            	errorMap.put("HeaderRepeatError", "Header name repeated: "+headerMap.get(cellValue)+" in ["+file.getOriginalFilename()+"]");
		            	workbook.close();
			            throw new RuntimeException(errorMap.toString());
		            }


		            headerNames.add(cellValue);
		        }


		      int rowNumber = 0;

		       List<String> mandatoryHeaderList = new ArrayList<>(headerMap.keySet());
		        List<String> notFoundList = new ArrayList<>();
		        for (String str : mandatoryHeaderList) {
		            if (!headerNames.contains(str)) {
		                notFoundList.add(headerMap.get(str));
		            }
		        }
		        if (!headerNames.containsAll(mandatoryHeaderList)) {
			    	   if(notFoundList.size()==1) {
				    	   	
			    		  errorMap.put("Column Name",notFoundList.toString()+" is missing in ["+file.getOriginalFilename()+"] Please look into help section");

			    	   }
			    	   else {
				    	   	errorMap.put("Column Names",notFoundList.toString()+" are missing in ["+file.getOriginalFilename()+"] Please look into help section");

			    	   }
		            	workbook.close();
			            throw new RuntimeException(errorMap.toString());

			       }
		       if(headerNames.indexOf("dob")>headerNames.indexOf("age")) {
	            	errorMap.put("DateOfBirthNotFoundError", "The age column shoud be after the Date of birth column"+" in ["+file.getOriginalFilename()+"]");
	            	workbook.close();
		            throw new RuntimeException(errorMap.toString());
	            }
		        List<String> newAgeList = new ArrayList<>(); 



		      while (rows.hasNext()) {
		        Row currentRow = rows.next();

		        if (rowNumber ==0) {
		          rowNumber++;
		          continue;
		        }


		        SixthGoal goal = new SixthGoal();

		        for(String head:headerNames) {
		            Cell currentCell = currentRow.getCell(headerNames.indexOf(head));
		          String cellValue = "";
		          switch (head) {
		          case "sno":
		              try {
		                  goal.setSNo((int) currentCell.getNumericCellValue());
		              } catch (IllegalStateException | NumberFormatException e) {
		                  errorMap.put("SNo", "Invalid value, must be a number, at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
		              }
		              break;
		          case "volunteer":
		        	  try {
			              goal.setVolunteer(currentCell.getStringCellValue());
					} catch (Exception e) {
						errorMap.put(headerMap.get(head),"Invalid value, must be a text , at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
					}
		              break;
		          case "mandal":
		        	  try {
		        		  goal.setMandal(currentCell.getStringCellValue());
					} catch (Exception e) {
						errorMap.put("Mandal","Invalid value, must be a text , at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
					}
		              
		              break;
		          case "village":
		        	  try {
		        		  goal.setVillage(currentCell.getStringCellValue());
					} catch (Exception e) {
						errorMap.put("Village","Invalid value, must be a text , at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
					}
		              
		              break;
		          case "urbanrural":
		        	  try {
		        		  goal.setUrbanOrRural(currentCell.getStringCellValue());
		        		  } catch (Exception e) {
						errorMap.put(headerMap.get(head),"Invalid value, must be a text , at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
					}
		              
		              break;
		          case "housesequence":
		              try {
		                  goal.setHouse_Sequence((int) currentCell.getNumericCellValue());
		              } catch (IllegalStateException | NumberFormatException e) {
		                  errorMap.put("House_Sequence", "Invalid value, must be a number, at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
		              }
		              break;
		          case "name":
		        	  try {
		        		  goal.setName(currentCell.getStringCellValue());
					} catch (Exception e) {
						errorMap.put(headerMap.get(head),"Invalid value, must be a text , at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
					}
		              
		              break;
		          case "gender":
		              String gender = currentCell.getStringCellValue();
		              if (gender.equalsIgnoreCase("M") || gender.equalsIgnoreCase("F")) {
		                  goal.setGender(gender);
		              } else {
		                  errorMap.put("Gender", "Invalid value, must be either 'Male' or 'Female', at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
		              }
		              break;

		          case "dob":
		        	    try {
		        	        LocalDateTime dateTime = currentCell.getLocalDateTimeCellValue();
		        	        LocalDate date = dateTime.toLocalDate();
		        	        goal.setDOB(date);
		        	    } catch (DateTimeParseException e) {
		        	        errorMap.put("DOB", "Invalid date format, must be in the format 'yyyy-MM-dd', at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
		        	    }
		        	    break;
		        	case "age":
		        		LocalDate dateOfBirth = goal.getDOB();
		        	    int age = (int) currentCell.getNumericCellValue();

		        	    LocalDate currentDate = LocalDate.now();
		        	    int ageFromDOB = currentDate.getYear() - dateOfBirth.getYear();
//
		        	    if (currentDate.getMonthValue() < dateOfBirth.getMonthValue()
		        	            || (currentDate.getMonthValue() == dateOfBirth.getMonthValue()
		        	            && currentDate.getDayOfMonth() < dateOfBirth.getDayOfMonth())) {
		        	        ageFromDOB--; // Adjust the age if the current date is before the birthdate in the current year
		        	    }
		        	    if (age != ageFromDOB) {
		        	    	goal.setAge(ageFromDOB);
		        	    	newAgeList.add(ageFromDOB+" at row "+(currentCell.getRowIndex()+1));
		        	    } else if (age < 0 || age > 120) {
		        	        errorMap.put("Age", "Invalid age, must be between 0 and 120, at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
			                  goal.setAge((int) currentCell.getNumericCellValue());

		        	        
		        	    } else {
		        	        goal.setAge(age);
		        	    }
		        	    break;
		        	case "aadhaar":
		        		if(currentCell!= null) {
		        	    Long aadhaar = (long) currentCell.getNumericCellValue();
		        		
		        	    if (aadhaar < 100000000000L || aadhaar > 999999999999L) {
		        	        errorMap.put("Aadhaar", "Invalid Aadhaar number, must be 12 digits, at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
		        	    } else {
		        	        goal.setAadhaar(aadhaar);
		        	    }
		        		}
		        	    break;
		        	case "contactnumber":
		        		if(currentCell!= null) {
		        		if (currentCell.getCellType() == CellType.NUMERIC) {
		                    long contactNumber = (long) currentCell.getNumericCellValue();
		                    if (contactNumber<1000000000L || contactNumber>9999999999L) {
		                        cellValue = "Contact Number";
		                        errorMap.put(cellValue, "Invalid contact number Specified, at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
		                    } else {
		                        goal.setContact_Number(contactNumber);
		                    }
		                } else {
		                    cellValue = "Contact Number";
		                    errorMap.put(cellValue, "Invalid data type, must be a number, at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
		                }
		        		}
		        	   break;
		        	   
			        	   
		        	case "havethedrinkingwaterfacility":
		        		if(!(currentCell==null)) {
		        			 if(currentCell.getCellType()==CellType.STRING) {
			        	   goal.setHave_the_drinking_water_facility(currentCell.getStringCellValue());
			        	   if (!currentCell.getStringCellValue().equals("Yes") && !currentCell.getStringCellValue().equals("No")) {
	                           cellValue = "Have_the_drinking_water_facility";
	                           errorMap.put(cellValue, "Invalid value, must be either 'Yes' or 'No', at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
			        	   } }}
		        		else {
		        			goal.setHave_the_drinking_water_facility(null);
		        		}
			        	   break;
			        	case "practicingopendefecation" :
			        		if(!(currentCell==null)) {
			        			 if(currentCell.getCellType()==CellType.STRING) {
			        	   goal.setPracticing_Open_Defecation(currentCell.getStringCellValue());
			        	   if (!currentCell.getStringCellValue().equals("Yes") && !currentCell.getStringCellValue().equals("No")) {
	                           cellValue = "Practicing_Open_Defecation";
	                           errorMap.put(cellValue, "Invalid value, must be either 'Yes' or 'No', at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
	                       }}}
			        		else {
			        			goal.setPracticing_Open_Defecation(null);
			        		}
			        	   break;
			        	case "sanitationservicesavailable":
			        		if(!(currentCell==null)) {
			        			 if(currentCell.getCellType()==CellType.STRING) {
			        	   goal.setSanitation_Services_available(currentCell.getStringCellValue());
			        	   if (!currentCell.getStringCellValue().equals("Yes") && !currentCell.getStringCellValue().equals("No")) {
	                           cellValue = "Sanitation_Services_available";
	                           errorMap.put(cellValue, "Invalid value, must be either 'Yes' or 'No', at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
	                       }}}
			        		else {
			        			goal.setSanitation_Services_available(null);
			        		}
			        	   break;
			        	case "handwashingservicesavailable":
			        		if(!(currentCell==null)) {
			        			 if(currentCell.getCellType()==CellType.STRING) {
			        	   goal.setHandwashing_Services_available(currentCell.getStringCellValue());
			        	   if (!currentCell.getStringCellValue().equals("Yes") && !currentCell.getStringCellValue().equals("No")) {
	                           cellValue = "Sanitation_Services_available";
	                           errorMap.put(cellValue, "Invalid value, must be either 'Yes' or 'No', at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
	                       }}}
			        		else {
			        			goal.setHandwashing_Services_available(null);
			        		}
			        	   break;
			        	case "havewastewaterflowsfacility":
			        		if(!(currentCell==null)) {
			        			 if(currentCell.getCellType()==CellType.STRING) {
			        	   goal.setHave_Waste_Water_Flows_Facility(currentCell.getStringCellValue());
			        	   if (!currentCell.getStringCellValue().equals("Yes") && !currentCell.getStringCellValue().equals("No")) {
	                           cellValue = "Have_Waste_Water_Flows_Facility";
	                           errorMap.put(cellValue, "Invalid value, must be either 'Yes' or 'No', at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
	                       }}}
			        		else {
			        			goal.setHave_Waste_Water_Flows_Facility(null);
			        		}
			        	   break;
			        	case "typeofwaterqualityinuse":
			        		if(!(currentCell==null)) {
			        			if (currentCell.getCellType()==CellType.STRING) {
			        	   goal.setType_of_Water_Quality_in_Use(currentCell.getStringCellValue());
			        			}
			        			else {
					        		  errorMap.put("Type of Water Quality in Use", "Invalid value, must be a text , at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
								}
			        		}
			        	   break;

			        	default:
				        	 break;
				          }
		          			
				        }
		        LocalDateTime now = LocalDateTime.now();
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm:ss");
		        String formattedDateTime = now.format(formatter);
      	      goal.setTimestamp(formattedDateTime);
				        goals.add(goal);
				      }
		      if(!newAgeList.isEmpty()) {
		    	  logger.info("The following ages has been modified "+newAgeList.toString());
		      }
				      workbook.close();

				      if (!errorMap.isEmpty()) {
				            throw new RuntimeException(errorMap.toString());
				        }
					     logger.info("Sixth goal  sheet has exported to SixthGoalService successfully");

				   return goals;
				    } catch (IOException e) {
				    	logger.error("fail to parse SixthGoals sheet",e);

				      throw new RuntimeException("fail to parse Goals sheet: " + e.getMessage());
				    }
				  }


}