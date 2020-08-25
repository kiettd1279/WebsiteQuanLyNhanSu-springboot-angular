import { Component, OnInit, ViewChild, ElementRef, AfterContentInit } from "@angular/core";
import { ModalDirective } from "ngx-bootstrap/modal";
import { FormControl, FormGroup, FormArray, FormBuilder, Validators } from "@angular/forms";
import { TabsetComponent } from "ngx-bootstrap/tabs";
import { Department } from "../../../models/department";
import { HttpClient } from "@angular/common/http";
import { DepartmentService } from "../../../services/department.service";
// import Swal from 'sweetalert2/dist/sweetalert2.js';
// import 'sweetalert2/src/sweetalert2.scss';

@Component({
  selector: "app-department",
  templateUrl: "./department.component.html",
  styleUrls: ["./department.component.css"],
})
export class DepartmentComponent implements OnInit, AfterContentInit {
  @ViewChild("staticTabs", { static: false }) staticTabs: TabsetComponent;
  @ViewChild("editModal", { static: false }) editModal: ModalDirective;
  @ViewChild("addModal", { static: false }) addModal: ModalDirective;
  @ViewChild("materialModal", { static: false }) materialModal: ModalDirective;
  @ViewChild("formDemo") formDemo:ElementRef<any>;

  addForm: FormGroup;

  departments: Department[] = [];
  department: Department = {} as Department;
  // public employee: any;
  img: any = "https://screenshotlayer.com/images/assets/placeholder.png";
  imgName: string = "Choose file";
  // addTaskValue: string = "";
  columns = [
    { name: "Phòng ban", prop: "name", sortTable: true },
    { name: "Địa chỉ", prop: "locationId", sortTable: true },
  ];

  // choosedDept: Department = {
  // //  id: 0,
  //   name: "",
  //   locationId: "",
  // };
  constructor(
    private http: HttpClient,
    private departmentService: DepartmentService, private formBuilder: FormBuilder
  ) { 
  }
  ngOnInit(): void {
    this.loadDepartment();
    this.addForm = this.formBuilder.group({
      name: ['', [Validators.required, Validators.minLength(2), Validators.maxLength(30)]],
      locationId: ['', [Validators.required]]
     });
  }

  ngAfterContentInit() {
    window.onload = () => {
      console.log(this.formDemo); 
    }
  }
  loadDepartment() {
    this.http.get<any>("../../../../assets/job.json").subscribe((res) => {
      // this.employee = res.job;
    });
    this.departmentService.list().subscribe((res: any) => {
      this.departments = res;
    });
  }
  // choose(row) {
  //   this.choosedDept = row;
  //   console.log(this.choosedDept);
  // }

  showAddModal() {
    this.addModal.show();
  }
  showEditModal(department) {
      this.department=department;
    this.editModal.show();
    // console.log('id',id)
  }
  hideAddModal() {
    this.imgName = "Choose file";
    this.img = "https://screenshotlayer.com/images/assets/placeholder.png";
    this.addModal.hide();
  }
  hideEditModal() {
    this.imgName = "Choose file";
    this.img = "https://screenshotlayer.com/images/assets/placeholder.png";
    this.editModal.hide();
  }
  // save() {
  //   this.departmentService.save(this.department).subscribe((res) => {
  //     this.departments.push(res.data);
  //     // this.addTaskValue = '';
  //     this.addModal.hide();
  //     this.editModal.hide();
  //     this.loadDepartment();
  //     this.alertWithSuccess();
  //   });
  // }
  alertWithSuccess(){
    // Swal.fire({
    //   position: 'top-center',
    //   icon: 'success',
    //   title: 'Bạn đã thêm thành công',
    //   showConfirmButton: false,
    //   timer: 1500
    // })
  }
}
