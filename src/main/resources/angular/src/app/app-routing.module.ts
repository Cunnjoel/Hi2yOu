import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './routes/login/login.component';
import { ProfilecreateupdateComponent } from './routes/profile/profilecreateupdate/profilecreateupdate.component';
import { ProfileviewComponent } from './routes/profile/profileview/profileview.component';
import { RegisterComponent } from './routes/register/register.component';
import { DashboardcreatepostComponent} from './routes/dashboard/dashboardcreatepost/dashboardcreatepost.component';

const routes: Routes = [
  {path: "", component: LoginComponent},
  {path: "register", component: RegisterComponent},
  {path: "profile", component: ProfilecreateupdateComponent},
  {path: "dashboard", component: DashboardcreatepostComponent},
  {path: 'viewprofile/:id', component : ProfileviewComponent},
  {path: "**", redirectTo: ""}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
