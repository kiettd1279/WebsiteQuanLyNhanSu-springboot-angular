package com.laptrinhweb.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhweb.dto.TimeKeepingDTO;
import com.laptrinhweb.dto.TimeKeepingDetailDTO;
import com.laptrinhweb.service.ITimeKeepingDetailService;

@CrossOrigin
@RestController
public class TimeKeepingDetailAPI {
	@Autowired
	ITimeKeepingDetailService timeKeepingDetailService;
	@GetMapping(value = "/timeKeepingDetail/history")
	public List<TimeKeepingDetailDTO> findAllHistory() {
		return timeKeepingDetailService.findAllHistory();
	}
	
	@GetMapping(value = "/timeKeepingDetail/morning")
	public List<TimeKeepingDetailDTO> findAllTK() {
		return timeKeepingDetailService.findAllShift("morning");
	}

	@GetMapping(value = "/timeKeepingDetail/afternoon")
	public List<TimeKeepingDetailDTO> getAllK() {
		return timeKeepingDetailService.findAllShift("afternoon");
	}

	@DeleteMapping(value = "/timeKeepingDetail/{id}")
	public TimeKeepingDetailDTO removeTimeKeepingDetail(@PathVariable("id") long id) {
		return timeKeepingDetailService.removeTimeKeeping(id);
	}

	@PutMapping(value = "/timeKeepingDetail/{id}")
	public TimeKeepingDetailDTO updateTimeKeeping(@PathVariable("id") long id,
			@RequestBody TimeKeepingDetailDTO model) {
		model.setId(id);
		return timeKeepingDetailService.endTimeKeepingforOneDay(model);
	}
}
