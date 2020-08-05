export class PricelistDTO {
    pricelistId: number;
    priceForOneDay: number;
    priceForKM: number;
    discount: number;
    user: number;

    constructor() {
        this.pricelistId = null;
        this.priceForOneDay = null;
        this.priceForKM = null;
        this.discount = null;
        this.user = null;
    }
}