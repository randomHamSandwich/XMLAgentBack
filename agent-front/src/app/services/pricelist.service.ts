import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PricelistDTO } from '../ad/pricelist-create/PricelistDTO';

@Injectable({
  providedIn: 'root'
})
export class PricelistService {

  private baseUrl = 'http://localhost:8080/api/pricelist';


  constructor(private http: HttpClient) { }

  createNewPricelist(data: PricelistDTO): Observable<any> {
    console.log("in here");
    
    return this.http.post(this.baseUrl, data);
  }

  updatePricelist() {

  }

  getPricelistById() {

  }

  getAllPricelists(): Observable<any> {
    return this.http.get(this.baseUrl);
  }
}
