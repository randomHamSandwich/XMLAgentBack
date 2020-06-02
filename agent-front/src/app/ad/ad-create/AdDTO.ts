export class AdDTO {
    idAd: string;
    startDate: string;
    endDate: string;
    pricelist: string;
    priceForOneDay: string;
    priceForKM: string;
    discount: string;
    car: string;
    
    constructor() {
        this.idAd = "";
        this.startDate = "";
        this.endDate = "";
        this.pricelist = "";
        this.priceForOneDay = "";
        this.priceForKM = "";
        this.discount = "";
        this.car = "";
    }
}