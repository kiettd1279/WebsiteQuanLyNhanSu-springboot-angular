import { Injectable } from '@angular/core';
import { ApiService } from './api.service';
import { User } from '../models/user';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private apiService: ApiService) { }
  checkUser(user : User ): Observable<User>{
    console.log(user);
    return this.apiService.post<User>(`${this.apiService.apiUrl.user.user}`,user);
  }
}
