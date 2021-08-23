import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

import { Gainer } from './home/gainer.model';
import { Loser } from './home/loser.model';

@Injectable({
  providedIn: 'root'
})
export class SummaryService {

  constructor(private httpService: HttpClient) { }

  public getGainers() : Observable<Gainer[]> {

    return this.httpService.get<Gainer[]>("http://localhost:8088/topgainers").pipe(catchError(this.handleError));
  }

  public getLosers() : Observable<Loser[]> {

    return this.httpService.get<Loser[]>("http://localhost:8088/toplosers").pipe(catchError(this.handleError));
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
