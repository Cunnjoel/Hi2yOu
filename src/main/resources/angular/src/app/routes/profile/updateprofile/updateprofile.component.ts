import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Profile } from 'src/app/models/Profile';
import { User } from 'src/app/models/User';
import { ProfileService } from 'src/app/services/profile.service';

@Component({
  selector: 'app-updateprofile',
  templateUrl: './updateprofile.component.html',
  styleUrls: ['./updateprofile.component.css']
})
export class UpdateprofileComponent implements OnInit {

  file : File = <File>{};
  fileUrl : any;
  profile : Profile = <Profile>{};
  picture : boolean = false;
  errorM : string = "";

  constructor(private profileService : ProfileService, private router : Router) { }

  ngOnInit(): void {
    this.profileService.getProfileById(this.profileService.getIdNumberFromUrl(this.router.url,15)).subscribe(responseBody=>{
        this.profile = responseBody;
    })
  }

  addFile(e : any)
  {
      this.file = e.target.files[0];
      this.picture = true;
      let reader = new FileReader();
      reader.readAsDataURL(e.target.files[0])
      reader.onload = (_e) =>
      {
        this.fileUrl = reader.result;
      }
  }

  updateProfile()
  {
    let formData : FormData = new FormData();
    formData.append('file', this.file);
    this.profileService.uploadProfilePic(formData).subscribe(reponseBody=>
      {
        if (reponseBody != null)
        {
          this.profile.pictureUrl = "https://" + reponseBody.fileUrl;
        }
        this.profileService.updateProfile(this.profile).subscribe(responseBody=>{
          this.profileService.currentUserProfile = responseBody;
          this.router.navigate(['/viewprofile/user/' + this.profileService.currentUserProfile.id])
      });
      });
  }
}
