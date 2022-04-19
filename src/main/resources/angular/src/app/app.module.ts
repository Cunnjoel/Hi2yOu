import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './routes/login/login.component';
import { RegisterComponent } from './routes/register/register.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { ProfileviewComponent } from './routes/profile/profileview/profileview.component';
import { ProfilecreateupdateComponent } from './routes/profile/profilecreateupdate/profilecreateupdate.component';
import { DashboardcreatepostComponent} from './routes/dashboard/dashboardcreatepost/dashboardcreatepost.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    ProfilecreateupdateComponent,
    ProfileviewComponent,
    DashboardcreatepostComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
