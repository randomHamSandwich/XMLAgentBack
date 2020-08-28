export class AdDTO {
    idAd: string;
    startDate: string;
    endDate: string;
    pricelistId: string;
    priceForOneDay: string;
    priceForKM: string;
    //discount: string;
    //car: string;
    userId: number;
    active: boolean;
    
    constructor() {
        this.idAd = "";
        this.startDate = "";
        this.endDate = "";
        this.pricelistId = "";
        this.priceForOneDay = "";
        this.priceForKM = "";
        this.active = true;
        //this.discount = "";
        //this.car = "";
        this.userId = null;
    }
}