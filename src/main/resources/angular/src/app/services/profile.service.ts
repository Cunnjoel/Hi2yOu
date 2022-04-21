import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Profile } from '../models/Profile';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  currentUserProfile : Profile = <Profile>{};

  constructor(private httpCli : HttpClient) { }

  createProfile(profile : Profile)
  {
      return this.httpCli.post<Profile>(`http://localhost:9000/profile`,profile);
  }

  getProfileById(id : number)
  {
    return this.httpCli.get<Profile>(`http://localhost:9000/profile/profile/${id}`);
  }

  getProfileByUserId(userId : number)
  {
    return this.httpCli.get<Profile>(`http://localhost:9000/profile/userProfile/${userId}`);
  }

  updateProfile(profile : Profile)
  {
    return this.httpCli.patch<Profile>(`http://localhost:9000/profile`,profile);
  }

  uploadProfilePic(image : FormData)
  {
    return this.httpCli.post<any>(`http://localhost:9000/profile/upload`,image);
  }

  getIdNumberFromUrl(URL : string, start : number) : number
  {
    let url : string = URL.slice(start);
    if (url.startsWith("user"))
    {
        return +url.slice(5);
    }
    return +url
  }
  
}
