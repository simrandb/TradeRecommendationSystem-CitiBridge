import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ShareComponent } from './stock/share.component';
import {Router} from '@angular/router'; 
import { AppComponent } from './app.component';

const routes: Routes = [
  {
    path: 'app',
    component: AppComponent,
  },
  {
    path: 'share',
    component: ShareComponent
  },
  
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
