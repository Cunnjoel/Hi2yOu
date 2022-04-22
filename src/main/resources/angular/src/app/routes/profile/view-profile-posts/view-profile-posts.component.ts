import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { Router } from '@angular/router';
import { Post } from 'src/app/models/Post';
import { PostService } from 'src/app/services/post.service';

@Component({
  selector: 'app-view-profile-posts',
  templateUrl: './view-profile-posts.component.html',
  styleUrls: ['./view-profile-posts.component.css']
})
export class ViewProfilePostsComponent implements OnInit, OnChanges{
  @Input() 
  userId : number = 0;

  postViewing : Post[] =[];
  constructor(private postService : PostService, private router : Router) { }
  ngOnChanges(changes: SimpleChanges): void {
    this.postService.getPostByUserId(this.userId).subscribe(responseBody=>{
      this.postViewing = responseBody; 
      this.postViewing.sort((a,b) => b.id - a.id)
    });
  }

  ngOnInit(): void {
  }
  
  viewUsersProfle(userId : number)
  {
    this.router.navigate(['viewprofile/user/'+ userId])
  }

}
