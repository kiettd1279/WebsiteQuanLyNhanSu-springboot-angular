import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../../services/user.service';
import { User } from '../../models/user';

@Component({
  selector: 'app-dashboard',
  templateUrl: 'login.component.html'
})
export class LoginComponent { 
  message: string = '';
  userName: string;
  pass: string;
  user : User ={
    name :"",
    password: ""
  }
  constructor( private router: Router, private userService:UserService) {}

  error: any = false;
  susu :any = false;
 
  loginUser($event){
    console.log($event);
      this.router.navigate(['quan-ly-nhan-vien/thong-tin-co-ban'])
  }

  onKey($event){
    
    this.user.name =$event.target.value;
    this.userService.checkUser(this.user).subscribe(res =>{
      
      console.log(res +"Back");
      if(res== null){
        this.error = true;
        this.susu = false;
      }else{
        this.error =false;
        this.susu = true;
      }
    });
  }
  
}