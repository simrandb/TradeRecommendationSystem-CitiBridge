import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor( private httpService : HttpClient) { }

  public verifyUser(username:Text, password:Text): Observable<boolean>
  {
    console.log("yayy  login.service.ts yayyy")

    return this.httpService.get<boolean>("http://localhost:8088/verifyuser?username="+username+"&password="+password);

  }
  /*
  public getUid(username:Text): number
  {
    console.log("in get uid")
    return this.httpService.get("http://localhost:8088/getUserId?username="+username);
  }*/


}




