import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    localStorage.clear()
    if(localStorage.getItem('username')==null || localStorage.getItem('username')=='null')
    {
      //alert('log out successful')
      window.location.pathname='./home'
    }
    else
    {
      alert('logout fail')
    }
  }

}
