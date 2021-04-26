import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
//import { LoginComponent } from './login/login.component';
//import { ShareComponent } from './stock/share.component';

import {Router} from '@angular/router'; 
import { AppComponent } from './app.component';
import { AllStocksComponent } from './all-stocks/all-stocks.component';
import { LoginComponent } from './login/login.component';
import { RecomComponent } from './recom/recom.component';
import { HomeComponent} from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { StocksComponent } from './stocks/stocks.component';
import { LogoutComponent } from './logout/logout.component';

const routes: Routes = [
  { path: 'app', component: AppComponent },
  //{ path: 'share', component: ShareComponent },
  { path: 'allStocks', component: AllStocksComponent },
  { path: 'login', component: LoginComponent },
  { path: 'recom', component: RecomComponent },
  { path: 'home', component: HomeComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'stockss', component: StocksComponent },
  { path: 'logout', component: LogoutComponent },
  { path: '', pathMatch:'full' , redirectTo: 'home' }
  
];
@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

