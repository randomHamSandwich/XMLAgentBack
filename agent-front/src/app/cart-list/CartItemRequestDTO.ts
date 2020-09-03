import { UUID } from 'angular2-uuid';

export class CartItemRequestDTO {

    reqId: UUID;
    adId: number;
    startTime: number;
    endTime: number;

    constructor(
        public requestId: UUID,
        public currentAdId: number,
        public startDate: number,
        public endDate: number) {

        this.reqId = requestId;
        this.adId = currentAdId;
        this.startTime = startDate;
        this.endTime = endDate;
    }

}