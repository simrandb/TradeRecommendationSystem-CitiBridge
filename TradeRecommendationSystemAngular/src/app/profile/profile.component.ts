import { Component, NgModule, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppRoutingModule } from '../app-routing.module';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})

export class ProfileComponent implements OnInit {

  loggedIn : Boolean = false
  constructor() {
    if(localStorage.getItem('username') != null)
      this.loggedIn=true;
   }

   
  ngOnInit(): void {
    if(localStorage.getItem('username')==null || localStorage.getItem('username')=='null')
    {
      //alert('Log in to view saved stocks')
      window.location.pathname='./login'
    }
    else
    {
      window.location.pathname='./stockss'
    }
  }

}
