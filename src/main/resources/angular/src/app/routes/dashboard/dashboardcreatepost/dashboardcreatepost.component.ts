
import { Component, ElementRef, OnChanges, OnInit, SimpleChanges, ViewChild } from '@angular/core';
import { Post } from 'src/app/models/Post';
import { PostService } from 'src/app/services/post.service';
import { SessionService } from 'src/app/services/session.service';
import { ViewallpostsComponent } from '../viewallposts/viewallposts/viewallposts.component';

@Component({
  selector: 'app-dashboardcreatepost',
  templateUrl: './dashboardcreatepost.component.html',
  styleUrls: ['./dashboardcreatepost.component.css']
})
export class DashboardcreatepostComponent implements OnInit {
  newPost: Post = <Post>{};
  posts : Post[] = [];
  errorM : string = "";
  file: File = <File>{};

  constructor(private postService: PostService, private sessionService: SessionService) { }

  ngOnInit(): void {
  }
  
  createPost() {
    let formData: FormData = new FormData();
    formData.append('file', this.file);
    this.postService.uploadPostPic(formData).subscribe(responseBody => {
      if(responseBody != null){
        this.newPost.pictureURL = "https://"+ responseBody.fileUrl;
      }
      this.sessionService.checkSession().subscribe(responseBody=>{
        this.newPost.user = responseBody;
        this.postService.createPost(this.newPost).subscribe(responseBody => {
          if (responseBody.id == null)
          {
            this.errorM = "Please upload a file, type a message or both to make a post";
          }
          else{
            this.postService.makePost = responseBody;
  
            this.newPost.message = ' ';
            this.errorM = "";
            this.viewAllPosts();
          }
        });
      });
      
    });


  }
  createPicturePost(e: any) {
    this.file = e.target.files[0];
  }
  viewAllPosts(){
    this.postService.getAllPosts().subscribe(responseBody=>{
      this.posts= responseBody
      this.posts.sort((a,b) => b.id - a.id)
      console.log(this.posts)
     });
  }
}




