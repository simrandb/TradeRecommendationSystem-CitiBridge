import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

import { Recom } from './recom/recom.model';

@Injectable({
  providedIn: 'root'
})
export class RecomService {

  url: string 
  ans: Observable<boolean>
  constructor(private httpService :HttpClient) { }

  public getRecom(cap: string, sector: string, topQuan: number, growthType: string): Observable<Recom[]>{
    
    this.url = 'http://localhost:8088/stocksforselectedfilters?marketCapSelected='+cap+'&sector='+sector+'&topHowMany='+topQuan+'&growthNumberOrGrowthpercent='+growthType
    console.log('in getRecom: '+this.url)
    return this.httpService.get<Recom[]>('http://localhost:8088/stocksforselectedfilters?marketCapSelected='+cap+'&sector='+sector+'&topHowMany='+topQuan+'&growthNumberOrGrowthpercent='+growthType)
                          .pipe(catchError(this.handleError));
    //FOR TESTING, UNCOMMENT THIS RETURN N COMMENT PREVIOUS RETURN
    //return this.httpService.get<Recom[]>('http://localhost:8088/stocksforselectedfilters?marketCapSelected='+cap+'&sector='+sector+'&topHowMany=2&growthNumberOrGrowthpercent='+growthType)
  
  }

  public saveStk(stkSYm: string):Observable<boolean>{
    
    this.url = 'http://localhost:8088/savestock?customerid='+parseInt(localStorage.getItem('uid'))+'&stocksymbol='+stkSYm
    console.log('in save Stock: '+ this.url )
    return this.httpService.get<boolean>(this.url)
                          .pipe(catchError(this.handleError));
  }

  public chkStkSave(stkSYm: string): Observable<boolean>{

    this.url= 'http://localhost:8088/stocksavedornot?customerid='+parseInt(localStorage.getItem('uid'))+'&stocksymbol='+stkSYm
    console.log('in chkSTkSave: '+this.url)
    this.ans = this.httpService.get<boolean>(this.url);
    console.log('boolean value ans= '+this.ans)
    return this.ans
    .pipe(catchError(this.handleError));
  }

  public searchStk(stkSYm: Text):Observable<Recom[]>{
    
    this.url = 'http://localhost:8088/searchStock?stkSym='+ stkSYm
    console.log('in Search Stock Service: '+ this.url )
    return this.httpService.get<Recom[]>(this.url)
                          .pipe(catchError(this.handleError));
  }

  private handleError(errorResponse: HttpErrorResponse) {
    if (errorResponse.error instanceof ErrorEvent) {
      console.error('Client side Error: ', errorResponse.error.message);
      alert('There is a problem with the service. Please try again later');
    }
    else {
      console.error('Server side Error: ', errorResponse);
      alert('There is a problem with the service on the Server side. Please try again later');
    }
    return throwError('There is a problem with the service. Please try again later');
  }

}
