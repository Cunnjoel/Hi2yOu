import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './routes/login/login.component';
import { ProfilecreateComponent } from './routes/profile/profilecreate/profilecreate.component';
import { ProfileviewComponent } from './routes/profile/profileview/profileview.component';
import { RegisterComponent } from './routes/register/register.component';
import { DashboardcreatepostComponent} from './routes/dashboard/dashboardcreatepost/dashboardcreatepost.component';
import { UpdateprofileComponent } from './routes/profile/updateprofile/updateprofile.component';

const routes: Routes = [
  {path: "", component: LoginComponent},
  {path: "register", component: RegisterComponent},
  {path: 'createprofile', component: ProfilecreateComponent},
  {path: 'updateprofile/:id', component: UpdateprofileComponent},
  {path: 'viewprofile/:id', component : ProfileviewComponent},
  {path: 'viewprofile/user/:id', component : ProfileviewComponent},
  {path: 'dashboard', component: DashboardcreatepostComponent},
  {path: "**", redirectTo: ""}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
