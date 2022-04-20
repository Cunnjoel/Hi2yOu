import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Profile } from 'src/app/models/Profile';
import { ProfileService } from 'src/app/services/profile.service';
import { SessionService } from 'src/app/services/session.service';

@Component({
  selector: 'app-profilecreateupdate',
  templateUrl: './profilecreate.component.html',
  styleUrls: ['./profilecreate.component.css']
})
export class ProfilecreateComponent implements OnInit {

  file : File = <File>{};
  newProfile : Profile = <Profile>{};
  currentProfile : Profile = <Profile>{};

  constructor(private profileService : ProfileService, private router : Router, private sessionService : SessionService) { }

  ngOnInit(): void {
    
  }

  createProfile()
  {
    let formData : FormData = new FormData();
    formData.append('file', this.file);
    this.profileService.uploadProfilePic(formData).subscribe(reponseBody=>
      {
        if (reponseBody != null)
        {
          this.newProfile.pictureUrl = "https://" + reponseBody.fileUrl;
        }
        this.sessionService.checkSession().subscribe(responseBody=>
          {
            this.newProfile.user = responseBody;
            this.profileService.createProfile(this.newProfile).subscribe(responseBody=>{
              this.profileService.currentUserProfile = responseBody;
              this.router.navigate([`/viewprofile/` + this.profileService.currentUserProfile.id])
              });
          });
      });
  }

  addFile(e : any)
  {
      this.file = e.target.files[0];
  }
}