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
 

<<<<<<< HEAD
  onKey($event){
    
    this.user.name =$event.target.value;
    this.userService.checkUser(this.user).subscribe(res =>{
      
      console.log(res +"Back");
      if(res== null){
=======
  loginUser($event){
    console.log(this.user);
    
    this.userService.checkUser(this.user).subscribe((res) =>{
      console.log("success");

      this.error =false;
      this.susu = true;
      this.router.navigate(['quan-ly-nhan-vien/thong-tin-co-ban'])
    },errr=>{
      console.log("Erro");
      
>>>>>>> c3e4997b87ea101a295e9aa99b7b4f54abba1794
        this.error = true;
        this.susu = false;
       
    });
  }
  
}