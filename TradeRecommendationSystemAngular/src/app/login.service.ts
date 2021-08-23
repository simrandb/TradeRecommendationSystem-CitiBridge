import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private httpService: HttpClient) { }

  public verifyUser(username: Text, password: Text): Observable<boolean> {
    console.log("yayy  service- verifyUser yayyy")
    return this.httpService.get<boolean>("http://localhost:8088/verifyuser?username=" + username + "&password=" + password)
                          .pipe(catchError(this.handleError));

  }
  public verifyUserExist(username: Text): Observable<boolean> {
    console.log("yayy  service- verifyUserExist yayyy")
    return this.httpService.get<boolean>("http://localhost:8088/checkuserexists/" + username)
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




