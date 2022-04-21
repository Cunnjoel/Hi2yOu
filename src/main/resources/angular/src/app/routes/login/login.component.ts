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
    let user2 : User;
    this.sessionService.login(this.user).subscribe(responseBody=>{
      user2 = responseBody;
      console.log(user2);
      if (user2.userId == null)
      {
          this.errorM = "Incorrect Username, Email, or password";
      }
      else
      {
        this.router.navigate(['/dashboard'])
      }
       })
    
  }
}
