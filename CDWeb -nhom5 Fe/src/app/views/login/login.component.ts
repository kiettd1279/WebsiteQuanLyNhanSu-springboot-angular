import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: 'login.component.html'
})
export class LoginComponent { 
  message: string = '';
  user: string;
  pass: string;
  constructor( private router: Router,) {}

  error: any = false;
 
  loginUser($event){
    console.log($event);
      this.router.navigate(['quan-ly-nhan-vien/thong-tin-co-ban'])
  }

  onKey($event){
    console.log($event.target.value)
    this.error = true;
    
  }
}