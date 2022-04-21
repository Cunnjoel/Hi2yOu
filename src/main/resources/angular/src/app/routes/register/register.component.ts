import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/User';
import { SessionService } from 'src/app/services/session.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: User = <User>{};
  errorM : string = "";

  constructor(private userService : UserService, private router: Router, private sessionService : SessionService) { }

  ngOnInit(): void {
  }
  registerUser()
  {
    this.userService.create(this.user).subscribe(responseBody=>
      {
        let newUser : User = responseBody;
        if (newUser.userId == null)
        {
          this.errorM = "Please file in the required fields with a *"
        }
        else
        {
          newUser.password = this.user.password;
          this.sessionService.login(newUser).subscribe(responseBody=>{
            this.router.navigate(['/createprofile'])
          })
        }
      });
  }
}
