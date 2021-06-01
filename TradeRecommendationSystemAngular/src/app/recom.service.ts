import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
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
    
    //FOR TESTING, UNCOMMENT THIS RETURN N COMMENT PREVIOUS RETURN
    //return this.httpService.get<Recom[]>('http://localhost:8088/stocksforselectedfilters?marketCapSelected='+cap+'&sector='+sector+'&topHowMany=2&growthNumberOrGrowthpercent='+growthType)
  
  }

  public saveStk(stkSYm: string):Observable<boolean>{
    
    this.url = 'http://localhost:8088/savestock?customerid='+parseInt(localStorage.getItem('uid'))+'&stocksymbol='+stkSYm
    console.log('in save Stock: '+ this.url )
    return this.httpService.get<boolean>(this.url);

  }

  public chkStkSave(stkSYm: string): Observable<boolean>{

    this.url= 'http://localhost:8088/stocksavedornot?customerid='+parseInt(localStorage.getItem('uid'))+'&stocksymbol='+stkSYm
    console.log('in chkSTkSave: '+this.url)
    this.ans = this.httpService.get<boolean>(this.url);
    console.log('boolean value ans= '+this.ans)
    return this.ans
  }
}
