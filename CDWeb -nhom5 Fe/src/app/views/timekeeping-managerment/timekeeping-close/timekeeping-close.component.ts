import { Component, OnInit } from '@angular/core';
import { TimeKeepingService } from '../../../services/time-keeping.service';
import { SalaryService } from '../../../services/salary.service';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-timekeeping-close',
  templateUrl: './timekeeping-close.component.html',
  styleUrls: ['./timekeeping-close.component.css']
})
export class TimekeepingCloseComponent implements OnInit {
timeKeeping =[];
date = "";
  constructor(private timKeepingService :TimeKeepingService ,private salaryService :SalaryService,private router: Router,
          private toastr:ToastrService) { }

  ngOnInit(): void {
    this.load();
  }
  load(){
    this.timKeepingService.loadTimeKeepingClose().subscribe(res =>{
    this.timeKeeping = res;
    
    }); 
  }
  paytrollSalary() {
    this.salaryService.payroll().subscribe(res => {
      if(res ==null){
          this.toastr.error("Không thể tính lương khi chưa chốt công","Thất bại");
      }else{
        this.toastr.success("Đã tính lương","Thành công")
        this.router.navigate(['quan-ly-luong/tinh-luong']);
      }
      
      
    });  
  }
}
