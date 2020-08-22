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

import com.laptrinhweb.dto.TimeKeepingDTO;
import com.laptrinhweb.dto.TimeKeepingInforDTO;
import com.laptrinhweb.service.ITimeKeepingService;

@CrossOrigin
@RestController
public class TimeKeepingAPI {
	@Autowired
	private ITimeKeepingService timekeepingService;

// xu ly cham cong 
	@GetMapping(value = "/timeKeeping")
	public List<TimeKeepingDTO> findAllTK() {
		return timekeepingService.saveAll();
	}
	// tao bang chấm công
	@GetMapping(value = "/timeKeeping/create")
	public List<TimeKeepingDTO> createTimeKeeping() {
		return timekeepingService.saveAll();
	}
	// load
	@GetMapping(value = "/timeKeeping/morning")
	public List<TimeKeepingDTO> findMorning() {
		return timekeepingService.findMorning();
	}
	
	// lấy danh sách bảng chấm cong chiều
	@GetMapping(value = "/timeKeeping/afternoon")
	public List<TimeKeepingDTO> findAfternoon() {
		return timekeepingService.findAfternoon();
	}
	// lấy danh sách bảng chấm cong sáng
	@GetMapping(value = "/timeKeeping/refet")
	public List<TimeKeepingDTO> refet() {
		return timekeepingService.RefetTimeKeeping();
	}
	//bat dau ca lam
	@PutMapping(value = "/timeKeeping/morning/{id}")
	public TimeKeepingDTO stardMorningTimeKeeping(@PathVariable("id") long id, @RequestBody TimeKeepingDTO model) {
		model.setId(id);
		return timekeepingService.stardUp(model, "morning");
	}
	@PutMapping(value = "/timeKeeping/afternoon/{id}")
	public TimeKeepingDTO stardAfternoonTimeKeeping(@PathVariable("id") long id, @RequestBody TimeKeepingDTO model) {
		model.setId(id);
		return timekeepingService.stardUp(model, "afternoon");
	}
// xu ly cham cong	
	
	
	@GetMapping(value = "/timeKeeping/{id}")
	public List<TimeKeepingDTO> findByOneTimeKeeping() {
		return timekeepingService.saveAll();
	}
	@GetMapping(value = "/timeKeepings")
	public List<TimeKeepingInforDTO> findAll() {
		return timekeepingService.findAll();
	}

	@PutMapping(value = "/timeKeeping/{id}")
	public TimeKeepingDTO update(@PathVariable("id") long id, @RequestBody TimeKeepingDTO model) {
		model.setId(id);
		return timekeepingService.update(model);
	}
	@PutMapping(value = "/timeKeepings/{id}")
	public TimeKeepingDTO edit(@PathVariable("id") long id, @RequestBody TimeKeepingDTO model) {
		model.setId(id);
		return timekeepingService.edit(model);
	}
	@GetMapping(value = "/timeKeeping/close")
	public List<TimeKeepingDTO> closeTimeKeeping(){
		return timekeepingService.CloseTimeKeeping();
	}
	
}
