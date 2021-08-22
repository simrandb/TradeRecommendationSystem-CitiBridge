import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Gainer } from './home/gainer.model';
import { Loser } from './home/loser.model';

@Injectable({
  providedIn: 'root'
})
export class SummaryService {

  constructor(private httpService: HttpClient) { }

  public getGainers() : Observable<Gainer[]> {

    return this.httpService.get<Gainer[]>("http://localhost:8088/topgainers");
  }

  public getLosers() : Observable<Loser[]> {

    return this.httpService.get<Loser[]>("http://localhost:8088/toplosers");
  }

}
