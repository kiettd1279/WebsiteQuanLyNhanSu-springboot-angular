import { Component, OnInit } from '@angular/core';
import { Paging } from '../../../models/paging';
import { TimeKeepingService } from '../../../services/time-keeping.service';
import { Timekeeping } from '../../../models/timekeeping';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-keepings',
  templateUrl: './keepings.component.html',
  styleUrls: ['./keepings.component.css']
})
export class KeepingsComponent implements OnInit {
  paging = { page: 0, pageLimit: 10, totalItems: 3 } as Paging;
  constructor(private timeKeepingService :TimeKeepingService ,private toastr :ToastrService) { }
  timeKeeping =[] ;
  timeKeepingMorning =[];
  timeKeepingAfternoon =[];
  
  ngOnInit(): void {
    //this.loadTimeKeeping();
    this.loadTimeKeepingMorning();
    this.loadTimeKeepingAfternoon();
    console.log("đã tạo bảng");

  }

   
    //search ------------------------------------------------

    onKeypress($event){
      console.log($event.target.value);
   }

    //---------------------------------------------------------
  loadTimeKeepingMorning(){
    this.timeKeepingService.listTimeKeepingMorning().subscribe(res =>{
        this.timeKeepingMorning = res;

        this.loadTimeKeepingAfternoon();
        console.log(res);
    });
  }
  loadTimeKeepingAfternoon(){
    this.timeKeepingService.listTimeKeepingAfternoon().subscribe(res =>{
        this.timeKeepingAfternoon = res;
 
    });
  }
  loadTimeKeeping(){
  
    this.timeKeepingService.listTimeKeeping().subscribe(res => {
      this.timeKeeping = res.data;
 

   //   this.paging = res.paging;
    });
  }
  creatTimeKeeping(){
    this.timeKeepingService.creaTimeKeeping().subscribe(res => {
      console.log("creatTimKeeping");
      if(res != null){
        this.loadTimeKeepingMorning();
        this.loadTimeKeepingAfternoon();
        this.toastr.success("đã tạo bảng chấm công","Thành công")
        console.log("Đã tạo bảng");
      }else{
        this.toastr.error("Bảng công chưa được chốt","Thất bại")
      }
    
    });
  }
  startUpMorning(timeKeeping : Timekeeping){
    console.log("event",event);
    this.timeKeepingService.creatTimeKeepingDetailMorning(timeKeeping).subscribe(res => {
      this.toastr.success("Đã bắt đầu đi làm","Nhân viên " +timeKeeping.id);
      this.loadTimeKeepingMorning();
      this.loadTimeKeepingAfternoon();
    });
  
  } 
  startUpAfternoon(timeKeeping : Timekeeping){
    this.timeKeepingService.creatTimeKeepingDetailAfternoon(timeKeeping).subscribe(res => {
      this.toastr.success("Đã bắt đầu đi làm","Nhân viên " +timeKeeping.id);
      this.loadTimeKeepingMorning();
      this.loadTimeKeepingAfternoon();
    });
  } 
  refet(){
    this.timeKeepingService.refetTimeKeeping().subscribe(res=> {
      console.log(res +" OKe Refet");
      if(res ==null ){
        this.toastr.error("Chấm công ngày mới thất bại","Không thể refet")
      }else{
        this.toastr.info("Đã tạo ngày chấm công mới","Đã refet")
      }
      this.loadTimeKeepingMorning();
      this.loadTimeKeepingAfternoon();
    });
  }
  closeTimeKeeping(){
    this.timeKeepingService.closeTimeKeeping().subscribe(res=> {
    
      if(res != null){
        this.toastr.info("Thành công","Chốt Công");
        this.loadTimeKeepingMorning();
        this.loadTimeKeepingAfternoon();
      }else{
        this.toastr.error("thất bại","Chốt Công");
      }
    });
  }
}