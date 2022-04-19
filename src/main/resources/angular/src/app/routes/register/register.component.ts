import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private userService : UserService, private router: Router ) { }

  ngOnInit(): void {
  }
  registerUser()
  {
    let formData : FormData = new FormData();
    this.userService.create(formData).subscribe(responseBody=>
      {
          //this.userService.create = responseBody;
          this.router.navigate(['/profile'])
      });
  }
}
