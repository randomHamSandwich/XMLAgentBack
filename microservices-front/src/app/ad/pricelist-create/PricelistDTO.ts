export class PricelistDTO {
    pricelistId: number;
    priceForOneDay: number;
    priceForKM: number;
    discountId: number;
    numberOfDays: number;
    discount: number;
    userId: number;

    constructor() {
        this.pricelistId = null;
        this.priceForOneDay = null;
        this.priceForKM = null;
        this.discountId = null;
        this.numberOfDays = null;
        this.discount = null;
        this.userId = null;
    }
}