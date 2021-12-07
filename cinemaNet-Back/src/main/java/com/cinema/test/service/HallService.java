package com.cinema.test.service;

import org.springframework.stereotype.Service;

import com.cinema.test.DTO.ResponseRegDTO;
import com.cinema.test.model.Hall;
@Service
public interface HallService {
	ResponseRegDTO createHall(Hall hall);
	ResponseRegDTO updateHall(Hall hall);
	Hall getHallById(Long id);
	

}
