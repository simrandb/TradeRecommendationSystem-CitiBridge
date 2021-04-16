import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Stock } from './stock/share.model';

@Injectable({
  providedIn: 'root'
})
export class ShareService {

  //shares: Share[];
  constructor( private httpService : HttpClient) { }

  public getAllShares():Observable <Stock[]>
  {
    return this.httpService.get<Stock[]>('http://localhost:8085/shares');
  }

}
