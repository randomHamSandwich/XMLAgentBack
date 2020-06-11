import { Injectable } from '@angular/core';

import { AdDTO } from '../ad/ad-create/AdDTO';
import { element } from 'protractor';

const SESSION_CART = 'sessionCart';

@Injectable({
    providedIn: 'root'
})

export class CartStorageService {
    // private adDTOs: Array<AdDTO> = [];
    private adIds: Array<string> = [];
    // private tempAdDTO: AdDTO;
    private isAdIdPresent :boolean=false;

    constructor() {


    }

    emptyCart() {
        window.sessionStorage.removeItem(SESSION_CART);
    }

    public getCartAdIds(): string[] {
        this.adIds = [];

        if (sessionStorage.getItem(SESSION_CART)) {
            JSON.parse(sessionStorage.getItem(SESSION_CART)).forEach(idAd => {

                this.adIds.push(idAd);
            });
        }

        return this.adIds;
    }


    public addCartAdId(newAd: AdDTO) {
        this.getCartAdIds();
        this.isAdIdPresent= false;
        this.adIds.forEach((value, index)=> {
            if(value===newAd.idAd){
                this.isAdIdPresent =true;
            }
            
        });

            if(!this.isAdIdPresent){
                this.adIds.push(newAd.idAd);
            }
            
        
        window.sessionStorage.removeItem(SESSION_CART);
        sessionStorage.setItem(SESSION_CART, JSON.stringify(this.adIds));


    }















    // getCartAdDTOs(): Array<AdDTO> {

    //     var vvv= JSON.parse(sessionStorage.getItem(SESSION_CART));

    //     for(var k in vvv) {
    //         console.log("zzzzzzzzzzzzz: " +k);
    //      }




    //     // if (sessionStorage.getItem(SESSION_CART)) {
    //     //     JSON.parse(sessionStorage.getItem(SESSION_CART)).forEach(element => {
    //     //         this.tempAdDTO = new AdDTO();
    //     //         this.tempAdDTO.idAd  = element.idAd;
    //     //         this.tempAdDTO.startDate = element.startDate;
    //     //         this.tempAdDTO.endDate = element.endDate;
    //     //         this.tempAdDTO.pricelist = element.pricelist;
    //     //         this.tempAdDTO.priceForOneDay = element.priceForOneDay;
    //     //         this.tempAdDTO.priceForKM = element.priceForKM;
    //     //         this.tempAdDTO.discount = element.discount;
    //     //         this.tempAdDTO.car = element.car;
    //     //         this.tempAdDTO.endUser= element.endUser;

    //     //       this.adDTOs.push(this.tempAdDTO);
    //     //     });
    //     //   }
    //         return  this.adDTOs;
    // }

    // addCartDTO(newAd: AdDTO) {

    //     console.log("---------- in cart storage service----------");

    //     console.log(
    //         newAd +
    //         "\n this.idAd " + newAd.idAd +
    //         "\n this.startDate " + newAd.startDate +
    //         "\n this.endDate  " + newAd.endDate +
    //         "\n this.pricelist " + newAd.pricelist +
    //         "\n this.priceForOneDay " + newAd.priceForOneDay +
    //         "\n this.priceForKM " + newAd.priceForKM +
    //         "\n this.discount " + newAd.discount +
    //         "\n this.car " + newAd.car +
    //         "\n this.endUser " + newAd.endUser



    //     );
    //     this.adDTOs = [];
    //     console.log(this.adDTOs);
    //     // this.adDTOs = JSON.parse(sessionStorage.getItem(SESSION_CART));


    //     if (sessionStorage.getItem(SESSION_CART)) {
    //         // JSON.parse(sessionStorage.getItem(SESSION_CART)).forEach(idAd => {
    //         //     // this.adDTOs.push(idAd.idAd);
    //         // });
    //         this.adDTOs = [];
    //         this.adDTOs = this.getCartAdDTOs();


    //     }

    //     // else { this.adDTOs.push(newAd); }
    //     // this.adDTOs = [];
    //     console.log("this.adDTOs" + this.adDTOs.pop);
    //     this.adDTOs.push(newAd);
    //     console.log(this.getCartAdDTOs());


    //     window.sessionStorage.removeItem(SESSION_CART);
    //     sessionStorage.setItem(SESSION_CART, JSON.stringify(newAd));

    // }

}  