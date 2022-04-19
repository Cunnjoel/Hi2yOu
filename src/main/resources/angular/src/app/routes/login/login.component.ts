import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/models/User';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  constructor(private userService : UserService, private router : Router) { }

  ngOnInit(): void {
    var loggedIn : any = localStorage.getItem("id)");
    if(loggedIn !== undefined || loggedIn !== undefined){
      this.router.navigate(['login']);
    }
  }
  onSubmit(form:NgForm) : void{
    let user : User = {username : form.value.username, password: form.value.password, email : form.value.email, userId : form.value.userId};
    console.log(user)
  }

userLogin(form : NgForm) : void{
  
  let user : User = <User> {};
    this.userService.get(user).subscribe(responseBody =>{
    
        this.router.navigate(['/dashboard'])
      })
  }
}
