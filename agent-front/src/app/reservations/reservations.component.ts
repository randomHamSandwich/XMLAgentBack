import { Component, OnInit } from '@angular/core';
import { CartItemDTO } from '../cart-list/CartItemDTO';
import { ReservationService } from 'src/app/services/reservation.service';
import { Observable } from 'rxjs';
import { TokenStorageService } from 'src/app/auth/token-storage.service';

@Component({
  selector: 'app-reservations',
  templateUrl: './reservations.component.html',
  styleUrls: ['./reservations.component.css']
})
export class ReservationsComponent implements OnInit {

  reservations: Observable<CartItemDTO[]>
  userId: number;

  constructor(
    private reservationService: ReservationService,
    private tokenService: TokenStorageService,
  ) { 

  }

  ngOnInit() {
    this.userId = +this.tokenService.getIdKorisnik();

    this.getReservations();
  }

  getReservations() {
    this.reservationService.getReservationByOwner(this.userId).subscribe(
      data => {
        this.reservations = data;
      },
      error => {
        console.log("Error: " + error.message);
              
      }
    );
  }
}
