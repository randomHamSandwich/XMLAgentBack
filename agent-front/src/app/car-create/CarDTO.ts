export class CarDTO {
    idCar: string;
    carBrand: string;
    carModel: string;
    carClass: string;
    fuelType: string;
    gearboxType: string;
    km: number;
    allowedKM: number;
    childrenSeats: number;
    cdw: boolean;
    street: string;
    streetNumber: string;
    city: string;
    country: string;
    
    constructor() {
        this.idCar = "";
        this.carBrand = "";
        this.carModel = "";
        this.carClass = "";
        this.fuelType = "";
        this.gearboxType = "";
        this.km = 0;
        this.allowedKM = 0;
        this.childrenSeats = 0;
        this.cdw = false;
        this.street = "";
        this.streetNumber = "";
        this.city = "";
        this.country = "";
    }

}