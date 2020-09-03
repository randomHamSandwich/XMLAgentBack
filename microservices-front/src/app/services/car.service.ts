import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpHeaders, HttpEvent } from '@angular/common/http';
import { CarDTO } from '../car-create/CarDTO';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CarService {
//we have to poin to microservice endpoint and its name is car-s,
//after that we can access resource car
  private baseUrl = 'http://localhost:8083/car-s/car';

  constructor(private http:HttpClient) {}

  createNewCar(data: CarDTO): Observable<any> {
    console.log("carService: ");
    console.log(data);
    return this.http.post(this.baseUrl, data);
  }


  public updateCar() {

  }

  public getCarById(idCar: any): Observable<any> {
      return this.http.get(this.baseUrl + '/' + idCar);
  }

  public getCarsList() {
    return this.http.get(this.baseUrl);
  }

  public getCarsOwndByUser(idUser: number){
    return this.http.get('http://localhost:8083/car-s/car/idOwner/'+ idUser);
  }
}
