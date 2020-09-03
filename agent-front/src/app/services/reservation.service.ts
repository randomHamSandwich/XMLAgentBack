import { Injectable } from '@angular/core';
import { HttpClient,HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AdDTO } from '../ad/ad-create/AdDTO';
import { AdResponse } from './responses/adResponse';


@Injectable({
    providedIn: 'root'
})

export class ReservationService {

    private baseUrl = 'http://localhost:8080/api/user-request';

    constructor(private http: HttpClient) { }

  crate(data: any): Observable<any> {
    return this.http.post(this.baseUrl, data);
  }

  getAdById(idAd: any): Observable<any> {
    return this.http.get<AdResponse>(this.baseUrl + '/' + idAd);
  }

  update(idAd: number, adData: any): Observable<any> {
    return this.http.put(this.baseUrl + '/' + idAd, adData);
  }

  delete(id: number) : Observable<any> {
    return this.http.delete(this.baseUrl + '/delete/' + id);
  }

  getReservationByOwner(idAd: any): Observable<any> {
    return this.http.get<AdResponse>(this.baseUrl + '/' + idAd);
  }

}