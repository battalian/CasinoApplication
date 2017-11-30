import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LogInComponent } from './log-in/log-in.component';
import {HttpModule} from '@angular/http';
import {UserDataService} from './user-data.service';
import {RouterModule} from '@angular/router';
import {UserAuthenticationService} from './user-authentication.service';
import {FormsModule} from '@angular/forms';
import { HomeComponent } from './home/home.component';

const appRoutes = [
  {path: '', redirectTo: '/logIn', pathMatch: 'full' },
  {path: 'logIn', component: LogInComponent , pathMatch: 'full' },
  {path: 'home', component: HomeComponent, pathMatch: 'full' }
];

@NgModule({
  declarations: [
    AppComponent,
    LogInComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    RouterModule.forRoot(appRoutes),
    FormsModule
  ],
  providers: [
    UserDataService,
    UserAuthenticationService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
