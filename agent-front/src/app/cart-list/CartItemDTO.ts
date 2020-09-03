import { UUID } from 'angular2-uuid';

export class CartItemDTO {

    id: UUID;
    carBrand: string;
    carModel: string;
    startDate: string;
    endDate: string;
    priceDay: number;
    discount: number;
    user: number;

    constructor(
        public cartItemId: UUID, 
        public brand: string, 
        public model: string,
        public dateFrom: string,
        public dateTo: string,
        public price: number,
        public disc: number,
        public userId: number) {

        this.id = cartItemId;
        this.carBrand = brand;
        this.carModel = model;
        this.startDate = dateFrom;
        this.endDate = dateTo;
        this.priceDay = price;
        this.discount = disc;
        this.user = userId;
    }

}