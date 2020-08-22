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

@Component({
  selector: 'app-candidate',
  templateUrl: './candidate.component.html',
  styleUrls: ['./candidate.component.css']
})
export class CandidateComponent implements OnInit{
  @ViewChild('staticTabs', { static: false }) staticTabs: TabsetComponent;
  candidates: Candidate[];
  paging = { page: 0, pageLimit: 10, totalItems: 3 } as Paging;
  empImgPath: any = "assets/img/candidates/";
  employeeAccept = {} as Employee;
  candidate = {} as Candidate;
  idAccept: number;
  constructor(private candidateService: CandidateService, private router: Router, private apiService: ApiService, private toastr: ToastrService, private employeeService: EmployeeService) { }
 

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

  toSchedule() {
    this.router.navigate(['tuyen-dung/schedule']);
  }

}
