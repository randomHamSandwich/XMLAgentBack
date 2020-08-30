export interface PricelistResponse {
    pricelistId: number;
    priceForOneDay: number;
    priceForKM: number;
    discountId: number;
    numberOfDays: number;
    discount: number;
    user: number;
    isDeleted: Boolean;
}