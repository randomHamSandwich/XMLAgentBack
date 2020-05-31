export class CarDTO {
    idCar: string;
    carBrand: string;
    carModel: string;
    carClass: string;
    fuelType: string;
    gearboxType: string;
    km: string;
    allowedKM: string;
    childrenSeats: string;
    cdw: string;
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
        this.km = "";
        this.allowedKM = "";
        this.childrenSeats = "";
        this.cdw = "";
        this.street = "";
        this.streetNumber = "";
        this.city = "";
        this.country = "";
    }

}