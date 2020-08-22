import { Component, OnInit } from '@angular/core';
import { TimeKeepingDetailService } from '../../../services/time-keeping-detail.service';
import { Paging } from '../../../models/paging';

@Component({
  selector: 'app-timekeeping-history',
  templateUrl: './timekeeping-history.component.html',
  styleUrls: ['./timekeeping-history.component.css']
})
export class TimekeepingHistoryComponent implements OnInit {
  listTimeKeepingDetail =[];
  constructor(private timeKeepingDetailService : TimeKeepingDetailService ) { }

  ngOnInit(): void {
  this.loadTimeKeepingDetailHistory();
  }
  loadTimeKeepingDetailHistory(){
    this.timeKeepingDetailService.getAllTimeKeepingDetail().subscribe(res => {
        this.listTimeKeepingDetail = res;
        console.log(this.listTimeKeepingDetail);
    });
}
}