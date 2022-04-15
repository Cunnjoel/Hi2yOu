import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


const baseUrl = 'http://localhost:4200/';
@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http : HttpClient) { }

  getAllUsers(): Observable<User[]>{
    return this.http.get<User[]>(baseUrl);
  }
  
  get(id: any): Observable<User> {
    return this.http.get(`${baseUrl}/${id}`);
  }

  create(data : any): Observable<any> {
    return this.http.post(baseUrl, data);
  }

  update(id: any, data: any): Observable<any>  {
    return this.http.put(`${baseUrl}/${id}`, data)
  }

  getByUsername(username: any): Observable<User>{
    return this.http.get<username>(`${baseUrl}?username=${username}`);
  }

  deleteUser(): Observable<any> {
    return this.http.delete(baseUrl);
  }
}
