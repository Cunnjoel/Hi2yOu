import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './routes/login/login.component';
import { RegisterComponent } from './routes/register/register.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { ProfileviewComponent } from './routes/profile/profileview/profileview.component';
import { ProfilecreateComponent } from './routes/profile/profilecreate/profilecreate.component';
import { DashboardcreatepostComponent} from './routes/dashboard/dashboardcreatepost/dashboardcreatepost.component';
import { UpdateprofileComponent } from './routes/profile/updateprofile/updateprofile.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    ProfilecreateComponent,
    ProfileviewComponent,
    DashboardcreatepostComponent,
    UpdateprofileComponent
    
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
