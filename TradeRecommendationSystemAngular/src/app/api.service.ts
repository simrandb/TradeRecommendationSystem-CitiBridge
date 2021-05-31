import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  API_KEY: string
  constructor(private httpClient: HttpClient) {

    this.API_KEY = '449e6fb6e6mshf00240bcfb49c1dp163cf5jsne8c16d30339a';

   }
   public getMktPrice(){
     this.httpClient.get('https://apidojo-yahoo-finance-v1.p.rapidapi.com/market/v2/get-summary?region=US&apiKey=${this.API_KEY}')
   }
}
