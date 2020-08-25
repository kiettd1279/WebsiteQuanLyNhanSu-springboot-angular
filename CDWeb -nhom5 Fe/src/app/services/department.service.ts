import { Injectable } from '@angular/core';
import { Department } from '../models/department';
import { Observable } from 'rxjs';
import { Paging } from '../models/paging';
import { RootObj } from '../models/root-obj';
import { ApiService } from './api.service';

@Injectable({
  providedIn: 'root'
})
export class DepartmentService {

 
  constructor(private apiService: ApiService) { }

  list(): Observable<[Department]> {
   
    console.log(`${this.apiService.apiUrl.departments.home}`);   
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
}
