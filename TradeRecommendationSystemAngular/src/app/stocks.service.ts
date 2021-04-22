import { Injectable } from '@angular/core';
import { Stock } from './stocks/stocks.model';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StocksService {

  constructor(private httpService :HttpClient) { }
  public getStocks(): Observable<Stock[]> {
    return this.httpService.get<Stock[]>('http://localhost:8088/user-shares/1');

  }
}
