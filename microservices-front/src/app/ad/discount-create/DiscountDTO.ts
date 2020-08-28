export class DiscountDTO {
    idDiscount: string;
    moreThanXDays: number;
    discount: number;
    userId: number;

    constructor() {
        this.idDiscount = "";
        this.moreThanXDays = null;
        this.discount = null;
        this.userId = null;
    }
}