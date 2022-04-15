import { Component, OnInit } from '@angular/core';
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

  constructor(private profileService : ProfileService) { }

  ngOnInit(): void {
  }

  createProfile()
  {
    let picUrl : string = "";
    let formData : FormData = new FormData();
    formData.append('file', this.file);
    this.profileService.uploadProfilePic(formData).subscribe(reponseBody=>
      {
          picUrl = reponseBody.fileurl;
      });
    this.newProfile.pictureUrl = picUrl;
    //console.log(this.newProfile);
    this.profileService.createProfile(this.newProfile).subscribe(responseBody=>{
      this.profileService.currentUserProfile = responseBody;
      });
  }

  addFile(e : any)
  {
      this.file = e.target.files[0];
  }
}
