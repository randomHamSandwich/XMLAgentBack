export class AdDTO {
    idAd: string;
    startDate: string;
    endDate: string;
    pricelist: string;
    priceForOneDay: string;
    priceForKM: string;
    discount: string;
    car: string;
    carModel: string;
    carClass: string;
    carBrand: string;
    user: number;
    active: boolean;

    constructor() {
        this.idAd = "";
        this.startDate = "";
        this.endDate = "";
        this.pricelist = "";
        this.priceForOneDay = "";
        this.priceForKM = "";
        this.discount = "";
        this.car = "";
        this.carModel = "";
        this.carClass = "";
        this.carBrand = "";
        this.user = 0;
        this.active = true;
    }
}