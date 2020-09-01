export class UniqueUserDTO {

    id: number;
    userName: string;
    
    constructor(
         public uniqueUserId: number,
         public uniqueUserName: string) {   

         this.id = uniqueUserId;
         this.userName = uniqueUserName;
         }
         
}