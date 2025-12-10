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
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.sdg.goals.model.FirstGoal;

@Component
public class FirstGoalHelper {
	private static final Logger logger = LoggerFactory.getLogger(FirstGoalHelper.class);

	  public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";	  
	  public static boolean hasExcelFormat(MultipartFile firstGoalFile) {
		  
		    if (!TYPE.equals(firstGoalFile.getContentType())) {
		      return false;
		    }

		    return true;
		  }

		  public static List<FirstGoal> excelToGoals(InputStream is,MultipartFile file) {
		    try {
		    	
		     
		      Workbook workbook = new XSSFWorkbook(is);

		      Sheet sheet = workbook.getSheetAt(0);
		     
		      Iterator<Row> rows = sheet.rowIterator();
		      List<FirstGoal> goals = new ArrayList<FirstGoal>();
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
			       headerMap.put("profession","Profession");
			       headerMap.put("earningsmonth","Earnings/Month");
			       headerMap.put("ipl","IPL");
			       headerMap.put("npl","NPL");
			       headerMap.put("childrenhouseholdscashbenefits","Children/households cash benefits");
			       headerMap.put("multidimentionalpovertyline","Multi-Dimentional Poverty Line");
			       headerMap.put("workinjurybenefitsprofessionwise","Work Injury Benefits (Profession wise)");
			       headerMap.put("maternitycashbenefits","Maternity Cash Benefits");
			       headerMap.put("pensionbenefits","Pension Benefits");
			       headerMap.put("poorpopulationreceivingsacb","Poor Population receiving SACB");
			       headerMap.put("disabilitycashbenefits","Disability Cash Benefits");
			       headerMap.put("unemploymentcashbenefits","Unemployment Cash Benefits");
			       headerMap.put("labourmarketprogramfpo","Labour Market Program(FPO)");
			       headerMap.put("socialinsurancecoverage","Social Insurance Coverage");
			       headerMap.put("bdw","BDW");
			       headerMap.put("bss","BSS");
			       List<String> mandatoryHeaderList = new ArrayList<>(headerMap.keySet());

			       

		        for (Cell cell : headerRow) {
		            String cellValue = cell.getStringCellValue().replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		            if(headerNames.contains(cellValue)) {
		            	errorMap.put("HeaderRepeatError", "Header name repeated: "+headerMap.get(cellValue)+" in ["+file.getOriginalFilename()+"]");
		            	workbook.close();
			            throw new RuntimeException(errorMap.toString());
		            }
		            headerNames.add(cellValue);
		        }
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
			      int rowNumber = 0;
			        List<String> newAgeList = new ArrayList<>(); 

		      while (rows.hasNext()) {
		        Row currentRow = rows.next();

		        if (rowNumber ==0 ) {
		          rowNumber++;
		          continue;
		        }

//		        Iterator<Cell> cellsInRow = currentRow.cellIterator();

		        FirstGoal goal = new FirstGoal();

		        for (String head:headerNames) {
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
		        	   
		        	   
		        	 case "profession":
		        	        String profession = currentCell.getStringCellValue();
		        	        if (profession.isEmpty()) {
		        	            errorMap.put("Profession", "Profession cannot be empty");
		        	        } else if (profession.length() > 50) {
		        	            errorMap.put("Profession", "Profession length must be less than or equal to 50 characters, at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
		        	        } else {
		        	            goal.setProfession(profession);
		        	        }
		        	        break;
		        	 case "earningsmonth":
		        			if(!(currentCell==null)) {
		        	        int earningsPerMonth = (int) currentCell.getNumericCellValue();
		        	        if (earningsPerMonth < 0) {
		        	            errorMap.put("Earnings Per Month", "Earnings per month must be a positive number, at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
		        	        } else {
		        	            goal.setEarningsPerMonth(earningsPerMonth);
		        	        }}
			        		else {
			        			goal.setEarningsPerMonth(null);
			        		}
		        	        break;
		        	    
		        	case "ipl":
		        		if(!(currentCell==null)) {
		        			 if(currentCell.getCellType()==CellType.STRING) {
		        	   goal.setIPL(currentCell.getStringCellValue());
		        	   if (!currentCell.getStringCellValue().equals("Yes")&& !currentCell.getStringCellValue().equals("No")) {
                           cellValue = "IPL";
                           errorMap.put(cellValue, "Invalid value, must be either 'Yes' or 'No', at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
                       }}}
		        		else {
		        			goal.setIPL(null);
		        		}
		        	   break;
		        	case "npl":
		        		if(!(currentCell==null)) {
		        			 if(currentCell.getCellType()==CellType.STRING) {
		        	   goal.setNPL(currentCell.getStringCellValue());
		        	   if (!currentCell.getStringCellValue().equals("Yes")&& !currentCell.getStringCellValue().equals("No")) {
                           cellValue = "NPL";
                           errorMap.put(cellValue, "Invalid value, must be either 'Yes' or 'No', at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
                       }}}
		        		else {
		        			goal.setNPL(null);
		        		}
		        	   break;
		        	case "childrenhouseholdscashbenefits":
		        		if(!(currentCell==null)) {
		        			 if(currentCell.getCellType()==CellType.STRING) {
		        	   goal.setChildrenOrhouseholds_cash_benefits(currentCell.getStringCellValue());
		        	   if (!currentCell.getStringCellValue().equals("Yes")&& !currentCell.getStringCellValue().equals("No")) {
                           cellValue = "ChildrenOrhouseholds_cash_benefits";
                           errorMap.put(cellValue, "Invalid value, must be either 'Yes' or 'No', at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
                       }}}
		        		else {
		        			goal.setChildrenOrhouseholds_cash_benefits(null);
		        		}
		        	   break;
		        	case "multidimentionalpovertyline":
		        		if(!(currentCell==null)) {
		        			 if(currentCell.getCellType()==CellType.STRING) {
		        	   goal.setMulti_Dimentional_Poverty_Line(currentCell.getStringCellValue());
		        	   if (!currentCell.getStringCellValue().equals("Yes")&& !currentCell.getStringCellValue().equals("No")) {
                           cellValue = "Multi_Dimentional_Poverty_Line";
                           errorMap.put(cellValue, "Invalid value, must be either 'Yes' or 'No', at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
                       }}}
		        		else {
		        			goal.setMulti_Dimentional_Poverty_Line(null);
		        		}
		        	   break;
		        	case "workinjurybenefitsprofessionwise":
		        		if(!(currentCell==null)) {
		        			 if(currentCell.getCellType()==CellType.STRING) {
		        	   goal.setWork_Injury_Benefits(currentCell.getStringCellValue());
		        	   if (!currentCell.getStringCellValue().equals("Yes")&& !currentCell.getStringCellValue().equals("No")) {
                           cellValue = "Work_Injury_Benefits";
                           errorMap.put(cellValue, "Invalid value, must be either 'Yes' or 'No', at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
                       }}}
		        		else {
		        			goal.setWork_Injury_Benefits(null);
		        		}
		        	   break;
		        	case "maternitycashbenefits":
		        		if(!(currentCell==null)) { 
		        			if(currentCell.getCellType()==CellType.STRING) {
		        		
		        	   goal.setMaternity_Cash_Benefits(currentCell.getStringCellValue());
		        	   if (!currentCell.getStringCellValue().equals("Yes")&&!currentCell.getStringCellValue().equals("NA") && !currentCell.getStringCellValue().equals("No")) {
                           cellValue = "Maternity_Cash_Benefits";
                           errorMap.put(cellValue, "Invalid value, must be either 'Yes' or 'No' or 'NA', at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
                       }}}
		        		else {
		        			goal.setMaternity_Cash_Benefits(null);
		        		}
		        	   break;
		        	case "pensionbenefits":
		        		if(!(currentCell==null)) {
		        			 if(currentCell.getCellType()==CellType.STRING) {
		        	   goal.setPension_Benefits(currentCell.getStringCellValue());
		        	   if (!currentCell.getStringCellValue().equals("Yes") && !currentCell.getStringCellValue().equals("No")) {
                           cellValue = "Pension_Benefits";
                           errorMap.put(cellValue, "Invalid value, must be either 'Yes' or 'No', at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
                       }}}
		        		else {
		        			goal.setPension_Benefits(null);
		        		}
		        	   break;
		        	case "poorpopulationreceivingsacb":
		        		if(!(currentCell==null)) {
		        			 if(currentCell.getCellType()==CellType.STRING) {
		        	   goal.setPoor_Population_receiving_SACB(currentCell.getStringCellValue());
		        	   if (!currentCell.getStringCellValue().equals("Yes") && !currentCell.getStringCellValue().equals("No")) {
                           cellValue = "Poor_Population_receiving_SACB";
                           errorMap.put(cellValue, "Invalid value, must be either 'Yes' or 'No', at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
                       }}}
		        		else {
		        			goal.setPoor_Population_receiving_SACB(null);
		        		}
		        	   break;
		        	case "disabilitycashbenefits":
		        		if(!(currentCell==null)) {
		        			 if(currentCell.getCellType()==CellType.STRING) {
		        	   goal.setDisability_Cash_Benefits(currentCell.getStringCellValue());
		        	   if (!currentCell.getStringCellValue().equals("Yes") && !currentCell.getStringCellValue().equals("No")) {
                           cellValue = "Disability_Cash_Benefits";
                           errorMap.put(cellValue, "Invalid value, must be either 'Yes' or 'No', at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
                       }}}
		        		else {
		        			goal.setDisability_Cash_Benefits(null);
		        		}
		        	   break;
		        	case "unemploymentcashbenefits":
		        		if(!(currentCell==null)) {
		        			 if(currentCell.getCellType()==CellType.STRING) {
		        	   goal.setUnemployment_Cash_Benefits(currentCell.getStringCellValue());
		        	   if (!currentCell.getStringCellValue().equals("Yes") && !currentCell.getStringCellValue().equals("No")) {
                           cellValue = "Unemployment_Cash_Benefits";
                           errorMap.put(cellValue, "Invalid value, must be either 'Yes' or 'No', at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
                       }}}
		        		else {
		        			goal.setUnemployment_Cash_Benefits(null);
		        		}
		        	   break;
		        	case "labourmarketprogramfpo":
		        		if(!(currentCell==null)) {
		        			 if(currentCell.getCellType()==CellType.STRING) {
		        	   goal.setLabour_Market_Program(currentCell.getStringCellValue());
		        	   if (!currentCell.getStringCellValue().equals("Yes") && !currentCell.getStringCellValue().equals("No")) {
                           cellValue = "Labour_Market_Program";
                           errorMap.put(cellValue, "Invalid value, must be either 'Yes' or 'No', at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
                       }}}
		        		else {
		        			goal.setLabour_Market_Program(null);
		        		}
		        	   break;
		        	case "socialinsurancecoverage":
		        		if(!(currentCell==null)) {
		        			 if(currentCell.getCellType()==CellType.STRING) {
		        	   goal.setSocial_Insurance_Coverage(currentCell.getStringCellValue());
		        	   if (!currentCell.getStringCellValue().equals("Yes") && !currentCell.getStringCellValue().equals("No")) {
                           cellValue = "Insurance_Coverage";
                           errorMap.put(cellValue, "Invalid value, must be either 'Yes' or 'No', at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
                       }}}
		        		else {
		        			goal.setSocial_Insurance_Coverage(null);
		        		}
		        	   break;
		        	case "bdw":
		        		if(!(currentCell==null)) {
		        			 if(currentCell.getCellType()==CellType.STRING) {
		        	   goal.setBDW(currentCell.getStringCellValue());
		        	   if (!currentCell.getStringCellValue().equals("Yes") && !currentCell.getStringCellValue().equals("No")) {
                           cellValue = "BDW";
                           errorMap.put(cellValue, "Invalid value, must be either 'Yes' or 'No', at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
                       }}}
		        		else {
		        			goal.setBDW(null);
		        		}
		        	   break;
		        	case "bss":
		        		if(!(currentCell==null)) {
		        			 if(currentCell.getCellType()==CellType.STRING) {
		        	   goal.setBSS(currentCell.getStringCellValue());
		        	   if (!currentCell.getStringCellValue().equals("Yes") && !currentCell.getStringCellValue().equals("No")) {
                           cellValue = "BSS";
                           errorMap.put(cellValue, "Invalid value, must be either 'Yes' or 'No', at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
                       }}}
		        		else {
		        			goal.setBSS(null);
		        		}
		        	   break;
		        	   
		        	default:
		        		
		        	 break;
		          }

		        }
		        LocalDateTime now = LocalDateTime.now();
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm:ss");
		        String formattedDateTime = now.format(formatter);
      	      goal.setTimeStamp(formattedDateTime);
		        goals.add(goal);
		      }
		      if(!newAgeList.isEmpty()) {
		    	  logger.info("The following ages has been modified "+newAgeList.toString());
		      }

		      workbook.close();

		      if (!errorMap.isEmpty()) {
		            throw new RuntimeException(errorMap.toString());
		        }
			     logger.info("First goal  sheet has exported to FirstGoalService successfully");

		   return goals;
		    } catch (IOException e) {
		    	logger.error("fail to parse FirstGoals sheet",e);

		      throw new RuntimeException("fail to parse Goals sheet: " + e.getMessage());
		    }
		  }
}
