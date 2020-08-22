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

import com.laptrinhweb.dto.CandidateDTO;
import com.laptrinhweb.service.ICandidateService;
import com.laptrinhweb.service.impl.CandidateService;

@CrossOrigin
@RestController
public class CandidateAPI {

	@Autowired
	private CandidateService candidateServe;

	@GetMapping(value = "/candidates")
	public List<CandidateDTO> getAll() {
		return candidateServe.findAll();
	}
	
	@PostMapping(value = "/candidates")
	public CandidateDTO craet(@RequestBody CandidateDTO model) {
		return candidateServe.save(model);
	}
	@PutMapping(value = "/candidates/{id}")
	public CandidateDTO update(@RequestBody CandidateDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return candidateServe.save(model);
	}
}
