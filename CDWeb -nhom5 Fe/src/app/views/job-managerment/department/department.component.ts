import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ApiService } from '../../../services/api.service';
import { DepartmentService } from '../../../services/department.service';
import { Paging } from '../../../models/paging';

@Component({
  selector: 'app-department',
  templateUrl: './department.component.html',
  styleUrls: ['./department.component.css']
})
export class DepartmentComponent implements OnInit {


  departments = [];

  constructor( private departmentService: DepartmentService,
    private apiService: ApiService) { }

  ngOnInit(): void {
    this.loadDepartments();
  }

  loadDepartments() {
    this.departmentService.list().subscribe(res => {
      this.departments = res;
      console.log(this.departments);
    });
  };


}
