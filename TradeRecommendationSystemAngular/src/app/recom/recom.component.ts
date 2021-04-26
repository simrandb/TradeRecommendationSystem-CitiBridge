import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-recom',
  templateUrl: './recom.component.html',
  styleUrls: ['./recom.component.css']
})
export class RecomComponent implements OnInit {
  loggedIn : Boolean = false

  constructor() { 
    if(localStorage.getItem('username') != null)
      this.loggedIn=true;
  
  }

  ngOnInit(): void {
  }

}
