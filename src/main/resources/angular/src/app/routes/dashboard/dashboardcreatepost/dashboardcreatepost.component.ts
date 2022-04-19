
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Post } from 'src/app/models/Post';
import { PostService } from 'src/app/services/post.service';

@Component({
  selector: 'app-dashboardcreatepost',
  templateUrl: './dashboardcreatepost.component.html',
  styleUrls: ['./dashboardcreatepost.component.css']
})
export class DashboardcreatepostComponent implements OnInit {
  newPost: Post = <Post>{};
  file: File = <File>{};

  constructor(private postService: PostService) { }

  ngOnInit(): void {
  }
  
  createPost() {
    this.newPost.user = {
      "userId": 1,
      "username": "user1",
      "password": "pass123",
      "email": "@email.com"
    };
    let formData: FormData = new FormData();
    formData.append('file', this.file);
    
    this.postService.uploadPostPic(formData).subscribe(responseBody => {
      if(responseBody != null){
        this.newPost.pictureURL = "https://"+ responseBody.fileUrl;
      }
      this.postService.createPost(this.newPost).subscribe(responseBody => {
        this.postService.makePost = responseBody;

        this.newPost.message = ' ';
        
      });
    });


  }
  createPicturePost(e: any) {
    this.file = e.target.files[0];
  }
}




