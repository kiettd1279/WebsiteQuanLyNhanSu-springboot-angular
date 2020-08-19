package com.laptrinhweb.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhweb.dto.DeparmentDTO;
import com.laptrinhweb.entity.DeparmentEntity;
import com.laptrinhweb.service.impl.DeparmentService;

@CrossOrigin
@RestController
public class DeparmentAPI {

	@Autowired
	private DeparmentService deparmentService;

	@GetMapping(value = "/derparment")
	public List<DeparmentDTO>getAllDerparment(){
		return deparmentService.findAll();
	}
	@PostMapping(name  = "/derparment")
	public DeparmentDTO creatDeparment(@RequestBody DeparmentDTO model) {
		System.out.println(model.getName());
		return deparmentService.save(model);
		
	}
	@PutMapping(value = "/derparment/{id}")
	public DeparmentDTO updateDeparment(@RequestBody DeparmentDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return deparmentService.save(model);
	}
}
