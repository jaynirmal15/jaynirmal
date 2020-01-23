import { Injectable } from '@angular/core';
import {HttpClient,HttpHeaders} from '@angular/common/http';
import { User } from './../model/userModel';
import { Wallet } from './../model/walletModel';
import { Router, ActivatedRoute } from '@angular/router';
import { UserLogin } from '../model/userLogin';
import { Transaction } from '../model/transactionModel';

@Injectable()
export class AddMoneyToWallet {
  walletURL = 'http://localhost:3000/addMoneyToWallet';
  //regURL ='http://localhost:3000/registration';
  constructor(private http: HttpClient,    private route: ActivatedRoute,
    private router: Router) {
     
  }

  addMoney(wallet : Wallet,amount:number): Promise<any> {
    let adding = {
      wallet,
      amount
    }
    console.log(adding);
    //console.log("inside get wallet" + user.user_id);
    // tslint:disable-next-line:prefer-const
    // let user_1 = user ? user : new User("", ""),
    let promise = new Promise((resolve, reject) => {
      this.http.post<any>(this.walletURL,adding)
      .subscribe(data => {
        resolve(data);
        console.log("auth service"+data.balance);       
      },
      error => {   
        reject(error);    
      });
    });
    return promise;
  }

  addMoneyToBorrowerWallet(transaction : Transaction): Promise<any> {
    
    //console.log(adding);
    //console.log("inside get wallet" + user.user_id);
    // tslint:disable-next-line:prefer-const
    // let user_1 = user ? user : new User("", ""),
    let promise = new Promise((resolve, reject) => {
      this.http.post<any>(this.walletURL,transaction)
      .subscribe(data => {
        resolve(data);
        console.log("auth service"+data.balance);       
      },
      error => {   
        reject(error);    
      });
    });
    return promise;
  }
//   logout(){
//     localStorage.removeItem('userLogin');
//   }

  // getUsers(){
  //   let promise = new Promise((resolve, reject) => {
  //     this.http.get<Array<User>>(this.loginURL)
  //     .subscribe(data => {
  //       resolve(data);
  //       console.log("all users:"+data);
  //     },
  //     error => {
  //       this.router.navigate(['/']),
  //       reject(error);
  //     });
  //   });
  //   return promise;
  // }



}


