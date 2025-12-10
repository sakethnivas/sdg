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

import com.sdg.goals.model.ThirdGoal;

public class ThirdGoalHelper {
	private static final Logger logger = LoggerFactory.getLogger(ThirdGoalHelper.class);

	  public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

	
	

	  public static boolean hasExcelFormat(MultipartFile thirdGoalFile) {
		  
		    if (!TYPE.equals(thirdGoalFile.getContentType())) {
		      return false;
		    }

		    return true;
		  }

		  public static List<ThirdGoal> excelToGoals(InputStream is,MultipartFile file) {
		    try {
		    	
		     
		      Workbook workbook = new XSSFWorkbook(is);

		      Sheet sheet = workbook.getSheetAt(0);
		     
		      Iterator<Row> rows = sheet.rowIterator();
		      List<ThirdGoal> goals = new ArrayList<ThirdGoal>();
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
			       headerMap.put("maternalmortality" ,"Maternal Mortality");
			       headerMap.put("birthsattendedbyshp" ,"Births Attended by SHP?");
			       headerMap.put("infantdeaths" ,"Infant Deaths");
			       headerMap.put("under5mr" ,"Under5 MR");
			       headerMap.put("neonataldeaths" ,"Neonatal deaths");
			       headerMap.put("hivinfected" ,"HIV infected?");
			       headerMap.put("tuberculosisinfected" ,"Tuberculosis infected?");
			       headerMap.put("malariainfected" ,"Malaria Infected?");
			       headerMap.put("needinterventioncheckup" ,"Need Intervention/Check Up?");
			       headerMap.put("hepatitisbinfected","Hepatitis B infected?");
			       headerMap.put("mortalityratebycdcdcrd","Mortality Rate by  CD, CD, CRD?");
			       headerMap.put("suicidaldeath" ,"Suicidal Death?");
			       headerMap.put("alcoholicdisorder" ,"Alcoholic Disorder?");
			       headerMap.put("alcoholicconsumptionliters" ,"Alcoholic Consumption (Liters)");
			       headerMap.put("roadtrafficdeaths","Road Traffic deaths?");
			       headerMap.put("womenreproductive1549yrs" ,"Women Re-productive(15-49Yrs)");
			       headerMap.put("adolescentbirth" ,"Adolescent birth");

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


		        ThirdGoal goal = new ThirdGoal();

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
		        		  goal.setUrban_Rural(currentCell.getStringCellValue());
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
		        	   
		        	   case "maternalmortality":
		        		if(!(currentCell==null)) {
		        			 if(currentCell.getCellType()==CellType.STRING) {
		        	   goal.setMaternal_Mortality(currentCell.getStringCellValue());
		        	   if (!currentCell.getStringCellValue().equals("Yes") && !currentCell.getStringCellValue().equals("No")) {
                           cellValue = "Maternal_Mortality";
                           errorMap.put(cellValue, "Invalid value, must be either 'Yes' or 'No', at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
                       }}}
		        		else {
		        			goal.setMaternal_Mortality(null);
		        		}
		        	   break;
		        	case "birthsattendedbyshp":
		        		if(!(currentCell==null)) {
		        			 if(currentCell.getCellType()==CellType.STRING) {
		        	   goal.setBirths_Attended_by_SHP(currentCell.getStringCellValue());
		        	   if (!currentCell.getStringCellValue().equals("Yes") && !currentCell.getStringCellValue().equals("No")) {
                           cellValue = "Births_Attended_by_SHP";
                           errorMap.put(cellValue, "Invalid value, must be either 'Yes' or 'No', at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
                       }}}
		        		else {
		        			goal.setBirths_Attended_by_SHP(null);
		        		}
		        	   break;
		        	case "infantdeaths":
		        		if(!(currentCell==null)) {
		        	    if (currentCell.getCellType() == CellType.STRING) {
		        	        goal.setInfant_Deaths(currentCell.getStringCellValue());
		        	    } else {
		        	        errorMap.put("Infant Deaths", "Invalid value, must be a string, at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
		        	    }}
		        		else {
		        			goal.setInfant_Deaths(null);
		        		}
		        	    break;
		        	case "under5mr": 
		        		if(!(currentCell==null)) {
		        	    if (currentCell.getCellType() == CellType.STRING) {
		        	        goal.setUnder5_MR(currentCell.getStringCellValue());
		        	    } else {
		        	        errorMap.put("Under-5 MR", "Invalid value, must be a string, at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
		        	    }}
		        		else {
		        			goal.setUnder5_MR(null);
		        		}
		        	    break;
		        	   
		        	case "neonataldeaths": 
		        		if(!(currentCell==null)) {
		        			 if(currentCell.getCellType()==CellType.STRING) {
		        	   goal.setNeonatal_deaths(currentCell.getStringCellValue());
		        	   if (!currentCell.getStringCellValue().equals("Yes") && !currentCell.getStringCellValue().equals("No")) {
                           cellValue = "Neonatal_deaths";
                           errorMap.put(cellValue, "Invalid value, must be either 'Yes' or 'No', at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
                       }}}
		        		else {
		        			goal.setNeonatal_deaths(null);
		        		}
		        	   break;
		        	case "hivinfected": 
		        		if(!(currentCell==null)) {
		        			 if(currentCell.getCellType()==CellType.STRING) {
		        	   goal.setHIV_infected(currentCell.getStringCellValue());
		        	   if (!currentCell.getStringCellValue().equals("Yes") && !currentCell.getStringCellValue().equals("No")) {
                           cellValue = "HIV_infected";
                           errorMap.put(cellValue, "Invalid value, must be either 'Yes' or 'No', at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
                       }}}
		        		else {
		        			goal.setHIV_infected(null);
		        		}
		        	   break;
		        	case "tuberculosisinfected": 
		        		if(!(currentCell==null)) {
		        			 if(currentCell.getCellType()==CellType.STRING) {
		        	   goal.setTuberculosis_infected(currentCell.getStringCellValue());
		        	   if (!currentCell.getStringCellValue().equals("Yes") && !currentCell.getStringCellValue().equals("No")) {
                           cellValue = "Tuberculosis_infected";
                           errorMap.put(cellValue, "Invalid value, must be either 'Yes' or 'No', at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
                       }}}
		        		else {
		        			goal.setTuberculosis_infected(null);
		        		}
		        	   break;
		        	case "malariainfected": 
		        		if(!(currentCell==null)) {
		        			 if(currentCell.getCellType()==CellType.STRING) {
		        	   goal.setMalaria_Infected(currentCell.getStringCellValue());
		        	   if (!currentCell.getStringCellValue().equals("Yes") && !currentCell.getStringCellValue().equals("No")) {
                           cellValue = "Malaria_Infected";
                           errorMap.put(cellValue, "Invalid value, must be either 'Yes' or 'No', at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
                       }}}
		        		else {
		        			goal.setMalaria_Infected(null);
		        		}
		        	   break;
		        	case "needinterventioncheckup": 
		        		if(!(currentCell==null)) {
		        			 if(currentCell.getCellType()==CellType.STRING) {
		        	   goal.setNeed_InterventionOrCheck_Up(currentCell.getStringCellValue());
		        	   if (!currentCell.getStringCellValue().equals("Yes") && !currentCell.getStringCellValue().equals("No")) {
                           cellValue = "Need_InterventionOrCheck_Up";
                           errorMap.put(cellValue, "Invalid value, must be either 'Yes' or 'No', at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
                       }}}
		        		else {
		        			goal.setNeed_InterventionOrCheck_Up(null);
		        		}
		        	   break;
		        	case "hepatitisbinfected": 
		        		if(!(currentCell==null)) {
		        			 if(currentCell.getCellType()==CellType.STRING) {
		        	   goal.setHepatitis_B_infected(currentCell.getStringCellValue());
		        	   if (!currentCell.getStringCellValue().equals("Yes") && !currentCell.getStringCellValue().equals("No")) {
                           cellValue = "Hepatitis_B_infected";
                           errorMap.put(cellValue, "Invalid value, must be either 'Yes' or 'No', at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
                       }}}
		        		else {
		        			goal.setHepatitis_B_infected(null);
		        		}
		        	   break;
		        	case "mortalityratebycdcdcrd": 
		        		if(!(currentCell==null)) {
		        			 if(currentCell.getCellType()==CellType.STRING) {
		        	   goal.setMortality_Rate_by__CD_CD_CRD(currentCell.getStringCellValue());
		        	   if (!currentCell.getStringCellValue().equals("Yes") && !currentCell.getStringCellValue().equals("No")) {
                           cellValue = "Mortality_Rate_by__CD_CD_CRD";
                           errorMap.put(cellValue, "Invalid value, must be either 'Yes' or 'No', at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
                       }}}
		        		else {
		        			goal.setMortality_Rate_by__CD_CD_CRD(null);
		        		}
		        	   break;
		        	case "suicidaldeath": 
		        		if(!(currentCell==null)) {
		        			 if(currentCell.getCellType()==CellType.STRING) {
		        	   goal.setSuicidal_Death(currentCell.getStringCellValue());
		        	   if (!currentCell.getStringCellValue().equals("Yes") && !currentCell.getStringCellValue().equals("No")) {
                           cellValue = "Suicidal_Death";
                           errorMap.put(cellValue, "Invalid value, must be either 'Yes' or 'No', at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
                       }}}
		        		else {
		        			goal.setSuicidal_Death(null);
		        		}
		        	   break;
		        	case "alcoholicdisorder": 
		        		if(!(currentCell==null)) {
		        			 if(currentCell.getCellType()==CellType.STRING) {
		        	   goal.setAlcoholic_Disorder(currentCell.getStringCellValue());
		        	   if (!currentCell.getStringCellValue().equals("Yes") && !currentCell.getStringCellValue().equals("No")) {
                           cellValue = "Alcoholic_Disorder";
                           errorMap.put(cellValue, "Invalid value, must be either 'Yes' or 'No', at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
                       }}}
		        		else {
		        			goal.setAlcoholic_Disorder(null);
		        		}
		        	   break;
		        	case "alcoholicconsumptionliters": 
		        		if(!(currentCell==null)) {
		        	   if (currentCell.getCellType() != CellType.NUMERIC) {
		        	        cellValue = "Alcoholic_Consumption";
		        	        errorMap.put(cellValue, "Invalid value type, must be a number, at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
		        	    } else {
				        	   goal.setAlcoholic_Consumption((int)currentCell.getNumericCellValue());
		        	    }}
		        		else {
		        			goal.setAlcoholic_Consumption(null);
		        		}
		        	   break;
		        	case "roadtrafficdeaths": 
		        		if(!(currentCell==null)) {
		        			 if(currentCell.getCellType()==CellType.STRING) {
		        	   goal.setRoad_Traffic_deaths(currentCell.getStringCellValue());
		        	   if (!currentCell.getStringCellValue().equals("Yes") && !currentCell.getStringCellValue().equals("No")) {
                           cellValue = "Road_Traffic_deaths";
                           errorMap.put(cellValue, "Invalid value, must be either 'Yes' or 'No', at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
                       }}}
		        		else {
		        			goal.setRoad_Traffic_deaths(null);
		        		}
			           break;
		        	case "womenreproductive1549yrs": 
		        		if(!(currentCell==null)) {
		        			 if(currentCell.getCellType()==CellType.STRING) {
			           goal.setWomen_Reproductive(currentCell.getStringCellValue());
			           if (!currentCell.getStringCellValue().equals("Yes") && !currentCell.getStringCellValue().equals("No")) {
                           cellValue = "Women_Reproductive";
                           errorMap.put(cellValue, "Invalid value, must be either 'Yes' or 'No', at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
                       }}}
		        		else {
		        			goal.setWomen_Reproductive(null);
		        		}
			           break;
		        	case "adolescentbirth": 
		        		if(!(currentCell==null)) {
		        			 if(currentCell.getCellType()==CellType.STRING) {
                       goal.setAdolescent_birth(currentCell.getStringCellValue());
                       if (!currentCell.getStringCellValue().equals("Yes") && !currentCell.getStringCellValue().equals("No")) {
                           cellValue = "Adolescent_birth";
                           errorMap.put(cellValue, "Invalid value, must be either 'Yes' or 'No', at row "+(currentCell.getRowIndex()+1)+" in ["+file.getOriginalFilename()+"]");
                       }}}
		        		else {
		        			goal.setAdolescent_birth(null);
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
			     logger.info("Third goal  sheet has exported to ThirdGoalService successfully");
		   return goals;
		    } catch (IOException e) {
		    	logger.error("fail to parse ThirdGoals sheet",e);
		      throw new RuntimeException("fail to parse Goals sheet: " + e.getMessage());
		    }
		  }

}
