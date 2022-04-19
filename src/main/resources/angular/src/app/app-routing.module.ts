import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './routes/dashboard/dashboard.component';
import { LoginComponent } from './routes/login/login.component';
import { ProfilecreateupdateComponent } from './routes/profile/profilecreateupdate/profilecreateupdate.component';
import { ProfileviewComponent } from './routes/profile/profileview/profileview.component';
import { RegisterComponent } from './routes/register/register.component';

const routes: Routes = [
  {path: "", component: LoginComponent},
  {path: "register", component: RegisterComponent},
  {path: "profile", component: ProfilecreateupdateComponent},
  {path: 'viewprofile/:id', component : ProfileviewComponent},
  {path: "dashboard", component: DashboardComponent},
  {path: "**", redirectTo: ""}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
