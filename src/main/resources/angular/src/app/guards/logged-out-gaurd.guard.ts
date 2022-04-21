import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { map, Observable } from 'rxjs';
import { SessionService } from '../services/session.service';

@Injectable({
  providedIn: 'root'
})
export class LoggedOutGaurdGuard implements CanActivate {
  constructor(private sessionService : SessionService, private router: Router)
  {
    
  }
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      return this.sessionService.checkSession().pipe(map(responseBody=>
        {
          if (responseBody == null)
          {
            return true;
          }
          this.router.navigate(["dashboard"]);
          return false;
        }));
  }
  
}
