import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
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

  getAdById() {

  }

  getAllAds(): Observable<any> {
    return this.http.get(this.baseUrl);
  }
}
