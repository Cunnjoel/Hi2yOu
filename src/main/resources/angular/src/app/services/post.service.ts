import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Post } from '../models/Post'


@Injectable({
  providedIn: 'root'
})
export class PostService {

  makePost : Post = <Post>{}
  makeLike : Post = <Post>{}

  constructor(private httpCli : HttpClient) { }

  createPost(post : Post){
    return this.httpCli.post<Post>(`http://localhost:9000/post`,post);
    console.log(post)
  }

  getPostByUserId(userId : number){
  console.log(userId)
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

  uploadPostPic(image : FormData){
    return this.httpCli.post<any>(`http://localhost:9000/post/upload`, image)
    
  }

}
