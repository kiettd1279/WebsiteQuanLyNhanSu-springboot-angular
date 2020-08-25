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
<<<<<<< HEAD
=======
    // console.log(user);
>>>>>>> c3e4997b87ea101a295e9aa99b7b4f54abba1794
    return this.apiService.post<User>(`${this.apiService.apiUrl.user.user}`,user);
  }
}
