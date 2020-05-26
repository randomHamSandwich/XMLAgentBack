import { Component, OnInit,Input } from '@angular/core';
import { Korisnik } from 'src/app/home/Korisnik';
import { Observable } from 'rxjs';
import { KorisnikService } from 'src/app/services/korisnik.service';
import { RoleDTO } from './RoleDTO';

@Component({
  selector: 'app-change-authoriy',
  templateUrl: './change-authoriy.component.html',
  styleUrls: ['./change-authoriy.component.css']
})
export class ChangeAuthoriyComponent implements OnInit {
  @Input() roleDTO: RoleDTO;

  users: Observable<Korisnik[]>;
  constructor(private korisnikService: KorisnikService) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.users = this.korisnikService.getAllKorisnik()
  }

  onUpdateUserAccess(user: Korisnik, permmision: string) {
    this.roleDTO = new RoleDTO();
    this.roleDTO.roleName = permmision;

    
    this.korisnikService.changeRole(
      user.idUser,       
      {
        roleName: this.roleDTO.roleName,
      }
    ).subscribe(
    data =>{
      console.log(data);
            this.roleDTO = data as RoleDTO;
        },
        error => console.log(error)
        );

        window.location.reload();
    };


  }

