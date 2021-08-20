import { Injectable } from '@angular/core';
import { Stock } from './stocks/stocks.model';
import { HttpClient, HttpErrorResponse , HttpClientModule} from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import 'rxjs/add/operator/delay';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/of';
import 'rxjs/add/observable/throw';

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
    
    return this.httpService.get<Stock[]>('http://localhost:8088/user-shares/'+uid)
                          .pipe(catchError(this.handleError));

  }
  public getUserId() :Observable<any> {
    console.log("in getuserid")
    //console.log(localStorage.getItem('username'))
    return this.httpService.get('http://localhost:8088/getuserid?username='+localStorage.getItem('username'))
                          .pipe(catchError(this.handleError));

  }

  public unSaveStk(stkSym: string) :Observable<any> {
    console.log("in unsavestk stkSym: "+stkSym)
    console.log(typeof(parseInt(localStorage.getItem('uid'))))
    
    this.url = 'http://localhost:8088/unsavestock?userid='+parseInt(localStorage.getItem('uid'))+'&stockSymbol='+stkSym
    console.log(this.url)
    return this.httpService.get(this.url)
    .pipe(catchError(this.handleError));
  }

  public changeQuantity(stkSym:string, sign:string) :Observable<any> {
  
    this.url = 'http://localhost:8088/altersavedstockquantity?userid='+parseInt(localStorage.getItem('uid'))+'&companySymbol='+stkSym+'&plusminus='+sign
    console.log(this.url)
    return this.httpService.get(this.url)
    .pipe(catchError(this.handleError));
  }
/*
  public getMarketPrice(stkSym:string) :Observable<any>{
    console.log("inside getMarketPrice")
    return this.httpService.get('http://localhost:8088/marketPrice?stockSymbol='+stkSym)

  }*/

  private handleError(errorResponse: HttpErrorResponse) {
    if (errorResponse.error instanceof ErrorEvent) {
      console.error('Client side Error: ', errorResponse.error.message);
    }
    else {
      console.error('Server side Error: ', errorResponse);
    }
    return throwError('There is a problem with the service. Please try again later');
  }
  
}
