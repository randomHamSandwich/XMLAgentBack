import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PricelistService {

  private baseUrl = 'http://localhost:8080/api/pricelist';


  constructor(private http: HttpClient) { }

  createNewPricelist() {

  }

  updatePricelist() {

  }

  getPricelistById() {

  }

  getAllPricelists(): Observable<any> {
    return this.http.get(this.baseUrl);
  }
}
