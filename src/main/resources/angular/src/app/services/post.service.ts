import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Post } from '../models/Post'
import { Timestamp } from "rxjs";
import { FormBuilder, FormGroup } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private httpCli : HttpClient, public fb : FormBuilder) { }

  createPost(id : number,
    message : string,
    picture : string,
    users : Array<object>,
    date : Timestamp<Date>,
    user : {
        id : number;
        username : string;
        password : string;
        email : string
    }){
    return this.httpCli.post<any>(`http://localhost:9000/post`, {
      "message": message,
      "picture": picture,
      "users": users,
      "date": date,
      "user": user
    });
  }

  getPostByUserId(userId : number){
  console.log(user)
    return this.httpCli.get<Post>(`http://localhost:9000/post/${userId}`);
  }

  getAllPosts(){
    return this.httpCli.get<any>(`http://localhost:9000/post`);
  }

  getOnePost(id : number){
    return this.httpCli.get<Post>(`http://localhost:9000/post/${id}`);
  }

  addLike(id: number, userId: number){
    return this.httpCli.patch<Post>(`http://localhost:9000/post/${id}/user/${userId}`,{
      "id": id,
      "user": userId
    });
  }

  getAllLikes(id: number){
    return this.httpCli.get<Post>(`http://localhost:9000/post/${id}/likes`);
  }

  uploadProfilePic(multipartFile: FormGroup){
    return this.httpCli.post<any>(`http://localhost:9000/upload`, {
      "multipartfile": multipartFile
    });
  }
}
