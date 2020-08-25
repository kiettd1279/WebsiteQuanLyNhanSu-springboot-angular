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
    name :this.userName,
    password: this.pass
  }
  constructor( private router: Router, private userService:UserService) {}

  error: any = false;
  susu :any = false;
 

  loginUser($event){
    console.log(this.user);
    
    this.userService.checkUser(this.user).subscribe((res) =>{
      console.log("success");

      this.error =false;
      this.susu = true;
      this.router.navigate(['quan-ly-nhan-vien/thong-tin-co-ban'])
    },errr=>{
      console.log("Erro");
      
        this.error = true;
        this.susu = false;
       
    });
  }
  
}