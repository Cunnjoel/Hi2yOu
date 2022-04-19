import { HttpClient } from '@angular/common/http';
import { identifierName } from '@angular/compiler';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SessionService {

  constructor(private httpCli : HttpClient) { }

  login(userId: number,username: string){
    return this.httpCli.post<any>(`http://localhost:9000/session`, {
      "id": userId,
      "username": username
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
