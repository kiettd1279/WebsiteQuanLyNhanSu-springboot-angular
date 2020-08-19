import { Injectable } from '@angular/core';
import { ApiService } from './api.service';
import { Observable } from 'rxjs';
import { RootObj } from '../models/root-obj';
import { TimekeepingDetail } from '../models/timekeeping-detail';

@Injectable({
  providedIn: 'root'
})
export class TimeKeepingDetailService {

  constructor(private apiService: ApiService) { }
  removeTimeKeepingDetail(data: TimekeepingDetail):Observable<[TimekeepingDetail]> {
    return this.apiService.delete<[TimekeepingDetail]>(`${this.apiService.apiUrl.timeKeepingDetail.home}/${data.id}`);
  }
  listTimeKeepingDetail():Observable<[TimekeepingDetail]> {
    return this.apiService.get<[TimekeepingDetail]>(`${this.apiService.apiUrl.timeKeepingDetail.home}`);
  }
  listMorning():Observable<[TimekeepingDetail]> {
    return this.apiService.get<[TimekeepingDetail]>(`${this.apiService.apiUrl.timeKeepingDetail.monrning}`);
  }
  listAfternoon():Observable<[TimekeepingDetail]> {
    return this.apiService.get<[TimekeepingDetail]>(`${this.apiService.apiUrl.timeKeepingDetail.afteroon}`);
  }

  save(data: TimekeepingDetail): Observable<TimekeepingDetail> {
   console.log(data);
    return this.apiService.put<TimekeepingDetail>(`${this.apiService.apiUrl.timeKeepingDetail.home}/${data.id}`, data);
  }
}
