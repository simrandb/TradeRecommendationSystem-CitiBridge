import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Recom } from './recom/recom.model';

@Injectable({
  providedIn: 'root'
})
export class RecomService {

  constructor(private httpService :HttpClient) { }

  public getRecom(cap: string, sector: string, topQuan: number, growthType: string): Observable<Recom[]>{
    console.log('http://localhost:8088/stocksforselectedfilters?marketCapSelected='+cap+'&sector='+sector+'&topHowMany='+topQuan+'&growthNumberOrGrowthpercent='+growthType)
    return this.httpService.get<Recom[]>('http://localhost:8088/stocksforselectedfilters?marketCapSelected='+cap+'&sector='+sector+'&topHowMany='+topQuan+'&growthNumberOrGrowthpercent='+growthType)
    
    //FOR TESTING, UNCOMMENT THIS RETURN N COMMENT PREVIOUS RETURN
    //return this.httpService.get<Recom[]>('http://localhost:8088/stocksforselectedfilters?marketCapSelected='+cap+'&sector='+sector+'&topHowMany=2&growthNumberOrGrowthpercent='+growthType)
  
  }

  public saveStk(stkSYm: string){

    
  }
}
