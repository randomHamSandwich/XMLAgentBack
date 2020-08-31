import { TokenStorageService } from '../auth/token-storage.service';
import { Observable } from 'rxjs';

export class CarDTO {
    idCar: string;
    carBrand: string;
    carModel: string;
    carClass: string;
    fuelType: string;
    gearboxType: string;
    advertised: boolean;
    km: number;
    allowedKM: number;
    childrenSeats: number;
    cdw: boolean;
    street: string;
    streetNumber: string;
    city: string;
    country: string;
    user: number;
    registrationPlate: string;
    // photo: Observable<any>;
    photo: any;
    
    constructor() {
        this.idCar = "";
        this.carBrand = "";
        this.carModel = "";
        this.carClass = "";
        this.fuelType = "";
        this.gearboxType = "";
        this.advertised = false;
        this.km = 0;
        this.allowedKM = 0;
        this.childrenSeats = 0;
        this.cdw = false;
        this.street = "";
        this.streetNumber = "";
        this.city = "";
        this.country = "";
        this.user = 0;
        this.registrationPlate = "";
        this.photo = null;
    }

}