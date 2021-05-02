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
  sTopQuan: number = 15;
  sGrowth: string = 'growthpercent' ;
  recomStocks=[];

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
    this.service.getRecom(this.sCap, this.sSector, this.sTopQuan, this.sGrowth).subscribe(response=>{this.recomStocks=response})

  }

  changeSector(event: any)
  {
    this.sSector = event.target.value;
    console.log(this.sSector);
    this.service.getRecom(this.sCap, this.sSector, this.sTopQuan, this.sGrowth).subscribe(response=>{this.recomStocks=response})

  }

  changeTopQuan(event: any)
  {
    this.sTopQuan = event.target.value;
    console.log(this.sTopQuan);
    this.service.getRecom(this.sCap, this.sSector, this.sTopQuan, this.sGrowth).subscribe(response=>{this.recomStocks=response})

  }

  changeGrowth(event: any)
  {
    this.sGrowth = event.target.value;
    console.log(this.sGrowth);
    this.service.getRecom(this.sCap, this.sSector, this.sTopQuan, this.sGrowth).subscribe(response=>{this.recomStocks=response})

  }

  ngOnInit(): void {

    this.service.getRecom(this.sCap, this.sSector, this.sTopQuan, this.sGrowth).subscribe(response=>{this.recomStocks=response})
  }

}
