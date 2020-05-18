export class SignUpInfo {
    ime: string;
    prezime: string;
    username: string;
    ulica: string;
    brojUlice: string;
    drzava: string;
    grad: string;
    brojTelefona: string;
    jmbg: string;
    email: string;
    password: string;
    role: string[];
    





constructor(ime: string, surname: string, username: string, streetName: string, streetNumber: string, contry: string, city: string,
    phoneNumber: string, jmbg: string, email: string, password: string){
        this.ime = ime;
        this.prezime=surname;
        this. username=username;
        this.ulica = streetName;
        this.brojUlice = streetNumber;
        this.drzava = contry;
        this.grad = city;
        this.brojTelefona = phoneNumber;
        this.jmbg = jmbg;
        this.email = email;
        this.password = password;
        this.role = ['pacijent']; 


    }


}
