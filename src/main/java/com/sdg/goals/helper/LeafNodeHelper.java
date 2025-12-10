package com.sdg.goals.helper;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sdg.goals.repository.ConfigParamRepository;
import com.sdg.goals.repository.EigthGoalRepository;
import com.sdg.goals.repository.FifthGoalRepository;
import com.sdg.goals.repository.FirstGoalRepository;
import com.sdg.goals.repository.FourthGoalRepository;
import com.sdg.goals.repository.NinthGoalRepository;
import com.sdg.goals.repository.SecondGoalRepository;
import com.sdg.goals.repository.SeventhGoalRepository;
import com.sdg.goals.repository.SixthGoalRepository;
import com.sdg.goals.repository.TenthGoalRepository;
import com.sdg.goals.repository.ThirdGoalRepository;


@Component
public class LeafNodeHelper {

	@Autowired
	private FirstGoalRepository firstGoalRepository;
	@Autowired
	private SecondGoalRepository secondGoalRepository;
	@Autowired
	private ThirdGoalRepository thirdGoalRepository;
	@Autowired
	private FourthGoalRepository fourthGoalRepository;
	@Autowired
	private FifthGoalRepository fifthGoalRepository;
	@Autowired
	private SixthGoalRepository sixthGoalRepository;
	@Autowired
	private SeventhGoalRepository seventhGoalRepository;
	@Autowired
	private EigthGoalRepository eigthGoalRepository;
	@Autowired
	private NinthGoalRepository ninthGoalRepository;
	@Autowired
	private TenthGoalRepository tenthGoalRepository;
	@Autowired
	private ConfigParamRepository configParamRepository;
	

	private LinkedHashMap<Integer, List<List<String>>> goalValues;
	
	
	


    /*****************GOAL 1*********************/
	public LinkedHashMap<Integer, List<List<String>>> firstValueCalculations() {
	  	List<Float> firstRepository = firstGoalRepository.firstGoalLeafNodeValues();
        goalValues = new LinkedHashMap<>();
        double[] unprocessedfirstgoalvalues = {(firstRepository.get(1)+firstRepository.get(2))/(firstRepository.get(22))*100,
        		(firstRepository.get(1))/(firstRepository.get(22))*100,
        		(firstRepository.get(2))/(firstRepository.get(22))*100,
        		(firstRepository.get(1)+firstRepository.get(2))/(firstRepository.get(22))*100,
        		(firstRepository.get(3)+firstRepository.get(4))/(firstRepository.get(22))*100,
        		(firstRepository.get(3))/(firstRepository.get(22))*100,
        		(firstRepository.get(4))/(firstRepository.get(22))*100,
        		(firstRepository.get(8)+firstRepository.get(9))/(firstRepository.get(5))*100,
        		(firstRepository.get(6))/(firstRepository.get(5))*100,
        		(firstRepository.get(6))/(firstRepository.get(8))*100,
        		(firstRepository.get(6))/(firstRepository.get(5))*100,
        		(firstRepository.get(8)+firstRepository.get(9))/(firstRepository.get(0))*100,
        		(firstRepository.get(8))/(firstRepository.get(0))*100,
        		(firstRepository.get(9))/(firstRepository.get(0))*100,
        		(firstRepository.get(10)+firstRepository.get(11))/(firstRepository.get(0))*100,
        		(firstRepository.get(10))/(firstRepository.get(0))*100,
        		(firstRepository.get(11))/(firstRepository.get(0))*100,
        		(firstRepository.get(12))/(firstRepository.get(0))*100,
        		(firstRepository.get(14)+firstRepository.get(15))/(firstRepository.get(0))*100,
        		(firstRepository.get(13))/(firstRepository.get(0))*100,
        		(firstRepository.get(14)+firstRepository.get(15))/(firstRepository.get(0))*100,
        		(firstRepository.get(14))/(firstRepository.get(0))*100,
        		(firstRepository.get(15))/(firstRepository.get(0))*100,
        		(firstRepository.get(16))/(firstRepository.get(0))*100,
        		(firstRepository.get(17))/(firstRepository.get(0))*100,//24
        		0.0,//25
        		(firstRepository.get(18))/(firstRepository.get(0))*100,//26
        		0.0,//27
        		(firstRepository.get(19))/(firstRepository.get(0))*100,//28
        		(firstRepository.get(20))/(firstRepository.get(0))*100,//29
        		(firstRepository.get(21))/(firstRepository.get(0))*100};//30
        
        
        String[] processedfirstgoalvalues = processArray(unprocessedfirstgoalvalues);

        goalValues.put(1,  List.of(List.of("Total","Female","Male"),List.of(processedfirstgoalvalues[0],processedfirstgoalvalues[1],processedfirstgoalvalues[2])));
        goalValues.put(2,  List.of(List.of("Total"),List.of(processedfirstgoalvalues[3])));
        goalValues.put(3,  List.of(List.of("Total","Urban","Rural"),List.of(processedfirstgoalvalues[4],processedfirstgoalvalues[5],processedfirstgoalvalues[6])));
        goalValues.put(4,  List.of(List.of("Total"),List.of(processedfirstgoalvalues[7])));
        goalValues.put(5,  List.of(List.of("Total"),List.of(processedfirstgoalvalues[8])));
        goalValues.put(6,  List.of(List.of("Total"),List.of(processedfirstgoalvalues[9])));
        goalValues.put(7,  List.of(List.of("Total"),List.of(processedfirstgoalvalues[10])));
        goalValues.put(8,  List.of(List.of("Total","Female","Male"),List.of(processedfirstgoalvalues[11],processedfirstgoalvalues[12],processedfirstgoalvalues[13])));
        goalValues.put(9,  List.of(List.of("Total","Female","Male"),List.of(processedfirstgoalvalues[14],processedfirstgoalvalues[15],processedfirstgoalvalues[16])));
        goalValues.put(10, List.of(List.of("Total"),List.of(processedfirstgoalvalues[17])));
        goalValues.put(11, List.of(List.of("Total"),List.of(processedfirstgoalvalues[18])));
        goalValues.put(12, List.of(List.of("Total"),List.of(processedfirstgoalvalues[19])));
        goalValues.put(13, List.of(List.of("Total","Female","Male"),List.of(processedfirstgoalvalues[20],processedfirstgoalvalues[21],processedfirstgoalvalues[22])));
        goalValues.put(14, List.of(List.of("Total"),List.of(processedfirstgoalvalues[23])));
        goalValues.put(15, List.of(List.of("Total"),List.of(processedfirstgoalvalues[24])));
        goalValues.put(16, List.of(List.of("Total"),List.of(processedfirstgoalvalues[25]))); //IGNORED
        goalValues.put(17, List.of(List.of("Total"),List.of(processedfirstgoalvalues[26])));
        goalValues.put(18, List.of(List.of("Total"),List.of(processedfirstgoalvalues[27])));//IGNORED
        goalValues.put(19, List.of(List.of("Total"),List.of(processedfirstgoalvalues[28])));
        goalValues.put(20, List.of(List.of("Total"),List.of(processedfirstgoalvalues[29])));
        goalValues.put(21, List.of(List.of("Total"),List.of(processedfirstgoalvalues[30])));

        return goalValues;

	}
    /****************GOAL 2********************/
	public LinkedHashMap<Integer, List<List<String>>> secondValueCalculations() {
	  	List<Float> secondRepository = secondGoalRepository.secondGoalLeafNodeValues();
        goalValues = new LinkedHashMap<>();
        
        double[] unprocessedsecondgoalvalues = { (secondRepository.get(1)),
          		 (secondRepository.get(2))/(secondRepository.get(0))*100,
       		 (secondRepository.get(3)+secondRepository.get(4))/(secondRepository.get(14))*100,
       		 (secondRepository.get(3))/(secondRepository.get(14))*100,
       		 (secondRepository.get(4))/(secondRepository.get(14))*100,
       		 (secondRepository.get(3)+secondRepository.get(4))/(secondRepository.get(14))*100,
       		 (secondRepository.get(3))/(secondRepository.get(14))*100,
       		 (secondRepository.get(4))/(secondRepository.get(14))*100,
       		 (secondRepository.get(5)+secondRepository.get(6))/(secondRepository.get(0))*100,
       		 (secondRepository.get(5))/(secondRepository.get(0))*100,
       		 (secondRepository.get(6))/(secondRepository.get(0))*100,
       		 (secondRepository.get(5)+secondRepository.get(6))/(secondRepository.get(0))*100,
       		 (secondRepository.get(5))/(secondRepository.get(0))*100,
       		 (secondRepository.get(6))/(secondRepository.get(0))*100,
       		 (secondRepository.get(7)),
             (secondRepository.get(7))/(secondRepository.get(8))*100,
       		 (secondRepository.get(9)),
       		 (secondRepository.get(10)),
       		 (secondRepository.get(9))/(secondRepository.get(8))*100,//
       		 (secondRepository.get(10))/(secondRepository.get(8))*100,
       		 (secondRepository.get(11)),
       		 (secondRepository.get(11))/(secondRepository.get(12)),
       		 0.0,
       		 (secondRepository.get(13)),
       		 0.0};
        String[] processedsecondgoalvalues = processArray(unprocessedsecondgoalvalues);
        goalValues.put(22, List.of(List.of("Total"),List.of(processedsecondgoalvalues[0])));
        goalValues.put(23, List.of(List.of("Total"),List.of(processedsecondgoalvalues[1])));
        goalValues.put(24, List.of(List.of("Total","Female","Male"),List.of(processedsecondgoalvalues[2],processedsecondgoalvalues[3],processedsecondgoalvalues[4])));
        goalValues.put(25, List.of(List.of("Total","Female","Male"),List.of(processedsecondgoalvalues[5],processedsecondgoalvalues[6],processedsecondgoalvalues[7])));
        goalValues.put(26, List.of(List.of("Total","Female","Male"),List.of(processedsecondgoalvalues[8],processedsecondgoalvalues[9],processedsecondgoalvalues[10])));
        goalValues.put(27, List.of(List.of("Total","Female","Male"),List.of(processedsecondgoalvalues[11],processedsecondgoalvalues[12],processedsecondgoalvalues[13])));
        goalValues.put(28, List.of(List.of("Total"),List.of(processedsecondgoalvalues[14])));
        goalValues.put(29, List.of(List.of("Total"),List.of(processedsecondgoalvalues[15])));
        goalValues.put(30, List.of(List.of("Total"),List.of(processedsecondgoalvalues[16])));
        goalValues.put(31, List.of(List.of("Total"),List.of(processedsecondgoalvalues[17])));
        goalValues.put(32, List.of(List.of("Total"),List.of(processedsecondgoalvalues[18])));
        goalValues.put(33, List.of(List.of("Total"),List.of(processedsecondgoalvalues[19])));
        goalValues.put(34, List.of(List.of("Total"),List.of(processedsecondgoalvalues[20])));
        goalValues.put(35, List.of(List.of("Total"),List.of(processedsecondgoalvalues[21])));//WRONG
        goalValues.put(36, List.of(List.of("Total"),List.of(processedsecondgoalvalues[22])));//IGNORED
        goalValues.put(37, List.of(List.of("Total"),List.of(processedsecondgoalvalues[23])));
        goalValues.put(38, List.of(List.of("Total"),List.of(processedsecondgoalvalues[24])));//IGNORED

        return goalValues;

	}
	
	/*****************GOAL-3***********************/
	public LinkedHashMap<Integer, List<List<String>>> thirdValueCalculations() {
	  	List<String> infantDeaths = thirdGoalRepository.thirdGoalInfantDeaths();
	  	List<String> underAgeMR = thirdGoalRepository.thirdGoalUnderAgeMR();
	  	List<Float> thirdRepository = thirdGoalRepository.thirdGoalLeafNodeValues();
	  	int[] ininfantDeathsArray = maleAndFemale(infantDeaths);
	  	int[] underAgeMRArray = maleAndFemale(underAgeMR);
        goalValues = new LinkedHashMap<>();
        double[] unprocessedthirdGoalValues = {
        		(thirdRepository.get(1)),
        		(thirdRepository.get(2)),
        		ininfantDeathsArray[1],
        		ininfantDeathsArray[0],
        		ininfantDeathsArray[0]+ininfantDeathsArray[1],
        		(ininfantDeathsArray[1])/(thirdRepository.get(0))*100,
        		(ininfantDeathsArray[0])/(thirdRepository.get(0))*100,
        		(ininfantDeathsArray[0]+ininfantDeathsArray[1])/(thirdRepository.get(0))*100,
        		underAgeMRArray[1],
        		underAgeMRArray[0],
        		underAgeMRArray[0]+underAgeMRArray[1],
        		underAgeMRArray[1]/(thirdRepository.get(0))*100,
        		underAgeMRArray[0]/(thirdRepository.get(0))*100,
        		(underAgeMRArray[0]+underAgeMRArray[1])/(thirdRepository.get(0))*100,
        		(thirdRepository.get(3)),
        		(thirdRepository.get(3))/(thirdRepository.get(0))*100,
        		(thirdRepository.get(4)),
        		(thirdRepository.get(5)),
        		((thirdRepository.get(4))+(thirdRepository.get(5))),
        		(thirdRepository.get(6)),
        		(thirdRepository.get(7)),
        		(thirdRepository.get(8)),
        		(thirdRepository.get(9))/(thirdRepository.get(0))*100,
        		(thirdRepository.get(10))/(thirdRepository.get(20))*100,
        		(thirdRepository.get(11))/(thirdRepository.get(20))*100,
        		(thirdRepository.get(10)+thirdRepository.get(11))/(thirdRepository.get(20))*100,
        		0.0,
        		(thirdRepository.get(12)),
        		(thirdRepository.get(13)),
        		(thirdRepository.get(12)+thirdRepository.get(13)),
        		(thirdRepository.get(12))/(thirdRepository.get(0))*100,
        		(thirdRepository.get(13))/(thirdRepository.get(0))*100,
        		(thirdRepository.get(12)+thirdRepository.get(13))/(thirdRepository.get(0))*100,
        		(thirdRepository.get(14))/(thirdRepository.get(0))*100,
        		(thirdRepository.get(15))/(thirdRepository.get(0))*100,
        		(thirdRepository.get(14)+thirdRepository.get(15))/(thirdRepository.get(0))*100,
        		0.0,
        		(thirdRepository.get(16)),
        		(thirdRepository.get(17)),
        		(thirdRepository.get(16))+(thirdRepository.get(17)),
        		(thirdRepository.get(18))/thirdRepository.get(0)*100,
        		(thirdRepository.get(19))/thirdRepository.get(22)*100,
        		(thirdRepository.get(21))/thirdRepository.get(23)*100,
        		0.0,0.0,0.0};
        String[] processedthirdGoalValues = processArray(unprocessedthirdGoalValues);

        goalValues.put(39, List.of(List.of("Total"),List.of(processedthirdGoalValues[0])));
        goalValues.put(40, List.of(List.of("Total"),List.of(processedthirdGoalValues[1])));
        goalValues.put(41, List.of(List.of("Female","Male","Total"),List.of(processedthirdGoalValues[2],processedthirdGoalValues[3],processedthirdGoalValues[4])));
        goalValues.put(42, List.of(List.of("Female","Male","Total"),List.of(processedthirdGoalValues[5],processedthirdGoalValues[6],processedthirdGoalValues[7])));
        goalValues.put(43, List.of(List.of("Female","Male","Total"),List.of(processedthirdGoalValues[8],processedthirdGoalValues[9],processedthirdGoalValues[10])));
        goalValues.put(44, List.of(List.of("Female","Male","Total"),List.of(processedthirdGoalValues[11],processedthirdGoalValues[12],processedthirdGoalValues[13])));
        goalValues.put(45, List.of(List.of("Total" ),List.of(processedthirdGoalValues[14])));
        goalValues.put(46, List.of(List.of("Total" ),List.of(processedthirdGoalValues[15])));
        goalValues.put(47, List.of(List.of("Female","Male","Total"),List.of( processedthirdGoalValues[16],processedthirdGoalValues[17],processedthirdGoalValues[18])));
        goalValues.put(48, List.of(List.of("Total" ),List.of(processedthirdGoalValues[19])));
        goalValues.put(49, List.of(List.of("Total" ),List.of(processedthirdGoalValues[20])));
        goalValues.put(50, List.of(List.of("Total" ),List.of(processedthirdGoalValues[21])));
        goalValues.put(51, List.of(List.of("Total" ),List.of(processedthirdGoalValues[22])));
        goalValues.put(52, List.of(List.of("Female","Male","Total"),List.of(processedthirdGoalValues[23],processedthirdGoalValues[24],processedthirdGoalValues[25])));
        goalValues.put(53, List.of(List.of("Total" ),List.of(processedthirdGoalValues[26])));//IGNORED
        goalValues.put(54, List.of(List.of("Female","Male","Total"),List.of(processedthirdGoalValues[27],processedthirdGoalValues[28],processedthirdGoalValues[29])));
        goalValues.put(55, List.of(List.of("Female","Male","Total"),List.of(processedthirdGoalValues[30],processedthirdGoalValues[31],processedthirdGoalValues[32])));
        goalValues.put(56, List.of(List.of("Female","Male","Total"),List.of(processedthirdGoalValues[33],processedthirdGoalValues[34],processedthirdGoalValues[35])));
        goalValues.put(57, List.of(List.of("Total" ),List.of(processedthirdGoalValues[36])));//IGNORED
        goalValues.put(58, List.of(List.of("Female","Male","Total"),List.of(processedthirdGoalValues[37],processedthirdGoalValues[38],processedthirdGoalValues[39])));
        goalValues.put(59, List.of(List.of("Total" ),List.of(processedthirdGoalValues[40])));
        goalValues.put(60, List.of(List.of("Total" ),List.of(processedthirdGoalValues[41])));
        goalValues.put(61, List.of(List.of("Total" ),List.of(processedthirdGoalValues[42])));
        goalValues.put(62, List.of(List.of("Total" ),List.of(processedthirdGoalValues[43])));//IGNORED
        goalValues.put(63, List.of(List.of("Total" ),List.of(processedthirdGoalValues[44])));//IGNORED
        goalValues.put(64, List.of(List.of("Total" ),List.of(processedthirdGoalValues[45])));//IGNORED
	     return goalValues;
	}
	
	/****************GOAL 4********************/
	public LinkedHashMap<Integer, List<List<String>>> fourthValueCalculations() {
	  	List<Float> fourthRepository = fourthGoalRepository.fourthGoalLeafNodeValues();
        goalValues = new LinkedHashMap<>();
        double[] unprocessedfourthgoalvalues = {
        		(fourthRepository.get(9))/(fourthRepository.get(1))*100,
        		fourthRepository.get(10)/(fourthRepository.get(1))*100,
        		(fourthRepository.get(9)+fourthRepository.get(10))/(fourthRepository.get(1))*100,
        		fourthRepository.get(11)/(fourthRepository.get(2))*100,
        		fourthRepository.get(12)/(fourthRepository.get(2))*100,
        		(fourthRepository.get(11)+fourthRepository.get(12))/(fourthRepository.get(2))*100,
        		fourthRepository.get(13)/(fourthRepository.get(1))*100,
        		fourthRepository.get(14)/(fourthRepository.get(1))*100,
        		(fourthRepository.get(13)+fourthRepository.get(14))/(fourthRepository.get(1))*100,
        		fourthRepository.get(15)/(fourthRepository.get(2))*100,
        		fourthRepository.get(16)/(fourthRepository.get(2))*100,
        		(fourthRepository.get(15)+fourthRepository.get(16))/(fourthRepository.get(2))*100,
        		fourthRepository.get(17)/(fourthRepository.get(1))*100,
        		fourthRepository.get(18)/(fourthRepository.get(1))*100,
        		(fourthRepository.get(17)+fourthRepository.get(18))/(fourthRepository.get(1))*100,
        		fourthRepository.get(19)/(fourthRepository.get(2))*100,
        		fourthRepository.get(20)/(fourthRepository.get(2))*100,
        		(fourthRepository.get(19)+fourthRepository.get(20))/(fourthRepository.get(2))*100,
        		fourthRepository.get(21)/(fourthRepository.get(1))*100,
        		fourthRepository.get(22)/(fourthRepository.get(1))*100,
        		(fourthRepository.get(21)+fourthRepository.get(22))/(fourthRepository.get(1))*100,
        		fourthRepository.get(23)/(fourthRepository.get(2))*100,
        		fourthRepository.get(24)/(fourthRepository.get(2))*100,
        		(fourthRepository.get(23)+fourthRepository.get(24))/(fourthRepository.get(2))*100,
        		fourthRepository.get(25)/(fourthRepository.get(4))*100,
        		fourthRepository.get(26)/(fourthRepository.get(3))*100,
        		(fourthRepository.get(27)+fourthRepository.get(28))/(fourthRepository.get(4))*100,
        		fourthRepository.get(27)/(fourthRepository.get(4))*100,
        		fourthRepository.get(28)/(fourthRepository.get(4))*100,
        		(fourthRepository.get(29)+fourthRepository.get(30))/(fourthRepository.get(3))*100,
        		fourthRepository.get(29)/(fourthRepository.get(3))*100,
        		fourthRepository.get(30)/(fourthRepository.get(3))*100,
        		(fourthRepository.get(31)+fourthRepository.get(32))/(fourthRepository.get(6))*100,
        		fourthRepository.get(31)/(fourthRepository.get(6))*100,
        		fourthRepository.get(32)/(fourthRepository.get(6))*100,
        		(fourthRepository.get(33)+fourthRepository.get(34))/(fourthRepository.get(5))*100,
        		fourthRepository.get(33)/(fourthRepository.get(5))*100,
        		fourthRepository.get(34)/(fourthRepository.get(5))*100,
        		(fourthRepository.get(35)+fourthRepository.get(36))/(fourthRepository.get(8))*100,
        		fourthRepository.get(35)/(fourthRepository.get(8))*100,
        		fourthRepository.get(36)/(fourthRepository.get(8))*100,
        		(fourthRepository.get(37)+fourthRepository.get(38))/(fourthRepository.get(7))*100,
        		fourthRepository.get(37)/(fourthRepository.get(7))*100,
        		fourthRepository.get(38)/(fourthRepository.get(7))*100,
        		0.0,          //46 IGNORES
        		0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,
        		0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,
        		(fourthRepository.get(39)+fourthRepository.get(40))/(fourthRepository.get(0))*100,
        		fourthRepository.get(39)/(fourthRepository.get(0))*100,
        		fourthRepository.get(40)/(fourthRepository.get(0))*100,
        		(fourthRepository.get(41)+fourthRepository.get(42))/(fourthRepository.get(0))*100,
        		fourthRepository.get(41)/(fourthRepository.get(0))*100,
        		fourthRepository.get(42)/(fourthRepository.get(0))*100,
        		(fourthRepository.get(43)+fourthRepository.get(44))/(fourthRepository.get(0))*100,
        		fourthRepository.get(43)/(fourthRepository.get(0))*100,
        		fourthRepository.get(44)/(fourthRepository.get(0))*100,
        		(fourthRepository.get(45)+fourthRepository.get(46))/(fourthRepository.get(0))*100,
        		fourthRepository.get(45)/(fourthRepository.get(0))*100,
        		fourthRepository.get(46)/(fourthRepository.get(0))*100,
        		(fourthRepository.get(45)+fourthRepository.get(46))/(fourthRepository.get(0))*100,
        		fourthRepository.get(45)/(fourthRepository.get(0))*100,
        		fourthRepository.get(46)/(fourthRepository.get(0))*100
        		};
        String[] processedfourthGoalValues = processArray(unprocessedfourthgoalvalues);
        goalValues.put(65, List.of(List.of("Female (Rural)","Male (Rural)","Total (Rural)","Female (Urban)","Male (Urban)","Total (Urban)"),List.of(processedfourthGoalValues[0],processedfourthGoalValues[1],processedfourthGoalValues[2],processedfourthGoalValues[3],processedfourthGoalValues[4],processedfourthGoalValues[5])));
        goalValues.put(66, List.of(List.of("Female (Rural)","Male (Rural)","Total (Rural)","Female (Urban)","Male (Urban)","Total (Urban)"),List.of(processedfourthGoalValues[6],processedfourthGoalValues[7],processedfourthGoalValues[8],processedfourthGoalValues[9],processedfourthGoalValues[10],processedfourthGoalValues[11])));
        goalValues.put(67, List.of(List.of("Female (Rural)","Male (Rural)","Total (Rural)","Female (Urban)","Male (Urban)","Total (Urban)"),List.of(processedfourthGoalValues[12],processedfourthGoalValues[13],processedfourthGoalValues[14],processedfourthGoalValues[15],processedfourthGoalValues[16],processedfourthGoalValues[17])));
        goalValues.put(68, List.of(List.of("Female (Rural)","Male (Rural)","Total(Rural)","Female (Urban)","Male (Urban)","Total (Urban)"),List.of(processedfourthGoalValues[18],processedfourthGoalValues[19],processedfourthGoalValues[20],processedfourthGoalValues[21],processedfourthGoalValues[22],processedfourthGoalValues[23])));
        goalValues.put(69, List.of(List.of("Urban","Rural"),List.of(processedfourthGoalValues[24],processedfourthGoalValues[25])));                                                               
        goalValues.put(70, List.of(List.of("Total (Urban)","Female (Urban)","Male (Urban)","Total (Rural)","Female (Rural)","Male (Rural)" ),List.of(processedfourthGoalValues[26],processedfourthGoalValues[27],processedfourthGoalValues[28],processedfourthGoalValues[29],processedfourthGoalValues[30],processedfourthGoalValues[31])));
        goalValues.put(71, List.of(List.of("Total (Urban)","Female (Urban)","Male (Urban)","Total (Rural)","Female (Rural)","Male (Rural)" ),List.of(processedfourthGoalValues[32],processedfourthGoalValues[33],processedfourthGoalValues[34],processedfourthGoalValues[35],processedfourthGoalValues[36],processedfourthGoalValues[37])));
        goalValues.put(72, List.of(List.of("Total (Urban)","Female (Urban)","Male (Urban)","Total (Rural)","Female (Rural)", "Male (Rural)"),List.of(processedfourthGoalValues[38],processedfourthGoalValues[39],processedfourthGoalValues[40],processedfourthGoalValues[41],processedfourthGoalValues[42],processedfourthGoalValues[43])));
        goalValues.put(73, List.of(List.of("Total"),List.of(processedfourthGoalValues[44])));
        goalValues.put(74, List.of(List.of("Total"),List.of(processedfourthGoalValues[45])));
        goalValues.put(75, List.of(List.of("Total"),List.of(processedfourthGoalValues[46])));
        goalValues.put(76, List.of(List.of("Total"),List.of(processedfourthGoalValues[47])));
        goalValues.put(77, List.of(List.of("Total"),List.of(processedfourthGoalValues[48])));
        goalValues.put(78, List.of(List.of("Total"),List.of(processedfourthGoalValues[49])));
        goalValues.put(79, List.of(List.of("Total"),List.of(processedfourthGoalValues[50])));
        goalValues.put(80, List.of(List.of("Total"),List.of(processedfourthGoalValues[51])));
        goalValues.put(81, List.of(List.of("Total"),List.of(processedfourthGoalValues[52])));
        goalValues.put(82, List.of(List.of("Total"),List.of(processedfourthGoalValues[53])));
        goalValues.put(83, List.of(List.of("Total"),List.of(processedfourthGoalValues[54])));
        goalValues.put(84, List.of(List.of("Total"),List.of(processedfourthGoalValues[55])));
        goalValues.put(85, List.of(List.of("Total"),List.of(processedfourthGoalValues[56])));
        goalValues.put(86, List.of(List.of("Total"),List.of(processedfourthGoalValues[57])));
        goalValues.put(87, List.of(List.of("Total"),List.of(processedfourthGoalValues[58])));
        goalValues.put(88, List.of(List.of("Total"),List.of(processedfourthGoalValues[59])));
        goalValues.put(89, List.of(List.of("Total"),List.of(processedfourthGoalValues[60])));
        goalValues.put(90, List.of(List.of("Total"),List.of(processedfourthGoalValues[61])));
        goalValues.put(91, List.of(List.of("Total"),List.of(processedfourthGoalValues[62])));
        goalValues.put(92, List.of(List.of("Total"),List.of(processedfourthGoalValues[63])));
        goalValues.put(93, List.of(List.of("Total"),List.of(processedfourthGoalValues[64])));
        goalValues.put(94, List.of(List.of("Total"),List.of(processedfourthGoalValues[65])));
        goalValues.put(95, List.of(List.of("Total"),List.of(processedfourthGoalValues[66])));
        goalValues.put(96, List.of(List.of("Total"),List.of(processedfourthGoalValues[67])));
        goalValues.put(97, List.of(List.of("Total"),List.of(processedfourthGoalValues[68])));
        goalValues.put(98, List.of(List.of("Total"),List.of(processedfourthGoalValues[69])));
        goalValues.put(99, List.of(List.of("Total"),List.of(processedfourthGoalValues[70])));
        goalValues.put(100, List.of(List.of("Total"),List.of(processedfourthGoalValues[71])));
        goalValues.put(101, List.of(List.of("Total"),List.of(processedfourthGoalValues[72])));
        goalValues.put(102, List.of(List.of("Total"),List.of(processedfourthGoalValues[73])));
        goalValues.put(103, List.of(List.of("Total"),List.of(processedfourthGoalValues[74])));
        goalValues.put(104, List.of(List.of("Total"),List.of(processedfourthGoalValues[75])));
        goalValues.put(105, List.of(List.of("Total"),List.of(processedfourthGoalValues[76])));
        goalValues.put(106, List.of(List.of("Total"),List.of(processedfourthGoalValues[77])));
        goalValues.put(107, List.of(List.of("Total"),List.of(processedfourthGoalValues[78])));
        goalValues.put(108, List.of(List.of("Total"),List.of(processedfourthGoalValues[79])));
        goalValues.put(109, List.of(List.of("Total"),List.of(processedfourthGoalValues[80])));
        goalValues.put(110, List.of(List.of("Total"),List.of(processedfourthGoalValues[81])));
        goalValues.put(111, List.of(List.of("Total"),List.of(processedfourthGoalValues[82])));
        goalValues.put(112, List.of(List.of("Total"),List.of(processedfourthGoalValues[83])));
        goalValues.put(113, List.of(List.of("Total"),List.of(processedfourthGoalValues[84])));
        goalValues.put(114, List.of(List.of("Total"),List.of(processedfourthGoalValues[85])));
        goalValues.put(115, List.of(List.of("Total"),List.of(processedfourthGoalValues[86])));
        goalValues.put(116, List.of(List.of("Total"),List.of(processedfourthGoalValues[87])));
        goalValues.put(117, List.of(List.of("Total"),List.of(processedfourthGoalValues[88])));
        goalValues.put(118, List.of(List.of("Total"),List.of(processedfourthGoalValues[89])));
        goalValues.put(119, List.of(List.of("Total","Female","Male"),List.of(processedfourthGoalValues[90],processedfourthGoalValues[91],processedfourthGoalValues[92])));
        goalValues.put(120, List.of(List.of("Total","Female","Male"),List.of(processedfourthGoalValues[93],processedfourthGoalValues[94],processedfourthGoalValues[95])));
        goalValues.put(121, List.of(List.of("Total","Female","Male"),List.of(processedfourthGoalValues[96],processedfourthGoalValues[97],processedfourthGoalValues[98])));
        goalValues.put(122, List.of(List.of("Total","Female","Male"),List.of(processedfourthGoalValues[99],processedfourthGoalValues[100],processedfourthGoalValues[101])));
        goalValues.put(123, List.of(List.of("Total","Female","Male"),List.of(processedfourthGoalValues[102],processedfourthGoalValues[103],processedfourthGoalValues[104])));        

        return goalValues;
	}
	
	/****************GOAL 5********************/
	public LinkedHashMap<Integer, List<List<String>>> fifthValueCalculations() {
	  	List<Float> fifthRepository = fifthGoalRepository.fifthGoalLeafNodeValues();
        goalValues = new LinkedHashMap<>();
        double[] unprocessedfifthgoalvalues = {
        		fifthRepository.get(4)/fifthRepository.get(1)*100,
        		0.0,
        		fifthRepository.get(5)/fifthRepository.get(1)*100,
        		fifthRepository.get(6)/fifthRepository.get(1)*100,
        		fifthRepository.get(7)/fifthRepository.get(2)*100,
        		fifthRepository.get(8)/fifthRepository.get(2)*100,
        		fifthRepository.get(9)/fifthRepository.get(2)*100,
        		(fifthRepository.get(7)+fifthRepository.get(8)+fifthRepository.get(9))/fifthRepository.get(2)*100,
        		fifthRepository.get(10)/fifthRepository.get(0)*100,
        		fifthRepository.get(11)/fifthRepository.get(0)*100,
        		fifthRepository.get(12)/fifthRepository.get(0)*100,
        		fifthRepository.get(13),
        		fifthRepository.get(14),
        		fifthRepository.get(13)+fifthRepository.get(14),
        		0.0,0.0,
        		fifthRepository.get(15),
        		fifthRepository.get(15),
        		fifthRepository.get(16)/fifthRepository.get(0)*100,
        		fifthRepository.get(15)/fifthRepository.get(0)*100,
        		fifthRepository.get(17)/fifthRepository.get(0)*100,
        		fifthRepository.get(18)/fifthRepository.get(0)*100,
        		0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,
        		(fifthRepository.get(19)+fifthRepository.get(20))/fifthRepository.get(0)*100,
        		fifthRepository.get(19)/fifthRepository.get(0)*100,
        		fifthRepository.get(19)/fifthRepository.get(2)*100,
        		fifthRepository.get(20)/fifthRepository.get(3)*100,
        		fifthRepository.get(21)/fifthRepository.get(0)*100,
        		0.0};
        String[] processedfifthGoalValues = processArray(unprocessedfifthgoalvalues);
        goalValues.put(124, List.of(List.of("Violence against women","Overarching legal frameworks and public life",
        		"Marriage and family","Employment and economic benefits"),List.of(processedfifthGoalValues[0],processedfifthGoalValues[1],
        				processedfifthGoalValues[2],processedfifthGoalValues[3])));
        goalValues.put(125, List.of(List.of("Female 15-24 yr","Female 25-35 yr","Female 36-49 yr","Total"),List.of(processedfifthGoalValues[4],processedfifthGoalValues[5],
        		processedfifthGoalValues[6],processedfifthGoalValues[7])));
        goalValues.put(126, List.of(List.of("Female"),List.of(processedfifthGoalValues[8])));
        goalValues.put(127, List.of(List.of("Female"),List.of(processedfifthGoalValues[9])));
        goalValues.put(128, List.of(List.of("Female"),List.of(processedfifthGoalValues[10])));
        goalValues.put(129, List.of(List.of("Female","Male","Total"),List.of(processedfifthGoalValues[11],processedfifthGoalValues[12],processedfifthGoalValues[13])));
        goalValues.put(130, List.of(List.of("Total"),List.of(processedfifthGoalValues[14])));
        goalValues.put(131, List.of(List.of("Total"),List.of(processedfifthGoalValues[15])));
        goalValues.put(132, List.of(List.of("Female"),List.of(processedfifthGoalValues[16])));
        goalValues.put(133, List.of(List.of("Female"),List.of(processedfifthGoalValues[17])));
        goalValues.put(134, List.of(List.of("Female"),List.of(processedfifthGoalValues[18])));
        goalValues.put(135, List.of(List.of("Female"),List.of(processedfifthGoalValues[19])));
        goalValues.put(136, List.of(List.of("Female"),List.of(processedfifthGoalValues[20])));
        goalValues.put(137, List.of(List.of("Female"),List.of(processedfifthGoalValues[21])));
        goalValues.put(138, List.of(List.of("Total"),List.of(processedfifthGoalValues[22])));
        goalValues.put(139, List.of(List.of("Total"),List.of(processedfifthGoalValues[23])));
        goalValues.put(140, List.of(List.of("Total"),List.of(processedfifthGoalValues[24])));
        goalValues.put(141, List.of(List.of("Total"),List.of(processedfifthGoalValues[25])));
        goalValues.put(142, List.of(List.of("Total"),List.of(processedfifthGoalValues[26])));
        goalValues.put(143, List.of(List.of("Total"),List.of(processedfifthGoalValues[27])));
        goalValues.put(144, List.of(List.of("Total"),List.of(processedfifthGoalValues[28])));
        goalValues.put(145, List.of(List.of("Total"),List.of(processedfifthGoalValues[29])));
        goalValues.put(146, List.of(List.of("Total"),List.of(processedfifthGoalValues[30])));
        goalValues.put(147, List.of(List.of("Total"),List.of(processedfifthGoalValues[31])));
        goalValues.put(148, List.of(List.of("Total"),List.of(processedfifthGoalValues[32])));
        goalValues.put(149, List.of(List.of("Total"),List.of(processedfifthGoalValues[33])));
        goalValues.put(150, List.of(List.of("Total"),List.of(processedfifthGoalValues[34])));
        goalValues.put(151, List.of(List.of("Total"),List.of(processedfifthGoalValues[35])));
        goalValues.put(152, List.of(List.of("Total"),List.of(processedfifthGoalValues[36])));
        goalValues.put(153, List.of(List.of("Total"),List.of(processedfifthGoalValues[37])));
        goalValues.put(154, List.of(List.of("Total"),List.of(processedfifthGoalValues[38])));
        goalValues.put(155, List.of(List.of("Total"),List.of(processedfifthGoalValues[39])));
        goalValues.put(156, List.of(List.of("Total"),List.of(processedfifthGoalValues[40])));
        goalValues.put(157, List.of(List.of("Total"),List.of(processedfifthGoalValues[41])));
        goalValues.put(158, List.of(List.of("Total"),List.of(processedfifthGoalValues[42])));        
        goalValues.put(159, List.of(List.of("Total"),List.of(processedfifthGoalValues[43])));
        goalValues.put(160, List.of(List.of("Female"),List.of(processedfifthGoalValues[44])));        
        goalValues.put(161, List.of(List.of("Female","Male"),List.of(processedfifthGoalValues[45],processedfifthGoalValues[46])));
        goalValues.put(162, List.of(List.of("Total"),List.of(processedfifthGoalValues[47])));        
        goalValues.put(163, List.of(List.of("Total"),List.of(processedfifthGoalValues[48])));        

        return goalValues;
	}
	/****************GOAL 6********************/
	public LinkedHashMap<Integer, List<List<String>>> sixthValueCalculations() {
	  	List<Float> sixthRepository = sixthGoalRepository.sixthGoalLeafNodeValues();

        goalValues = new LinkedHashMap<>();
        double[] unprocessedsixthgoalvalues = {
        		sixthRepository.get(5)/sixthRepository.get(1)*100,
        		sixthRepository.get(6)/sixthRepository.get(2)*100,
        		(sixthRepository.get(5)+sixthRepository.get(6))/(sixthRepository.get(1)+sixthRepository.get(2))*100,
        		sixthRepository.get(7)/sixthRepository.get(3)*100,
        		sixthRepository.get(8)/sixthRepository.get(4)*100,
        		sixthRepository.get(9)/sixthRepository.get(3)*100,
        		sixthRepository.get(10)/sixthRepository.get(4)*100,
        		sixthRepository.get(11)/sixthRepository.get(3)*100,
        		sixthRepository.get(12)/sixthRepository.get(4)*100,
        		sixthRepository.get(13)/sixthRepository.get(3)*100,
        		sixthRepository.get(14)/sixthRepository.get(4)*100,
        		sixthRepository.get(15)/sixthRepository.get(3)*100,
        		sixthRepository.get(16)/sixthRepository.get(4)*100,
        		sixthRepository.get(17)/sixthRepository.get(3)*100,
        		sixthRepository.get(18)/sixthRepository.get(4)*100,
        		sixthRepository.get(19)/sixthRepository.get(3)*100,
        		sixthRepository.get(20)/sixthRepository.get(4)*100,
        		sixthRepository.get(21)/sixthRepository.get(3)*100,
        		sixthRepository.get(22)/sixthRepository.get(4)*100,
        		0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};
        String[] processedsixthGoalValues = processArray(unprocessedsixthgoalvalues);
        goalValues.put(164, List.of(List.of("Rural","Urban","Total"),List.of(processedsixthGoalValues[0],processedsixthGoalValues [1],processedsixthGoalValues [2])));
        goalValues.put(165, List.of(List.of("Rural","Urban"),List.of(processedsixthGoalValues[3],processedsixthGoalValues [4])));
        goalValues.put(166, List.of(List.of("Rural","Urban"),List.of(processedsixthGoalValues[5],processedsixthGoalValues [6])));
        goalValues.put(167, List.of(List.of("Rural","Urban"),List.of(processedsixthGoalValues[7],processedsixthGoalValues [8])));
        goalValues.put(168, List.of(List.of("Rural","Urban"),List.of(processedsixthGoalValues[9],processedsixthGoalValues [10])));
        goalValues.put(169, List.of(List.of("Rural","Urban"),List.of(processedsixthGoalValues[11],processedsixthGoalValues[12])));
        goalValues.put(170, List.of(List.of("Rural","Urban"),List.of(processedsixthGoalValues[13],processedsixthGoalValues[14])));
        goalValues.put(171, List.of(List.of("Rural","Urban"),List.of(processedsixthGoalValues[15],processedsixthGoalValues[16])));
        goalValues.put(172, List.of(List.of("Rural","Urban"),List.of(processedsixthGoalValues[17],processedsixthGoalValues[18])));   
        goalValues.put(173, List.of(List.of("Rural","Urban","Total"),List.of(getConfigs(0),getConfigs(1),getConfigs(2))));
        goalValues.put(174, List.of(List.of("Rural","Urban","Total"),List.of(getConfigs(3),getConfigs(4),getConfigs(5))));
        goalValues.put(175, List.of(List.of("Rural","Urban","Total"),List.of(getConfigs(6),getConfigs(7),getConfigs(8))));
        goalValues.put(176, List.of(List.of("Total"),List.of(processedsixthGoalValues[19])));
        goalValues.put(177, List.of(List.of("Total"),List.of(processedsixthGoalValues[20])));
        goalValues.put(178, List.of(List.of("Total"),List.of(processedsixthGoalValues[21])));
        goalValues.put(179, List.of(List.of("Total"),List.of(processedsixthGoalValues[22])));
        goalValues.put(180, List.of(List.of("Total"),List.of(processedsixthGoalValues[23])));
        goalValues.put(181, List.of(List.of("Total"),List.of(processedsixthGoalValues[24])));
        goalValues.put(182, List.of(List.of("Total"),List.of(processedsixthGoalValues[25])));
        goalValues.put(183, List.of(List.of("Total"),List.of(processedsixthGoalValues[26])));
        goalValues.put(184, List.of(List.of("Total"),List.of(processedsixthGoalValues[27])));
        goalValues.put(185, List.of(List.of("Total"),List.of(processedsixthGoalValues[28])));
        goalValues.put(186, List.of(List.of("Total"),List.of(processedsixthGoalValues[29])));
        goalValues.put(187, List.of(List.of("Total"),List.of(processedsixthGoalValues[30])));
        goalValues.put(188, List.of(List.of("Total"),List.of(processedsixthGoalValues[31])));
        goalValues.put(189, List.of(List.of("Total"),List.of(processedsixthGoalValues[32])));
        goalValues.put(190, List.of(List.of("Total"),List.of(processedsixthGoalValues[33])));
        goalValues.put(191, List.of(List.of("Total"),List.of(processedsixthGoalValues[34])));
        goalValues.put(192, List.of(List.of("Total"),List.of(processedsixthGoalValues[35])));
        goalValues.put(193, List.of(List.of("Total"),List.of(processedsixthGoalValues[36])));
        goalValues.put(194, List.of(List.of("Total"),List.of(processedsixthGoalValues[37])));
        goalValues.put(195, List.of(List.of("Total"),List.of(processedsixthGoalValues[38])));
        goalValues.put(196, List.of(List.of("Total"),List.of(processedsixthGoalValues[39])));
        goalValues.put(197, List.of(List.of("Total"),List.of(processedsixthGoalValues[40])));
        goalValues.put(198, List.of(List.of("Total"),List.of(processedsixthGoalValues[41])));
        goalValues.put(199, List.of(List.of("Total"),List.of(processedsixthGoalValues[42])));
        goalValues.put(200, List.of(List.of("Total"),List.of(processedsixthGoalValues[43])));
        goalValues.put(201, List.of(List.of("Total"),List.of(processedsixthGoalValues[44])));
        goalValues.put(202, List.of(List.of("Total"),List.of(processedsixthGoalValues[45])));
        goalValues.put(203, List.of(List.of("Total"),List.of(processedsixthGoalValues[46])));
        goalValues.put(204, List.of(List.of("Total"),List.of(processedsixthGoalValues[47])));

        return goalValues;
        }
	/***************GOAL 7*******************/
	public LinkedHashMap<Integer, List<List<String>>> seventhValueCalculations() {
	  	List<Float> seventhRepository = seventhGoalRepository.seventhGoalLeafNodeValues();

	      goalValues = new LinkedHashMap<>();
	      double[] unprocessedseventhgoalvalues = {
		    		seventhRepository.get(1)/seventhRepository.get(0)*100,
		    		seventhRepository.get(2)/seventhRepository.get(0)*100,
		    		seventhRepository.get(3)/seventhRepository.get(0)*100,
		    		0.0
			};
	        String[] processedseventhGoalValues = processArray(unprocessedseventhgoalvalues);

	        goalValues.put(205, List.of(List.of("Total"),List.of(processedseventhGoalValues[0])));
	        goalValues.put(206, List.of(List.of("Total"),List.of(processedseventhGoalValues[1])));
	        goalValues.put(207, List.of(List.of("Total"),List.of(processedseventhGoalValues[2])));
	        goalValues.put(208, List.of(List.of("Total"),List.of(getConfigs(9))));
	        goalValues.put(209, List.of(List.of("Total"),List.of(processedseventhGoalValues[3])));

	        return goalValues;

	
}
	/***************GOAL 8*******************/
	public LinkedHashMap<Integer, List<List<String>>> eigthValueCalculations() {
	  	List<Float> eigthRepository = eigthGoalRepository.eigthGoalLeafNodeValues();
	      goalValues = new LinkedHashMap<>();
	      double[] unprocessedeigthgoalvalues = {
	    		  0.0,0.0,
	      		eigthRepository.get(3)/eigthRepository.get(0)*100,
	      		eigthRepository.get(4)/eigthRepository.get(0)*100,
	      		(eigthRepository.get(3)+eigthRepository.get(4))/eigthRepository.get(0)*100,
	      		0.0,0.0,0.0,0.0,0.0,0.0,
	      		eigthRepository.get(5)/(eigthRepository.get(3)+eigthRepository.get(4)),
	      		eigthRepository.get(6)/(eigthRepository.get(3)+eigthRepository.get(4)),
	      		(eigthRepository.get(5)+eigthRepository.get(6))/(eigthRepository.get(3)+eigthRepository.get(4)),
	      		eigthRepository.get(7)/eigthRepository.get(0)*100,
	      		eigthRepository.get(8)/eigthRepository.get(0)*100,
	      		(eigthRepository.get(7)+eigthRepository.get(8))/eigthRepository.get(0)*100,
	      		eigthRepository.get(9)/eigthRepository.get(1)*100,
	      		eigthRepository.get(10)/eigthRepository.get(1)*100,
	      		(eigthRepository.get(9)+eigthRepository.get(10))/eigthRepository.get(1)*100,
	      		eigthRepository.get(11)/eigthRepository.get(2)*100,
	      		eigthRepository.get(12)/eigthRepository.get(2)*100,
	      		(eigthRepository.get(11)+eigthRepository.get(12))/eigthRepository.get(2)*100,
	      		0.0,0.0,0.0,0.0,0.0,
	      		eigthRepository.get(13)/eigthRepository.get(0)*100,
	      		eigthRepository.get(14)/eigthRepository.get(0)*100,
	      		(eigthRepository.get(13)+eigthRepository.get(14))/eigthRepository.get(0)*100,
	      		0.0,0.0,0.0,0.0,0.0,

	      };
	      String[] processedeigthGoalValues = processArray(unprocessedeigthgoalvalues);
	        goalValues.put(210, List.of(List.of("Total"),List.of(processedeigthGoalValues[0])));
	        goalValues.put(211, List.of(List.of("Total"),List.of(processedeigthGoalValues[1])));
	        goalValues.put(212, List.of(List.of("Female","Male","Total"),List.of(processedeigthGoalValues[2],processedeigthGoalValues[3],processedeigthGoalValues[4])));
	        goalValues.put(213, List.of(List.of("Total"),List.of(processedeigthGoalValues[5])));
	        goalValues.put(214, List.of(List.of("Total"),List.of(processedeigthGoalValues[6])));
	        goalValues.put(215, List.of(List.of("Total"),List.of(processedeigthGoalValues[7])));
	        goalValues.put(216, List.of(List.of("Total"),List.of(processedeigthGoalValues[8])));
	        goalValues.put(217, List.of(List.of("Total"),List.of(processedeigthGoalValues[9])));
	        goalValues.put(218, List.of(List.of("Total"),List.of(processedeigthGoalValues[10])));
	        goalValues.put(219, List.of(List.of("Female","Male","Total"),List.of(processedeigthGoalValues[11],processedeigthGoalValues[12],processedeigthGoalValues[13])));
	        goalValues.put(220, List.of(List.of("Female","Male","Total"),List.of(processedeigthGoalValues[14],processedeigthGoalValues[15],processedeigthGoalValues[16])));
	        goalValues.put(221, List.of(List.of("Female","Male","Total"),List.of(processedeigthGoalValues[17],processedeigthGoalValues[18],processedeigthGoalValues[19])));
	        goalValues.put(222, List.of(List.of("Female","Male","Total"),List.of(processedeigthGoalValues[20],processedeigthGoalValues[21],processedeigthGoalValues[22])));
	        goalValues.put(223, List.of(List.of("Total"),List.of(processedeigthGoalValues[23])));
	        goalValues.put(224, List.of(List.of("Total"),List.of(processedeigthGoalValues[24])));
	        goalValues.put(225, List.of(List.of("Total"),List.of(processedeigthGoalValues[25])));
	        goalValues.put(226, List.of(List.of("Total"),List.of(processedeigthGoalValues[26])));
	        goalValues.put(227, List.of(List.of("Total"),List.of(processedeigthGoalValues[27])));
	        goalValues.put(228, List.of(List.of("Total"),List.of(getConfigs(10))));
	        goalValues.put(229, List.of(List.of("Total"),List.of(getConfigs(11))));
	        goalValues.put(230, List.of(List.of("Female","Male","Total"),List.of(processedeigthGoalValues[28],processedeigthGoalValues[29],processedeigthGoalValues[30])));
	        goalValues.put(231, List.of(List.of("Total"),List.of(processedeigthGoalValues[31])));
	        goalValues.put(232, List.of(List.of("Total"),List.of(processedeigthGoalValues[32])));
	        goalValues.put(233, List.of(List.of("Total"),List.of(processedeigthGoalValues[33])));
	        goalValues.put(234, List.of(List.of("Total"),List.of(processedeigthGoalValues[34])));
	        goalValues.put(235, List.of(List.of("Total"),List.of(processedeigthGoalValues[35])));

	        return goalValues;
	}
	/***************GOAL 9*******************/
	public LinkedHashMap<Integer, List<List<String>>> ninthValueCalculations() {
	  	List<Float> ninthRepository = ninthGoalRepository.ninthGoalLeafNodeValues();

	      goalValues = new LinkedHashMap<>();
	double[] unprocessedninthgoalvalues = {
    		0.0,0.0,
    		ninthRepository.get(7),
    		ninthRepository.get(7)/ninthRepository.get(1),
    		ninthRepository.get(8)/ninthRepository.get(2)*100,
    		ninthRepository.get(9)/ninthRepository.get(3)*100,
    		ninthRepository.get(10)/ninthRepository.get(4)*100,
    		0.0,0.0,0.0,
    		ninthRepository.get(11)/ninthRepository.get(5)*100,
    		0.0,0.0,0.0,0.0,
    		ninthRepository.get(12)/ninthRepository.get(6)*100	
	};
    String[] processedninthGoalValues = processArray(unprocessedninthgoalvalues);
    goalValues.put(236, List.of(List.of("Total"),List.of(getConfigs(12))));
    goalValues.put(237, List.of(List.of("Total"),List.of(processedninthGoalValues[0])));
    goalValues.put(238, List.of(List.of("Total"),List.of(processedninthGoalValues[1])));
    goalValues.put(239, List.of(List.of("Total"),List.of(getConfigs(13))));
    goalValues.put(240, List.of(List.of("Total"),List.of(processedninthGoalValues[2])));
    goalValues.put(241, List.of(List.of("Total"),List.of(processedninthGoalValues[3])));
    goalValues.put(242, List.of(List.of("Total"),List.of(processedninthGoalValues[4])));
    goalValues.put(243, List.of(List.of("Total"),List.of(processedninthGoalValues[5])));
    goalValues.put(244, List.of(List.of("Total"),List.of(processedninthGoalValues[6])));
    goalValues.put(245, List.of(List.of("Total"),List.of(processedninthGoalValues[7])));
    goalValues.put(246, List.of(List.of("Total"),List.of(processedninthGoalValues[8])));
    goalValues.put(247, List.of(List.of("Total"),List.of(processedninthGoalValues[9])));
    goalValues.put(248, List.of(List.of("Total"),List.of(getConfigs(14))));
    goalValues.put(249, List.of(List.of("Total"),List.of(processedninthGoalValues[10])));
    goalValues.put(250, List.of(List.of("Total"),List.of(processedninthGoalValues[11])));
    goalValues.put(251, List.of(List.of("Total"),List.of(processedninthGoalValues[12])));
    goalValues.put(252, List.of(List.of("Total"),List.of(processedninthGoalValues[13])));
    goalValues.put(253, List.of(List.of("Total"),List.of(processedninthGoalValues[14])));
    goalValues.put(254, List.of(List.of("Total"),List.of(processedninthGoalValues[15])));

    return goalValues;
	}
	/****************GOAL 10********************/
	public LinkedHashMap<Integer, List<List<String>>> tenthValueCalculations() {
	  	List<Float> tenthRepository = tenthGoalRepository.tenthGoalLeafNodeValues();

	      goalValues = new LinkedHashMap<>();
	      double[] unprocessedtenthgoalvalues = {
	      		tenthRepository.get(3)/tenthRepository.get(1),
	      		tenthRepository.get(4)/tenthRepository.get(2),
	      		tenthRepository.get(5)/(tenthRepository.get(1)+tenthRepository.get(2))*100,
	      		tenthRepository.get(6)/tenthRepository.get(0)*100,
	      		tenthRepository.get(7)/tenthRepository.get(0)*100,
	      		0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0
	      };
	      String[] processedtenthGoalValues = processArray(unprocessedtenthgoalvalues);
	      goalValues.put(255, List.of(List.of("Female","Male","Total"),List.of(processedtenthGoalValues[0],processedtenthGoalValues[1],(unprocessedtenthgoalvalues[2]==0.0) ? "0%": processedtenthGoalValues[2]+"%" )));
	      goalValues.put(256, List.of(List.of("Total"),List.of(processedtenthGoalValues[3])));
	      goalValues.put(257, List.of(List.of("Total"),List.of(processedtenthGoalValues[4])));
	      goalValues.put(258, List.of(List.of("Total"),List.of(processedtenthGoalValues[5])));
	      goalValues.put(259, List.of(List.of("Total"),List.of(processedtenthGoalValues[6])));
	      goalValues.put(260, List.of(List.of("Total"),List.of(processedtenthGoalValues[7])));
	      goalValues.put(261, List.of(List.of("Total"),List.of(processedtenthGoalValues[8])));
	      goalValues.put(262, List.of(List.of("Total"),List.of(processedtenthGoalValues[9])));
	      goalValues.put(263, List.of(List.of("Total"),List.of(processedtenthGoalValues[10])));
	      goalValues.put(264, List.of(List.of("Total"),List.of(processedtenthGoalValues[11])));
	      goalValues.put(265, List.of(List.of("Total"),List.of(processedtenthGoalValues[12])));
	      goalValues.put(266, List.of(List.of("Total"),List.of(processedtenthGoalValues[13])));
	      goalValues.put(267, List.of(List.of("Total"),List.of(processedtenthGoalValues[14])));
	      goalValues.put(268, List.of(List.of("Total"),List.of(processedtenthGoalValues[15])));
	      goalValues.put(269, List.of(List.of("Total"),List.of(processedtenthGoalValues[16])));
	      goalValues.put(270, List.of(List.of("Total"),List.of(processedtenthGoalValues[17])));
	      goalValues.put(271, List.of(List.of("Total"),List.of(processedtenthGoalValues[18])));
	      goalValues.put(272, List.of(List.of("Total"),List.of(processedtenthGoalValues[19])));
	      goalValues.put(273, List.of(List.of("Total"),List.of(processedtenthGoalValues[20])));
	      goalValues.put(274, List.of(List.of("Total"),List.of(processedtenthGoalValues[21])));

	      return goalValues;
	  	}
	public int[] maleAndFemale(List<String> lists){
		int[] children = new int[2];
        for (int i = 0; i < lists.size(); i++) {
            String[] parts = lists.get(i).split(",");
            for (String part : parts) {
                String[] subparts = part.split("-");
                if (subparts[0].equals("M")) {
                    children[0] += Integer.parseInt(subparts[1]);
                } else if (subparts[0].equals("F")) {
                    children[1] += Integer.parseInt(subparts[1]);
                }
            }
        }

		return children;
	}

	
    public String[] processArray(double[] arr) {
    	DecimalFormat df = new DecimalFormat("#.#");
        df.setRoundingMode(RoundingMode.HALF_UP);
        double[] unpro = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            unpro[i] = Double.parseDouble(df.format(arr[i]));
          }
        String[] pro = new String[unpro.length];
        for (int i = 0; i < unpro.length; i++) {
            double value = unpro[i];
            if (Double.isInfinite(value) || Double.isNaN(value) || value == 0.0) {
                pro[i] = "No data available";
            } else if (value % 1 == 0) {
                pro[i] = Integer.toString((int) value);
            } else {
                pro[i] = Double.toString(value);
            }
        }

        return pro;
    }
    public String getConfigs(int configId) {
		List<String> configList = configParamRepository.configList();
		return configList.get(configId);
    }
}