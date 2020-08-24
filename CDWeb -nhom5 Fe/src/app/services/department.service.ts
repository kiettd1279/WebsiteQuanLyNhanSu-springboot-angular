import { Injectable } from '@angular/core';
import { Department } from '../models/department';
import { Observable } from 'rxjs';
import { ApiService } from './api.service';
import { RootObj } from '../models/root-obj';

@Injectable({
  providedIn: 'root'
})
export class DepartmentService {

 
  constructor(private apiService: ApiService) { }

  list(): Observable<[Department]> {
   
    // console.log(`${this.apiService.apiUrl.departments.home}`);   
    return this.apiService.get<[Department]>
      (`${this.apiService.apiUrl.departments.home}`);
  }
  save(data: Department): Observable<RootObj<Department>> {
    if (!data.id) {
      return this.apiService.post<RootObj<Department>>(this.apiService.apiUrl.departments.home, data);
    } else {
      return this.apiService.put<RootObj<Department>>(`${this.apiService.apiUrl.departments.home}/${data.id}`, data);
    }
  }
  // getDeptById(id: Number): Observable<RootObj<Department>> {
  //   return this.apiService.get<RootObj<Department>>
  //     (`${this.apiService.apiUrl.departments.getDept}/${id}`, id);
  // }
}
