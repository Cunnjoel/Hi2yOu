import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Profile } from 'src/app/models/Profile';
import { User } from 'src/app/models/User';
import { ProfileService } from 'src/app/services/profile.service';
import { SessionService } from 'src/app/services/session.service';

@Component({
  selector: 'app-profileview',
  templateUrl: './profileview.component.html',
  styleUrls: ['./profileview.component.css']
})
export class ProfileviewComponent implements OnInit {

  profileViewing : Profile = <Profile>{};
  id : number = 0;
  userId : number = 0;
  buttonOn : boolean = false;

  constructor(private profileService : ProfileService , private router : Router, private sessionService : SessionService) { }

  ngOnInit(): void {
    this.id = this.profileService.getIdNumberFromUrl(this.router.url,13);
    if (this.router.url.includes("user"))
    {
      this.getProfileByUserId(this.id);
    }
    else if (this.id == 0)
    {
      let userid : number;
      this.sessionService.checkSession().subscribe(responseBody=>
        {
          userid = responseBody.userId;
          this.getProfileByUserId(userid);
        });
    }
    else
    {
      this.getProfileById(this.id);
    }
  }

  getProfileById(id : number)
  {
    this.profileService.getProfileById(id).subscribe(responseBody=>{
    this.profileViewing = responseBody;
    this.userId = this.profileViewing.user.userId;
    this.checkIfUsersProfile();
    console.log(this.profileViewing)
    });
  }

  getProfileByUserId(userId : number)
  {
    this.profileService.getProfileByUserId(userId).subscribe(responseBody=>{
    this.profileViewing = responseBody;
    this.userId = userId;
    this.checkIfUsersProfile();
    console.log(this.profileViewing)
    });
  }
  
  updateProfile()
  {
    this.router.navigate(['/updateprofile/' + this.id]);
  }

  checkIfUsersProfile()
  {
    let userOn : User; 
    this.sessionService.checkSession().subscribe(responseBody=>{
      userOn = responseBody;
      if (userOn.userId === this.profileViewing.user.userId)
      
      {
        this.buttonOn = true;
      }
      else
      {
        this.buttonOn = false;
      }
   })
  }
}
