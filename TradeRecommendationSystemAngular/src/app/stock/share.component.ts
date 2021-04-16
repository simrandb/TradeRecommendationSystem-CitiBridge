import { Component, OnInit } from '@angular/core';
import { ShareService } from '../share.service';

@Component({
  selector: 'app-share',
  templateUrl: './share.component.html',
  styleUrls: ['./share.component.css']
})
export class ShareComponent implements OnInit {

  name = "My Share component" ;
    share={
      instrumentId:1234,
      instrumentName:"ABCD",
      marketRate:123.45

    }

    shares=[
      {
      instrumentId:10012,
      instrumentName:"ABCD",
      marketRate:123.45
  
    },
    {
      instrumentId:10123,
      instrumentName:"HDFC",
      marketRate:1000
  
    },
    {
      instrumentId:102456,
      instrumentName:"Citi",
      marketRate:167
  
    }

  ]
  constructor(private service: ShareService) { }

  ngOnInit(): void {
    this.service.getAllShares().subscribe(response=>{this.shares=response});
  }

}
