import { Component, OnInit, Input, OnChanges, SimpleChanges } from '@angular/core';
import { Post } from 'src/app/models/Post';
import { PostService } from 'src/app/services/post.service';
import { SessionService } from 'src/app/services/session.service';

@Component({
  selector: 'app-addlikes',
  templateUrl: './addlikes.component.html',
  styleUrls: ['./addlikes.component.css']
})
export class AddlikesComponent implements OnInit, OnChanges {
  newLike: Post = <Post>{};

  isLiked: boolean = true;

  count: number = 0; 

  @Input()
  postId!: number;

  @Input()
  postUsers: object[] = [];

  @Input()
  postView: any = [];

  constructor(private postService: PostService, private sessionService: SessionService) { }
  ngOnChanges() {
    this.checkLike();
  }

  ngOnInit(): void {
    this.checkLike();
  }

  @Input()
  addLike() {
    this.sessionService.checkSession().subscribe(responseBody => {
      this.newLike.user = responseBody;
      this.postService.addLike(this.postId, this.newLike.user.userId).subscribe(responseBody => {
        this.postService.makeLike = responseBody
      })
      this.isLiked = false;
      this.checkLike();
    })
  }

  checkLike() {
    this.sessionService.checkSession().subscribe(responseBody => {
      this.newLike.user = responseBody;
      this.postView.users.forEach((element: { userId: number; }) => {
        if(element.userId === this.newLike.user.userId){
          this.isLiked = false;
        }
      });
    })
  }

  likeCounter(){
    this.postView.users.forEach((element: { Count: () => number; }) => {
      this.count = element.Count()
    });
  }

}


