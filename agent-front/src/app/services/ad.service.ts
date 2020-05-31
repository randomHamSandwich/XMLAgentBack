import { Injectable } from '@angular/core';
import { HttpClient,HttpParams } from '@angular/common/http';
import { AdDTO } from '../ad/ad-create/AdDTO';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdService {


  private baseUrl = 'http://localhost:8080/api/ad';

  constructor(private http: HttpClient) { }

  createNewAd(data: AdDTO): Observable<any> {
    return this.http.post(this.baseUrl, data);
  }

  updateAd() {

  }

  getAdById(id): Observable<any> {
    console.log("in service " + id);
    
    return this.http.get(this.baseUrl + '/' + id);
  }

  getAllAds(): Observable<any> {
    return this.http.get(this.baseUrl);
  }


  searchAdd(city: string , date : string): Observable<any> {
    const params = new HttpParams().set('city', city).set('date', date);
    return this.http.get(this.baseUrl+'/search', {params} );
  }
}
