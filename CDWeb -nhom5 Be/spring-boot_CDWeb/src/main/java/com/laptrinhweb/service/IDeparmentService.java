package com.laptrinhweb.service;

import java.util.List;

import com.laptrinhweb.dto.DeparmentDTO;


public interface IDeparmentService {
	List<DeparmentDTO> findAll();
	DeparmentDTO save(DeparmentDTO dto);
}
