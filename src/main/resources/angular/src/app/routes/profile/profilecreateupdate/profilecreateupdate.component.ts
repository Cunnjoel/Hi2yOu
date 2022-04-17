import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Profile } from 'src/app/models/Profile';
import { ProfileService } from 'src/app/services/profile.service';

@Component({
  selector: 'app-profilecreateupdate',
  templateUrl: './profilecreateupdate.component.html',
  styleUrls: ['./profilecreateupdate.component.css']
})
export class ProfilecreateupdateComponent implements OnInit {

  file : File = <File>{};
  newProfile : Profile = <Profile>{};

  constructor(private profileService : ProfileService, private router : Router) { }

  ngOnInit(): void {
  }

  createProfile()
  {
    let formData : FormData = new FormData();
    formData.append('file', this.file);
    this.profileService.uploadProfilePic(formData).subscribe(reponseBody=>
      {
          this.newProfile.pictureUrl = "https://" + reponseBody.fileUrl;
          this.profileService.createProfile(this.newProfile).subscribe(responseBody=>{
            this.profileService.currentUserProfile = responseBody;
            this.router.navigate(['/viewprofile'])
            });
      });
  }

  addFile(e : any)
  {
      this.file = e.target.files[0];
  }

  updateProfile()
  {
    let formData : FormData = new FormData();
    formData.append('file', this.file);
    this.profileService.uploadProfilePic(formData).subscribe(reponseBody=>
      {
          this.newProfile.pictureUrl = "https://" + reponseBody.fileUrl;
          this.profileService.updateProfile(this.newProfile).subscribe(responseBody=>{
            this.profileService.currentUserProfile = responseBody;
            this.router.navigate(['/viewprofile'])
            });
      });
  }
}
