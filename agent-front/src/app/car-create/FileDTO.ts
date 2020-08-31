import { Observable } from 'rxjs';

export class FileDTO {
    id: string;
    name: string;
    type: string;
    data: any;

    constructor() {
        this.id = "";
        this.name = "";
        this.type = "";
        this.data = null;
    }
}