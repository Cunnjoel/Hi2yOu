import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private httpCli : HttpClient) { }

  createPost(message : string, picture : string, users : Array<object>, date : string, user : object ){
      return this.httpCli.post<any>(`http://localhost:9000/post`, { ""}
      , {
        withCredentials: true
      });
    }

  getPostByUserId(userId : number){
      return this.httpCli.get<any>(`http://localhost:9000/post/${userId}``, {
         "postId": postId.
         "message": message,
         "picture": picture,
         "users": users,
         "user": user
      }
      , {
        withCredentials: true
      });
    }

     getPostByUserId(userId : number){
         return this.httpCli.get<any>(`http://localhost:9000/post`, {
            Array<object>
         }
         , {
           withCredentials: true
         });
       }

}
