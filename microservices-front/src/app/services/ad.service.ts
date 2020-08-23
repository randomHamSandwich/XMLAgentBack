import { Injectable } from '@angular/core';
import { HttpClient,HttpParams } from '@angular/common/http';
import { AdDTO } from '../ad/ad-create/AdDTO';
import { Observable } from 'rxjs';
//import { start } from 'repl';

@Injectable({
  providedIn: 'root'
})
export class AdService {


  private baseUrl = 'http://localhost:8083/ad/ad';

  constructor(private http: HttpClient) { }

  createNewAd(data: AdDTO): Observable<any> {
    return this.http.post(this.baseUrl, data);
  }

  getAdById(idAd: any): Observable<any> {
    return this.http.get(this.baseUrl + '/' + idAd);
  }

  updateAd() {

  }

  getAllAds(city: string , startDateTime : string, endDateTime: string): Observable<any> {
    const params = new HttpParams().set('city', city).set('startDateTime', startDateTime).set('endDateTime', endDateTime);
    return this.http.get(this.baseUrl, {params});
  }


  // searchAdd(city: string , startDateTime : string, endDateTime: string): Observable<any> {
  //   const params = new HttpParams().set('city', city).set('startDateTime', startDateTime).set('endDateTime', endDateTime);
  //   return this.http.get(this.baseUrl+'/search', {params} );
  // }
}
