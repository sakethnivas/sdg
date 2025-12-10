package com.sdg.goals.service.impl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.sdg.goals.service.DateService;

@Service
public class DateServiceImpl implements DateService {

	@Autowired
	FirstGoalRepository firstGoalRepository;
	@Autowired
	SecondGoalRepository secondGoalRepository;
	@Autowired
	ThirdGoalRepository thirdGoalRepository;
	@Autowired
	FourthGoalRepository fourthGoalRepository;
	@Autowired
	FifthGoalRepository fifthGoalRepository;
	@Autowired
	SixthGoalRepository sixthGoalRepository;
	@Autowired
	SeventhGoalRepository seventhGoalRepository;
	@Autowired
	EigthGoalRepository eigthGoalRepository;
	@Autowired
	NinthGoalRepository ninthGoalRepository;
	@Autowired
	TenthGoalRepository tenthGoalRepository;

	
	
	@Override
	public int uploadedYear(int SGId) {

		if(SGId>0&&SGId<22) {
			
			return Integer.parseInt(firstGoalRepository.firstGoalDate().substring(0, 4));
		}
		else if(SGId>21 && SGId<39){
			
			return Integer.parseInt(secondGoalRepository.secondGoalDate().substring(0, 4));
		}
		else if(SGId>38 && SGId<65){
			

			return Integer.parseInt(thirdGoalRepository.thirdGoalDate().substring(0, 4));
		}
		else if(SGId>64 && SGId<124){
			

			return Integer.parseInt(fourthGoalRepository.fourthGoalDate().substring(0, 4));
		}
		else if(SGId>123 && SGId<164){
			

			return Integer.parseInt(fifthGoalRepository.fifthGoalDate().substring(0, 4));
		}
		else if(SGId>163 && SGId<205) {
			
			return Integer.parseInt(sixthGoalRepository.sixthGoalDate().substring(0, 4));
		}
		else if(SGId>204 && SGId<210) {
			
			return Integer.parseInt(seventhGoalRepository.seventhGoalDate().substring(0, 4));
		}
		else if(SGId>209 && SGId<236) {
			
			return Integer.parseInt(eigthGoalRepository.eigthGoalDate().substring(0, 4));
		}
		else if(SGId>235 && SGId<255) {
			
			return Integer.parseInt(ninthGoalRepository.ninthGoalDate().substring(0, 4));
		}
		else {
			

			return Integer.parseInt(tenthGoalRepository.tenthGoalDate().substring(0, 4));
		}
		
	}

}