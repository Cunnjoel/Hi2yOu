import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './routes/login/login.component';
import { ProfilecreateComponent } from './routes/profile/profilecreate/profilecreate.component';
import { ProfileviewComponent } from './routes/profile/profileview/profileview.component';
import { RegisterComponent } from './routes/register/register.component';
import { DashboardcreatepostComponent} from './routes/dashboard/dashboardcreatepost/dashboardcreatepost.component';
import { UpdateprofileComponent } from './routes/profile/updateprofile/updateprofile.component';
import { ViewallpostsComponent} from './routes/dashboard/viewallposts/viewallposts/viewallposts.component';
import { LoggedInGuardsGuard } from './guards/logged-in-guards.guard';
import { LoggedOutGaurdGuard } from './guards/logged-out-gaurd.guard';

const routes: Routes = [
  {path: "", component: LoginComponent, canActivate: [LoggedOutGaurdGuard]},
  {path: "register", component: RegisterComponent, canActivate: [LoggedOutGaurdGuard]},
  {path: 'createprofile', component: ProfilecreateComponent,canActivate: [LoggedInGuardsGuard]},
  {path: 'updateprofile/:id', component: UpdateprofileComponent,canActivate: [LoggedInGuardsGuard]},
  {path: 'viewprofile/:id', component : ProfileviewComponent,canActivate: [LoggedInGuardsGuard]},
  {path: 'viewprofile/user/:id', component : ProfileviewComponent,canActivate: [LoggedInGuardsGuard]},
  {path: 'dashboard', component: DashboardcreatepostComponent,canActivate: [LoggedInGuardsGuard]},
  {path: 'viewposts', component: ViewallpostsComponent,canActivate: [LoggedInGuardsGuard]},
  {path: "**", redirectTo: ""}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
