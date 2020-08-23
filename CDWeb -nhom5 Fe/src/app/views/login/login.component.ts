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
    UserName :"",
    password: ""
  }
  constructor( private router: Router, private userService:UserService) {}

  error: any = false;
 
  loginUser($event){
    console.log($event);
      this.router.navigate(['dashboard'])
  }

  onKey($event){
    console.log($event.target.value)
    this.error = true;
    this.user.UserName =$event.target.value;
    this.userService.checkUser(this.user).subscribe(res =>{
      console.log(res);
    });
  }
  
}