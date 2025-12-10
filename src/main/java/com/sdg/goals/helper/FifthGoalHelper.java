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

import com.sdg.goals.model.FifthGoal;

public class FifthGoalHelper {
	private static final Logger logger = LoggerFactory.getLogger(FifthGoalHelper.class);
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	 public static boolean hasExcelFormat(MultipartFile fifthGoalFile) {
		  
		    if (!TYPE.equals(fifthGoalFile.getContentType())) {
		      return false;
		    }

		    return true;
		  }
	  public static List<FifthGoal> excelToGoals(InputStream is,MultipartFile file) {
		    try {
		    	
		     
		      Workbook workbook = new XSSFWorkbook(is);

		      Sheet sheet = workbook.getSheetAt(0);
		     
		      Iterator<Row> rows = sheet.rowIterator();
		      List<FifthGoal> goals = new ArrayList<FifthGoal>();
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
			       headerMap.put("violenceagainstwomen","Violence against women");
			       headerMap.put("marriageandfamily","Marriage and Family");
			       headerMap.put("eeb","E & EB");
			       headerMap.put("sexualviolence","Sexual Violence");
			       headerMap.put("marriedbefore15years","Married before 15 years?");
			       headerMap.put("marriedbefore18years","Married before 18 years?");
			       headerMap.put("undergonegenitalmutilationcutting","Undergone Genital Mutilation/Cutting?");
			       headerMap.put("unpaidtimeondomesticcareworkhoursday","Unpaid Time on domestic & care work (Hours/day)");
			       headerMap.put("issheaparliamentarian","Is She a Parliamentarian?");
			       headerMap.put("isshealocalgovernmentelect","Is She a Local Government Elect?");
			       headerMap.put("isshemanagerseniormanager","Is She Manager/Senior Manager?");
			       headerMap.put("rightsoveragriland","Rights Over Agri Land");
			       headerMap.put("ownamobilephoneanduseinternet","Own a Mobile Phone and use Internet?");

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
		        List<String> newAgeList = new ArrayList<>(); 

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



		      while (rows.hasNext()) {
		        Row currentRow = rows.next();

		        if (rowNumber ==0) {
		          rowNumber++;
		          continue;
		        }


		        FifthGoal goal = new FifthGoal();

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
		        	   
		        	case "violenceagainstwomen":
		        		if(!(currentCell==null)) {
		        			 if(currentCell.getCellType()==CellType.STRING) {
		        	   goal.setVoilence_against_women(currentCell.getStringCellValue());
					   if (!currentCell.getStringCellValue().equals("Yes")&&!currentCell.getStringCellValue().equals("NA") && !currentCell.getStringCellValue().equals("No")) {
                           cellValue = "Voilence_against_women";
                           errorMap.put(cellValue, "Invalid value, must be either 'Yes' or 'No' or 'NA', at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
                       }}}
		        		else {
		        			goal.setVoilence_against_women(null);
		        		}
		        	   break;
		        	case "marriageandfamily":
		        		if(!(currentCell==null)) {
		        			 if(currentCell.getCellType()==CellType.STRING) {
		        	   goal.setMarriageandFamily(currentCell.getStringCellValue());
					   if (!currentCell.getStringCellValue().equals("Yes")&&!currentCell.getStringCellValue().equals("NA") && !currentCell.getStringCellValue().equals("No")) {
                           cellValue = "MarriageandFamily";
                           errorMap.put(cellValue, "Invalid value, must be either 'Yes' or 'No' or 'NA', at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
                       }}}
		        		else {
		        			goal.setMarriageandFamily(null);
		        		}
		        	   break;
		        	case "eeb":
		        		if(!(currentCell==null)) {
		        			 if(currentCell.getCellType()==CellType.STRING) {
		        	   goal.setEandEB(currentCell.getStringCellValue());
					   if (!currentCell.getStringCellValue().equals("Yes")&&!currentCell.getStringCellValue().equals("NA") && !currentCell.getStringCellValue().equals("No")) {
                           cellValue = "EandEB";
                           errorMap.put(cellValue, "Invalid value, must be either 'Yes' or 'No' or 'NA', at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
                       }}}
		        		else {
		        			goal.setEandEB(null);
		        		}
		        	   break;
		        	case "sexualviolence":
		        		if(!(currentCell==null)) {
		        			 if(currentCell.getCellType()==CellType.STRING) {
		        	   goal.setSexual_Voilence(currentCell.getStringCellValue());
					   if (!currentCell.getStringCellValue().equals("Yes")&&!currentCell.getStringCellValue().equals("NA") && !currentCell.getStringCellValue().equals("No")) {
                           cellValue = "Sexual_Voilence";
                           errorMap.put(cellValue, "Invalid value, must be either 'Yes' or 'No' or 'NA', at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
                       }}}
		        		else {
		        			goal.setSexual_Voilence(null);
		        		}
		        	   break;
		        	case "marriedbefore15years":
		        		if(!(currentCell==null)) {
		        			 if(currentCell.getCellType()==CellType.STRING) {
		        	   goal.setMarried_before_15years(currentCell.getStringCellValue());
					   if (!currentCell.getStringCellValue().equals("Yes")&&!currentCell.getStringCellValue().equals("NA") && !currentCell.getStringCellValue().equals("No")) {
                           cellValue = "Married_before_15years";
                           errorMap.put(cellValue, "Invalid value, must be either 'Yes' or 'No' or 'NA', at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
                       }}}
		        		else {
		        			goal.setMarried_before_15years(null);
		        		}
		        	   break;
		        	case "marriedbefore18years":
		        		if(!(currentCell==null)) {
		        			 if(currentCell.getCellType()==CellType.STRING) {
		        	   goal.setMarried_before_18years(currentCell.getStringCellValue());
					   if (!currentCell.getStringCellValue().equals("Yes")&&!currentCell.getStringCellValue().equals("NA") && !currentCell.getStringCellValue().equals("No")) {
                           cellValue = "Married_before_18years";
                           errorMap.put(cellValue, "Invalid value, must be either 'Yes' or 'No' or 'NA', at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
                       }}}
		        		else {
		        			goal.setMarried_before_18years(null);
		        		}
		        	   break;
		        	case "undergonegenitalmutilationcutting":
		        		if(!(currentCell==null)) {
		        			 if(currentCell.getCellType()==CellType.STRING) {
		        	   goal.setUndergone_Genital_Mutilation_or_Cutting(currentCell.getStringCellValue());
					   if (!currentCell.getStringCellValue().equals("Yes")&&!currentCell.getStringCellValue().equals("NA") && !currentCell.getStringCellValue().equals("No")) {
                           cellValue = "Undergone_Genital_Mutilation_or_Cutting";
                           errorMap.put(cellValue, "Invalid value, must be either 'Yes' or 'No' or 'NA', at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
                       }}}
		        		else {
		        			goal.setUndergone_Genital_Mutilation_or_Cutting(null);
		        		}
		        	   break;
		        	case "unpaidtimeondomesticcareworkhoursday":	
		        		if(!(currentCell==null)) {
		        	    if (currentCell.getCellType() == CellType.NUMERIC) {
		        	        int intValue = (int) currentCell.getNumericCellValue();
		        	        goal.setUnpaid_Time_on_domestic_and_care_work_Hours_or_day(intValue);
		        	    } else {
		        	        String StringValue = currentCell.getStringCellValue();
		        	        if (StringValue.equalsIgnoreCase("NA")) {
		        	            goal.setUnpaid_Time_on_domestic_and_care_work_Hours_or_day(null); // Set null or any other placeholder value for "NA"
		        	        } else {
		        	            try {
		        	                int intValue = Integer.parseInt(StringValue);
		        	                goal.setUnpaid_Time_on_domestic_and_care_work_Hours_or_day(intValue);
		        	            } catch (NumberFormatException e) {
		        	                errorMap.put("setUnpaid_Time_on_domestic_and_care_work_Hours_or_day", "Invalid value, must be an integer, at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
		        	            }
		        	        }
		        	    }}
		        		else {
		        			goal.setUnpaid_Time_on_domestic_and_care_work_Hours_or_day(null);
		        		}
		        	    break;
		        	case "issheaparliamentarian":
		        		if(!(currentCell==null)) {
		        			 if(currentCell.getCellType()==CellType.STRING) {
		        	   goal.setIs_She_a_Parlimentarian(currentCell.getStringCellValue());
					   if (!currentCell.getStringCellValue().equals("Yes")&&!currentCell.getStringCellValue().equals("NA") && !currentCell.getStringCellValue().equals("No")) {
                           cellValue = "Is_She_a_Parlimentarian";
                           errorMap.put(cellValue, "Invalid value, must be either 'Yes' or 'No' or 'NA', at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
                       }}}
		        		else {
		        			goal.setIs_She_a_Parlimentarian(null);
		        		}
		        	   break;
		        	case "isshealocalgovernmentelect":
		        		if(!(currentCell==null)) {
		        			 if(currentCell.getCellType()==CellType.STRING) {
		        	   goal.setIs_She_a_Local_Government_Elect(currentCell.getStringCellValue());
					   if (!currentCell.getStringCellValue().equals("Yes")&&!currentCell.getStringCellValue().equals("NA") && !currentCell.getStringCellValue().equals("No")) {
                           cellValue = "Is_She_a_Local_Government_Elect";
                           errorMap.put(cellValue, "Invalid value, must be either 'Yes' or 'No' or 'NA', at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
                       }}}
		        		else {
		        			goal.setIs_She_a_Local_Government_Elect(null);
		        		}
		        	   break;
		        	case "isshemanagerseniormanager":
		        		if(!(currentCell==null)) {
		        			 if(currentCell.getCellType()==CellType.STRING) {
		        	   goal.setIs_She_Manager_orSenior_Manager(currentCell.getStringCellValue());
		        		}
		        			 else {
		                           errorMap.put("Is She Manager/Senior Manager?", "Invalid value, must be a text , at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");

		        			 }
		        		}
		        		else {
		        			goal.setIs_She_Manager_orSenior_Manager(null);
		        		}
					  		        	   break;
		        	case "rightsoveragriland":
		        		if(!(currentCell==null)) {
		        			 if(currentCell.getCellType()==CellType.STRING) {
		        	   goal.setRights_Over_Agri_Land(currentCell.getStringCellValue());
					   if (!currentCell.getStringCellValue().equals("Yes")&&!currentCell.getStringCellValue().equals("NA") && !currentCell.getStringCellValue().equals("No")) {
                           cellValue = "Rights_Over_Agri_Land";
                           errorMap.put(cellValue, "Invalid value, must be either 'Yes' or 'No' or 'NA', at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
                       }}}
		        		else {
		        			goal.setRights_Over_Agri_Land(null);
		        		}
		        	   break;
		        	case "ownamobilephoneanduseinternet":
		        		if(!(currentCell==null)) {
		        			 if(currentCell.getCellType()==CellType.STRING) {
		        	   goal.setOwn_a_Mobile_Phone_and_use_Internet(currentCell.getStringCellValue());
					   if (!currentCell.getStringCellValue().equals("Yes")&&!currentCell.getStringCellValue().equals("NA") && !currentCell.getStringCellValue().equals("No")) {
                           cellValue = "Own_a_Mobile_Phone_and_use_Internet";
                           errorMap.put(cellValue, "Invalid value, must be either 'Yes' or 'No' or 'NA', at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
                       }}}
		        		else {
		        			goal.setOwn_a_Mobile_Phone_and_use_Internet(null);
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
				     logger.info("Fifth goal  sheet has exported to FifthGoalService successfully");

			   return goals;
		      }
		    catch (IOException e) {
		    	logger.error("fail to parse FifthGoals sheet",e);

			      throw new RuntimeException("fail to parse FifthGoals sheet: " + e.getMessage());
			    }
			  }
}