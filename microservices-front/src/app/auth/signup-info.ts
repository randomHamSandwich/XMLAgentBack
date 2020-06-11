export class SignUpInfo {
    ulica: string;
    brojUlice: string;
    drzava: string;
    grad: string;
    brojTelefona: string;
    email: string;
    password: string;
    role: string[];

constructor( streetName: string, streetNumber: string, contry: string, city: string,
    phoneNumber: string, email: string, password: string){
        this.ulica = streetName;
        this.brojUlice = streetNumber;
        this.drzava = contry;
        this.grad = city;
        this.brojTelefona = phoneNumber;
        this.email = email;
        this.password = password;
        this.role = ['end_user']; 


    }


}
