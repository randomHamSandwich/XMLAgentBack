import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpHeaders, HttpEvent } from '@angular/common/http';
import { CarDTO } from '../car-create/CarDTO';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CarService {

  private baseUrl = 'http://localhost:8080/api/car';

  constructor(private http:HttpClient) {}

  createNewCar(data: CarDTO): Observable<any> {
    return this.http.post(this.baseUrl, data);
  }

  public editCar(data: CarDTO, idCar: any): Observable<any> {
    console.log(data);
    return this.http.put(this.baseUrl + '/' + idCar, data);
  }

  public getCarById(idCar: any): Observable<any> {
      return this.http.get(this.baseUrl + '/' + idCar);
  }

  public getCarsList() {
    return this.http.get(this.baseUrl);
  }

  public getCarsOwndByUser(idUser: number){
    return this.http.get('http://localhost:8080/api/car/idOwner/'+ idUser);
  }

  public deleteCar(idCar: any): Observable<any> {
    return this.http.get(this.baseUrl + '/delete/' + idCar);
  }
}
