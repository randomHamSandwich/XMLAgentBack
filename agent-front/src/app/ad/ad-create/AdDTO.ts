export class AdDTO {
    idAd: string;
    startDate: string;
    endDate: string;
    pricelist: string;
    priceForOneDay: string;
    priceForKM: string;
    discount: string;
    car: string;
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
        this.user = 0;
        this.active = true;
    }
}