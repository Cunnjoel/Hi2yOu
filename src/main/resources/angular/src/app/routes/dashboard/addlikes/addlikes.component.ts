import { Component, OnInit, Input } from '@angular/core';
import { Post } from 'src/app/models/Post';
import { PostService } from 'src/app/services/post.service';
import { SessionService } from 'src/app/services/session.service';

@Component({
  selector: 'app-addlikes',
  templateUrl: './addlikes.component.html',
  styleUrls: ['./addlikes.component.css']
})
export class AddlikesComponent implements OnInit {
  newLike: Post = <Post>{};

  isLiked: boolean = true;

  @Input()
  postId!: number; 

  @Input()
  postUsers!: object;

  constructor(private postService: PostService, private sessionService: SessionService) { }

  ngOnInit(): void {
  }

  @Input()
  addLike(){
    this.sessionService.checkSession().subscribe(responseBody =>{
      this.newLike.user = responseBody;
      this.postService.addLike(this.postId, this.newLike.user.userId).subscribe(responseBody =>{
        this.postService.makeLike = responseBody
        console.log(this.newLike.user);
        console.log(this.postUsers)
      })
      this.isLiked = false;
    })
  }


}
