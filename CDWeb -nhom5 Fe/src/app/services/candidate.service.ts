import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RootObj } from '../models/root-obj';
import { Paging } from '../models/paging';
import { Candidate } from '../models/candidate';
import { ApiService } from './api.service';
import { HttpClient, HttpRequest, HttpHeaders, HttpEvent } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class CandidateService {

  constructor(private apiService: ApiService, private http: HttpClient) { }

  list(paging: Paging, type: number): Observable<[Candidate]> {
    const query = `page=${paging.page + 1}&page_limit=4`;
    console.log(`${this.apiService.apiUrl.candidates.home}/${type}?${query}`);
    return this.apiService.get<[Candidate]>
      (`${this.apiService.apiUrl.candidates.home}/?${query}`);
  }

  getOne(id): Observable<RootObj<Candidate>> {
    return this.apiService.get<RootObj<Candidate>>
      (`${this.apiService.apiUrl.candidates.home}/${id}`);
  }

  edit(id,candidate: Candidate): Observable<RootObj<Candidate>> {
    return this.apiService.put<RootObj<Candidate>>
      (`${this.apiService.apiUrl.candidates.home}/${id}`,candidate);
  }

  addCandidate( candidate: Candidate): Observable<any>{
    const req = new HttpRequest('POST', this.apiService.apiUrl.candidates.home, candidate);

    return this.http.request(req);


  }
}
