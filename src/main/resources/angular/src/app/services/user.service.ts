import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../models/User';



const baseUrl = 'http://localhost:9000/user';
@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpCli : HttpClient) { }

  getAllUsers(){
    return this.httpCli.get<User[]>(baseUrl);
  }
  
  get(id: any){
    return this.httpCli.get<User>(`${baseUrl}/${id}`);
  }

  create(data : User){
    return this.httpCli.post<User>(baseUrl, data);
  }

  update(id: any, data: any){
    return this.httpCli.put(`${baseUrl}/${id}`, data)
  }

  getByUsername(username: any){
    return this.httpCli.get<User>(`${baseUrl}?username=${username}`);
  }

  deleteUser(){
    return this.httpCli.delete(baseUrl);
  }
}
