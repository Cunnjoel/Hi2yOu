import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Profile } from 'src/app/models/Profile';
import { ProfileService } from 'src/app/services/profile.service';

@Component({
  selector: 'app-profileview',
  templateUrl: './profileview.component.html',
  styleUrls: ['./profileview.component.css']
})
export class ProfileviewComponent implements OnInit {

  profileViewing : Profile = <Profile>{};
  constructor(private profileService : ProfileService , private router : Router) { }

  ngOnInit(): void {
    let url : string = this.router.url.slice(13);
    if (url.startsWith("user"))
    {
        let userid : number = +url.slice(6);
        this.getProfileByUserId(userid)
    }
    else
    {
      let id : number = +url;
      this.getProfileById(id);
    }
  }

  getProfileById(id : number)
  {
    console.log(this.profileService.currentUserProfile);
    this.profileService.getProfileById(id).subscribe(responseBody=>{
    this.profileViewing = responseBody;
    });
  }

  getProfileByUserId(userId : number)
  {
    console.log(this.profileService.currentUserProfile);
    this.profileService.getProfileByUserId(userId).subscribe(responseBody=>{
    this.profileViewing = responseBody;
    });
  }
}
