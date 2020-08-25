import { Component, OnInit, ViewChild, OnDestroy,  } from '@angular/core';
import { TabsetComponent } from 'ngx-bootstrap/tabs';
import { Paging } from '../../../models/paging';
import { Subscription } from 'rxjs';
import { Candidate } from '../../../models/candidate';
import { Employee } from '../../../models/employee';
import { ActivatedRoute, Router } from '@angular/router';
import { CandidateService } from './../../../services/candidate.service';
import { ApiService } from './../../../services/api.service';
import { ToastrService} from 'ngx-toastr'
import { EmployeeService } from '../../../services/employee.service';
import { FormGroup, FormBuilder } from '@angular/forms';
import { ModalDirective } from 'ngx-bootstrap/modal';

@Component({
  selector: 'app-candidate',
  templateUrl: './candidate.component.html',
  styleUrls: ['./candidate.component.css']
})
export class CandidateComponent implements OnInit{
  @ViewChild('staticTabs', { static: false }) staticTabs: TabsetComponent;
  @ViewChild('addModal', { static: false }) addModal: ModalDirective;
  candidates: Candidate[];
  paging = { page: 0, pageLimit: 10, totalItems: 3 } as Paging;
  empImgPath: any = "assets/img/candidates/";
  employeeAccept = {} as Employee;
  candidate = {} as Candidate;
  idAccept: number;
  genders = [{value: true, name: 'Nam'}, {value: false, name: 'Nữ'}];
  image: String;
  imgName: string = 'Choose file';
  img: any = 'https://screenshotlayer.com/images/assets/placeholder.png';
  candidateAdd: Candidate = {} as Candidate;
  saveForm: FormGroup;
  constructor(private candidateService: CandidateService, private fb: FormBuilder, private router: Router, private apiService: ApiService, private toastr: ToastrService, private employeeService: EmployeeService) { 
  this.saveForm = this.fb.group({
    firstname: [''],
    lastname: [''],
    birthDay:[''],
    gender: [''],
    email: [''],
    phoneNumber: [''],
    ethnic: [''],
    hometown: [''],
    IDCard: [''],
    degree: [''],
    career: [''],
    experience: [''],
    literacy: [''],
    skill: [''],
    hobby: [''],
    position: [''],
    file:['']
    });
  }
  errorName: any = false;
  errorLastName: any = false;
  errorDate: any = false;
  errorGender: any = false;
  ngOnInit(): void {
   this.loadCandidate(null);
  }
 
  selectTab(tabId: number) {
    this.staticTabs.tabs[tabId].active = true;
  }

  loadCandidate(page = null) {
    // if (page != null) {
    //   this.paging.page = page.offset;
    // }
    this.candidateService.list(this.paging, 0).subscribe(res => {
      this.candidates = res.filter( c => {
          return c.status === 0;
      });
      console.log('candidates',this.candidates);
    
     // this.paging = res.paging;
    });
  };

  choose(id){
    this.router.navigateByUrl(`tuyen-dung/info/${id}`);
  }

  accept(candidate) {
    this.idAccept  = candidate.id;
    this.candidate = candidate;
    this.candidate.status = 1;
    this.candidateService.edit(this.idAccept,this.candidate).subscribe(res =>{
      this.toastr.success('Đã chấp nhận ứng cử viên','');
      this.ngOnInit();
   });

  
  this.employeeAccept.firstName= candidate.firstname;
  this.employeeAccept.lastName= candidate.lastname;
  this.employeeAccept.birthDay= candidate.birthDay;
  this.employeeAccept.gender= candidate.gender;
  this.employeeAccept.email= candidate.email;
  this.employeeAccept.phoneNumber= candidate.phoneNumber;
  this.employeeAccept.jobLevel= candidate.position;
  this.employeeAccept.job= candidate.position;


  console.log('employeeAccept',this.employeeAccept);
  this.employeeService.addEmployee(this.employeeAccept).subscribe(res =>{
   
  });

  

  }

  decline(candidate) {
    this.idAccept  = candidate.id;
    this.candidate = candidate;
    this.candidate.status = 2;
    this.candidateService.edit(this.idAccept,this.candidate).subscribe(res =>{
      this.toastr.success('Đã từ chối ứng cử viên','');
      this.ngOnInit();
   });
  }
 
  toAdd() {
    // console.log("dsadsadsa");
     this.router.navigate(['tuyen-dung/add']);
  }

  showAddModal() {
    this.addModal.show();
  }

  hideModal() {
    this.imgName = 'Choose file';
    this.img = 'https://screenshotlayer.com/images/assets/placeholder.png';
    this.addModal.hide();
  }

  toSchedule() {
    this.router.navigate(['tuyen-dung/schedule']);
  }
  onGender($event){
    if($event.target.value==null ||$event.target.value==""){
      this.errorGender = true;
    }else{
      this.errorGender =false;
    }
  }
  onLastName($event){
    if($event.target.value==null ||$event.target.value==""){
      this.errorLastName = true;
    }else{
      this.errorLastName =false;
    }
  }
  onName($event){
    if($event.target.value==null ||$event.target.value==""){
      this.errorName = true;
    }else{
      this.errorName =false;
    }
  
  }
  onDate($event){
    if($event.target.value==null ||$event.target.value==""){
      this.errorDate = true;
    }else{
      this.errorDate =false;
    }
  }
  selectFile(event) {
    this.image = "";
    console.log(this.image);
  }
// -------------------------------------
  save() {
    this.candidateService.addCandidate(this.candidateAdd).subscribe(res =>{
      console.log(res);
      this.router.navigateByUrl('tuyen-dung/tuyen-nhan-su');
      this.toastr.success('Thêm ứng cử viên thành công','');
      this.loadCandidate();
      this.hideModal();
    });
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
    reader.readAsDataURL(files[0]);
    reader.onload = (_event) => {
      this.img = reader.result;

    }
  }

}
