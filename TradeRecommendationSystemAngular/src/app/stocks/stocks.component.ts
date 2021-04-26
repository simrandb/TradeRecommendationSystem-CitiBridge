import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { StocksService } from '../stocks.service';

@Component({
  selector: 'app-stocks',
  templateUrl: './stocks.component.html',
  styleUrls: ['./stocks.component.css']
})
export class StocksComponent implements OnInit {

  stocks=[];
  //userId : number;
  userName : string;
  loggedIn : Boolean = false
  
  constructor(private service: StocksService) { 
   // this.userId = parseInt(localStorage.getItem('uid'))

   if(localStorage.getItem('username') != null)
      this.loggedIn=true;
  }
  private unSave(stkSym: string) {
    this.service.unSaveStk(stkSym).subscribe(data=>{})
    window.location.pathname="./stockss"
  }
  
  ngOnInit(): void {
    if(localStorage.getItem('username')==null || localStorage.getItem('username')=='null')
    {
      window.location.pathname='./login'
    }
    
    console.log("in Stocks.Component")
    console.log(localStorage.getItem('username'))
    this.userName = localStorage.getItem('username')
    
    this.service.getUserId().subscribe(data=>{this.service.getStocks(data).subscribe(response=>{this.stocks=response})});

  }

}
