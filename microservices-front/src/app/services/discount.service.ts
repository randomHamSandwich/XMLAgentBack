import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { DiscountDTO } from '../ad/discount-create/DiscountDTO';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DiscountService {

  private baseUrl = 'http://localhost:8083/ad/discounts';

  constructor(private http:HttpClient) {}

  createNewDiscount(data: DiscountDTO): Observable<any> {
    return this.http.post(this.baseUrl, data);
  }

  updateDiscount(id: number, discountData: any): Observable<any> {
    return this.http.put(this.baseUrl + '/' + id, discountData);
  }

  getDiscountById(id: number): Observable<any> {
    return this.http.get(this.baseUrl + '/' + id);
  }

  getAllDiscounts():Observable<any> {
    return this.http.get(this.baseUrl);
  }

  getActiveDiscounts(id: number): Observable<any> {
    return this.http.get(this.baseUrl + '/active/' + id);
  }
  
}
