import { NumberSymbol } from '@angular/common';
import { Component, OnInit } from '@angular/core';
//import { runInThisContext } from 'node:vm';
import { Observable } from 'rxjs';
import { ApiService } from '../api.service';
import { StocksService } from '../stocks.service';
import { Stock } from './stocks.model';

@Component({
  selector: 'app-stocks',
  templateUrl: './stocks.component.html',
  styleUrls: ['./stocks.component.css']
})
export class StocksComponent implements OnInit {

  stocks=[];
  userName : string;
  loggedIn : Boolean = false;
  mktPrice: NumberSymbol;
  loaded : Boolean = false;

  constructor(private service: StocksService, private apiService: ApiService) { 

   if(localStorage.getItem('username') != null)
      this.loggedIn=true;
  }

  private unSave(stkSym: string) {
    this.service.unSaveStk(stkSym).subscribe(data=>{})
    location.reload();
  }
  
  private changeQuan(stkSym: string, sign: string, curQuan: number) {
    console.log(sign)
    console.log(curQuan)
    if (curQuan==1 && sign=='minus')
    {
      console.log("inside curquan==1")
      console.log("stksym=minus")
      this.service.unSaveStk(stkSym).subscribe(data=>{})
      location.reload();
    }
    else{
      this.service.changeQuantity(stkSym, sign).subscribe(data=>{})
      location.reload();
    }
  }

  refresh() {
    this.loaded = false;
    
    this.service.getUserId().subscribe(data=>{this.service.getStocks(data).subscribe(response=>{this.stocks=response; this.loaded = true;})});
    
  }
   
  ngOnInit(): void {
    if(localStorage.getItem('username')==null || localStorage.getItem('username')=='null')
    {
      window.location.pathname='./login'
    }
    this.loaded = false;
    console.log("LOADING= " +this.loaded)
    console.log("in Stocks.Component")
    console.log(localStorage.getItem('username'))
    this.userName = localStorage.getItem('username')
    
    this.service.getUserId().subscribe(data=>{this.service.getStocks(data).subscribe(response=>{this.stocks=response; this.loaded = true;})});
    
    console.log("LOADING= " +this.loaded)
  }

}
