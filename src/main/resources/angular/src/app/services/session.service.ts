import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SessionService {

  constructor(private httpCli : HttpClient) { }

  login(username: string, password: string, email: string){
    return this.httpCli.post<any>(`http://localhost:9000/session`, {
      "username": username,
      "password": password,
      "email": email
    },
    {
      withCredentials: true
    });
  }

  checkSession(){
    return this.httpCli.get<any>('http://localhost:9000/session', {
      withCredentials: true
    });
  }

  logout(){
    return this.httpCli.delete<any>('http://localhost:9000/session', {
      withCredentials: true
    });
  }
}
