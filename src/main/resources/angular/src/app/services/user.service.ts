import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/User';



const baseUrl = 'http://localhost:9000/';
@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpCli : HttpClient) { }

  getAllUsers(): Observable<User[]>{
    return this.httpCli.get<User[]>(baseUrl);
  }
  
  get(id: any): Observable<User> {
    return this.httpCli.get<User>(`${baseUrl}/${id}`);
  }

  create(data : any): Observable<any> {
    return this.httpCli.post(baseUrl, data);
  }

  update(id: any, data: any): Observable<any>  {
    return this.httpCli.put(`${baseUrl}/${id}`, data)
  }

  getByUsername(username: any): Observable<User>{
    return this.httpCli.get<User>(`${baseUrl}?username=${username}`);
  }

  deleteUser(): Observable<any> {
    return this.httpCli.delete(baseUrl);
  }
}
