import { Injectable } from '@angular/core';
import { ApiService } from './api.service';
import { HttpClient } from '@angular/common/http';
import { Paging } from '../models/paging';
import { Observable } from 'rxjs';
import { RootObj } from '../models/root-obj';
import { SalaryHistory } from '../models/salary-history';

@Injectable({
  providedIn: 'root'
})
export class SalaryService {

  constructor(private apiService: ApiService, private http: HttpClient) { }

  payroll(): Observable<[SalaryHistory]> {
    console.log(`${this.apiService.apiUrl.salary.payroll}`);
    return this.apiService.get<[SalaryHistory]>(`${this.apiService.apiUrl.salary.payroll}`);
  }
  loadSalaryHistorys():  Observable<[SalaryHistory]> {
    return this.apiService.get<[SalaryHistory]>(`${this.apiService.apiUrl.salary.home}`);

  }

}
