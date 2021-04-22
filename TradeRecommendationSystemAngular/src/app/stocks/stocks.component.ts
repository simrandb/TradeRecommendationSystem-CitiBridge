import { Component, OnInit } from '@angular/core';
import { StocksService } from '../stocks.service';

@Component({
  selector: 'app-stocks',
  templateUrl: './stocks.component.html',
  styleUrls: ['./stocks.component.css']
})
export class StocksComponent implements OnInit {

  stocks=[];

  constructor(private service: StocksService) { }

  ngOnInit(): void {
    this.service.getStocks().subscribe(response=>{this.stocks=response});
  }

}
