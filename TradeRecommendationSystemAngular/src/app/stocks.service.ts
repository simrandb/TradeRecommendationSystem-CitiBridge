import { Injectable } from '@angular/core';
import { Stock } from './stocks/stocks.model';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StocksService {
  //env=environment
  url : string
  constructor(private httpService :HttpClient) { }
  public getStocks(uid: number): Observable<Stock[]> {
    console.log("in StocksService")
    console.log('uid= '+uid)
    localStorage.setItem('uid', uid.toString())
    
    return this.httpService.get<Stock[]>('http://localhost:8088/user-shares/'+uid);

  }
  public getUserId() :Observable<any> {
    console.log("in getuserid")
    //console.log(localStorage.getItem('username'))
    return this.httpService.get('http://localhost:8088/getuserid?username='+localStorage.getItem('username'))

  }

  public unSaveStk(stkSym: string) :Observable<any> {
    console.log("in unsavestk stkSym: "+stkSym)
    console.log(typeof(parseInt(localStorage.getItem('uid'))))
    
    this.url = 'http://localhost:8088/unsavestock?userid='+parseInt(localStorage.getItem('uid'))+'&stockSymbol='+stkSym
    console.log(this.url)
    return this.httpService.get(this.url)
  }
}
