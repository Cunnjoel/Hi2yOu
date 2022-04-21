import { HttpClient } from '@angular/common/http';
import { identifierName } from '@angular/compiler';
import { Injectable } from '@angular/core';
import { User } from '../models/User';

@Injectable({
  providedIn: 'root'
})
export class SessionService {

  constructor(private httpCli : HttpClient) { }

  login(user : User){
    return this.httpCli.post<User>(`http://localhost:9000/session`,user ,
    {
      withCredentials: true
    });
  }

  checkSession(){
    return this.httpCli.get<User>('http://localhost:9000/session', {
      withCredentials: true
    });
  }

  logout(){
    return this.httpCli.delete<any>('http://localhost:9000/session', {
      withCredentials: true
    });
  }
}
