import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { SessionService } from './services/session.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angular';
  constructor(private router: Router, private sessionService : SessionService) { }

  ngOnInit(): void {
  }
  logout()
  {
    this.sessionService.logout().subscribe(responseBody=>
      {
          console.log(responseBody);
      });
  }
}
