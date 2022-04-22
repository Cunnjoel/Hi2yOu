import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Post } from '../models/Post'
import { User } from '../models/User';


@Injectable({
  providedIn: 'root'
})
export class PostService {

  makePost : Post = <Post>{}
  makeLike : Post = <Post>{}

  constructor(private httpCli : HttpClient) { }

  createPost(post : Post){
    return this.httpCli.post<Post>(`http://localhost:9000/post`,post);
  }

  getPostByUserId(userId : number){
    return this.httpCli.get<Post[]>(`http://localhost:9000/post/user/${userId}`);
  }

  getAllPosts(){
    return this.httpCli.get<any>(`http://localhost:9000/post`);
  }

  getOnePost(id : number){
    return this.httpCli.get<Post>(`http://localhost:9000/post/${id}`);
  }

  addLike(id: number, userId: number){
    return this.httpCli.put<Post>(`http://localhost:9000/post/${id}/user/${userId}`,{
      "id": id,
      "user": userId
    });
  }

  getAllLikes(id: number){
    return this.httpCli.get<User[]>(`http://localhost:9000/post/${id}/likes`);
  }

  uploadPostPic(image : FormData){
    return this.httpCli.post<any>(`http://localhost:9000/post/upload`, image)
    
  }

}
