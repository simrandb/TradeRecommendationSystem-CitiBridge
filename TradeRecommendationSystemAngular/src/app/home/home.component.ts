import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  loggedIn : Boolean = false
  constructor() { 
    if(localStorage.getItem('username') != null)
      this.loggedIn=true;
  }

  ngOnInit(): void {


  }

}
