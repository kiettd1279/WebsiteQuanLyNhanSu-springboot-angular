package com.laptrinhweb.service;

import java.util.List;

import com.laptrinhweb.dto.TimeKeepingDetailDTO;

public interface ITimeKeepingDetailService {
     List<TimeKeepingDetailDTO> findAllShift(String shift);
     
     
     List<TimeKeepingDetailDTO> findAllHistory();
     
     TimeKeepingDetailDTO endTimeKeepingforOneDay(TimeKeepingDetailDTO model);
     TimeKeepingDetailDTO removeTimeKeeping(long id);
}
