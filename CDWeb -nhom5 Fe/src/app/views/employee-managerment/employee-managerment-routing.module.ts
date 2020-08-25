import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BasicInfoComponent } from './basic-info/basic-info.component';
import { IdentificationComponent } from './identification/identification.component';
import { DegreeComponent } from './degree/degree.component';


const routes: Routes = [
  {
    path: '',  
    data: {
      title: 'Quản lý nhân viên'
    },
    children: [
      { 
        path: 'thong-tin-co-ban', 
        component: BasicInfoComponent,
        data: {
          title: 'Thông tin cơ bản'
        },
      },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EmployeeManagermentRoutingModule { }
