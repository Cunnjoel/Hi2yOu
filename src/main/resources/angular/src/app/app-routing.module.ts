import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './routes/login/login.component';
import { ProfilecreateupdateComponent } from './routes/profile/profilecreateupdate/profilecreateupdate.component';
import { ProfileviewComponent } from './routes/profile/profileview/profileview.component';
import { RegisterComponent } from './routes/register/register.component';
import { DashboardcreatepostComponent} from './routes/dashboard/dashboardcreatepost/dashboardcreatepost.component';
import { ViewallpostsComponent} from './routes/dashboard/viewallposts/viewallposts/viewallposts.component';

const routes: Routes = [
  {path: "", component: LoginComponent},
  {path: "register", component: RegisterComponent},
  {path: 'profile', component: ProfilecreateupdateComponent},
  {path: 'viewprofile/:id', component : ProfileviewComponent},
  {path: 'viewprofile/user/:id', component : ProfileviewComponent},
  {path: 'dashboard', component: DashboardcreatepostComponent},
  {path: 'viewposts', component: ViewallpostsComponent},
  {path: "**", redirectTo: ""}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
