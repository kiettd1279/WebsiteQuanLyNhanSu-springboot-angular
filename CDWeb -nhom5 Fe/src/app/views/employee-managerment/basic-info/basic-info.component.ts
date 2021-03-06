import { Component, OnInit, ViewChild } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { TabsetComponent } from 'ngx-bootstrap/tabs';
import { Employee } from '../../../models/employee';
import { Job } from '../../../models/job';
import { ModalDirective } from 'ngx-bootstrap/modal';
import { HttpClient } from '@angular/common/http';
import { ExcelService } from '../../../services/excel.service';
import { Paging } from '../../../models/paging';
import { EmployeeService } from '../../../services/employee.service';
import { JsonPipe } from '@angular/common';
import { ApiService } from '../../../services/api.service';
import { ToastrService } from 'ngx-toastr';


@Component({
  selector: 'app-basic-info',
  templateUrl: './basic-info.component.html',
  styleUrls: ['./basic-info.component.css']
})
export class BasicInfoComponent implements OnInit {

  @ViewChild('staticTabs', { static: false }) staticTabs: TabsetComponent;
  @ViewChild('addModal', { static: false }) addModal: ModalDirective;
  @ViewChild('materialModal', { static: false }) materialModal: ModalDirective;

  columns = [
    { name: 'Tên', prop: 'firstname ', sortTable: true },
    { name: 'Lương cơ bản', prop: 'salary', sortTable: true },
    { name: 'Email', sortTable: true },
    { name: 'Địa chỉ', sortTable: true },
  ];
  image: File; 
  saveForm: FormGroup;
  genders = [{value: true, name: 'Nam'}, {value: false, name: 'Nữ'}];
  action: string;
  employees: Employee[] = [];
  employee: Employee = {} as Employee;
  paging = { page: 0, pageLimit: 10, totalItems: 10 } as Paging;
  img: any = 'https://screenshotlayer.com/images/assets/placeholder.png';
  empImgPath: any = this.apiService.apiUrl.employees.images;
  imgName: string = 'Choose file';
  public imagePath: any = "assets/img/candidates/";
  public job: any;
 
  choosedEmp: Employee = {
    id: 0,
    firstName: '',
    lastName: '',
    birthDay: null,
    gender: true,
    email: '',
    phoneNumber: '',
    hireDay: null,
    jobLevel: 1,
    imageName: '',
    job: null,
  };

  constructor(
    private http: HttpClient, private excelService: ExcelService, private employeeService: EmployeeService,
    private apiService: ApiService, private fb: FormBuilder,private toastr :ToastrService) { 
      
    this.saveForm = this.fb.group({
      firstName: ['',[Validators.required]],
      lastName: ['',[Validators.required]],
      birthDay:['',[Validators.required]],
      gender: ['',[Validators.required]],
      email: ['',[Validators.required]],
      phoneNumber: [''],
      hireDay: [''],
      salary: [''],
      file:['']
      });
      
  }
  erroTen :any = false;
  erroHo :any = false;
  ngOnInit(): void {
    this.loadEmployee();
  }
  onHo($event){
    if($event.target.value == null ||$event.target.value==""){
      this.erroHo == true;
    }else{
      this.erroHo == false;
    }
  }
  onTen($event) {
     if($event.target.value == null ||$event.target.value==""){
      this.erroTen =true;
    }else{
      this.erroTen =false;
    }
  }
  selectTab(tabId: number) {
    this.staticTabs.tabs[tabId].active = true;
  }

  loadEmployee(page = null) {
    if (page != null) {
      this.paging.page = page.offset;
    }
    this.employeeService.list(this.paging).subscribe(res => {
      this.employees = res;
   //   this.paging = res.paging;
    });
  };


  choose(row) {
    this.choosedEmp = row;
    console.log(this.choosedEmp);
  }

  showAddModal() {
    this.action = 'ADD';
    this.addModal.show();


  }
  openEdit(id){
    this.action == 'EDIT'
    this.employeeService.getOne(id).subscribe(res =>{
      this.employee = res;
    });
    this.showAddModal();
  }

  selectFile(event){
    this.image = event.target.files.item(0);
    console.log(this.image);
    
  }

  save(){
    if(this.action == 'ADD'){
      this.employeeService.addEmployee(this.employee).subscribe(res =>{
        console.log(res);
        this.toastr.success("Thêm nhân viên ","thành công");
        this.loadEmployee();
      });
    }else if(this.action == 'EDIT'){
      this.employeeService.addEmployee(this.employee).subscribe(res =>{
        console.log(res);
        this.toastr.success("Cập nhật thông tin nhân viên ","thành công");
        this.loadEmployee();
      });
    }
    this.hideModal();
  }

  hideModal() {
    this.imgName = 'Choose file';
    this.img = 'https://screenshotlayer.com/images/assets/placeholder.png';
    this.addModal.hide();
  }

  exportAsXLSX() {
    this.excelService.exportAsExcelFile(this.employees, 'DSNV');
  }

  preview(files) {
    if (files.length === 0)
      return;

    var mimeType = files[0].type;
    this.imgName = files[0].name;
    if (mimeType.match(/image\/*/) == null) {
      return;
    }

    var reader = new FileReader();
    this.imagePath = files;
    reader.readAsDataURL(files[0]);
    reader.onload = (_event) => {
      this.img = reader.result;

    }
  }
}
