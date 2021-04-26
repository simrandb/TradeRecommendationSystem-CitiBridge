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
    console.log("yayy  service- verifyUser yayyy")
    return this.httpService.get<boolean>("http://localhost:8088/verifyuser?username="+username+"&password="+password);

  }
  public verifyUserExist(username:Text): Observable<boolean>
  {
    console.log("yayy  service- verifyUserExist yayyy")
    return this.httpService.get<boolean>("http://localhost:8088/checkuserexists/"+username);
  }

}




