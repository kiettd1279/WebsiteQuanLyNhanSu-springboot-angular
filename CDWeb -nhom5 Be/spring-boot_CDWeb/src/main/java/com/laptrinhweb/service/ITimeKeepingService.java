package com.laptrinhweb.service;

import java.util.List;

import com.laptrinhweb.dto.TimeKeepingDTO;
import com.laptrinhweb.dto.TimeKeepingInforDTO;
import com.laptrinhweb.entity.TimeKeepingEntity;

public interface ITimeKeepingService {
	// tạo bảng lương với tất cả danh sách nhân viên
	// nếu thời gian hiện tại(nowDate) < startDate -20; + chấm công
	// nếu thời gian hiện tại(nowDate) > startDate -20; + tạo ra bảng lương mới
	/*
	 * Status 1:Chấm công Status 2:Chốt bảng công Status 3: đã trả lương
	 */

	List<TimeKeepingDTO> saveAll();

	List<TimeKeepingInforDTO> findAll();

	TimeKeepingDTO edit(TimeKeepingDTO model);

	// chức năng chấm công cho 1 nhân viên trong 1 cột lương
	TimeKeepingDTO update(TimeKeepingDTO model);

	TimeKeepingDTO findByOne(long id);

	List<TimeKeepingDTO> FindAll();

	// List<TimeKeepingDTO> Save();
	// TimeKeepingDTO Replace(TimeKeepingEntity oldTimeKeeping);
	List<TimeKeepingDTO> findMorning();

	List<TimeKeepingDTO> findAfternoon();

	TimeKeepingDTO stardUp(TimeKeepingDTO model, String shift);

	List<TimeKeepingDTO> RefetTimeKeeping();

	List<TimeKeepingDTO> CloseTimeKeeping();

}
