import { Component, OnInit, ViewChild, TemplateRef,} from '@angular/core';
import { SalaryService } from '../../../services/salary.service';
import { ApiService } from '../../../services/api.service';
import { Paging } from '../../../models/paging';
import { SalaryHistory } from '../../../models/salary-history';
import { BsModalRef, BsModalService } from 'ngx-bootstrap/modal';

@Component({
  selector: 'app-salary-counting',
  templateUrl: './salary-counting.component.html',
  styleUrls: ['./salary-counting.component.css']
})
export class SalaryCountingComponent implements OnInit {
  
  salaryHistories: SalaryHistory[] = [];
  salary = [];
  notifyModalRef: BsModalRef;
  @ViewChild('notifyModalTemplate') public notifyModalTemplate: TemplateRef<any>;


  constructor(
    private salaryService: SalaryService, private apiService: ApiService,private modalService: BsModalService
  ) { }

  ngOnInit(): void {
    this.loadSalaryHistories();
  }
  
  paytrollSalary() {
    this.salaryService.payroll().subscribe(res => {
  //    this.salaryHistories = res;
     // this.paging = res.paging;
    });  
  };

  loadSalaryHistories(){
    this.salaryService.loadSalaryHistorys().subscribe(res => {
     this.salary = res;
     console.log(res);
    });
  }

}

// link tai lieu
// stackoverflow.com/questions/41880420/how-to-get-templateref-of-a-component-in-angular2