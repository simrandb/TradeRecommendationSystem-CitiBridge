import { Component, OnInit } from '@angular/core';
import { SummaryService } from '../summary.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css',
                './layout.css', './framework.css']
})
export class HomeComponent implements OnInit {

  loggedIn : Boolean = false
  topGainer=[];
  topLoser=[];
  loaded : Boolean = false;
  
  constructor(private service: SummaryService) { 
    if(localStorage.getItem('username') != null)
      this.loggedIn=true;
  }

  refresh() {
    this.loaded = false;
    this.service.getGainers().subscribe(response=>{this.topGainer=response; this.loaded=true;})
    this.service.getLosers().subscribe(Response=>{this.topLoser=Response; this.loaded=true;})
  }

  ngOnInit(): void {
    this.loaded = false;
    this.service.getGainers().subscribe(response=>{this.topGainer=response; this.loaded=true;})
    this.service.getLosers().subscribe(Response=>{this.topLoser=Response; this.loaded=true;})
  }

}
