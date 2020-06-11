import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { GearboxTypeDTO } from '../admin/gearbox-list/GearboxTypeDTO';
import { CarModelDTO } from '../admin/car-model-list/CarModel';


@Injectable({
    providedIn: 'root'
})

export class CarModelService {


    private carModelUrl = 'http://localhost:8080/api/carmodel';

    constructor(private http: HttpClient) { }


    public getCarModel(id): Observable<any> {

        return this.http.get(this.carModelUrl + '/' + id);
    }

    public getCarModels(): Observable<any> {
        return this.http.get(this.carModelUrl);
    }
    updateCarModel(updateCarModel: any): Observable<any> {

        return this.http.put(this.carModelUrl + '/' + updateCarModel.idCarModel, updateCarModel);
    }

    deleteCarModel(carModel: CarModelDTO): Observable<any> {

        return this.http.delete(this.carModelUrl + '/' + carModel.idCarModel);
    }

    addGearboxType(name: CarModelDTO): Observable<any> {
        return this.http.post(this.carModelUrl, name);
    }




}