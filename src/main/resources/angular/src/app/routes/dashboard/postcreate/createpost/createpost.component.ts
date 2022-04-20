import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Post } from 'src/app/models/Post';
import { PostService } from 'src/app/services/post.service';



@Component({
  selector: 'app-createpost',
  templateUrl: './createpost.component.html',
  styleUrls: ['./createpost.component.css']
})

export class CreatePostComponent implements OnInit {

  file : File = <File>{};
  newPost : Post = <Post>{};

  constructor(private postService : PostService, private router : Router) { }


  ngOnInit(): void {
  }

    createPost()
  {
    let picUrl : string = "";
    let formData : FormData = new FormData();
    //let user : User = new User();

    let current = new Date();
    let cDate = current.getFullYear() + "-" + (current.getMonth() +1) + "-" + current.getDay() ;
    let cTime = current.getHours() + ":" + current.getMinutes() + ":" + current.getSeconds();
    let dateTime = cDate + " " + cTime;
    formData.append('file', this.file);


    this.postService.uploadProfilePic(formData).subscribe(reponseBody=>
      {
        this.newPost.picture = "https://" + reponseBody.fileUrl;
        //his.newPost.date = dateTime;
        this.newPost.id= 1;

        this.newPost.user.id = 1;
        this.newPost.user.username="test";
        this.newPost.user.password="pass";
        this.newPost.user.email="emaol@gmail.com";
        console.log(this.newPost);

       this.postService.createPost(this.newPost).subscribe(responseBody=>{
          this.router.navigate(['/postView']);

        });
     });


  }

  addFile(e : any)
  {
      this.file = e.target.files[0];
  }
}
