import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Reg } from './../model/regModel';
import { UserLogin } from './../model/userLogin';
import { Wallet } from './../model/wallet';
import { Router, ActivatedRoute } from '@angular/router';
@Injectable()

export class RegistrationService {
 // loginURL = 'http://localhost:3000/login';
  regURL ='http://localhost:3000/doUserRegistration';
  walletURL='http://localhost:3000/createNewUserWallet';
  loginURL='http://localhost:3000/createNewUserLogin';
  constructor(private http: HttpClient,    private route: ActivatedRoute,
    private router: Router) {
  }
  register(reg: Reg=null): Promise<any> {

    console.log("User Creation Req: " + reg);
    let promise = new Promise((resolve, reject) => {
      this.http.post<Reg>(this.regURL,reg)
      .subscribe(data => {
        resolve(data);
        console.log(data);
        alert("User Created");
      },
      error => {
        this.router.navigate(['/']),
        reject(error);
      });
    });
    return promise;
  }
  createnewUserLogin(userlogin: UserLogin=null): Promise<any> {

    console.log(userlogin);
    let promise = new Promise((resolve, reject) => {
      this.http.post<UserLogin>(this.regURL,userlogin)
        .subscribe(data => {
            resolve(data);
            console.log(data);
            alert("Login Created");
          },
          error => {
            this.router.navigate(['/']),
              reject(error);
          });
    });
    return promise;
  }
  createNewUserWallet(wallet: Wallet=null): Promise<any> {

    console.log("Create Wallet Request" + wallet);
    let promise = new Promise((resolve, reject) => {
      this.http.post<Wallet>(this.regURL,wallet)
        .subscribe(data => {
            resolve(data);
            console.log(data);
            alert("Wallet Created");
          },
          error => {
            //this.router.navigate(['/']),

              reject(error);
          });
    });
    return promise;
  }
}


