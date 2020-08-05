export class DiscountDTO {
    idDiscount: string;
    moreThanXDays: number;
    discount: number;
    user: number;

    constructor() {
        this.idDiscount = "";
        this.moreThanXDays = null;
        this.discount = null;
        this.user = null;
    }
}