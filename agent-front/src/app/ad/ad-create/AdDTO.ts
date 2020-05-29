export class AdDTO {
    idAd: string;
    startDate: Date;
    endDate: Date;
    pricelist: string;
    car: string;
    
    constructor() {
        this.idAd = "";
        this.startDate = null;
        this.endDate = null;
        this.pricelist = "";
        this.car = "";
    }

}