
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Post } from 'src/app/models/Post';
import { PostService } from 'src/app/services/post.service';
import { SessionService } from 'src/app/services/session.service';

@Component({
  selector: 'app-dashboardcreatepost',
  templateUrl: './dashboardcreatepost.component.html',
  styleUrls: ['./dashboardcreatepost.component.css']
})
export class DashboardcreatepostComponent implements OnInit {
  newPost: Post = <Post>{};
  file: File = <File>{};
  message: string = "";

  constructor(private postService: PostService, private sessionService: SessionService) { }

  ngOnInit(): void {
  }

  createPost() {
    let formData: FormData = new FormData();
    formData.append('file', this.file);

    this.postService.uploadPostPic(formData).subscribe(responseBody => {
      if (responseBody != null) {
        this.newPost.pictureURL = "https://" + responseBody.fileUrl;
      }
      this.sessionService.checkSession().subscribe(responseBody => {
        this.newPost.user = responseBody;
        this.postService.createPost(this.newPost).subscribe(responseBody => {
          this.postService.makePost = responseBody;
          console.log(responseBody)
          if(responseBody === null){
            console.log(responseBody)
            this.message = "You must write a message or attach an image to post!"
            
          }

          this.newPost.message = ' ';

        });
      });
    });
  }

  createPicturePost(e: any) {
    this.file = e.target.files[0];
  }
}




