package com.cinema.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.test.DTO.ResponseRegDTO;
import com.cinema.test.model.Hall;
import com.cinema.test.repository.HallRepository;
import com.cinema.test.service.HallService;

@Service

public class HallServiceImpl implements HallService {
	@Autowired
	private HallRepository hallRep;
	@Override
	public ResponseRegDTO createHall(Hall hall) {
		try { hallRep.save(hall);
			return new ResponseRegDTO("OK");
			
		}
		catch(Exception e) {
			System.out.println(e.toString());
			return new ResponseRegDTO("Error");
		}
	}

	@Override
	public ResponseRegDTO updateHall(Hall hall) {
		try { hallRep.save(hall);
		return new ResponseRegDTO("OK");
		
	}
	catch(Exception e) {
		System.out.println(e.toString());
		return new ResponseRegDTO("Error");
	}
}

	@Override
	public Hall getHallById(Long id) {
		 return hallRep.getById(id);
		
	}

}
