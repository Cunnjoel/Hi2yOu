import { Component, OnInit } from '@angular/core';
import { Profile } from 'src/app/models/Profile';
import { ProfileService } from 'src/app/services/profile.service';

@Component({
  selector: 'app-profileview',
  templateUrl: './profileview.component.html',
  styleUrls: ['./profileview.component.css']
})
export class ProfileviewComponent implements OnInit {

  profileViewing : Profile = <Profile>{};
  constructor(private profileService : ProfileService) { }

  ngOnInit(): void {
    this.getProfileById();
  }

  getProfileById()
  {
    console.log(this.profileService.currentUserProfile);
      this.profileService.getProfileById(1).subscribe(responseBody=>{
      this.profileViewing = responseBody;
      });
  }
}
