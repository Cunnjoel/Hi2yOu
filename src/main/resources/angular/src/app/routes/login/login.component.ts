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
  currentUserLogin : User = <User>();

  constructor(private userService : UserService, private router : Router, private sessionService: SessionService) { }

  ngOnInit(): void {
  }

userLogin(){
  
    this.userService.getByUsername(this.user.username).subscribe(responseBody =>{
    let loginUser : User = responseBody 
    if (loginUser !=null) 
    {this.sessionService.login(loginUser).subscribe(responseBody=>{
      if(responseBody.id == null)
      {
        this.errorM = "Invalid username or password"
      }
      else
      {
        console.log(responseBody);
        this.userService.currentUserLogin = responseBody;
        this.router.navigate(['/dashboard'])
      }
       })}
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
