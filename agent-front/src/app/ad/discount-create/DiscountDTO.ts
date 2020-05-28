export class DiscountDTO {
    idDiscount: string;
    moreThanXDays: number;
    discount: number;

    constructor() {
        this.idDiscount = "";
        this.moreThanXDays = null;
        this.discount = null;
    }
}