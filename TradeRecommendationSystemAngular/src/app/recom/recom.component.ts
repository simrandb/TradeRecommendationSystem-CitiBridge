import { Component, OnInit } from '@angular/core';
import { RecomService } from '../recom.service';

@Component({
  selector: 'app-recom',
  templateUrl: './recom.component.html',
  styleUrls: ['./recom.component.css']
})
export class RecomComponent implements OnInit {
  loggedIn : Boolean = false
  sCap: string = 'any';
  sSector: string = 'Financial Services';
  sTopQuan: number = 5;
  sGrowth: string = 'growthpercent' ;
  recomStocks=[];
  savedStk: boolean;
  loaded : Boolean = false;

  constructor(private service: RecomService) { 
    if(localStorage.getItem('username') != null)
    {
      this.loggedIn=true;
    } 
  }

  changeCap(event: any)
  {
    this.sCap = event.target.value;
    console.log(this.sCap);
    this.loaded=false;
    this.service.getRecom(this.sCap, this.sSector, this.sTopQuan, this.sGrowth).subscribe(response=>{this.recomStocks=response; this.loaded=true;})

  }

  changeSector(event: any)
  {
    this.sSector = event.target.value;
    console.log(this.sSector);
    this.loaded=false;
    this.service.getRecom(this.sCap, this.sSector, this.sTopQuan, this.sGrowth).subscribe(response=>{this.recomStocks=response; this.loaded=true;})

  }

  changeTopQuan(event: any)
  {
    this.sTopQuan = event.target.value;
    console.log(this.sTopQuan);
    this.loaded=false;
    this.service.getRecom(this.sCap, this.sSector, this.sTopQuan, this.sGrowth).subscribe(response=>{this.recomStocks=response; this.loaded=true;})

  }

  changeGrowth(event: any)
  {
    this.sGrowth = event.target.value;
    console.log(this.sGrowth);
    this.loaded = false;
    this.service.getRecom(this.sCap, this.sSector, this.sTopQuan, this.sGrowth).subscribe(response=>{this.recomStocks=response; this.loaded=true;})

  }

  saveStock(stkSym: string) {
    this.service.chkStkSave(stkSym).subscribe(response=>{this.stockExists(response, stkSym)})
    console.log(" in recom comp, save stock, this.savedSTk= "+this.savedStk)
  }

  stockExists(res: boolean,stkSym:string){
    console.log("in recom comp, stockExists")
    if(res==true)
    {
      //this.savedStk = true
      //this.recomStocks[i].isDisabled = true;
      alert('STOCK PREVIOUSLY SAVED')
    }
    else 
    {
      //this.recomStocks[i].isDisabled = false;
      //this.savedStk = false
      this.service.saveStk(stkSym).subscribe();
      alert('Stock Saved in Profile!');

    }
    return
  }

  refresh() {
    this.loaded=false;
    this.service.getRecom(this.sCap, this.sSector, this.sTopQuan, this.sGrowth).subscribe(response=>{this.recomStocks=response; this.loaded=true;})

  }

  ngOnInit(): void {

    this.loaded = false;
    this.service.getRecom(this.sCap, this.sSector, this.sTopQuan, this.sGrowth).subscribe(response=>{this.recomStocks=response; this.loaded=true;})

  
  }

}
