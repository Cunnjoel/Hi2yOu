import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/User';
import { SessionService } from 'src/app/services/session.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: User = <User>{};
  errorM : string = "";

  constructor(private userService : UserService, private router : Router, private sessionService: SessionService) { }

  ngOnInit(): void {
  }

userLogin(){
  
    let loginUser : User;
    this.userService.getByUsername(this.user.username).subscribe(responseBody =>{
    loginUser = responseBody 
    if(loginUser.userId == null)
    {
      this.userService.getUserGivenEmail(this.user.username).subscribe(responseBody=>{
        loginUser = responseBody;
        if (loginUser.userId == null)
        {
          this.errorM = "Incorrect Username, Email";
        }
        else
        {
            this.canLogin(loginUser);
        }
      })
    }
    else
    {
      this.canLogin(loginUser);
    }
     })
  }
  canLogin(u : User)
  {
    this.user.userId = u.userId;
    this.user.username = u.username;
    this.user.email = u.email;
    this.sessionService.login(this.user).subscribe(responseBody=>{
      if (responseBody == null)
      {
          this.errorM = "Incorrect password";
      }
      else
      {
        this.router.navigate(['/dashboard'])
      }
       })
  }
}
// getUserGivenEmail(){
//   this.userService.getUserGivenEmail(this.user.email).subscribe
//   (responseBody =>{
//     let getUserGivenEmail : User = responseBody
//     if (getUserGivenEmail = !null)
    
//   })
// }
