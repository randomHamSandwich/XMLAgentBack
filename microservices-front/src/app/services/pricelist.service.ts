import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PricelistDTO } from '../ad/pricelist-create/PricelistDTO';

@Injectable({
  providedIn: 'root'
})
export class PricelistService {

  private baseUrl = 'http://localhost:8083/ad/pricelist';


  constructor(private http: HttpClient) { }

  createNewPricelist(data: PricelistDTO): Observable<any> {
    return this.http.post(this.baseUrl, data);
  }

  updatePricelist(id: number, updateData: any): Observable<any> {
    return this.http.put(this.baseUrl + '/' + id, updateData);
  }

  getPricelistById(id: number): Observable<any> {
    return this.http.get(this.baseUrl + '/' + id);
  }

  getAllPricelists(): Observable<any> {
    return this.http.get(this.baseUrl);
  }

  deletePricelist(id: number): Observable<any> {
    return this.http.delete(this.baseUrl + '/' + id);
  }
}
