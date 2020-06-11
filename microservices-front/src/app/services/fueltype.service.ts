import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FuelTypeDTO } from '../admin/fuel-type-list/FuelTypeDTO';


@Injectable({
    providedIn: 'root'
  })
  
export class FuelTypeService{


    private FuelTypeUrl = 'http://localhost:8080/api/fuelType';

    constructor(private http: HttpClient) { }
  
  
    public getFuelType(id): Observable<any> {
      return this.http.get(this.FuelTypeUrl + '/' + id);
    }
  
    public getFuelTypes(): Observable<any> {
      return this.http.get(this.FuelTypeUrl);
    }

    updateFuelType(updateFuelType: any): Observable<any> {
      console.log("gears on servis is: " + updateFuelType.idGearboxType + " " + updateFuelType.name);
    //   const roleName = new HttpParams().set('updateFuelType', updateFuelType.roleName);
      return this.http.put(this.FuelTypeUrl + '/' + updateFuelType.idGearboxType, updateFuelType);
    }

    deleteGearbox(ft: FuelTypeDTO) : Observable<any> {

      return this.http.delete(this.FuelTypeUrl + '/' + ft.idFuelType);
    }
  
  
    addFuelType(name: FuelTypeDTO): Observable<any> {
      return this.http.post(this.FuelTypeUrl, name);
    }


} 