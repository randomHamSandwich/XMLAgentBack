export class PricelistDTO {
    pricelistId: number;
    priceForOneDay: number;
    priceForKM: number;

    constructor() {
        this.pricelistId = null;
        this.priceForOneDay = null;
        this.priceForKM = null;
    }
}