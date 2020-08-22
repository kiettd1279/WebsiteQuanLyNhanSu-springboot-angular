import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RootObj } from '../models/root-obj';
import { Paging } from '../models/paging';
import { Employee } from '../models/employee';
import { ApiService } from './api.service';
import { HttpClient, HttpRequest, HttpHeaders, HttpEvent } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private apiService: ApiService, private http: HttpClient) { }

  getOne(id):Observable<Employee> {
    return this.apiService.get<Employee>
      (`${this.apiService.apiUrl.employees.getId}/${id}`);
  }

  list(paging: Paging): Observable<[Employee]> {
    const query = `page=${paging.page + 1}&page_limit=4`;
    console.log(`${this.apiService.apiUrl.employees.home}?${query}`);
    return this.apiService.get<[Employee]>
      (`${this.apiService.apiUrl.employees.home}?${query}`);
  }

  addEmployee(employee: Employee): Observable<any>{
    const req = new HttpRequest('POST', this.apiService.apiUrl.employees.home, employee);

    return this.http.request(req);
  }

  jobInformations(paging: Paging): Observable<RootObj<[Employee]>> {
    const query = `page=${paging.page}&page_limit=${paging.pageLimit}`;
    console.log(`${this.apiService.apiUrl.employees.jobInformations}?${query}`);
    return this.apiService.get<RootObj<[Employee]>>
      (`${this.apiService.apiUrl.employees.jobInformations}?${query}`);
  }
}
