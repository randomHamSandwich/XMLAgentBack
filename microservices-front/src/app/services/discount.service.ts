import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { DiscountDTO } from '../ad/discount-create/DiscountDTO';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DiscountService {

  private baseUrl = 'http://localhost:8080/api/discounts';

  constructor(private http:HttpClient) {}

  createNewDiscount(data: DiscountDTO): Observable<any> {
    return this.http.post(this.baseUrl, data);
  }

  updateDiscount() {

  }

  getDiscountById() {

  }

  getAllDiscounts():Observable<any> {
   // console.log("in get all discounts service");
    
    return this.http.get(this.baseUrl);
  }
}
