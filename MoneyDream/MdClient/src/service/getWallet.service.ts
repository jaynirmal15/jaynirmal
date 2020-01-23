import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { User } from './../model/userModel';
import { Router, ActivatedRoute } from '@angular/router';


@Injectable()
export class GetWalletService {
  loginURL = 'http://localhost:3000/getWalletAmount';
  //regURL ='http://localhost:3000/registration';
  constructor(private http: HttpClient,    private route: ActivatedRoute,
    private router: Router) {
  }


  getWallet(user_id : string): Promise<any> {
   // console.log("inside get wallet" + user.user_id);
    // tslint:disable-next-line:prefer-const
    // let user_1 = user ? user : new User("", ""),
    let promise = new Promise((resolve, reject) => {
      this.http.post<any>(this.loginURL,{id: user_id})
      .subscribe(data => {
        resolve(data);
     //   console.log("auth service"+data.balance);       
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


